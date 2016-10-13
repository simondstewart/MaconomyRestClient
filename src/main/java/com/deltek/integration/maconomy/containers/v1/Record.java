package com.deltek.integration.maconomy.containers.v1;

import java.util.Map;

import com.deltek.integration.maconomy.relations.ContextResource;

public abstract class Record implements ContextResource {

	private Links links;
	private Map<String, Object> data;

	@Override
	public Links getLinks() {
		return links;
	}

	public void setLinks(final Links links) {
		this.links = links;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(final Map<String, Object> data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		final Record other = (Record) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
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
		return "Record [links=" + links + ", data=" + data + "]";
	}

}
