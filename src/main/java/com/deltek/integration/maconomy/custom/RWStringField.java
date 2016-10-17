package com.deltek.integration.maconomy.custom;

import java.util.Map;

public class RWStringField extends RStringField implements IStringFieldSetter {

	public RWStringField(final Map<String, Object> recordData, final String fieldName) {
		super(recordData, fieldName);
	}

	@Override
	public void set(final String value) {
		this.recordData.put(this.fieldName, value);
	}

}
