package com.deltek.integration.maconomy.domain.internal;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.deltek.integration.maconomy.domain.HasLinks;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "containerName", "links" })
public class Endpoint implements HasLinks {

	@JsonProperty("containerName")
	private String containerName;
	
	@JsonProperty("links")
    private Links links;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("containerName")
	public String getContainerName() {
		return containerName;
	}

	@JsonProperty("containerName")
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	@JsonProperty("links")
	public Links getLinks() {
		return links;
	}

	@JsonProperty("links")
	public void setLinks(Links links) {
		this.links = links;
	}

    @JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

    @JsonAnySetter
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

}
