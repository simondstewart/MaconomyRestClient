package com.deltek.integration.maconomy.domain;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "meta",
        "data",
        "links"
})
public class Record<T> implements HasLinksAndConcurrencyHolder {

    @JsonProperty("meta")
    private RecordMeta meta;

    @JsonProperty("data")
    private T data;

    @JsonProperty("links")
    private Links links;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The data
     */
    @JsonProperty("data")
    public T getData() {
        return data;
    }

    /**
     * @param data The data
     */
    @JsonProperty("data")
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return The meta
     */
    @JsonProperty("meta")
    public RecordMeta getMeta() {
        return meta;
    }

    /**
     * @param meta The meta
     */
    @JsonProperty("meta")
    public void setMeta(RecordMeta meta) {
        this.meta = meta;
    }


    /**
     * @return The links
     */
    @JsonProperty("links")
    public Links getLinks() {
        return links;
    }

    /**
     * @param links The links
     */
    @JsonProperty("links")
    public void setLinks(Links links) {
        this.links = links;
    }



    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
