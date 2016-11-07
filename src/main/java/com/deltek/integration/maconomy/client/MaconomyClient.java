package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.client.ServerException.serverException;
import static com.deltek.integration.maconomy.containers.v1.ContainersConstants.MACONOMY_CONCURRENCY_CONTROL;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.CONTENT_DISPOSITION;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.CONTENT_DISPOSITION_VALUE;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.CONTENT_TYPE;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.CONTENT_TYPE_VALUE;
import static com.deltek.integration.maconomy.relations.LinkRelations.read;
import static javax.ws.rs.client.Entity.json;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.client.filter.EncodingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.message.GZipEncoder;

import com.deltek.integration.maconomy.client.filters.AuthorizationFilter;
import com.deltek.integration.maconomy.client.filters.LanguageFilter;
import com.deltek.integration.maconomy.containers.v1.ContainersConstants;
import com.deltek.integration.maconomy.containers.v1.Link;
import com.deltek.integration.maconomy.filedrop.v1.FiledropConstants;
import com.deltek.integration.maconomy.filedrop.v1.FiledropLocation;
import com.deltek.integration.maconomy.containers.v1.data.ConcurrencyControl;
import com.deltek.integration.maconomy.containers.v1.data.Container;
import com.deltek.integration.maconomy.containers.v1.data.Meta;
import com.deltek.integration.maconomy.containers.v1.handshake.Containers;
import com.deltek.integration.maconomy.relations.ContextResource;
import com.deltek.integration.maconomy.relations.EntityLinkRelation;
import com.deltek.integration.maconomy.relations.HttpMethod;
import com.deltek.integration.maconomy.relations.LinkRelation;
import com.deltek.integration.maconomy.relations.QueryPart;
import com.deltek.integration.maconomy.relations.SafeLinkRelation;

/**
 * Primary entry point for the Maconomy REST API
 */
public final class MaconomyClient {

	private static final Log LOG = LogFactory.getLog(MaconomyClient.class);

	private final Client client;
	private final String host, port, shortname;

	private MaconomyClient(final Client client,
						   final String host,
						   final String port,
						   final String shortname) {
		this.client = client;
		this.host = host;
		this.port = port;
		this.shortname = shortname;
	}

	/**
	 * Load Containers endpoint for general system information.
	 *
	 * @return The Containers endpoint.
	 */
	public Containers containers() {
		final Invocation.Builder request = containersWebTarget().request(MediaType.APPLICATION_JSON);
		return executeRequest(request, read(Containers.class), null);
	}

	/**
	 * Load Container overview for a specific container
	 *
	 * @param containerName The name of the container, may include namespace e.g. "maconommy:jobs"
	 * @return A representation of the container overview
	 */
	public Container container(final String containerName) {
		final Invocation.Builder request = containersWebTarget().path(containerName)
				                                          .request(MediaType.APPLICATION_JSON);
		return executeRequest(request, read(Container.class), null);
	}

	/**
	 * Load Container overview for a specific container in a given namespace
	 *
	 * @param namespace The container's namespace. Default is "maconomy".
	 * @param containerName The name of the container to load
	 * @return A representation of the container overview
	 */
	public Container container(final String namespace, final String containerName) {
		return container(namespace + ":" + containerName);
	}

	/**
	 * Invokes a transition without supplying an entity.
	 *
	 * @param contextResource
	 * @param linkRelation
	 * @return
	 */
	public <TargetResource> TargetResource transition(final ContextResource contextResource,
			                                          final SafeLinkRelation<TargetResource> linkRelation) {
		final Invocation.Builder request = invocationBuilder(contextResource, linkRelation);
		return executeRequest(request, linkRelation, null);
	}

	/**
	 * Invokes a transition that requires an entity.
	 *
	 * @param contextResource
	 * @param linkRelation
	 * @param requestEntity
	 * @return
	 */
	public <EntityType, TargetResource> TargetResource transition(final Meta<? extends ConcurrencyControl> contextResource,
			                                                      final EntityLinkRelation<EntityType, TargetResource> linkRelation) {
		final Invocation.Builder request = invocationBuilder(contextResource, linkRelation);
		final String concurrencyControl = contextResource.getMeta().getConcurrencyControl();
		if (concurrencyControl != null && !concurrencyControl.isEmpty()) {
			request.header(MACONOMY_CONCURRENCY_CONTROL, concurrencyControl);
		}
		return executeRequest(request, linkRelation, linkRelation.getEntity());
	}

	/**
	 * Create a new filedrop to upload a file to.
	 * 
	 * @return a location of the new filedrop.
	 */
	public FiledropLocation createFiledrop() {
		final Invocation.Builder request = filedropWebTarget().path(FiledropConstants.NEW_FILEDROP_PATH).request(MediaType.APPLICATION_JSON);
		return executeRequest(request, HttpMethod.POST, FiledropLocation.class, null);
	}

	public void uploadFile(final String file, final FiledropLocation filedrop) {
		final Path path = Paths.get(file);
		final String fileName = path.getFileName().toString();
		final byte[] fileContents = getFileContents(path);
		final Invocation.Builder request = client.target(filedrop.getLocation())
				.request(MediaType.APPLICATION_JSON)
				.header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
				.header(CONTENT_DISPOSITION, getContentDispositionValue(fileName));

		executeRequest(request, HttpMethod.POST, Entity.entity(fileContents, CONTENT_TYPE_VALUE));
	}

	private String getContentDispositionValue(final String fileName) {
		return CONTENT_DISPOSITION_VALUE + "\"" + fileName + "\"";
	}

	private Invocation.Builder invocationBuilder(final ContextResource contextResource,
                                                 final LinkRelation<?> linkRelation) {
		final Link link = contextResource.getLinks()
                                         .get(linkRelation)
                                         .orElseThrow(() -> new ClientException(linkRelation.getName()));
		final UriBuilder uriBuilder = client.target(link.getHref()).getUriBuilder();
        for(final QueryPart queryPart : linkRelation.getQuery()) {
        	uriBuilder.queryParam(queryPart.getName(), queryPart.getValues());
        }
        return client.target(uriBuilder).request(MediaType.APPLICATION_JSON);
	}

	// TODO: (ANH) clean up this stuff
	private <TargetResource, EntityType> TargetResource executeRequest(final Invocation.Builder request,
			                                                           final LinkRelation<TargetResource> linkRelation,
			                                                           final EntityType requestEntity) {
		return executeRequest(request, linkRelation.getMethod(), linkRelation.getTargetResource(), json(requestEntity));
	}

	private <TargetResource, EntityType> TargetResource executeRequest(final Invocation.Builder request,
			                                                           final HttpMethod method,
			                                                           final Class<TargetResource> target,
			                                                           final Entity<EntityType> requestEntity) {
		final Response response = executeRequest(request, method, requestEntity);
		return response.readEntity(target);
	}

	private <EntityType> Response executeRequest(final Invocation.Builder request,
			                                 final HttpMethod method,
			                                 final Entity<EntityType> requestEntity) {
		final Response response;
		if (requestEntity == null || requestEntity.getEntity() == null) {
			response = request.method(method.name());
		} else {
			response = request.method(method.name(), requestEntity);
		}

		check(response);

		LOG.info(response);
		return response;
	}

	private void check(final Response response) {
		if (response.getStatus() >= 300) {
			throw serverException(response);
		}
	}

	private WebTarget containersWebTarget() {
		return client.target(server()).path(ContainersConstants.PATH).path(shortname);
	}

	private WebTarget filedropWebTarget() {
		return client.target(server()).path(FiledropConstants.PATH).path(shortname);
	}

	private URI server() {
		try {
			return new URI(host + ":" + port);
		} catch (final URISyntaxException e) {
			throw new ClientException(host + ":" + port, e);
		}
	}

	private byte[] getFileContents(final Path path) {
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			throw new ClientException("Error while attempting file upload", e);
		}
	}

	public static final class Builder {

		// mandatory fields
		private final String host, port, shortname;

		// optional fields
		private Client client = ClientBuilder.newBuilder()
                                             .register(JacksonFeature.class)
				                             .register(EncodingFilter.class)
				                             .register(GZipEncoder.class)
				                             .register(LoggingFeature.class)
				                             .build();
		private String language, username, password;

		public Builder(final String host, final String port, final String shortname) {
			this.host = host;
			this.port = port;
			this.shortname = shortname;
		}

		/* package */ Builder client(final Client client) {
			this.client = client;
			return this;
		}

		public Builder language(final String language) {
			this.language = language;
			return this;
		}

		public Builder username(final String username) {
			this.username = username;
			return this;
		}

		public Builder password(final String password) {
			this.password = password;
			return this;
		}

		public MaconomyClient build() {
			configureClient();
			return new MaconomyClient(client, host, port, shortname);
		}

		private void configureClient() {
			client.register(new AuthorizationFilter(username, password));
			if (language != null) {
				client.register(new LanguageFilter(language));
			}
		}

	}

}
