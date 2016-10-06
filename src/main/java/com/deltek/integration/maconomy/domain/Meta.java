package com.deltek.integration.maconomy.domain;

import java.util.Map;

/**
 * Meta properties associated with the resource.
 */
public interface Meta {

  /**
   * @return the map of the additional properties contained in this meta element.
   */
  Map<String, Object> getAdditionalProperties();

}
