package com.deltek.integration.maconomy.containers.v1.specification;

import java.util.List;

import com.deltek.integration.maconomy.containers.v1.Links;
import com.deltek.integration.maconomy.relations.ContextResource;

public class ForeignKey implements ContextResource {

	private String name;
	private String rel;
	private String searchContainer;
	private String searchPane;
	private String title;
	private boolean incomplete;
	private List<FieldReference> fieldReferences;
	private Links links;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getSearchContainer() {
		return searchContainer;
	}

	public void setSearchContainer(String searchContainer) {
		this.searchContainer = searchContainer;
	}

	public String getSearchPane() {
		return searchPane;
	}

	public void setSearchPane(String searchPane) {
		this.searchPane = searchPane;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isIncomplete() {
		return incomplete;
	}

	public void setIncomplete(boolean incomplete) {
		this.incomplete = incomplete;
	}

	public List<FieldReference> getFieldReferences() {
		return fieldReferences;
	}

	public void setFieldReferences(List<FieldReference> fieldReferences) {
		this.fieldReferences = fieldReferences;
	}

	@Override
	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

}
