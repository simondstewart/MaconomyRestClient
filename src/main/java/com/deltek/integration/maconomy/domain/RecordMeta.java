package com.deltek.integration.maconomy.domain;


/**
 * Meta information associated with a record.
 */
public interface RecordMeta extends Meta {

  /**
   * @return the row number of this Maconomy record.
   */
  Integer rowNumber();

}
