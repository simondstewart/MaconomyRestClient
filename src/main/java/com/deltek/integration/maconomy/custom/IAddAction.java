package com.deltek.integration.maconomy.custom;

import java.util.function.Function;

import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.CardTableRecord;
import com.deltek.integration.maconomy.relations.ContextResource;
import com.deltek.integration.maconomy.relations.LinkRelations;

public interface IAddAction<Context extends ContextResource, RecordType extends IInitRecord>
extends IHasClient, IHasContext<CardTableData> {

	public Function<CardTableRecord, RecordType> getInitRecordCtorFn();

	default RecordType add() {
		final CardTableData cardTableData = getContext();
		final CardTableRecord initData = getClient().transition(cardTableData.getPanes().getTable(),
				                                                LinkRelations.addTable());
		return getInitRecordCtorFn().apply(initData);
	}

}
