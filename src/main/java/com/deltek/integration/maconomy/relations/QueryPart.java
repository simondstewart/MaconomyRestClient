package com.deltek.integration.maconomy.relations;

public class QueryPart {

	private final String name;
	private final Object[] values;

	QueryPart(final String name, final Object... values) {
		this.name = name;
		this.values = values;
	}

	public String getName() {
		return name;
	}

	public Object[] getValues() {
		return values;
	}

}
