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
    "paneName",
    "concurrencyControl",
    "rowCount",
    "rowOffset"
})
public class TableMeta {

    @JsonProperty("paneName")
    private String paneName;
    @JsonProperty("concurrencyControl")
    private String concurrencyControl;
    @JsonProperty("rowCount")
    private Integer rowCount;
    @JsonProperty("rowOffset")
    private Integer rowOffset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The paneName
     */
    @JsonProperty("paneName")
    public String getPaneName() {
        return paneName;
    }

    /**
     * 
     * @param paneName
     *     The paneName
     */
    @JsonProperty("paneName")
    public void setPaneName(String paneName) {
        this.paneName = paneName;
    }

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
    public void setConcurrencyControl(String concurrencyControl) {
        this.concurrencyControl = concurrencyControl;
    }

    /**
     * 
     * @return
     *     The rowCount
     */
    @JsonProperty("rowCount")
    public Integer getRowCount() {
        return rowCount;
    }

    /**
     * 
     * @param rowCount
     *     The rowCount
     */
    @JsonProperty("rowCount")
    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    /**
     * 
     * @return
     *     The rowOffset
     */
    @JsonProperty("rowOffset")
    public Integer getRowOffset() {
        return rowOffset;
    }

    /**
     * 
     * @param rowOffset
     *     The rowOffset
     */
    @JsonProperty("rowOffset")
    public void setRowOffset(Integer rowOffset) {
        this.rowOffset = rowOffset;
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
