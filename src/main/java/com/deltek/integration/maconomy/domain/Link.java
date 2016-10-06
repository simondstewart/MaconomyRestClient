/**
 *
 */
package com.deltek.integration.maconomy.domain;


/**
 * Maconomy link returned from the web service.
 */
public interface Link {

  /**
   * @return the link URL
   */
  String getHref();

  /**
   * @return the link relation associated with this link.
   */
  String getRel();

}
