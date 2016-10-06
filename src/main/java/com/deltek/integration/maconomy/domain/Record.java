package com.deltek.integration.maconomy.domain;



/**
 * Maconomy record.
 */
public interface Record extends DataProvider, Actionable, HasLinksAndConcurrencyHolder {

  /**
   * @return the meta information associated with this record.
   */
  RecordMeta getMeta();

  /**
   * @return the data contained in this Maconomy record.
   */
  Data getData();

  /**
   * @return the container state that provides the possible values of an enumeration type
   */
  ContainerState getDataEnumValues();

  /**
   * @return the container state that is identified by the same key as the context resource.
   */
  ContainerState getDataSameKey();

}
