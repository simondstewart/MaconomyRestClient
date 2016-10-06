package com.deltek.integration.maconomy.domain;


/**
 * Maconomy link relation.
 */
public interface LinkRelation {

  /**
   * @return value of this link relation
   */
  String value();

  /**
   * @return if this link relation is a data relation
   */
  boolean isDataRelation();

  /**
   * @return if this link relation is an action relation
   */
  boolean isActionRelation();

}
