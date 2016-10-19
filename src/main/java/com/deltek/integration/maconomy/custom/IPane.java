package com.deltek.integration.maconomy.custom;

import java.util.List;

public interface IPane<InitRecordType, RecordType> {

	List<RecordType> records();

}
