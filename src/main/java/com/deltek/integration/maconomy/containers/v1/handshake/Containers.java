package com.deltek.integration.maconomy.containers.v1.handshake;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Containers {

	private String shortname;
	private Versions versions;
	private List<Language> languages;
	private boolean authenticated;
	private Authentication authentication;

	public String getShortname() {
		return shortname;
	}

	public void setShortname(final String shortname) {
		this.shortname = shortname;
	}

	public Versions getVersions() {
		return versions;
	}

	public void setVersions(final Versions versions) {
		this.versions = versions;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(final List<Language> languages) {
		this.languages = languages;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(final boolean authenticated) {
		this.authenticated = authenticated;
	}

	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(final Authentication authentication) {
		this.authentication = authentication;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (authenticated ? 1231 : 1237);
		result = prime * result + ((authentication == null) ? 0 : authentication.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((shortname == null) ? 0 : shortname.hashCode());
		result = prime * result + ((versions == null) ? 0 : versions.hashCode());
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
		final Containers other = (Containers) obj;
		if (authenticated != other.authenticated) {
			return false;
		}
		if (authentication == null) {
			if (other.authentication != null) {
				return false;
			}
		} else if (!authentication.equals(other.authentication)) {
			return false;
		}
		if (languages == null) {
			if (other.languages != null) {
				return false;
			}
		} else if (!languages.equals(other.languages)) {
			return false;
		}
		if (shortname == null) {
			if (other.shortname != null) {
				return false;
			}
		} else if (!shortname.equals(other.shortname)) {
			return false;
		}
		if (versions == null) {
			if (other.versions != null) {
				return false;
			}
		} else if (!versions.equals(other.versions)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Containers [shortname=" + shortname + ", versions=" + versions + ", languages=" + languages
				+ ", authenticated=" + authenticated + ", authentication=" + authentication + "]";
	}

}
