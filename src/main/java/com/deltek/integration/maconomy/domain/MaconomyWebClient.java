package com.deltek.integration.maconomy.domain;


/**
 * Client that is used to initialize the session with the Maconomy RESTful web service.
 */
public interface MaconomyWebClient {

  /**
   * @return basic information about the Maconomy installation, such as version, languages and authentication methods supported.
   */
  Service service();

  /**
   * @param username
   * @param password
   * @return if it was possible to successfully log into Maconomy with the provided username and password.
   */
  boolean login(final String username, final String password);

  /**
   * @param containerName
   * @return a Maconomy container for the given name.
   */
  Container container(final String containerName);

}
