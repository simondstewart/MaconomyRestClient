package com.deltek.integration.maconomy.custom;

import com.deltek.integration.maconomy.containers.v1.ConcurrencyControl;
import com.deltek.integration.maconomy.containers.v1.Meta;

public class BaseCardTableRecord<Context extends Meta<? extends ConcurrencyControl>>
extends BaseRecord<Context> {


	public BaseCardTableRecord(final IHasClient clientProvider,
                               final Context context) {
		super(clientProvider, context);
	}

}
