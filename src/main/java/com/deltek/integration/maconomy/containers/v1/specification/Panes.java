package com.deltek.integration.maconomy.containers.v1.specification;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Panes {
	
	private Pane filter, card, table;

	public Pane getFilter() {
		return filter;
	}

	public void setFilter(Pane filter) {
		this.filter = filter;
	}

	public Pane getCard() {
		return card;
	}

	public void setCard(Pane card) {
		this.card = card;
	}

	public Pane getTable() {
		return table;
	}

	public void setTable(Pane table) {
		this.table = table;
	}

}
