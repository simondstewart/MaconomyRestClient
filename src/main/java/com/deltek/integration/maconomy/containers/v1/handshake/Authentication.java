package com.deltek.integration.maconomy.containers.v1.handshake;

public class Authentication {

	private boolean useDomainCredentialsForBasicAuthentication;
	private Schemes schemes;

	public boolean isUseDomainCredentialsForBasicAuthentication() {
		return useDomainCredentialsForBasicAuthentication;
	}

	public void setUseDomainCredentialsForBasicAuthentication(
			final boolean useDomainCredentialsForBasicAuthentication) {
		this.useDomainCredentialsForBasicAuthentication = useDomainCredentialsForBasicAuthentication;
	}

	public Schemes getSchemes() {
		return schemes;
	}

	public void setSchemes(final Schemes schemes) {
		this.schemes = schemes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((schemes == null) ? 0 : schemes.hashCode());
		result = prime * result + (useDomainCredentialsForBasicAuthentication ? 1231 : 1237);
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
		final Authentication other = (Authentication) obj;
		if (schemes == null) {
			if (other.schemes != null) {
				return false;
			}
		} else if (!schemes.equals(other.schemes)) {
			return false;
		}
		if (useDomainCredentialsForBasicAuthentication != other.useDomainCredentialsForBasicAuthentication) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Authentication [useDomainCredentialsForBasicAuthentication="
				+ useDomainCredentialsForBasicAuthentication + ", schemes=" + schemes + "]";
	}

}
