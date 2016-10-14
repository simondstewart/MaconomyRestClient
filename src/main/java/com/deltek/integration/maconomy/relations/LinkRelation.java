package com.deltek.integration.maconomy.relations;

/**
 * Representation of a transition between a context resource and a target resource.
 *
 * @param <TargetResource> A type corresponding to a REST API response.
 * @param <EntityType> A type representing the entity or payload type..
 */
public interface LinkRelation<TargetResource, EntityType> {

	/**
	 * The name used to identify the link relation.
	 *
	 * @return A name indicating the type of link relation.
	 */
	String getName();

	/**
	 * The HTTP method associated with this link relation.
	 *
	 * @return A HTTP method supported by the REST API.
	 */
	HttpMethod getMethod();

	/**
	 * The type of the target resource when following this transition.
	 *
	 * @return A target type corresponding to a REST API response.
	 */
	Class<TargetResource> getTargetResource();

}
