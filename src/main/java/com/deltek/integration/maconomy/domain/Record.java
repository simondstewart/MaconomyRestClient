package com.deltek.integration.maconomy.domain;



/**
 * Maconomy record.
 */
public interface Record extends LinkProvider, DataProvider, Actionable {

  /**
   * @return the meta information associated with this record.
   */
  RecordMeta meta();

  /**
   * @return the data contained in this Maconomy record.
   */
  Data data();

  /**
   * @return the container state that provides the possible values of an enumeration type
   */
  ContainerState dataEnumValues();

  /**
   * @return the container state that is identified by the same key as the context resource.
   */
  ContainerState dataSameKey();

}
