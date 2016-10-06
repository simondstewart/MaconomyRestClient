package com.deltek.integration.maconomy.domain.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.deltek.integration.maconomy.domain.Criteria;
import com.deltek.integration.maconomy.domain.CriteriaBuilder;
import com.deltek.integration.maconomy.domain.Restriction;


/**
 * Default search criteria builder implementation.
 */
public class CriteriaBuilderImpl implements CriteriaBuilder {

  private Optional<Integer> limit = Optional.empty();
  private Optional<Integer> offset = Optional.empty();
  private List<String> fields = new ArrayList<String>();
  private final List<String> restrictions = new ArrayList<String>();
  private final List<String> others = new ArrayList<String>();

  /** Constructor */
  public CriteriaBuilderImpl() { }

  /** {@inheritDoc} */
  @Override
  public CriteriaBuilder limit(final int newLimit) {
    limit = Optional.of(newLimit);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public CriteriaBuilder offset(final int newOffset) {
    offset = Optional.of(newOffset);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public CriteriaBuilder fields(final List<String> selectedFields) {
    fields = selectedFields;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public CriteriaBuilder restriction(final String newRestriction) {
    restrictions.add(newRestriction);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public CriteriaBuilder restriction(final Restriction newRestriction) {
    restrictions.add(newRestriction.toString());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public CriteriaBuilder other(final String newOther) {
    others.add(newOther);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Criteria build() {
    return new DefaultCriteria(limit, offset, fields, restrictions, others);
  }

  private static class DefaultCriteria implements Criteria {

    private final Optional<Integer> limit;
    private final Optional<Integer> offset;
    private final List<String> fields;
    private final List<String> restrictions;
    private final List<String> others;

    private DefaultCriteria(final Optional<Integer> limit,
                            final Optional<Integer> offset,
                            final List<String> fields,
                            final List<String> restrictions,
                            final List<String> others) {
      this.limit = limit;
      this.offset = offset;
      this.fields = fields;
      this.restrictions = restrictions;
      this.others = others;
    }

    /** {@inheritDoc} */
    @Override
    public Optional<Integer> limit() {
      return limit;
    }

    /** {@inheritDoc} */
    @Override
    public Optional<Integer> offset() {
      return offset;
    }

    /** {@inheritDoc} */
    @Override
    public List<String> fields() {
      return fields;
    }

    /** {@inheritDoc} */
    @Override
    public List<String> restrictions() {
      return restrictions;
    }

    /** {@inheritDoc} */
    @Override
    public List<String> others() {
      return others;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isAny() {
      return limit.isPresent() || offset.isPresent() || !fields.isEmpty() || !restrictions.isEmpty() || !others.isEmpty();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
      //TODO: return a representation that can be directly placed into a URI
      return "DefaultCriteria [limit=" + limit + ", offset=" + offset + ", fields=" + fields + ", restrictions=" + restrictions + ", other=" + others + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
    }

  }

}
