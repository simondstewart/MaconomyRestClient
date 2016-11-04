package com.deltek.integration.maconomy.containers.v1.specification;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Specification {

	private String containerName;
	private Panes panes;
	private Map<String, RelatedContainer> relatedContainers;

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(final String containerName) {
		this.containerName = containerName;
	}

	public Panes getPanes() {
		return panes;
	}

	public void setPanes(final Panes panes) {
		this.panes = panes;
	}

	public Map<String, RelatedContainer> getRelatedContainers() {
		return relatedContainers;
	}

	public void setRelatedContainers(Map<String, RelatedContainer> relatedContainers) {
		this.relatedContainers = relatedContainers;
	}

}
