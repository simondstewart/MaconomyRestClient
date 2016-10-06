package com.deltek.integration.maconomy.domain.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deltek.integration.maconomy.domain.Link;
import com.deltek.integration.maconomy.domain.LinkRelation;
import com.deltek.integration.maconomy.domain.Links;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by AlesHavlik on 23/06/2015.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinksImpl implements Links {

  @JsonIgnore
  private final Map<String, Link> links = new HashMap<String, Link>();

  @JsonAnyGetter
  public Map<String, Link> getLinks() {
    return links;
  }

  @JsonAnySetter
  public void setLinks(final String name, final Link value) {
    this.links.put(name, value);
  }

  /** {@inheritDoc} */
  @Override
  public List<Link> get() {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public Link get(final LinkRelation relation) {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public List<Link> get(final String keyword) {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public List<Link> getActions() {
    //TODO: implementation left for future as this interface might change
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public List<Link> getData() {
    //TODO: implementation left for future as this interface might change
    return null;
  }

}
