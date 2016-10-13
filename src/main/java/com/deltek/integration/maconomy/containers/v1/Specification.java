package com.deltek.integration.maconomy.containers.v1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Specification {

	private String containerName;

	// TODO: (ANH) Implement remaining specification

	//private Object panes;
	//private Object relatedContainers;

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(final String containerName) {
		this.containerName = containerName;
	}

}
