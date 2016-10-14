package com.deltek.integration.maconomy.containers.v1;

import com.deltek.integration.maconomy.relations.ContextResource;

public interface Meta<MetaType extends ConcurrencyControl> extends ContextResource {

	public MetaType getMeta();

}
