package com.deltek.integration.maconomy.domain.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
  "records",
  "links"
})
public class FilterPane<T> {

  //    @JsonProperty("meta")
  //    private String meta;

  @JsonProperty("records")
  private List<RecordImpl> records = new ArrayList<>();

  @JsonProperty("links")
  private LinksImpl links;

  @JsonIgnore
  private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
  public List<RecordImpl> getRecords() {
    return records;
  }

  /**
   *
   * @param records
   *     The records
   */
  @JsonProperty("records")
  public void setRecords(final List<RecordImpl> records) {
    this.records = records;
  }

  @JsonProperty("links")
  public LinksImpl getLinks() {
    return links;
  }

  /**
   * @param links The links
   */
  @JsonProperty("links")
  public void setLinks(final LinksImpl links) {
    this.links = links;
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
