package com.deltek.integration.maconomy.custom;

import com.deltek.integration.maconomy.containers.v1.data.CardTableData;

public interface ITable<InitRecordType extends IInitRecord, RecordType extends IRecord>
extends IPane<InitRecordType, RecordType>,
        IHasContext<CardTableData>,
        IInsertAction<CardTableData, InitRecordType>,
        IAddAction<CardTableData, InitRecordType> {
}
