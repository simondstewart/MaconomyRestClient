package com.deltek.integration.maconomy.containers.v1;

public class ApplicationPackagingUnit {

	private String major;
	private String minor;
	private String patch;
	private String hotfix;

	public String getMajor() {
		return major;
	}

	public void setMajor(final String major) {
		this.major = major;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(final String minor) {
		this.minor = minor;
	}

	public String getPatch() {
		return patch;
	}

	public void setPatch(final String patch) {
		this.patch = patch;
	}

	public String getHotfix() {
		return hotfix;
	}

	public void setHotfix(final String hotfix) {
		this.hotfix = hotfix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotfix == null) ? 0 : hotfix.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((minor == null) ? 0 : minor.hashCode());
		result = prime * result + ((patch == null) ? 0 : patch.hashCode());
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
		final ApplicationPackagingUnit other = (ApplicationPackagingUnit) obj;
		if (hotfix == null) {
			if (other.hotfix != null) {
				return false;
			}
		} else if (!hotfix.equals(other.hotfix)) {
			return false;
		}
		if (major == null) {
			if (other.major != null) {
				return false;
			}
		} else if (!major.equals(other.major)) {
			return false;
		}
		if (minor == null) {
			if (other.minor != null) {
				return false;
			}
		} else if (!minor.equals(other.minor)) {
			return false;
		}
		if (patch == null) {
			if (other.patch != null) {
				return false;
			}
		} else if (!patch.equals(other.patch)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ApplicationPackagingUnit [major=" + major + ", minor=" + minor + ", patch=" + patch + ", hotfix="
				+ hotfix + "]";
	}

}
