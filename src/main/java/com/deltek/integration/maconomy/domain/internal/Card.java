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
    "meta",
    "records"
})
public class Card<T> {

    @JsonProperty("meta")
    private CardMeta meta;
    @JsonProperty("records")
    private List<Record<T>> records = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The meta
     */
    @JsonProperty("meta")
    public CardMeta getMeta() {
        return meta;
    }

    /**
     * 
     * @param meta
     *     The meta
     */
    @JsonProperty("meta")
    public void setMeta(CardMeta meta) {
        this.meta = meta;
    }

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
