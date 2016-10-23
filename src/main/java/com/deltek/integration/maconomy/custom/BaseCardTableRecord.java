package com.deltek.integration.maconomy.custom;

import java.util.function.Function;

import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.CardTableRecord;

public abstract class BaseCardTableRecord<CardType extends ICard<?,?>>
extends BaseRecord<CardTableRecord>
implements IHasCardCtor<CardType> {

	private final Function<CardTableData, CardType> cardCtorFn;

	public BaseCardTableRecord(final IHasClient clientProvider,
                               final CardTableRecord context,
		                       final Function<CardTableData, CardType> cardCtorFn) {
		super(clientProvider, context);
		this.cardCtorFn = cardCtorFn;
	}

	@Override
	public Function<CardTableData, CardType> getCardCtorFn() {
		return cardCtorFn;
	}

}
