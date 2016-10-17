package com.deltek.integration.maconomy.custom;

import java.util.List;

public interface ICard<CreateRecordType, UpdateRecordType> {
	List<UpdateRecordType> records();
}
