package com.deltek.integration.maconomy.custom;

import java.util.function.Function;

import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.relations.LinkRelations;

public interface IHasCard<CardType> extends ICustomContainer {

	public Function<CardTableData, CardType> getCardCtorFn();

	default public CardType card() {
        final CardTableData data = getClient().transition(getContainer(), LinkRelations.dataAnyKey());
        return getCardCtorFn().apply(data);
    }

}
