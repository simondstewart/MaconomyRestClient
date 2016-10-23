package com.deltek.integration.maconomy.custom;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.relations.ContextResource;

public class BaseRecord<Context extends ContextResource>
implements IHasClient, IHasContext<Context> {

	private final IHasClient clientProvider;
	private final Context context;

	public BaseRecord(final IHasClient clientProvider,
			          final Context context) {
		this.clientProvider = clientProvider;
		this.context = context;
	}

	@Override
	public MaconomyClient getClient() {
		return clientProvider.getClient();
	}

	@Override
	public Context getContext() {
		return context;
	}
}
