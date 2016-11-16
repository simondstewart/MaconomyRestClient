package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.client.util.ServerException.serverException;
import static com.deltek.integration.maconomy.containers.v1.ContainersConstants.CONTAINER_PLACEHOLDER;
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
import com.deltek.integration.maconomy.client.filters.PerformanceFilter;
import com.deltek.integration.maconomy.client.util.ClientException;
import com.deltek.integration.maconomy.client.util.Utils;
import com.deltek.integration.maconomy.containers.v1.ContainersConstants;
import com.deltek.integration.maconomy.containers.v1.Link;
import com.deltek.integration.maconomy.filedrop.v1.FiledropConstants;
import com.deltek.integration.maconomy.filedrop.v1.FiledropContents;
import com.deltek.integration.maconomy.filedrop.v1.Filedrop;
import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.data.ConcurrencyControl;
import com.deltek.integration.maconomy.containers.v1.data.Container;
import com.deltek.integration.maconomy.containers.v1.data.FilterData;
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
		return executeRequest(request, read(Containers.class));
	}

	/**
	 * Load Container overview for a specific container
	 *
	 * @param containerName The name of the container, may include namespace e.g. "maconommy:jobs"
	 * @return A representation of the container overview
	 */
	public Container container(final String containerName) {
		final Invocation.Builder request = containersWebTarget().path(containerName).request(MediaType.APPLICATION_JSON);
		return executeRequest(request, read(Container.class));
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
		return executeRequest(request, linkRelation);
	}

	/**
	 * Invokes a transition returning a resource that requires an entity.
	 *
	 * @param contextResource
	 * @param linkRelation
	 * @param filedrop an optional filedrop used during the request.
	 * @return
	 */
	public <EntityType, TargetResource> TargetResource transition(final Meta<? extends ConcurrencyControl> contextResource,
			                                                      final EntityLinkRelation<EntityType, TargetResource> linkRelation,
			                                                      final Optional<Filedrop> filedrop) {
		final Invocation.Builder request = invocationBuilder(contextResource, linkRelation);
		addConcurrencyControlHeader(request, contextResource.getMeta().getConcurrencyControl());
		addMaconomyFileCallbackHeader(request, filedrop);
		return executeRequest(request, linkRelation);
	}

	/**
	 * Invokes the foreign key search for a given link and link relation.
	 * 
	 * @param link of the foreign key
	 * @param linkRelation of the foreign key search
	 * @return the filter data resource corresponding to the foreign key search.
	 */
	public FilterData foreignKey(final Link link, EntityLinkRelation<CardTableRecord, FilterData> linkRelation) {
		final Invocation.Builder request = invocationBuilder(link, linkRelation);
		return executeRequest(request, linkRelation);
	}

	/**
	 * Invokes the foreign key navigation.
	 * 
	 * @param link
	 * @param linkRelation
	 * @param containerName
	 * @return the card table data resource corresponding to the foreign key navigation.
	 */
	public CardTableData foreignKey(final Link link, final SafeLinkRelation<CardTableData> linkRelation, final String containerName) {
		final Invocation.Builder request = invocationBuilder(link, linkRelation, containerName);
		return executeRequest(request, linkRelation);
	}

	/**
	 * Invokes a transition returning a filedrop without supplying an entity.
	 * 
	 * @param contextResource
	 * @param linkRelation
	 * @return the location of the filedrop that was pointed to in the response.
	 */
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
		final Invocation.Builder request = client.target(filedrop.getLocation()).request(MediaType.APPLICATION_JSON)
				                           .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
				                           .header(CONTENT_DISPOSITION, String.format(CONTENT_DISPOSITION_VALUE_FORMAT, path.getFileName().toString()));
		executeRequest(request, HttpMethod.POST, Entity.entity(Utils.getFileContents(path), CONTENT_TYPE_VALUE));
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
		return invocationBuilder(link, linkRelation);
	}

	private Invocation.Builder invocationBuilder(final Link link, final LinkRelation<?> linkRelation) {
		final UriBuilder uriBuilder = client.target(link.getHref()).getUriBuilder();
		return invocationBuilder(uriBuilder, linkRelation.getQuery());
	}

	private Invocation.Builder invocationBuilder(final Link link, final LinkRelation<?> linkRelation, final String containerName) {
		final UriBuilder uriBuilder = client.target(link.getTemplate().replace(CONTAINER_PLACEHOLDER, containerName)).getUriBuilder();
		return invocationBuilder(uriBuilder, linkRelation.getQuery());
	}

	private Invocation.Builder invocationBuilder(final UriBuilder uriBuilder, final Iterable<QueryPart> queries) {
		for (final QueryPart queryPart : queries) {
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
	 * For this type of link relation there is no request entity.
	 * Response entity is attempted to be read to a given target type specified in the link relation and returned.
	 * 
	 * @param request
	 * @param linkRelation without an entity
	 * @return the resource obtained after executing the request.
	 */
	private <TargetResource, EntityType> TargetResource executeRequest(final Invocation.Builder request,
			                                                           final SafeLinkRelation<TargetResource> linkRelation) {
		return executeRequest(request, linkRelation.getMethod(), linkRelation.getTargetResource(), null);
	}

	/**
	 * Execute the request based on a given link relation which will be used to determine the HTTP method and the type of the target resource.
	 * If there is request entity, then it has to use a JSON format which is assumed for this method.
	 * Response entity is attempted to be read to a given target type specified in the link relation and returned.
	 * 
	 * @param request
	 * @param linkRelation with a possible entity
	 * @return the resource obtained after executing the request.
	 */
	private <TargetResource, EntityType> TargetResource executeRequest(final Invocation.Builder request,
			                                                           final EntityLinkRelation<EntityType, TargetResource> linkRelation) {
		return executeRequest(request, linkRelation.getMethod(), linkRelation.getTargetResource(), json(linkRelation.getEntity()));
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

	/** Use to create a Maconomy client instance. */
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
		private boolean logPerformance;

		/**
		 * Constructor initializing all the mandatory fields of the Maconomy client.
		 * 
		 * @param host
		 * @param port
		 * @param shortname
		 */
		public Builder(final String host, final String port, final String shortname) {
			this.host = host;
			this.port = port;
			this.shortname = shortname;
		}

		/** Overwrites the default request execution client.
		 * 
		 * @param client to execute requests with
		 * @return this builder
		 */
		 /* package */ Builder client(final Client client) {
			this.client = client;
			return this;
		}

		/** 
		 * Overwrites the default language to use when translating localization terms on the server.
		 * Used in all requests sent to the server.
		 * 
		 * @param language to use
		 * @return this builder
		 */
		public Builder language(final String language) {
			this.language = language;
			return this;
		}

		/** 
		 * Overwrites the default data format in which the print action is being executed. 
		 * Check {@code MaconomyFormat} for details of what format options are configurable. 
		 * Used in all requests sent to the server.
		 * 
		 * @param format to use
		 * @return this builder
		 */
		public Builder format(final MaconomyFormat format) {
			this.format = format;
			return this;
		}

		/**
		 * Set if the requests that need to be executed require authentication.
		 * 
		 * @param username to authenticate with
		 * @return this builder
		 */
		public Builder username(final String username) {
			this.username = username;
			return this;
		}

		/**
		 * Set if the requests that need to be executed require authentication.
		 * 
		 * @param password to authenticate with
		 * @return this builder
		 */
		public Builder password(final String password) {
			this.password = password;
			return this;
		}

		/**
		 * Set if the request and response times should be logged.
		 * 
		 * @param logPerformance
		 * @return this builder
		 */
		public Builder logPerformance(final boolean logPerformance) {
			this.logPerformance = logPerformance;
			return this;
		}

		/**
		 * @return the Maconomy client instance corresponding to the state of this builder.
		 */
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
			if (logPerformance) {
				client.register(new PerformanceFilter());
			}
		}

	}

}
