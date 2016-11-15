package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.containers.v1.ContainersConstants.MACONOMY_CONCURRENCY_CONTROL;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.LINK;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.LINK_VALUE_PATTERN;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.MACONOMY_FILE_CALLBACK;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.MACONOMY_FILE_CALLBACK_VALUE_FORMAT;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.NEW_FILEDROP_PATH;
import static com.deltek.integration.maconomy.relations.LinkRelations.read;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.regex.Matcher;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.filter.EncodingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.message.GZipEncoder;

import com.deltek.integration.maconomy.client.api.Container;
import com.deltek.integration.maconomy.client.api.Filedrop;
import com.deltek.integration.maconomy.client.filters.AuthorizationFilter;
import com.deltek.integration.maconomy.client.filters.FormatFilter;
import com.deltek.integration.maconomy.client.filters.LanguageFilter;
import com.deltek.integration.maconomy.client.filters.PerformanceFilter;
import com.deltek.integration.maconomy.client.internal.RequestClientImpl;
import com.deltek.integration.maconomy.containers.v1.Link;
import com.deltek.integration.maconomy.filedrop.v1.FiledropImpl;
import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.data.ConcurrencyControl;
import com.deltek.integration.maconomy.containers.v1.data.ContainerImpl;
import com.deltek.integration.maconomy.containers.v1.data.FilterData;
import com.deltek.integration.maconomy.containers.v1.data.Meta;
import com.deltek.integration.maconomy.containers.v1.handshake.Containers;
import com.deltek.integration.maconomy.custom.MaconomyFormat;
import com.deltek.integration.maconomy.relations.EntityLinkRelation;
import com.deltek.integration.maconomy.relations.HttpMethod;
import com.deltek.integration.maconomy.relations.SafeLinkRelation;

/**
 * Primary entry point for the Maconomy REST API.
 */
public final class MaconomyClient extends RequestClientImpl {

	private MaconomyClient(final Client client,
						   final URI serverAddress,
						   final String shortname) {
		super(client, serverAddress, shortname);
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
		final ContainerImpl container = executeRequest(request, read(ContainerImpl.class));
		return new Container(container, this);
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
	 * Invokes a transition returning a resource that requires an entity.
	 *
	 * @param contextResource
	 * @param linkRelation
	 * @param filedrop an optional filedrop used during the request.
	 * @return
	 */
	public <EntityType, TargetResource> TargetResource transition(final Meta<? extends ConcurrencyControl> contextResource,
			                                                      final EntityLinkRelation<EntityType, TargetResource> linkRelation,
			                                                      final Optional<FiledropImpl> filedrop) {
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
	public Filedrop filedrop(final Meta<? extends ConcurrencyControl> contextResource,
			                           final SafeLinkRelation<?> linkRelation) {
		final Invocation.Builder request = invocationBuilder(contextResource, linkRelation);
		addConcurrencyControlHeader(request, contextResource.getMeta().getConcurrencyControl());
		final Response response = executeRequest(request, linkRelation.getMethod(), null);
		final Optional<FiledropImpl> filedrop = getLinkFiledrop(response.getHeaderString(LINK));
		if (filedrop.isPresent()) {
			return new Filedrop(filedrop.get(), this);
		} else {
			throw new ClientException("Filedrop location was expected in the response header");
		}
	}

	/**
	 * Create a new filedrop to upload a file to.
	 * 
	 * @return a location of the new filedrop.
	 */
	public Filedrop createFiledrop() {
		final Invocation.Builder request = filedropWebTarget().path(NEW_FILEDROP_PATH).request(MediaType.APPLICATION_JSON);
		final FiledropImpl filedrop = executeRequest(request, HttpMethod.POST, FiledropImpl.class, null);
		return new Filedrop(filedrop, this);
	}

	private void addConcurrencyControlHeader(final Invocation.Builder request, final String concurrencyControl) {
		if (concurrencyControl != null && !concurrencyControl.isEmpty()) {
			request.header(MACONOMY_CONCURRENCY_CONTROL, concurrencyControl);
		}
	}

	private void addMaconomyFileCallbackHeader(Invocation.Builder request, Optional<FiledropImpl> filedrop) {
		if (filedrop.isPresent() && filedrop.get().getLocation() != null && !filedrop.get().getLocation().isEmpty()) {
			request.header(MACONOMY_FILE_CALLBACK, String.format(MACONOMY_FILE_CALLBACK_VALUE_FORMAT, filedrop.get().getLocation()));
		}
	}

	private Optional<FiledropImpl> getLinkFiledrop(final String linkValue) {
		if (linkValue != null) {
			final Optional<String> filedropLocation = getMatchingFiledropLocation(LINK_VALUE_PATTERN.matcher(linkValue));
			if (filedropLocation.isPresent()) {
				final FiledropImpl filedrop = new FiledropImpl();
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
			return new MaconomyClient(client, getServerAddress(), shortname);
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

		private URI getServerAddress() {
			try {
				return new URI(host + ":" + port);
			} catch (final URISyntaxException e) {
				throw new ClientException(host + ":" + port, e);
			}
		}

	}

}
