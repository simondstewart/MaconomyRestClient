package com.deltek.integration.maconomy.domain.internal;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AlesHavlik on 23/06/2015.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Links {

    @JsonIgnore
    private Map<String, Link> links = new HashMap<String, Link>();

    @JsonAnyGetter
    public Map<String, Link> getLinks() {
        return links;
    }

    @JsonAnySetter
    public void setLinks(String name, Link value) {
        this.links.put(name, value);
    }
}
