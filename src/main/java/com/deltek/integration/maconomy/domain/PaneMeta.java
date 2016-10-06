package com.deltek.integration.maconomy.domain;


/**
 * Meta information associated with a pane.
 */
public interface PaneMeta extends Meta {

  /**
   * @return the name of this Maconomy pane.
   */
  String paneName();

  /**
   * @return the number of records.
   */
  Integer rowCount();

  /**
   * @return the number of first records that are skipped.
   */
  Integer rowOffset();

}
