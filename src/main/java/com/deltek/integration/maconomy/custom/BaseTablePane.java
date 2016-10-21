package com.deltek.integration.maconomy.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.CardTableRecord;

public abstract class BaseTablePane<InitRecordType, RecordType>
extends BasePane<InitRecordType, RecordType>
implements ITable<InitRecordType, RecordType> {

	private final CardTableData cardTableData;
	private final Function<CardTableRecord, InitRecordType> initRecordCtorFn;
	private final Function<CardTableRecord, RecordType> recordCtorFn;

	protected BaseTablePane(final CardTableData cardTableData,
			               final Function<CardTableRecord, InitRecordType> initRecordCtorFn,
			               final Function<CardTableRecord, RecordType> recordCtorFn) {
		this.cardTableData = cardTableData;
		this.initRecordCtorFn = initRecordCtorFn;
		this.recordCtorFn = recordCtorFn;
	}

	@Override
	public List<RecordType> records() {
		final List<RecordType> records = new ArrayList<>();
		for(final CardTableRecord record : cardTableData.getPanes().getTable().getRecords()) {
			records.add(recordCtorFn.apply(record));
		}
		return records;
	}

}
