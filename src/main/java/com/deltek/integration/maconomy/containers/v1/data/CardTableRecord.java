package com.deltek.integration.maconomy.containers.v1.data;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "meta", "data", "links" })
public class CardTableRecord extends Record implements Meta<CardTableRecord.Meta> {

	private CardTableRecord.Meta meta;

	@Override
	public CardTableRecord.Meta getMeta() {
		return meta;
	}

	public void setMeta(final CardTableRecord.Meta meta) {
		this.meta = meta;
	}

	public static class Meta implements ConcurrencyControl {

		private int rowNumber;
		private String concurrencyControl;

		public int getRowNumber() {
			return rowNumber;
		}

		public void setRowNumber(final int rowNumber) {
			this.rowNumber = rowNumber;
		}

		@Override
		public String getConcurrencyControl() {
			return concurrencyControl;
		}

		public void setConcurrencyControl(final String concurrencyControl) {
			this.concurrencyControl = concurrencyControl;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((concurrencyControl == null) ? 0 : concurrencyControl.hashCode());
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
			if (concurrencyControl == null) {
				if (other.concurrencyControl != null) {
					return false;
				}
			} else if (!concurrencyControl.equals(other.concurrencyControl)) {
				return false;
			}
			if (rowNumber != other.rowNumber) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Meta [rowNumber=" + rowNumber + ", concurrencyControl=" + concurrencyControl + "]";
		}

	}

}
