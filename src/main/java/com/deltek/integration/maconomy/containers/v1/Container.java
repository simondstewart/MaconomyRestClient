package com.deltek.integration.maconomy.containers.v1;

import com.deltek.integration.maconomy.relations.ContextResource;

public class Container implements ContextResource {

	private String containerName;
	private Links links;

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(final String containerName) {
		this.containerName = containerName;
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
		result = prime * result + ((containerName == null) ? 0 : containerName.hashCode());
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
		final Container other = (Container) obj;
		if (containerName == null) {
			if (other.containerName != null) {
				return false;
			}
		} else if (!containerName.equals(other.containerName)) {
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
		return "Container [containerName=" + containerName + ", links=" + links + "]";
	}

}
