package com.deltek.integration.maconomy.util;

/**
 * Various constants used with Maconomy web service.
 */
public class Constants {

  //******************************* URI ********************************/
  /** Template URI serving as a base for accessing the resources. */
  public static final String BASE_URI_TEMPLATE = "http://{serverAddress}:{serverPort}"; //$NON-NLS-1$
  /** Path template used to access the containers endpoint. */
  public static final String CONTAINERS_PATH_TEMPLATE = "containers/v1/{databaseShortname}"; //$NON-NLS-1$
  /** Part of the path that indicates that "any" key should be used to select the record of the context resource. */
  public static final String ANY_RECORD ="data;any"; //$NON-NLS-1$

  //**************************** containers ****************************/
  /** Name of the container used to check that the provided login credentials are correct. */
  public static final String LOGIN_CONTAINER = "api_currentemployee"; //$NON-NLS-1$

  //***************************** headers ******************************/
  /** Header used to indicate the Maconomy authentication method used. */
  public static final String MACONOMY_AUTHENTICATION_HEADER = "Maconomy-Authentication"; //$NON-NLS-1$
  /** Authorization header. */
  public static final String AUTHORIZATION_HEADER = "Authorization"; //$NON-NLS-1$
  /** Basic authentication method. */
  public static final String BASIC_HTTP_AUTHENTICATION = "Basic"; //$NON-NLS-1$
  /** Header included in the server response containing the Maconomy reconnect token as a value. */
  public static final String MACONOMY_RECONNECT_HEADER = "Maconomy-Reconnect"; //$NON-NLS-1$
  /** Indicates that Maconomy reconnect token should be used as an authentication method. */
  public static final String RECONNECT_HEADER_VALUE = "X-Reconnect"; //$NON-NLS-1$

  //************************** link relations **************************/
  /** Delimiter used to separate parts of the link relation. */
  public static final char DELIMITER = ':';
  /** Namespace for the link relations that represent the data fetch operations. */
  public static final String DATA_NAMESPACE = "data"; //$NON-NLS-1$
  /** Namespace for the link relations that represent actions. */
  public static final String ACTION_NAMESPACE = "action"; //$NON-NLS-1$

}
