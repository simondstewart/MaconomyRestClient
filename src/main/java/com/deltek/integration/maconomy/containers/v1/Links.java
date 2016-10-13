package com.deltek.integration.maconomy.containers.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.deltek.integration.maconomy.relations.LinkRelation;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Links {

    @JsonIgnore
    private final Map<String, Link> links = new HashMap<String, Link>();

    /**
     * Convenience method to get link relations on Context Resources.
     *
     * @param linkRelation The link relation to lookup
     * @return Either a link or {@code Optional#empty()}
     */
    public Optional<Link> get(final LinkRelation<?> linkRelation) {
    	final String name = linkRelation.getName();
    	if (links.containsKey(name)) {
        	return Optional.of(links.get(name));
        } else {
        	return Optional.empty();
        }
    }

    @JsonAnySetter
    public void setLinks(final String name, final Link value) {
        this.links.put(name, value);
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
		final Links other = (Links) obj;
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
		return "Links [links=" + links + "]";
	}

}
