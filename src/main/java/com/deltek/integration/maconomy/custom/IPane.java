package com.deltek.integration.maconomy.custom;

import java.util.List;

public interface IPane<InitRecordType extends IInitRecord, RecordType extends IRecord> {

	List<RecordType> records();

}
