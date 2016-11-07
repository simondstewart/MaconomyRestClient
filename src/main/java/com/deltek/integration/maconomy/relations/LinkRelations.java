package com.deltek.integration.maconomy.relations;

import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.FilterData;
import com.deltek.integration.maconomy.containers.v1.specification.Specification;
import com.deltek.integration.maconomy.filedrop.v1.FiledropLocation;

/**
 * Factory that produces link relations.
 */
public class LinkRelations {

	/**
	 * The self link relation indicates a hyperlink to the context resource. This is useful
	 * when a client program interacts with one resource and the web service responds
	 * with the state of another resource.
     *
	 * @return A "self" link relation
	 */
	public static <T extends ContextResource> SafeLinkRelation<T> self(final Class<T> contextResource) {
		return new BaseLinkRelation.SafeLinkRelationImpl<>("self", HttpMethod.GET, contextResource);
	}

	/**
	 * Indicates a link that is used to perform the read state transition. This
	 * obtains a fresh copy of the current resource state. This maps naturally to the
	 * HTTP GET method.
	 *
	 * @param targetType The type of the representation to GET
	 * @return A "action:read" link relation
	 */
	public static <TargetType> SafeLinkRelation<TargetType> read(final Class<TargetType> targetType) {
		return new BaseLinkRelation.SafeLinkRelationImpl<>("action:read", HttpMethod.GET, targetType);
	}

	/**
	 * Indicates a reference to the specification resource for the context resource
     * (a container).
     *
	 * @return A "specification" link relation
	 */
	public static SafeLinkRelation<Specification> specification() {
		return new BaseLinkRelation.SafeLinkRelationImpl<>("specification", HttpMethod.GET, Specification.class);
	}

	/**
	 * Indicates a reference to a container filter resource that can be used to
	 * search for specific resources within the container. If, for example, a client program
	 * wants to display and interact with a particular expense sheet, it uses the filter to
	 * find the link to the resource state of that particular expense sheet.
	 *
	 * @return A "data:filter" link relation
	 */
	public static SafeLinkRelation<FilterData> dataFilter(final FilterRestriction filterRestriction) {
		return new BaseLinkRelation.SafeLinkRelationImpl<>("data:filter", HttpMethod.GET, FilterData.class, filterRestriction);
	}

	/**
     * Indicates a reference to a container resource state that is identified by
     * “any” key. This is often not very useful, since a client program often needs to
     * interact with a specific resource rather than just any resource. To find a reference
     * to the specific resource, a client program must use the filter resource to search for
     * the required resource. However, in some situations, notably in singleton containers
     * that conceptually contain exactly one record for each user, this is the only way to
     * access the resource state.
     *
	 * @return A "data:any-key" link relation
	 */
	public static SafeLinkRelation<CardTableData> dataAnyKey() {
		return new BaseLinkRelation.SafeLinkRelationImpl<>("data:any-key", HttpMethod.GET, CardTableData.class);
	}

	/**
     * Indicates a reference to a container resource state that is identified by
     * the same key as the context resource. This kind of link occurs when a record in a
     * filter contains a link to the full resource state for that particular resource. A record
     * in the filter pane of the ExpenseSheets container links to the full resource state of
     * that particular expense sheet.
     *
	 * @return A "data:same-key" link relation
	 */
	public static SafeLinkRelation<CardTableData> dataSameKey() {
		return new BaseLinkRelation.SafeLinkRelationImpl<>("data:same-key", HttpMethod.GET, CardTableData.class);
	}
	
	/**
	 * Indicates a link that is used to perform a foreign key search.
	 * 
	 * @return A "data:search" link relation
	 */
	public static SafeLinkRelation<FilterData> dataSearch(final FilterRestriction filterRestriction) {
		return new BaseLinkRelation.SafeLinkRelationImpl<>("data:search", HttpMethod.GET, FilterData.class, filterRestriction);
	}

	/**
	 * Indicates a link that is used to obtain the enum values.
	 * 
	 * @return A "data:enumvalues" link relation
	 */
	public static SafeLinkRelation<FilterData> dataEnumValues() {
		return new BaseLinkRelation.SafeLinkRelationImpl<>("data:enumvalues", HttpMethod.GET, FilterData.class);
	}

	/**
     * Indicates a link that is used to perform the initialize state transition in
	 * the insert variant. This resource computes a template to be used when creating
	 * a record. The template record is pre-filled with the default value for each field in
	 * the record. The insert variant is significant in a table pane, where the new record
	 * will be inserted at the position of the record that contains the hyperlink. Client
	 * programs must use the POST method with no request entity to perform this state
	 * transition.
     *
	 * @return A "action:insert" link relation
	 */
	public static SafeLinkRelation<CardTableRecord> insert() {
		return new BaseLinkRelation.SafeLinkRelationImpl<>("action:insert",
				                                           HttpMethod.POST,
				                                           CardTableRecord.class);
	}

	/**
     * Indicates a link that is used to perform the initialize state transition in the
     * add variant. This works like the insert variant described previously, but in a table
     * pane the new record is added at the end of the table. Client programs must use
     * the POST method with no request entity to perform this state transition.
     *
	 * @return A "action:add" link relation
	 */
	public static SafeLinkRelation<CardTableRecord> addCard() {
		return new BaseLinkRelation.SafeLinkRelationImpl<>("action:add",
				                                           HttpMethod.POST,
				                                           CardTableRecord.class);
	}

	/**
     * Indicates a link that is used to perform the initialize state transition in the
     * add variant. This works like the insert variant described previously, but in a table
     * pane the new record is added at the end of the table. Client programs must use
     * the POST method with no request entity to perform this state transition.
     *
	 * @return A "action:add" link relation
	 */
	public static EntityLinkRelation<Void, CardTableRecord> addTable() {
		return new BaseLinkRelation.EntityLinkRelationImpl<Void, CardTableRecord>("action:add",
				                                                                  HttpMethod.POST,
				                                                                  CardTableRecord.class,
				                                                                  null);
	}

	/**
     * Indicates a link that is used to perform the create state transition. This
     * creates a record in a pane. In a card pane, for example, in the ExpenseSheets
     * container, this creates an expense sheet. In a table pane it creates a row in the
     * table, for example another line on the expense sheet. Client programs must use the
     * POST method with a record structure as the request entity.
     *
	 * @return A "action:create" link relation
	 */
	public static EntityLinkRelation<CardTableRecord, CardTableData> create(final CardTableRecord cardTableRecord) {
		return new BaseLinkRelation.EntityLinkRelationImpl<CardTableRecord, CardTableData>("action:create",
				                                                                   HttpMethod.POST,
				                                                                   CardTableData.class,
				                                                                   cardTableRecord);
	}

	/**
     * Indicates a link that is used to perform the update state transition. This
     * state transition changes the values of one or more fields in a record. Client programs
     * must use the POST method with a record structure as the request entity
     *
	 * @return A "action:update" link relation
	 */
	public static EntityLinkRelation<CardTableRecord, CardTableData> update(final CardTableRecord cardTableRecord) {
		return new BaseLinkRelation.EntityLinkRelationImpl<CardTableRecord, CardTableData>("action:update",
				                                                                   HttpMethod.POST,
				                                                                   CardTableData.class,
				                                                                   cardTableRecord);
	}

	/**
     * Indicates a link that is used to perform the delete state transition. This
     * state transition deletes a record. In a card pane, for example, in the ExpenseSheets
     * container, this deletes the expense sheet including any expense sheet lines. In a
     * table pane this deletes a row in the table, such as an expense sheet line. Client
     * programs must use the HTTP DELETE method.
     *
	 * @return A "action:delete" link relation
	 */
	public static EntityLinkRelation<Void, CardTableData> delete() {
		return new BaseLinkRelation.EntityLinkRelationImpl<Void, CardTableData>("action:delete",
				                                                                HttpMethod.DELETE,
				                                                                CardTableData.class,
				                                                                null);
	}

	/**
	 * @return A link relation used to create a new filedrop.
	 */
	public static SafeLinkRelation<FiledropLocation> newFiledrop() {
		return new BaseLinkRelation.SafeLinkRelationImpl<>("filedrop:new", HttpMethod.POST, FiledropLocation.class);
	}

}
