package com.deltek.integration.maconomy.domain;


/**
 * Authentication schemes used in Maconomy installation.
 */
public interface Schemes {

  /**
   * @return the X-Reconnect authentication scheme details.
   */
  Scheme xReconnect();

}
