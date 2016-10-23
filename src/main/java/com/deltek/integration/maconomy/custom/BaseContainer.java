package com.deltek.integration.maconomy.custom;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.containers.v1.Container;

public abstract class BaseContainer
implements ICustomContainer, IHasClient, IHasContext<Container> {

	private final MaconomyClient maconomyClient;
	private final Container container;

    public BaseContainer(final MaconomyClient maconomyClient,
    		             final String containerName) {
        this.maconomyClient = maconomyClient;
        this.container = maconomyClient.container(containerName);
    }

    @Override
    public MaconomyClient getClient() {
    	return maconomyClient;
    }

    @Override
    public Container getContext() {
    	return container;
    }

}
