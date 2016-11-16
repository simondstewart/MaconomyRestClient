package com.deltek.integration.maconomy;

public class Constants {

	/** Name of the foreign key linking expense sheet line to an activity. */
	public static final String ACTIVITYNUMBER_ACTIVITY_FOREIGN_KEY = "activitynumber_activity";

	/** Name of the field used for foreign key search in the {@code Constants#JOBS} container. */
	public static final String PROJECT_MANAGER_NUMBER = "projectmanagernumber";

	/** Default package for custom generated code: com.deltek.integration.maconomy.custom.codegen */
	public static final String CUSTOM_PACKAGE = "com.deltek.integration.maconomy.custom.codegen";

	/** Path to output directory for generated code which should not be under version control */
	public static final String GENERATED = "generated/src/test/java/";

	/** Path to test output directory. */
	public static final String TEST_OUTPUT = "test/output/";

}
