package com.deltek.integration.maconomy.relations;

abstract class BaseLinkRelation<TargetResource> implements LinkRelation<TargetResource>{

	private final String name;
	private final HttpMethod method;
	private final Class<TargetResource> targetResource;

	BaseLinkRelation(final String name,
			         final HttpMethod method,
			         final Class<TargetResource> targetResource) {
		this.name = name;
		this.method = method;
		this.targetResource = targetResource;
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

	public static final class EntityLinkRelationImpl<EntityType, TargetResource> extends BaseLinkRelation<TargetResource>
	                                                                             implements EntityLinkRelation<EntityType, TargetResource> {

		EntityLinkRelationImpl(final String name, final HttpMethod method, final Class<TargetResource> targetResource) {
			super(name, method, targetResource);
		}

	}

	public static final class BasicLinkRelationImpl<TargetResource> extends BaseLinkRelation<TargetResource>
	                                                                implements BasicLinkRelation<TargetResource> {

		BasicLinkRelationImpl(final String name, final HttpMethod method, final Class<TargetResource> targetResource) {
			super(name, method, targetResource);
		}

	}

}
