package com.deltek.integration.maconomy.domain;

import org.springframework.expression.spel.ast.Operator;


/**
 * Restriction used as part of the Maconomy filter record selection.
 */
public interface Restriction {

  /**
   * @return the name of the field used in the restriction.
   */
  String fieldName();

  /**
   * @return the operator used in the restriction.
   */
  Operator operator();

  /**
   * @return the value used in the restriction.
   */
  MaconomyValue value();

}
