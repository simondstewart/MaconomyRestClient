package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.client.ServerException.serverException;
import static com.deltek.integration.maconomy.containers.v1.ContainersConstants.MACONOMY_CONCURRENCY_CONTROL;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.CONTENT_DISPOSITION;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.CONTENT_DISPOSITION_VALUE_FORMAT;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.CONTENT_TYPE;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.CONTENT_TYPE_VALUE;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.LINK;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.LINK_VALUE_PATTERN;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.MACONOMY_FILE_CALLBACK;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.MACONOMY_FILE_CALLBACK_VALUE_FORMAT;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.NEW_FILEDROP_PATH;
import static com.deltek.integration.maconomy.relations.LinkRelations.read;
import static javax.ws.rs.client.Entity.json;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.regex.Matcher;

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
import com.deltek.integration.maconomy.client.filters.FormatFilter;
import com.deltek.integration.maconomy.client.filters.LanguageFilter;
import com.deltek.integration.maconomy.containers.v1.ContainersConstants;
import com.deltek.integration.maconomy.containers.v1.Link;
import com.deltek.integration.maconomy.filedrop.v1.FiledropConstants;
import com.deltek.integration.maconomy.filedrop.v1.FiledropContents;
import com.deltek.integration.maconomy.filedrop.v1.Filedrop;
import com.deltek.integration.maconomy.containers.v1.data.ConcurrencyControl;
import com.deltek.integration.maconomy.containers.v1.data.Container;
import com.deltek.integration.maconomy.containers.v1.data.Meta;
import com.deltek.integration.maconomy.containers.v1.handshake.Containers;
import com.deltek.integration.maconomy.custom.MaconomyFormat;
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
	 * Invokes a transition returning a resource without supplying an entity.
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
	 * Invokes a transition returning a resource that requires an entity.
	 *
	 * @param contextResource
	 * @param linkRelation
	 * @param filedrop
	 * @return
	 */
	public <EntityType, TargetResource> TargetResource transition(final Meta<? extends ConcurrencyControl> contextResource,
			                                                      final EntityLinkRelation<EntityType, TargetResource> linkRelation,
			                                                      final Optional<Filedrop> filedrop) {
		final Invocation.Builder request = invocationBuilder(contextResource, linkRelation);
		addConcurrencyControlHeader(request, contextResource.getMeta().getConcurrencyControl());
		addMaconomyFileCallbackHeader(request, filedrop);
		return executeRequest(request, linkRelation, linkRelation.getEntity());
	}

	public Optional<Filedrop> filedrop(final Meta<? extends ConcurrencyControl> contextResource,
			                           final SafeLinkRelation<?> linkRelation) {
		final Invocation.Builder request = invocationBuilder(contextResource, linkRelation);
		addConcurrencyControlHeader(request, contextResource.getMeta().getConcurrencyControl());
		final Response response = executeRequest(request, linkRelation.getMethod(), null);
		return getLinkFiledrop(response.getHeaderString(LINK));
	}

	/**
	 * Create a new filedrop to upload a file to.
	 * 
	 * @return a location of the new filedrop.
	 */
	public Filedrop createFiledrop() {
		final Invocation.Builder request = filedropWebTarget().path(NEW_FILEDROP_PATH).request(MediaType.APPLICATION_JSON);
		return executeRequest(request, HttpMethod.POST, Filedrop.class, null);
	}

	/**
	 * Upload the contents of the file specified at a given path to a given filedrop, which should be empty, otherwise an error will be thrown.
	 * 
	 * @param file
	 * @param filedrop
	 */
	public void uploadFile(final Path path, final Filedrop filedrop) {
		final String fileName = path.getFileName().toString();
		final byte[] fileContents = Utils.getFileContents(path);
		final Invocation.Builder request = client.target(filedrop.getLocation()).request(MediaType.APPLICATION_JSON)
				.header(CONTENT_TYPE, CONTENT_TYPE_VALUE).header(CONTENT_DISPOSITION, String.format(CONTENT_DISPOSITION_VALUE_FORMAT, fileName));
		executeRequest(request, HttpMethod.POST, Entity.entity(fileContents, CONTENT_TYPE_VALUE));
	}

	/**
	 * Read the contents of the given filedrop.
	 * 
	 * @param filedrop
	 * @return the contents of the filedrop.
	 */
	public FiledropContents readFiledrop(final Filedrop filedrop) {
		final Invocation.Builder request = client.target(filedrop.getLocation()).request(CONTENT_TYPE_VALUE);
		final Response response = executeRequest(request, HttpMethod.GET, null);
		final String type = response.getHeaderString(CONTENT_TYPE);
		final byte[] data = response.readEntity(byte[].class);
		return new FiledropContents(type, data);
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

	private void addConcurrencyControlHeader(final Invocation.Builder request, final String concurrencyControl) {
		if (concurrencyControl != null && !concurrencyControl.isEmpty()) {
			request.header(MACONOMY_CONCURRENCY_CONTROL, concurrencyControl);
		}
	}

	private void addMaconomyFileCallbackHeader(Invocation.Builder request, Optional<Filedrop> filedrop) {
		if (filedrop.isPresent() && filedrop.get().getLocation() != null && !filedrop.get().getLocation().isEmpty()) {
			request.header(MACONOMY_FILE_CALLBACK, String.format(MACONOMY_FILE_CALLBACK_VALUE_FORMAT, filedrop.get().getLocation()));
		}
	}

	/**
	 * Execute the request based on a given link relation which will be used to determine the HTTP method and the type of the target resource.
	 * If there is request entity, then it has to use a JSON format which is assumed for this method.
	 * Response entity is attempted to be read to a given target type specified in the link relation and returned.
	 * 
	 * @param request
	 * @param linkRelation
	 * @param requestEntity using JSON format
	 * @return the resource obtained after executing the request
	 */
	private <TargetResource, EntityType> TargetResource executeRequest(final Invocation.Builder request,
			                                                           final LinkRelation<TargetResource> linkRelation,
			                                                           final EntityType requestEntity) {
		return executeRequest(request, linkRelation.getMethod(), linkRelation.getTargetResource(), json(requestEntity));
	}

	/**
	 * Execute the request using the HTTP method, type of the target resource and request entity format.
	 * Response entity is attempted to be read to a given target type and returned.
	 * 
	 * @param request
	 * @param method
	 * @param target
	 * @param requestEntity
	 * @return the resource obtained after executing the request
	 */
	private <TargetResource, EntityType> TargetResource executeRequest(final Invocation.Builder request,
			                                                           final HttpMethod method,
			                                                           final Class<TargetResource> target,
			                                                           final Entity<EntityType> requestEntity) {
		final Response response = executeRequest(request, method, requestEntity);
		return response.readEntity(target);
	}

	/**
	 * Execute the request using the HTTP method and request entity format.
	 * Response entity is not attempted to be read, response is returned instead.
	 * 
	 * @param request
	 * @param method
	 * @param requestEntity
	 * @return the response obtained after executing the request
	 */
	private <EntityType> Response executeRequest(final Invocation.Builder request,
			                                     final HttpMethod method,
			                                     final Entity<EntityType> requestEntity) {
		final boolean hasRequestEntity = requestEntity != null && requestEntity.getEntity() != null;
		final Response response = hasRequestEntity ? request.method(method.name(), requestEntity) : request.method(method.name());
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
		return client.target(getServerAddress()).path(ContainersConstants.PATH).path(shortname);
	}

	private WebTarget filedropWebTarget() {
		return client.target(getServerAddress()).path(FiledropConstants.PATH).path(shortname);
	}

	private Optional<Filedrop> getLinkFiledrop(final String linkValue) {
		if (linkValue != null) {
			final Optional<String> filedropLocation = getMatchingFiledropLocation(LINK_VALUE_PATTERN.matcher(linkValue));
			if (filedropLocation.isPresent()) {
				final Filedrop filedrop = new Filedrop();
				filedrop.setLocation(filedropLocation.get());
				return Optional.of(filedrop);
			}
		}
		return Optional.empty();
	}

	private Optional<String> getMatchingFiledropLocation(final Matcher matcher) {
		final boolean isMatchingLocation = matcher.matches() && matcher.groupCount() == 1 && matcher.group(1) != null && !matcher.group(1).isEmpty();
		return isMatchingLocation ? Optional.of(matcher.group(1)) : Optional.empty();
	}

	private URI getServerAddress() {
		try {
			return new URI(host + ":" + port);
		} catch (final URISyntaxException e) {
			throw new ClientException(host + ":" + port, e);
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
		private MaconomyFormat format;

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

		public Builder format(final MaconomyFormat format) {
			this.format = format;
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
			if (format != null && format.isValid()) {
				client.register(new FormatFilter(format));
			}
		}

	}

}
