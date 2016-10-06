package com.deltek.integration.maconomy.domain;

import java.util.List;

/**
 * Meta properties associated with the resource.
 */
public interface Meta {

  /**
   * @return the list of all the names of properties contained in this meta element.
   */
  List<String> names();

  /**
   * @param name
   * @return the value of a meta property for {@code name}, in case it does not exist {@code null} is returned.
   */
  String get(final String name);

}
