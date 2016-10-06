package com.deltek.integration.maconomy.domain;

/**
 * Marks entities that provide Maconomy links.
 */
public interface LinkProvider {

  /**
   * @return the collection of Maconomy links associated with this resource.
   */
  Links links();

}
