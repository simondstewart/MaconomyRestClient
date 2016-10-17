package com.deltek.integration.maconomy.containers.v1;

public class FilterData extends Data {

	private FilterData.Panes panes;

	public FilterData.Panes getPanes() {
		return panes;
	}

	public void setPanes(final FilterData.Panes panes) {
		this.panes = panes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((panes == null) ? 0 : panes.hashCode());
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
		final FilterData other = (FilterData) obj;
		if (panes == null) {
			if (other.panes != null) {
				return false;
			}
		} else if (!panes.equals(other.panes)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "FilterData [panes=" + panes + "]";
	}

	public static class Panes {

		private FilterPane filter;

		public FilterPane getFilter() {
			return filter;
		}

		public void setFilter(final FilterPane filter) {
			this.filter = filter;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((filter == null) ? 0 : filter.hashCode());
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
			final Panes other = (Panes) obj;
			if (filter == null) {
				if (other.filter != null) {
					return false;
				}
			} else if (!filter.equals(other.filter)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Panes [filter=" + filter + "]";
		}

	}

}
