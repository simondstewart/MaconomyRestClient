package com.deltek.integration.maconomy.custom;

import java.util.function.Function;

import com.deltek.integration.maconomy.containers.v1.FilterData;
import com.deltek.integration.maconomy.relations.FilterRestriction;
import com.deltek.integration.maconomy.relations.LinkRelations;

public interface IHasFilter<FilterType> extends ICustomContainer {

	public Function<FilterData, FilterType> getFilterCtorFn();

	default public FilterType filter(final FilterRestriction restriction) {
        final FilterData data = getClient().transition(getContainer(), LinkRelations.dataFilter(restriction));
        return getFilterCtorFn().apply(data);
    }

}
