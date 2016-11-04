package com.deltek.integration.maconomy.containers.v1.data;

public class CardTableData extends Data {

	private CardTableData.Panes panes;

	public CardTableData.Panes getPanes() {
		return panes;
	}

	public void setPanes(final CardTableData.Panes panes) {
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
		final CardTableData other = (CardTableData) obj;
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
		return "CardTableData [panes=" + panes + "]";
	}

	public static class Panes {

		private CardTablePane card, table;

		public CardTablePane getCard() {
			return card;
		}

		public void setCard(final CardTablePane card) {
			this.card = card;
		}

		public CardTablePane getTable() {
			return table;
		}

		public void setTable(final CardTablePane table) {
			this.table = table;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((card == null) ? 0 : card.hashCode());
			result = prime * result + ((table == null) ? 0 : table.hashCode());
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
			if (card == null) {
				if (other.card != null) {
					return false;
				}
			} else if (!card.equals(other.card)) {
				return false;
			}
			if (table == null) {
				if (other.table != null) {
					return false;
				}
			} else if (!table.equals(other.table)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Panes [card=" + card + ", table=" + table + "]";
		}

	}

}
