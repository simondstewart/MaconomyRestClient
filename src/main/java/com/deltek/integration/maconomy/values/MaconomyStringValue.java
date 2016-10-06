package com.deltek.integration.maconomy.values;

import java.util.Optional;

import com.deltek.integration.maconomy.domain.MaconomyValue;

/**
 * Representation of Maconomy String value.
 */
public class MaconomyStringValue implements MaconomyValue {

  String value;

  private MaconomyStringValue(final String value) {
    this.value = value;
  }

  /**
   * @param value
   * @return the new instance of Maconomy string value
   */
  public static MaconomyValue create(final String value) {
    return new MaconomyStringValue(value);
  }

  /** {@inheritDoc} */
  @Override
  public Optional<String> getString() {
    return Optional.of(value);
  }

  /** {@inheritDoc} */
  @Override
  public Optional<Integer> getInt() {
    return Optional.empty();
  }

}
