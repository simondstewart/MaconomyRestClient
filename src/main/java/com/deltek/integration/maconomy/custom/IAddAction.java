package com.deltek.integration.maconomy.custom;

import static java.util.Optional.empty;

import java.util.function.Function;

import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.CardTableRecord;
import com.deltek.integration.maconomy.relations.ContextResource;
import com.deltek.integration.maconomy.relations.LinkRelations;

public interface IAddAction<Context extends ContextResource, RecordType extends IInitRecord>
extends IHasClient, IHasContext<CardTableData> {

	public Function<CardTableRecord, RecordType> getInitRecordCtorFn();

	default RecordType add() {
		final CardTableData cardTableData = getContext();
		final CardTableRecord initData = getClient().transition(cardTableData.getPanes().getTable(), LinkRelations.addTable(), empty());
		return getInitRecordCtorFn().apply(initData);
	}

}
