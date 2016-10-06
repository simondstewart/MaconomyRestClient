package com.deltek.integration.maconomy.domain;

import java.util.List;

import com.deltek.integration.maconomy.domain.internal.CriteriaBuilderImpl;


/**
 * Builder for search criteria.
 */
public interface CriteriaBuilder {

  /**
   * @return the new criteria builder.
   */
  static CriteriaBuilder create() {
    return new CriteriaBuilderImpl();
  }

  /**
   * @param newLimit the maximum number of records that Maconomy filter will contain; default 25
   * @return this builder.
   */
  CriteriaBuilder limit(final int newLimit);

  /**
   * @param newOffset first results that are skipped; default 0
   * @return this builder.
   */
  CriteriaBuilder offset(final int newOffset);

  /**
   * @param selectedFields that Maconomy filter will contain; key fields are always included; by default all fields are included
   * @return this builder.
   */
  CriteriaBuilder fields(final List<String> selectedFields);

  /**
   * @param newRestriction
   * @return this builder.
   */
  CriteriaBuilder restriction(final String newRestriction);

  /**
   * @param newRestriction
   * @return this builder.
   */
  CriteriaBuilder restriction(final Restriction newRestriction);

  /**
   * @param newOther that will be placed as is when creating the final criteria
   * @return this builder.
   */
  CriteriaBuilder other(final String newOther);

  /**
   * @return the search criteria to use for executing search.
   */
  Criteria build();

}
