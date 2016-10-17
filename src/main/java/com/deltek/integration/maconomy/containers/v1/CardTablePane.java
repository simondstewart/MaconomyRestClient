package com.deltek.integration.maconomy.containers.v1;

import java.util.List;


public class CardTablePane extends Pane implements Meta<CardTablePane.Meta> {

	private CardTablePane.Meta meta;
	private List<CardTableRecord> records;

	@Override
	public CardTablePane.Meta getMeta() {
		return meta;
	}

	public void setMeta(final CardTablePane.Meta meta) {
		this.meta = meta;
	}

	public List<CardTableRecord> getRecords() {
		return records;
	}

	public void setRecords(final List<CardTableRecord> records) {
		this.records = records;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((meta == null) ? 0 : meta.hashCode());
		result = prime * result + ((records == null) ? 0 : records.hashCode());
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
		final CardTablePane other = (CardTablePane) obj;
		if (meta == null) {
			if (other.meta != null) {
				return false;
			}
		} else if (!meta.equals(other.meta)) {
			return false;
		}
		if (records == null) {
			if (other.records != null) {
				return false;
			}
		} else if (!records.equals(other.records)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CardTablePane [meta=" + meta + ", records=" + records + "]";
	}

	public static class Meta implements ConcurrencyControl {

		private String paneName;
		private String concurrencyControl;
		private int rowCount;
		private int rowOffset;

		public String getPaneName() {
			return paneName;
		}

		public void setPaneName(final String paneName) {
			this.paneName = paneName;
		}

		@Override
		public String getConcurrencyControl() {
			return concurrencyControl;
		}

		public void setConcurrencyControl(final String concurrencyControl) {
			this.concurrencyControl = concurrencyControl;
		}

		public int getRowCount() {
			return rowCount;
		}

		public void setRowCount(final int rowCount) {
			this.rowCount = rowCount;
		}

		public int getRowOffset() {
			return rowOffset;
		}

		public void setRowOffset(final int rowOffset) {
			this.rowOffset = rowOffset;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((concurrencyControl == null) ? 0 : concurrencyControl.hashCode());
			result = prime * result + ((paneName == null) ? 0 : paneName.hashCode());
			result = prime * result + rowCount;
			result = prime * result + rowOffset;
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
			if (paneName == null) {
				if (other.paneName != null) {
					return false;
				}
			} else if (!paneName.equals(other.paneName)) {
				return false;
			}
			if (rowCount != other.rowCount) {
				return false;
			}
			if (rowOffset != other.rowOffset) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Meta [paneName=" + paneName + ", concurrencyControl=" + concurrencyControl + ", rowCount="
					+ rowCount + ", rowOffset=" + rowOffset + "]";
		}

	}
}
