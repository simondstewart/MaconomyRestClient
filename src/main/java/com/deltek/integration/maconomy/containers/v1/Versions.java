package com.deltek.integration.maconomy.containers.v1;

public class Versions {

	private ToolsPackagingUnit tpu;
	private ApplicationPackagingUnit apu;

	public ToolsPackagingUnit getTpu() {
		return tpu;
	}

	public void setTpu(final ToolsPackagingUnit tpu) {
		this.tpu = tpu;
	}

	public ApplicationPackagingUnit getApu() {
		return apu;
	}

	public void setApu(final ApplicationPackagingUnit apu) {
		this.apu = apu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apu == null) ? 0 : apu.hashCode());
		result = prime * result + ((tpu == null) ? 0 : tpu.hashCode());
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
		final Versions other = (Versions) obj;
		if (apu == null) {
			if (other.apu != null) {
				return false;
			}
		} else if (!apu.equals(other.apu)) {
			return false;
		}
		if (tpu == null) {
			if (other.tpu != null) {
				return false;
			}
		} else if (!tpu.equals(other.tpu)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Versions [tpu=" + tpu + ", apu=" + apu + "]";
	}

}
