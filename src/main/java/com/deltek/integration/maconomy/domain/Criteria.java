package com.deltek.integration.maconomy.domain;

import java.util.List;
import java.util.Optional;


/**
 * Search criteria used to select the record set returned by the Maconomy filter.
 */
public interface Criteria {

  /**
   * @return the maximum number of records that Maconomy filter will contain; default 25 if not specified.
   */
  Optional<Integer> limit();

  /**
   * @return first results that are skipped; default 0 if not specified.
   */
  Optional<Integer> offset();

  /**
   * @return field names that Maconomy filter will contain; key fields are always included; by default all fields are included if not
   * specified.
   */
  List<String> fields();

  /**
   * @return the list of restrictions defined.
   */
  List<String> restrictions();

  /**
   * @return the list of other criteria that were defined explicitly.
   */
  List<String> others();

  /**
   * @return if any non-default criterion is present
   */
  boolean isAny();

}
