package com.deltek.integration.maconomy.custom;

import java.util.function.Function;

import com.deltek.integration.maconomy.containers.v1.data.CardTableRecord;
import com.deltek.integration.maconomy.relations.ContextResource;
import com.deltek.integration.maconomy.relations.LinkRelations;

public interface IInsertAction<Context extends ContextResource, RecordType extends IInitRecord>
extends IHasClient, IHasContext<Context> {

	public Function<CardTableRecord, RecordType> getInitRecordCtorFn();

	default RecordType insert() {
		final CardTableRecord initData = getClient().transition(getContext(), LinkRelations.insert());
		return getInitRecordCtorFn().apply(initData);
	}

}
