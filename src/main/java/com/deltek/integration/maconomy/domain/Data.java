package com.deltek.integration.maconomy.domain;

import java.util.List;

/**
 * Data that is contained in a Maconomy record.
 */
public interface Data {

  /**
   * @return a list of field names for this data.
   */
  List<String> fields();

  /**
   * @param fieldName
   * @return the Maconomy value for the {@code field}.
   */
  MaconomyValue get(final String fieldName);

}
