package com.deltek.integration.maconomy.client.util;

/**
 * Important Maconomy containers that might be useful for integrations.
 */
public enum ImportantContainers {

	JOBS("jobs"),
	TIMEREGISTRATION("timeregistration"),
	EXPENSESHEETS("expensesheets"),
	NOTES("notes");

	private final String name;
	
	private ImportantContainers(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
