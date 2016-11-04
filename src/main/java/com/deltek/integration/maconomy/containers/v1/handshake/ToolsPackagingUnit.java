package com.deltek.integration.maconomy.containers.v1.handshake;

public class ToolsPackagingUnit {

	private String major;
	private String minor;
	private String sp;
	private String fix;
	private String beta;

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

	public String getSp() {
		return sp;
	}

	public void setSp(final String sp) {
		this.sp = sp;
	}

	public String getFix() {
		return fix;
	}

	public void setFix(final String fix) {
		this.fix = fix;
	}

	public String getBeta() {
		return beta;
	}

	public void setBeta(final String beta) {
		this.beta = beta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beta == null) ? 0 : beta.hashCode());
		result = prime * result + ((fix == null) ? 0 : fix.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((minor == null) ? 0 : minor.hashCode());
		result = prime * result + ((sp == null) ? 0 : sp.hashCode());
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
		final ToolsPackagingUnit other = (ToolsPackagingUnit) obj;
		if (beta == null) {
			if (other.beta != null) {
				return false;
			}
		} else if (!beta.equals(other.beta)) {
			return false;
		}
		if (fix == null) {
			if (other.fix != null) {
				return false;
			}
		} else if (!fix.equals(other.fix)) {
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
		if (sp == null) {
			if (other.sp != null) {
				return false;
			}
		} else if (!sp.equals(other.sp)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ToolsPackagingUnit [major=" + major + ", minor=" + minor + ", sp=" + sp + ", fix=" + fix + ", beta="
				+ beta + "]";
	}

}
