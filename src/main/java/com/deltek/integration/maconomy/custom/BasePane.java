package com.deltek.integration.maconomy.custom;

import com.deltek.integration.maconomy.client.MaconomyClient;

public abstract class BasePane<InitRecordType extends IInitRecord, RecordType extends IRecord>
implements IPane<InitRecordType, RecordType>, IHasClient {

	private final IHasClient clientProvider;

	BasePane(final IHasClient clientProvider) {
		this.clientProvider = clientProvider;
	}

	@Override
	public MaconomyClient getClient() {
		return clientProvider.getClient();
	}

}
