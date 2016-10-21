package com.deltek.integration.maconomy.relations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jersey.repackaged.com.google.common.base.Joiner;

public class FilterRestriction implements Iterable<QueryPart> {

	public static String RESTRICTION = "";
	public static int LIMIT = 25;
	public static int OFFSET = 0;

	private final String restriction;
	private final int limit;
	private final int offset;
	private final List<String> select = new ArrayList<>();
	private final List<OrderBy> orderBy = new ArrayList<>();

	private FilterRestriction(final String restriction, final int limit, final int offset) {
		this.restriction = restriction;
		this.limit = limit;
		this.offset = offset;
	}

	@Override
	public Iterator<QueryPart> iterator() {
		final List<QueryPart> parts = new ArrayList<>();
		if (!restriction.isEmpty()) {
			parts.add(new QueryPart("restriction", restriction));
		}
		if (limit != LIMIT) {
			parts.add(new QueryPart("limit", limit));
		}
		if (offset != OFFSET) {
			parts.add(new QueryPart("offset", offset));
		}
		if (!select.isEmpty()) {
			parts.add(new QueryPart("fields", Joiner.on(',').join(select).toLowerCase()));
		}
		if (!orderBy.isEmpty()) {
			parts.add(new QueryPart("orderby", Joiner.on(',').join(orderBy).toLowerCase()));
		}
		return parts.iterator();
	}

	public static FilterRestriction none() {
		return new FilterRestriction(RESTRICTION, LIMIT, OFFSET);
	}

	public static FilterRestriction restrict(final String restriction, final int limit, final int offset) {
		return new FilterRestriction(restriction, limit, offset);
	}

	public static FilterRestriction restrict(final String restriction,
			                                 final int limit,
			                                 final int offset,
			                                 final List<String> select,
			                                 final List<OrderBy> orderBy) {
		final FilterRestriction filterRestriction = new FilterRestriction(restriction, limit, offset);
		filterRestriction.select.addAll(select);
		filterRestriction.orderBy.addAll(orderBy);
		return filterRestriction;
	}

	public static final class OrderBy {
		private final SortOrder sortOrder;
		private final String fieldName;

		public OrderBy(final SortOrder sortOrder, final String fieldName) {
			this.sortOrder = sortOrder;
			this.fieldName = fieldName;
		}

		@Override
		public String toString() {
			return sortOrder.sign + fieldName;
		}

		public enum SortOrder {
			UNDEFINED(""), ASCENDING("+"), DESCENDING("-");
			public final String sign;

			SortOrder(final String sign) {
				this.sign = sign;
			}
		}
	}


}
