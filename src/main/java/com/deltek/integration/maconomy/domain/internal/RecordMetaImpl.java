package com.deltek.integration.maconomy.domain.internal;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.deltek.integration.maconomy.domain.RecordMeta;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "concurrencyControl",
    "rowNumber",
})
public class RecordMetaImpl implements RecordMeta {

    @JsonProperty("concurrencyControl")
    private String concurrencyControl;
    @JsonProperty("rowNumber")
    private Integer rowNumber;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The concurrencyControl
     */
    @JsonProperty("concurrencyControl")
    public String getConcurrencyControl() {
        return concurrencyControl;
    }

    /**
     *
     * @param concurrencyControl
     *     The concurrencyControl
     */
    @JsonProperty("concurrencyControl")
    public void setConcurrencyControl(final String concurrencyControl) {
        this.concurrencyControl = concurrencyControl;
    }

    /**
     *
     * @return
     *     The rowCount
     */
    @JsonProperty("rowNumber")
    public Integer getRowNumber() {
        return rowNumber;
    }

    /**
     *
     * @param rowNumber
     *     The rowNumber
     */
    @JsonProperty("rowNumber")
    public void setRowNumber(final Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(final String name, final Object value) {
        this.additionalProperties.put(name, value);
    }

}
