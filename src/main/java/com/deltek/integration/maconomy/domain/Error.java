package com.deltek.integration.maconomy.domain;

/**
 * Error returned from Maconomy.
 */
public interface Error {

  /**
   * @return the error family.
   */
  String family();

  /**
   * @return the error message.
   */
  String message();

  /**
   * @return the error severity.
   */
  String severity();

  /**
   * @return the focus field of the error.
   */
  Focus focus();

}
