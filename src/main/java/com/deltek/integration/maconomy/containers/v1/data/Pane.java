package com.deltek.integration.maconomy.containers.v1.data;

import java.util.List;

import com.deltek.integration.maconomy.containers.v1.Links;
import com.deltek.integration.maconomy.relations.ContextResource;

public abstract class Pane<RecordType> implements ContextResource {

	private Links links;

	private List<RecordType> records;
	public List<RecordType> getRecords() {
		return records;
	}

	public void setRecords(final List<RecordType> records) {
		this.records = records;
	}

	@Override
	public Links getLinks() {
		return links;
	}

	public void setLinks(final Links links) {
		this.links = links;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((links == null) ? 0 : links.hashCode());
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
		final Pane<?> other = (Pane<?>) obj;
		if (links == null) {
			if (other.links != null) {
				return false;
			}
		} else if (!links.equals(other.links)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Pane [links=" + links + "]";
	}

}
