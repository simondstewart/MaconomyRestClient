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
	private String switchField;
	private String switchValue;
	private List<FieldReference> fieldReferences;
	private Links links;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(final String rel) {
		this.rel = rel;
	}

	public String getSearchContainer() {
		return searchContainer;
	}

	public void setSearchContainer(final String searchContainer) {
		this.searchContainer = searchContainer;
	}

	public String getSearchPane() {
		return searchPane;
	}

	public void setSearchPane(final String searchPane) {
		this.searchPane = searchPane;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public boolean isIncomplete() {
		return incomplete;
	}

	public void setIncomplete(final boolean incomplete) {
		this.incomplete = incomplete;
	}

	public String getSwitchField() {
		return switchField;
	}

	public void setSwitchField(final String switchField) {
		this.switchField = switchField;
	}

	public String getSwitchValue() {
		return switchValue;
	}

	public void setSwitchValue(final String switchValue) {
		this.switchValue = switchValue;
	}

	public List<FieldReference> getFieldReferences() {
		return fieldReferences;
	}

	public void setFieldReferences(final List<FieldReference> fieldReferences) {
		this.fieldReferences = fieldReferences;
	}

	@Override
	public Links getLinks() {
		return links;
	}

	public void setLinks(final Links links) {
		this.links = links;
	}

}
