package com.deltek.integration.maconomy.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import com.deltek.integration.maconomy.relations.ContextResource;
import com.deltek.integration.maconomy.relations.HttpMethod;
import com.deltek.integration.maconomy.relations.SafeLinkRelation;

/**
 * Client used to make the requests to the server.
 */
public interface RequestClient {

	/**
	 * @return the current instance of the client used to invoke the server requests.
	 */
	Client getClient();

	/**
	 * @param contextResource
	 * @param linkRelation
	 * @return a target resource that is obtained from the given context resource by following the given link relation.
	 */
	<TargetResource> TargetResource transition(final ContextResource contextResource, final SafeLinkRelation<TargetResource> linkRelation);

	/**
	 * Execute the request using the HTTP method and request entity format.
	 * Response entity is not attempted to be read, response is returned instead.
	 * 
	 * @param request
	 * @param method
	 * @param requestEntity
	 * @return the response obtained after executing the request
	 */
	<EntityType> Response executeRequest(final Invocation.Builder request, final HttpMethod method, final Entity<EntityType> requestEntity);

}
