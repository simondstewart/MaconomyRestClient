package com.deltek.integration.maconomy.values;

import java.util.Optional;

import com.deltek.integration.maconomy.domain.MaconomyValue;

/**
 * Representation of Maconomy integer value.
 */
public class MaconomyIntegerValue implements MaconomyValue {

  int value;

  private MaconomyIntegerValue(final int value) {
    this.value = value;
  }

  /**
   * @param value
   * @return the new instance of Maconomy integer value
   */
  public static MaconomyValue create(final int value) {
    return new MaconomyIntegerValue(value);
  }

  /** {@inheritDoc} */
  @Override
  public Optional<String> getString() {
    return Optional.of(Integer.toString(value));
  }

  /** {@inheritDoc} */
  @Override
  public Optional<Integer> getInt() {
    return Optional.of(value);
  }

}
