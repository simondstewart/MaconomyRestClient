package com.deltek.integration.maconomy.containers.v1.specification;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Actions {

	private Map<String, Action> others = new HashMap<String, Action>();

	@JsonAnyGetter
	public Map<String, Action> getOthers() {
		return others;
	}

	@JsonAnySetter
	public void setAction(String name, Action action) {
		others.put(name, action);
	}

}
