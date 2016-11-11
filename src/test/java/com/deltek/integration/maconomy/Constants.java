package com.deltek.integration.maconomy;

public class Constants {

	/** Jobs container */
	public static final String JOBS = "jobs";

	/** TimeRegistration container */
	public static final String TIMEREGISTRATION = "timeregistration";

	/** Notes container */
	public static final String NOTES = "notes";

	/** Name of the field used for foreign key search in the {@code Constants#JOBS} container. */
	public static final String PROJECT_MANAGER_NUMBER = "projectmanagernumber";

	/** Default package for custom generated code: com.deltek.integration.maconomy.custom.codegen */
	public static final String CUSTOM_PACKAGE = "com.deltek.integration.maconomy.custom.codegen";

	/** Path to output directory for generated code which should not be under version control */
	public static final String GENERATED = "generated/src/test/java/";

	/** Path to test output directory. */
	public static final String TEST_OUTPUT = "test/output/";

}
