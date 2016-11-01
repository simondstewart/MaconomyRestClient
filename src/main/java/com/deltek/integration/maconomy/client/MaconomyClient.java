package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.client.ServerException.serverException;
import static com.deltek.integration.maconomy.containers.v1.Constants.MACONOMY_CONCURRENCY_CONTROL;
import static com.deltek.integration.maconomy.relations.LinkRelations.read;
import static javax.ws.rs.client.Entity.json;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.client.filter.EncodingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.springframework.util.Base64Utils;

import com.deltek.integration.maconomy.containers.v1.ConcurrencyControl;
import com.deltek.integration.maconomy.containers.v1.Constants;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.deltek.integration.maconomy.containers.v1.Containers;
import com.deltek.integration.maconomy.containers.v1.Link;
import com.deltek.integration.maconomy.containers.v1.Meta;
import com.deltek.integration.maconomy.relations.ContextResource;
import com.deltek.integration.maconomy.relations.EntityLinkRelation;
import com.deltek.integration.maconomy.relations.LinkRelation;
import com.deltek.integration.maconomy.relations.QueryPart;
import com.deltek.integration.maconomy.relations.SafeLinkRelation;

/**
 * Primary entry point for the Maconomy REST API
 */
public final class MaconomyClient {

	private static final Log LOG = LogFactory.getLog(MaconomyClient.class);

	private final Client client;
	private final URI target;
	private final String shortname, language, username, password;

	private String reconnectToken;

	private MaconomyClient(final Client client,
						   final URI target,
						   final String shortname,
						   final String language,
						   final String username,
						   final String password) {
		this.target = target;
		this.shortname = shortname;
		this.language = language;
		this.username = username;
		this.password = password;
		this.client = configureClient(client);
	}
	
	private Client configureClient(final Client newClient) {
		newClient.register(new AuthorizationFilter());
		if (language != null) {
			newClient.register(new LanguageFilter());
		}
		return newClient;
	}
	
	/**
	 * Load Containers endpoint for general system information.
	 *
	 * @return The Containers endpoint.
	 */
	public Containers containers() {
		final Invocation.Builder request = baseWebTarget().request(MediaType.APPLICATION_JSON);
		return executeRequest(request, read(Containers.class), null);
	}

	/**
	 * Load Container overview for a specific container
	 *
	 * @param containerName The name of the container, may include namespace e.g. "maconommy:jobs"
	 * @return A representation of the container overview
	 */
	public Container container(final String containerName) {
		final Invocation.Builder request = baseWebTarget().path(containerName)
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
		final Response response;
		if (requestEntity == null) {
			response = request.method(linkRelation.getMethod().name());
		} else {
			response = request.method(linkRelation.getMethod().name(), json(requestEntity));
		}

		check(response);

		LOG.info(response);
		final Class<TargetResource> clazz = linkRelation.getTargetResource();
		return response.readEntity(clazz);
	}

	private void check(final Response response) {
		if (response.getStatus() >= 300) {
			throw serverException(response);
		}
	}

	private WebTarget baseWebTarget() {
		return client.target(target)
				     .path(Constants.PATH)
				     .path(shortname);
	}
	
	/** Filter for authorization. */
	private final class AuthorizationFilter implements ClientRequestFilter, ClientResponseFilter {

		@Override
		public void filter(ClientRequestContext requestContext) throws IOException {
			requestContext.getHeaders().add(Constants.MACONOMY_AUTHENTICATION, Constants.X_RECONNECT);
			if (reconnectToken != null) {
				requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION, Constants.X_RECONNECT + " " + reconnectToken);
				LOG.info("Using reconnect token");
			} else if (username != null && password != null) {
				final String combined = username + ":" + password;
				final byte[] utf8_bytes = combined.getBytes(Charset.forName("UTF-8"));
				final String base64 = Base64Utils.encodeToString(utf8_bytes);
				requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION, "BASIC " + base64);
				LOG.info("Using basic authentication");
			}
			// TODO: (ANH) handle domain credentials
		}
		
		@Override
		public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext)
				throws IOException {
			reconnectToken = responseContext.getHeaderString(Constants.MACONOMY_RECONNECT);
		}

	}
	
	/** Filter for language selection. */
	private final class LanguageFilter implements ClientRequestFilter {

		@Override
		public void filter(ClientRequestContext requestContext) throws IOException {
			requestContext.getHeaders().add(Constants.ACCEPT_LANGUAGE, language);
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
			try {
				final URI target = new URI(host + ":" + port);
				return new MaconomyClient(client,
										  target,
						                  shortname,
						                  language,
						                  username,
						                  password);
			} catch (final URISyntaxException e) {
				throw new ClientException(host + ":" + port, e);
			}
		}

	}

}
