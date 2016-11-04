package com.deltek.integration.maconomy.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.deltek.integration.maconomy.containers.v1.data.FilterData;
import com.deltek.integration.maconomy.containers.v1.data.FilterRecord;

public abstract class BaseFilterPane<InitRecordType extends IInitRecord, RecordType extends IRecord>
extends BasePane<InitRecordType, RecordType>
implements IFilter<InitRecordType, RecordType> {

	private final FilterData filterData;
	private final Function<FilterRecord, InitRecordType> initRecordCtorFn;
	private final Function<FilterRecord, RecordType> recordCtorFn;

	protected BaseFilterPane(final IHasClient clientProvider,
			                 final FilterData filterData,
			                 final Function<FilterRecord, InitRecordType> initRecordCtorFn,
			                 final Function<FilterRecord, RecordType> recordCtorFn) {
		super(clientProvider);
		this.filterData = filterData;
		this.initRecordCtorFn = initRecordCtorFn;
		this.recordCtorFn = recordCtorFn;
	}

	@Override
	public FilterData getContext() {
		return filterData;
	}

	@Override
	public List<RecordType> records() {
		final List<RecordType> records = new ArrayList<>();
		for(final FilterRecord record : filterData.getPanes().getFilter().getRecords()) {
			records.add(recordCtorFn.apply(record));
		}
		return records;
	}

}
