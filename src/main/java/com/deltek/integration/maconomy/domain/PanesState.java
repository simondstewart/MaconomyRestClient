package com.deltek.integration.maconomy.domain;

import java.util.List;

/**
 * State of all the Maconomy panes in a context Maconomy container.
 */
public interface PanesState {

  /**
   * @return the state of all the panes.
   */
  List<PaneState> get();

  /**
   * @return the state of filter pane if present among these panes.
   */
  PaneState filter();

  /**
   * @return the state of card pane if present among these panes.
   */
  PaneState card();

  /**
   * @return the state of table pane if present among these panes.
   */
  PaneState table();

}
