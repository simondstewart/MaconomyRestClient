package com.deltek.integration.maconomy.custom;

import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.Container;
import com.deltek.integration.maconomy.relations.LinkRelations;

public interface IHasCard<CardType extends ICard<?, ?>>
extends IHasClient, IHasContext<Container>, IHasCardCtor<CardType> {

	default public CardType card() {
        final CardTableData data = getClient().transition(getContext(), LinkRelations.dataAnyKey());
        return getCardCtorFn().apply(data);
    }

}
