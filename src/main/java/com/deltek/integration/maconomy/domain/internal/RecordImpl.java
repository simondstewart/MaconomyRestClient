package com.deltek.integration.maconomy.domain.internal;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.deltek.integration.maconomy.domain.ContainerState;
import com.deltek.integration.maconomy.domain.Criteria;
import com.deltek.integration.maconomy.domain.Data;
import com.deltek.integration.maconomy.domain.Link;
import com.deltek.integration.maconomy.domain.Links;
import com.deltek.integration.maconomy.domain.Record;
import com.deltek.integration.maconomy.domain.RecordMeta;
import com.deltek.integration.maconomy.util.PredefinedLinkRelations;
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
public class RecordImpl implements Record {

  @JsonProperty("meta")
  private RecordMetaImpl meta;

  @JsonProperty("data")
  private DataImpl data;

  @JsonProperty("links")
  private LinksImpl links;

  @JsonIgnore
  private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * @return The data
   */
  @JsonProperty("data")
  public Data getData() {
    return data;
  }

  /**
   * @param data The data
   */
  @JsonProperty("data")
  public void setData(final DataImpl data) {
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
  public void setMeta(final RecordMetaImpl meta) {
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

  /** {@inheritDoc} */
  @Override
  public ContainerState getDataEnumValues() {
    final Link link = links.getLinks().get(PredefinedLinkRelations.DATA_ENUMVALUES.value());
    //TODO: either we will be returning null values, "empty objects", or optional containers
    if (link != null) {
      return getData(link);
    }
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public ContainerState getDataSameKey() {
    //TODO: implement following getDataEnumValues once the approach is agreed upon
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public ContainerState getData(final Link link) {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public ContainerState getData(final Link link, final Criteria criteria) {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public ContainerState getAction(final Link link) {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public ContainerState getAction(final Link link, final Record record) {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public Record getActionInsert() {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public Record getActionAdd() {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public ContainerState getActionCreate(final Record record) {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public ContainerState getActionUpdate(final Record record) {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public ContainerState getActionDelete() {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public ContainerState getActionPrint() {
    //TODO: implementation left for future as this interface might change
    return null;
  }

}
