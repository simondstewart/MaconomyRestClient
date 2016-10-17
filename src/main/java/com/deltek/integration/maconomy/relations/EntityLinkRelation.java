package com.deltek.integration.maconomy.relations;

public interface EntityLinkRelation<EntityType, TargetResource> extends LinkRelation<TargetResource> {

	EntityType getEntity();

}
