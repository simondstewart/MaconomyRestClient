package com.deltek.integration.maconomy.domain.internal;

import static com.deltek.integration.maconomy.util.Constants.ACTION_NAMESPACE;
import static com.deltek.integration.maconomy.util.Constants.DATA_NAMESPACE;
import static com.deltek.integration.maconomy.util.Constants.DELIMITER;

import com.deltek.integration.maconomy.domain.LinkRelation;

/**
 * Implementation of a link relation.
 */
public class LinkRelationImpl implements LinkRelation {

  private final String value;

  /**
   * @param value
   */
  public LinkRelationImpl(final String value) {
    this.value = value;
  }

  /** {@inheritDoc} */
  @Override
  public String value() {
    return value;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isDataRelation() {
    return value().startsWith(DATA_NAMESPACE + DELIMITER);
  }

  /** {@inheritDoc} */
  @Override
  public boolean isActionRelation() {
    return value().startsWith(ACTION_NAMESPACE + DELIMITER);
  }

}
