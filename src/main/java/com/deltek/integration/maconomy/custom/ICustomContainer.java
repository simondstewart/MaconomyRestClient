package com.deltek.integration.maconomy.custom;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.containers.v1.Container;

/**
 * Marker interface for custom containers
 */
public interface ICustomContainer {

	MaconomyClient getClient();

	Container getContainer();

}
