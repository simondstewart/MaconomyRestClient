package com.deltek.integration.maconomy.client.internal;

import static com.deltek.integration.maconomy.client.util.ServerException.serverException;
import static com.deltek.integration.maconomy.containers.v1.ContainersConstants.CONTAINER_PLACEHOLDER;
import static javax.ws.rs.client.Entity.json;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deltek.integration.maconomy.client.util.ClientException;
import com.deltek.integration.maconomy.containers.v1.ContainersConstants;
import com.deltek.integration.maconomy.containers.v1.Link;
import com.deltek.integration.maconomy.filedrop.v1.FiledropConstants;
import com.deltek.integration.maconomy.relations.ContextResource;
import com.deltek.integration.maconomy.relations.EntityLinkRelation;
import com.deltek.integration.maconomy.relations.HttpMethod;
import com.deltek.integration.maconomy.relations.LinkRelation;
import com.deltek.integration.maconomy.relations.QueryPart;
import com.deltek.integration.maconomy.relations.SafeLinkRelation;

public class RequestClientImpl implements IRequestClient {

	private static final Log LOG = LogFactory.getLog(RequestClientImpl.class);

	private final URI serverAddress;
	private final String shortname;
	private final Client client;

	protected RequestClientImpl(final Client client, final URI serverAddress, final String shortname) {
		this.client = client;
		this.serverAddress = serverAddress;
		this.shortname = shortname;
	}

	@Override
	public Client getClient() {
		return client;
	}

	@Override
	public <TargetResource> TargetResource transition(final ContextResource contextResource,
			                                          final SafeLinkRelation<TargetResource> linkRelation) {
		final Invocation.Builder request = invocationBuilder(contextResource, linkRelation);
		return executeRequest(request, linkRelation);
	}

	protected WebTarget containersWebTarget() {
		return client.target(serverAddress).path(ContainersConstants.PATH).path(shortname);
	}

	protected WebTarget filedropWebTarget() {
		return client.target(serverAddress).path(FiledropConstants.PATH).path(shortname);
	}

	protected Invocation.Builder invocationBuilder(final ContextResource contextResource, final LinkRelation<?> linkRelation) {
		final Link link = contextResource.getLinks()
				.get(linkRelation)
				.orElseThrow(() -> new ClientException(linkRelation.getName()));
		return invocationBuilder(link, linkRelation);
	}

	protected Invocation.Builder invocationBuilder(final Link link, final LinkRelation<?> linkRelation) {
		final UriBuilder uriBuilder = client.target(link.getHref()).getUriBuilder();
		return invocationBuilder(uriBuilder, linkRelation.getQuery());
	}

	protected Invocation.Builder invocationBuilder(final Link link, final LinkRelation<?> linkRelation, final String containerName) {
		final UriBuilder uriBuilder = client.target(link.getTemplate().replace(CONTAINER_PLACEHOLDER, containerName)).getUriBuilder();
		return invocationBuilder(uriBuilder, linkRelation.getQuery());
	}

	private Invocation.Builder invocationBuilder(final UriBuilder uriBuilder, final Iterable<QueryPart> queries) {
		for (final QueryPart queryPart : queries) {
			uriBuilder.queryParam(queryPart.getName(), queryPart.getValues());
		}
		return client.target(uriBuilder).request(MediaType.APPLICATION_JSON);
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
	protected <TargetResource, EntityType> TargetResource executeRequest(final Invocation.Builder request,
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
	protected <TargetResource, EntityType> TargetResource executeRequest(final Invocation.Builder request,
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
	protected <TargetResource, EntityType> TargetResource executeRequest(final Invocation.Builder request,
			                                                             final HttpMethod method,
			                                                             final Class<TargetResource> target,
			                                                             final Entity<EntityType> requestEntity) {
		final Response response = executeRequest(request, method, requestEntity);
		return response.readEntity(target);
	}

	@Override
	public <EntityType> Response executeRequest(final Invocation.Builder request,
			                                        final HttpMethod method,
			                                        final Entity<EntityType> requestEntity) {
		final boolean hasRequestEntity = requestEntity != null && requestEntity.getEntity() != null;
		final Response response = hasRequestEntity ? request.method(method.name(), requestEntity) : request.method(method.name());
		check(response);
		LOG.info(response);
		return response;
	}

	private static void check(final Response response) {
		if (response.getStatus() >= 300) {
			throw serverException(response);
		}
	}

}
