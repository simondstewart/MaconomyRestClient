package com.deltek.integration.maconomy.client.api;

import com.deltek.integration.maconomy.client.RequestClient;
import com.deltek.integration.maconomy.containers.v1.Links;
import com.deltek.integration.maconomy.relations.SafeLinkRelation;

/**
 * Entry point to the Maconomy REST API in the context of a Maconomy container.
 */
public class Container implements IContainer {

	private final IContainer container;
	private RequestClient requestClient;

	public Container(final IContainer container, final RequestClient requestClient) {
		this.container = container;
		this.requestClient = requestClient;
	}

	public <TargetResource> TargetResource transition(final SafeLinkRelation<TargetResource> linkRelation) {
		return requestClient.transition(container, linkRelation);
	}
	
	@Override
	public Links getLinks() {
		return container.getLinks();
	}

	@Override
	public String getContainerName() {
		return container.getContainerName();
	}

}
