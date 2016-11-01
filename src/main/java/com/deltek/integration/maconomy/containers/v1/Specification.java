package com.deltek.integration.maconomy.containers.v1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Specification {

	private String containerName;

	// TODO: (ANH) Implement remaining specification

	private SpecificationPanes panes;
	//private Object relatedContainers;

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(final String containerName) {
		this.containerName = containerName;
	}

	public SpecificationPanes getPanes() {
		return panes;
	}

	public void setPanes(final SpecificationPanes panes) {
		this.panes = panes;
	}

}
