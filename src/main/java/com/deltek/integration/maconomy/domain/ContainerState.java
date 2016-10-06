package com.deltek.integration.maconomy.domain;


/**
 * Maconomy container state.
 */
public interface ContainerState extends LinkProvider {

  /**
   * @return the meta information associated with this container state.
   */
  ContainerMeta meta();

  /**
   * @return the link to this resource.
   */
  Link self();

  /**
   * @return the state of all the panes for this Maconomy container.
   */
  PanesState panes();

}
