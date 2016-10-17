package com.deltek.integration.maconomy.custom;

import java.util.Map;

public class RStringField implements IStringFieldGetter {

	protected final Map<String, Object> recordData;
	protected final String fieldName;

	public RStringField(final Map<String, Object> recordData, final String fieldName) {
		this.recordData = recordData;
		this.fieldName = fieldName;
	}

	@Override
	public String get() {
		return (String) this.recordData.get(fieldName);
	}

}
