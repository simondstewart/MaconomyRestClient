package com.deltek.integration.maconomy.custom;

import java.util.function.Function;

import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.deltek.integration.maconomy.relations.LinkRelations;

public interface IHasCard<CardType> extends IHasClient, IHasContext<Container> {

	public Function<CardTableData, CardType> getCardCtorFn();

	default public CardType card() {
        final CardTableData data = getClient().transition(getContext(), LinkRelations.dataAnyKey());
        return getCardCtorFn().apply(data);
    }

}
