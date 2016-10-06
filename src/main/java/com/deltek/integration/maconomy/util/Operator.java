package com.deltek.integration.maconomy.util;

/**
 * Set of operators supported in restrictions.
 */
public enum Operator {

  /** Equals. */
  EQUALS("="), //$NON-NLS-1$
  /** Not equals. */
  NOT_EQUALS("!="), //$NON-NLS-1$
  /** Less. */
  LESS("<"), //$NON-NLS-1$
  /** Greater. */
  GREATER(">"), //$NON-NLS-1$
  /** Less or equals*/
  LESS_EQUALS("<="), //$NON-NLS-1$
  /** Greater or equals. */
  GREATER_EQUALS(">="), //$NON-NLS-1$
  /** Wildcard. */
  LIKE("like"); //$NON-NLS-1$

  private String value;

  private Operator(final String value) {
    this.value = value;
  }

  /**
   * @return the representation value of this operator
   */
  public String value() {
    return value;
  }

}
