package com.deltek.integration.maconomy.domain.internal;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "records",
    "links"
})
public class FilterPane<T> {

//    @JsonProperty("meta")
//    private String meta;

    @JsonProperty("records")
    private List<Record<T>> records = new ArrayList<>();
    
    @JsonProperty("links")
    private Links links;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

//    /**
//     * 
//     * @return
//     *     The meta
//     */
//    @JsonProperty("meta")
//    public String getMeta() {
//        return meta;
//    }
//
//    /**
//     * 
//     * @param meta
//     *     The meta
//     */
//    @JsonProperty("meta")
//    public void setMeta(String meta) {
//        this.meta = meta;
//    }

    /**
     * 
     * @return
     *     The records
     */
    @JsonProperty("records")
    public List<Record<T>> getRecords() {
        return records;
    }

    /**
     * 
     * @param records
     *     The records
     */
    @JsonProperty("records")
    public void setRecords(List<Record<T>> records) {
        this.records = records;
    }

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
