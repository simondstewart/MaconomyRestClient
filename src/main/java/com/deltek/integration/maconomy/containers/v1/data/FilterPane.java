package com.deltek.integration.maconomy.containers.v1.data;

public class FilterPane extends Pane<FilterRecord> {

	private FilterPane.Meta meta;

	public FilterPane.Meta getMeta() {
		return meta;
	}

	public void setMeta(final FilterPane.Meta meta) {
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
		final FilterPane other = (FilterPane) obj;
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
		return "FilterPane [meta=" + meta + ", records=]";
	}

	public static class Meta {

		private String paneName;
		private int rowCount;
		private int rowOffset;

		public String getPaneName() {
			return paneName;
		}

		public void setPaneName(final String paneName) {
			this.paneName = paneName;
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
			return "Meta [paneName=" + paneName + ", rowCount=" + rowCount + ", rowOffset=" + rowOffset + "]";
		}

	}
}
