package com.deltek.integration.maconomy.domain.internal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by AlesHavlik on 23/06/2015.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Link {

    @JsonProperty("template")
    private String template;

    @JsonProperty("href")
    private String href;

    @JsonProperty("rel")
    private String rel;


    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("rel")
    public String getRel() {
        return rel;
    }

    @JsonProperty("rel")
    public void setRel(String rel) {
        this.rel = rel;
    }
}
