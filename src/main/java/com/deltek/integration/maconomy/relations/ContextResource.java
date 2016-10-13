package com.deltek.integration.maconomy.relations;

import com.deltek.integration.maconomy.containers.v1.Links;

/**
 * A Context Resource is the starting point of a state transition. The other
 * end is called the Target Resource. The possible transitions from a given
 * context resource are available as a collection of hyperlinks.
 */
public interface ContextResource {

	public Links getLinks();

}
