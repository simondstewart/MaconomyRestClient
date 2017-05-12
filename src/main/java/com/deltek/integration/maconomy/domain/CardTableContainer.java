package com.deltek.integration.maconomy.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.deltek.integration.maconomy.psorestclient.domain.JobBudget;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "panes",
    "links"
})
public class CardTableContainer<T, U> {

    @JsonProperty("panes")
    private CardTablePanes<T, U> panes;
    @JsonProperty("links")
    private Links links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The panes
     */
    @JsonProperty("panes")
    public CardTablePanes<T, U> getPanes() {
        return panes;
    }

    /**
     * 
     * @param panes
     *     The panes
     */
    @JsonProperty("panes")
    public void setPanes(CardTablePanes<T, U> panes) {
        this.panes = panes;
    }

    @JsonProperty("links")
    public Links getLinks() {
        return links;
    }

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

    public List<Record<U>> tableRecords() {
    	if(getPanes() == null) {
    		throw new RuntimeException("No Panes for this Container");
    	}
    	if(getPanes().getTable() == null) {
    		throw new RuntimeException("No Table Pane in this Container.");
    	}
    	return getPanes().getTable().getRecords();
    }
    
    public Record<U> lastRecord() {
    	return tableRecords().get(tableRecords().size() - 1);
    }
    
    public Record<U> recordAt(Integer index) {
    	return tableRecords().get(index);
    }
    
    public U dataAt(Integer index) {
    	return tableRecords().get(index).getData();
    }
    
    public Record<T> card() {
    	if(getPanes() == null) {
    		throw new RuntimeException("No Panes for this Container");
    	}
    	if(getPanes().getCard() == null) {
    		throw new RuntimeException("No Card Pane in this Container.");
    	}
    	if(getPanes().getCard().getRecords() == null || getPanes().getCard().getRecords().size() == 0) {
    		throw new RuntimeException("No Records for Card Pane.");
    	}
        return getPanes().getCard().getRecords().get(0);
    }
    
}
