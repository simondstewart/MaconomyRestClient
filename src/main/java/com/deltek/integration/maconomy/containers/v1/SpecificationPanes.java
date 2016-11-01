package com.deltek.integration.maconomy.containers.v1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpecificationPanes {
	
	private SpecificationPane filter, card, table;

	public SpecificationPane getFilter() {
		return filter;
	}

	public void setFilter(SpecificationPane filter) {
		this.filter = filter;
	}

	public SpecificationPane getCard() {
		return card;
	}

	public void setCard(SpecificationPane card) {
		this.card = card;
	}

	public SpecificationPane getTable() {
		return table;
	}

	public void setTable(SpecificationPane table) {
		this.table = table;
	}

}
