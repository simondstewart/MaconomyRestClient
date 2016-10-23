package com.deltek.integration.maconomy.custom;

import java.util.function.Function;

import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.CardTableRecord;
import com.deltek.integration.maconomy.relations.LinkRelations;

public interface IAddAction<RecordType extends IInitRecord>
extends IHasClient, IHasContext<CardTableData> {

	public Function<CardTableRecord, RecordType> getInitRecordCtorFn();

	default RecordType insert() {
		final CardTableRecord initData = getClient().transition(getContext(), LinkRelations.add());
		return getInitRecordCtorFn().apply(initData);
	}

}
