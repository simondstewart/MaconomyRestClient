package com.deltek.integration.maconomy.custom;

import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.CardTableRecord;
import com.deltek.integration.maconomy.relations.LinkRelations;

public interface ICreateAction<CardType extends ICard<?,?>>
extends IHasClient, IHasContext<CardTableRecord>, IHasCardCtor<CardType> {

	default CardType create() {
		final CardTableData data = getClient().transition(getContext(), LinkRelations.create(getContext()));
		return getCardCtorFn().apply(data);
	}

}
