package com.deltek.integration.maconomy.custom;

import com.deltek.integration.maconomy.containers.v1.FilterData;

public interface IFilter<InitRecordType extends IInitRecord, RecordType extends IRecord>
extends IPane<InitRecordType, RecordType>, IHasContext<FilterData> {
}
