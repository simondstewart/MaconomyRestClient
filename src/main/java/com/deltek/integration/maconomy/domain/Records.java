package com.deltek.integration.maconomy.domain;

import java.util.List;

/**
 * Record set contained by the Maconomy pane.
 */
public interface Records {

  /**
   * @return the list of all records.
   */
  List<Record> get();

}
