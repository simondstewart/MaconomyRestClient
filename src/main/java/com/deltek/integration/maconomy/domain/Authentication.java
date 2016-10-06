package com.deltek.integration.maconomy.domain;

/**
 * Authentication part of the service.
 */
public interface Authentication {

  /**
   * @return the supported authentication schemes.
   */
  Schemes schemes();

}
