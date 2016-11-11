package com.deltek.integration.maconomy.relations;

import java.util.Collections;

abstract class BaseLinkRelation<TargetResource> implements LinkRelation<TargetResource>{

	private final String name;
	private final HttpMethod method;
	private final Class<TargetResource> targetResource;
	private final Iterable<QueryPart> query;

	BaseLinkRelation(final String name,
			         final HttpMethod method,
			         final Class<TargetResource> targetResource,
			         final Iterable<QueryPart> query) {
		this.name = name;
		this.method = method;
		this.targetResource = targetResource;
		this.query = query;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public HttpMethod getMethod() {
		return method;
	}

	@Override
	public Class<TargetResource> getTargetResource() {
		return targetResource;
	}

	@Override
	public Iterable<QueryPart> getQuery() {
		return query;
	}

	public static final class EntityLinkRelationImpl<EntityType, TargetResource> extends BaseLinkRelation<TargetResource>
	                                                                             implements EntityLinkRelation<EntityType, TargetResource> {

		private final EntityType entity;

		EntityLinkRelationImpl(final String name,
				               final HttpMethod method,
				               final Class<TargetResource> targetResource,
				               final EntityType entity) {
			super(name, method, targetResource, Collections.<QueryPart>emptyList());
			this.entity = entity;
		}

		EntityLinkRelationImpl(final String name,
				               final HttpMethod method,
				               final Class<TargetResource> targetResource,
				               final Iterable<QueryPart> query,
				               final EntityType entity) {
			super(name, method, targetResource, query);
			this.entity = entity;
		}

		@Override
		public EntityType getEntity() {
			return entity;
		}

	}

	public static final class SafeLinkRelationImpl<TargetResource> extends BaseLinkRelation<TargetResource>
	                                                               implements SafeLinkRelation<TargetResource> {

		SafeLinkRelationImpl(final String name, final HttpMethod method, final Class<TargetResource> targetResource, final Iterable<QueryPart> query) {
			super(name, method, targetResource, query);
		}

		SafeLinkRelationImpl(final String name, final HttpMethod method, final Class<TargetResource> targetResource) {
			this(name, method, targetResource, Collections.<QueryPart>emptyList());
		}

	}

}
