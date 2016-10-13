package com.deltek.integration.maconomy.containers.v1;

import com.deltek.integration.maconomy.relations.ContextResource;

public abstract class Data implements ContextResource {

	private Data.Meta meta;
	private Links links;

	public Data.Meta getMeta() {
		return meta;
	}

	public void setMeta(final Data.Meta meta) {
		this.meta = meta;
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
		result = prime * result + ((meta == null) ? 0 : meta.hashCode());
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
		final Data other = (Data) obj;
		if (links == null) {
			if (other.links != null) {
				return false;
			}
		} else if (!links.equals(other.links)) {
			return false;
		}
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
		return "Data [meta=" + meta + ", links=" + links + "]";
	}

	public static final class Meta {

		private String containerName;

		public String getContainerName() {
			return containerName;
		}

		public void setContainerName(final String containerName) {
			this.containerName = containerName;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((containerName == null) ? 0 : containerName.hashCode());
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
			if (containerName == null) {
				if (other.containerName != null) {
					return false;
				}
			} else if (!containerName.equals(other.containerName)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Meta [containerName=" + containerName + "]";
		}

	}

}
