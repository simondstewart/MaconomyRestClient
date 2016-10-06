package com.deltek.integration.maconomy.domain;

import java.util.Optional;

/**
 * Maconomy Value abstraction.
 */
public interface MaconomyValue {

  /**
   * @return the string value of this Maconomy value
   */
  Optional<String> getString();

  /**
   * @return the int value of this Maconomy value
   */
  Optional<Integer> getInt();

}
