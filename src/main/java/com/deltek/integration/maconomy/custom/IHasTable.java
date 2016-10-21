package com.deltek.integration.maconomy.custom;

import java.util.function.Function;

import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.relations.LinkRelations;

public interface IHasTable<TableType> extends ICustomContainer {

	public Function<CardTableData, TableType> getTableCtorFn();

	default public TableType table() {
        final CardTableData data = getClient().transition(getContainer(), LinkRelations.dataAnyKey());
        return getTableCtorFn().apply(data);
    }

}
