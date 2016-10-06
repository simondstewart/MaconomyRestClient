package com.deltek.integration.maconomy.domain;


/**
 * State of a single Maconomy pane in a context Maconomy container.
 */
public interface PaneState extends HasLinks, Actionable {

  /**
   * @return the meta information associated with this pane state.
   */
  PaneMeta meta();

  /**
   * @return the records that are contained in this Maconomy pane state.
   */
  Records records();

}
