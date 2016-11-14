package com.deltek.integration.maconomy.containers.v1;

public interface ContainersConstants {

	/** Path for version 1 of the containers API. */
	public static final String PATH = "/containers/v1";

	public static final String MACONOMY_AUTHENTICATION = "Maconomy-Authentication";

	public static final String MACONOMY_RECONNECT = "Maconomy-Reconnect";

	public static final String X_RECONNECT = "X-Reconnect";

	public static final String MACONOMY_CONCURRENCY_CONTROL = "Maconomy-Concurrency-Control";

	/** Request header used to specify the language in which the terms returned from the server should be localized. */
	public static final String ACCEPT_LANGUAGE = "Accept-Language";

	/** Request header used to format data in the prints. */
	public static final String MACONOMY_FORMAT = "Maconomy-Format";

	/** Maconomy format header value part that indicates how the server should format date values. */
	public static final String DATE_FORMAT = "date-format";

	/** Maconomy format header value part that indicates how the server should format time values. */
	public static final String TIME_FORMAT = "time-format";

	/** Maconomy format header value part that indicates the character used as a thousand separator. */
	public static final String THOUSAND_SEPARATOR = "thousand-separator";

	/** Maconomy format header value part that indicates the character used as a decimal separator. */
	public static final String DECIMAL_SEPARATOR = "decimal-separator";

	/** Maconomy format header value part that indicates the number of decimals to include. */
	public static final String NUMBER_OF_DECIMALS = "number-of-decimals";

	/** Placeholder used in link template to be replaced with the container name the user is navigating to. */
	public static final String CONTAINER_PLACEHOLDER = "{container}";

}
