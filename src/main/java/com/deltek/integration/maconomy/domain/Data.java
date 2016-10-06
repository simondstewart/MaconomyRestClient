package com.deltek.integration.maconomy.domain;

import java.util.List;
import java.util.Optional;

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
   * @return the optional value for the {@code field}.
   */
  Optional<MaconomyValue> get(final String fieldName);

}
