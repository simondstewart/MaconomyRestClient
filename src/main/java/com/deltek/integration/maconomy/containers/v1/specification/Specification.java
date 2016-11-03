package com.deltek.integration.maconomy.containers.v1.specification;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Specification {

	private String containerName;

	// TODO: (ANH) Implement remaining specification

	private Panes panes;
	//private Object relatedContainers;

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

}
