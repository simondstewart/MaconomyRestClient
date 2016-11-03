package com.deltek.integration.maconomy.containers.v1.specification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Field {
	
	private String name;
	private String title;
	private String type;
	private String subtypeContainer;
	private String enumType;
	private boolean key;
	private List<String> references;
	private boolean create;
	private boolean update;
	private boolean hidden;
	private boolean secret;
	private boolean unfilterable;
	private boolean autoSubmit;
	private String suggestions;
	
	private Map<String, Object> others = new HashMap<String, Object>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubtypeContainer() {
		return subtypeContainer;
	}

	public void setSubtypeContainer(String subtypeContainer) {
		this.subtypeContainer = subtypeContainer;
	}

	public String getEnumType() {
		return enumType;
	}

	public void setEnumType(String enumType) {
		this.enumType = enumType;
	}

	public boolean isKey() {
		return key;
	}

	public void setKey(boolean key) {
		this.key = key;
	}

	public List<String> getReferences() {
		return references;
	}

	public void setReferences(List<String> references) {
		this.references = references;
	}

	public boolean isCreate() {
		return create;
	}

	public void setCreate(boolean create) {
		this.create = create;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public boolean isSecret() {
		return secret;
	}

	public void setSecret(boolean secret) {
		this.secret = secret;
	}

	public boolean isUnfilterable() {
		return unfilterable;
	}

	public void setUnfilterable(boolean unfilterable) {
		this.unfilterable = unfilterable;
	}

	public boolean isAutoSubmit() {
		return autoSubmit;
	}

	public void setAutoSubmit(boolean autoSubmit) {
		this.autoSubmit = autoSubmit;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	@JsonAnyGetter
	public Map<String, Object> getOthers() {
		return others;
	}

	@JsonAnySetter
	public void setOther(String name, Object value) {
		this.others.put(name, value);
	}

}
