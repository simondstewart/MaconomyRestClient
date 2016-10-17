package com.deltek.integration.maconomy.containers.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "meta", "data", "links" })
public class FilterRecord extends Record {

	private FilterRecord.Meta meta;

	public FilterRecord.Meta getMeta() {
		return meta;
	}

	public void setMeta(final FilterRecord.Meta meta) {
		this.meta = meta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((meta == null) ? 0 : meta.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final FilterRecord other = (FilterRecord) obj;
		if (meta == null) {
			if (other.meta != null) {
				return false;
			}
		} else if (!meta.equals(other.meta)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "FilterRecord [meta=" + meta + "]";
	}

	public static class Meta {

		private int rowNumber;

		public int getRowNumber() {
			return rowNumber;
		}

		public void setRowNumber(final int rowNumber) {
			this.rowNumber = rowNumber;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + rowNumber;
			return result;
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Meta other = (Meta) obj;
			if (rowNumber != other.rowNumber) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Meta [rowNumber=" + rowNumber + "]";
		}

	}
}
