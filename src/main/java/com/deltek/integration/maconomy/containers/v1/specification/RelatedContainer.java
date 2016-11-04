package com.deltek.integration.maconomy.containers.v1.specification;

import com.deltek.integration.maconomy.containers.v1.Links;
import com.deltek.integration.maconomy.relations.ContextResource;

public class RelatedContainer implements ContextResource {

	private String containerName;
	private Links links;

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	@Override
	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

}
