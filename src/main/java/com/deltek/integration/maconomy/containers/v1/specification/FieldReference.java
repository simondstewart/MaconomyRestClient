package com.deltek.integration.maconomy.containers.v1.specification;

public class FieldReference {

	private String field;
	private String foreignField;
	private boolean supplement;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getForeignField() {
		return foreignField;
	}

	public void setForeignField(String foreignField) {
		this.foreignField = foreignField;
	}

	public boolean isSupplement() {
		return supplement;
	}

	public void setSupplement(boolean supplement) {
		this.supplement = supplement;
	}

}
