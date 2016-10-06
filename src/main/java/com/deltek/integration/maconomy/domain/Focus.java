package com.deltek.integration.maconomy.domain;

/**
 * Optional focus if the error was caused by a field.
 */
public interface Focus {

  /**
   * @return the name of the focus field.
   */
  String fieldName();

  /**
   * @return the pane name where the focus field is located.
   */
  String paneName();

  /**
   * @return the row number of the record where the field is located.
   */
  int rowNumber();

}
