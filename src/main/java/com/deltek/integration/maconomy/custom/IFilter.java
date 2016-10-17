package com.deltek.integration.maconomy.custom;

import java.util.List;

public interface IFilter<CreateRecordType, UpdateRecordType> {
	List<UpdateRecordType> records();
}
