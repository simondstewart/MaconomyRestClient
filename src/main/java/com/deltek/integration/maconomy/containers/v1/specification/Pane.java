package com.deltek.integration.maconomy.containers.v1.specification;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pane {
	
	private String paneName;
	private String title;
	private String entity;
	private Actions actions;
	private Map<String, Field> fields;

	public String getPaneName() {
		return paneName;
	}

	public void setPaneName(String paneName) {
		this.paneName = paneName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Actions getActions() {
		return actions;
	}

	public void setActions(Actions actions) {
		this.actions = actions;
	}

	public Map<String, Field> getFields() {
		return fields;
	}

	public void setFields(Map<String, Field> fields) {
		this.fields = fields;
	}

}
