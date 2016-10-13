package com.deltek.integration.maconomy.containers.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Schemes {

	private Scheme basic;
	@JsonProperty(value = "x-changepassword")
	private Scheme changepassword;
	@JsonProperty(value = "x-reconnect")
	private Scheme reconnect;
	@JsonProperty(value = "x-resetpassword")
	private Scheme resetpassword;

	public Scheme getBasic() {
		return basic;
	}

	public void setBasic(final Scheme basic) {
		this.basic = basic;
	}

	public Scheme getChangepassword() {
		return changepassword;
	}

	public void setChangepassword(final Scheme changepassword) {
		this.changepassword = changepassword;
	}

	public Scheme getReconnect() {
		return reconnect;
	}

	public void setReconnect(final Scheme reconnect) {
		this.reconnect = reconnect;
	}

	public Scheme getResetpassword() {
		return resetpassword;
	}

	public void setResetpassword(final Scheme resetpassword) {
		this.resetpassword = resetpassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basic == null) ? 0 : basic.hashCode());
		result = prime * result + ((changepassword == null) ? 0 : changepassword.hashCode());
		result = prime * result + ((reconnect == null) ? 0 : reconnect.hashCode());
		result = prime * result + ((resetpassword == null) ? 0 : resetpassword.hashCode());
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
		final Schemes other = (Schemes) obj;
		if (basic == null) {
			if (other.basic != null) {
				return false;
			}
		} else if (!basic.equals(other.basic)) {
			return false;
		}
		if (changepassword == null) {
			if (other.changepassword != null) {
				return false;
			}
		} else if (!changepassword.equals(other.changepassword)) {
			return false;
		}
		if (reconnect == null) {
			if (other.reconnect != null) {
				return false;
			}
		} else if (!reconnect.equals(other.reconnect)) {
			return false;
		}
		if (resetpassword == null) {
			if (other.resetpassword != null) {
				return false;
			}
		} else if (!resetpassword.equals(other.resetpassword)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Schemes [basic=" + basic + ", changepassword=" + changepassword + ", reconnect=" + reconnect
				+ ", resetpassword=" + resetpassword + "]";
	}

}
