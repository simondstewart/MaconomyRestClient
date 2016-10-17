package com.deltek.integration.maconomy.relations;

/**
 * A safe link relation represents a transition that does not cause side effects.
 *
 * @param <TargetResource> The response type
 */
public interface SafeLinkRelation<TargetResource> extends LinkRelation<TargetResource> {

}
