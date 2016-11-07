package com.deltek.integration.maconomy.custom;

import java.util.function.Function;

import com.deltek.integration.maconomy.containers.v1.data.CardTableData;

public interface IHasCardCtor<CardType extends ICard<?,?>> {

	public Function<CardTableData, CardType> getCardCtorFn();

}
