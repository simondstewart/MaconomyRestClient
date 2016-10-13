package com.deltek.integration.maconomy.relations;

import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.FilterData;
import com.deltek.integration.maconomy.containers.v1.Specification;

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
	public static <T extends ContextResource> LinkRelation<T> self(final Class<T> contextResource) {
		return new BaseLinkRelation<>("self", HttpMethod.GET, contextResource);
	}

	/**
	 * Indicates a reference to the specification resource for the context resource
     * (a container).
     *
	 * @return A "specification" link relation
	 */
	public static LinkRelation<Specification> specification() {
		return new BaseLinkRelation<>("specification", HttpMethod.GET, Specification.class);
	}

	/**
	 * Indicates a reference to a container filter resource that can be used to
	 * search for specific resources within the container. If, for example, a client program
	 * wants to display and interact with a particular expense sheet, it uses the filter to
	 * find the link to the resource state of that particular expense sheet.
	 *
	 * @return A "data:filter" link relation
	 */
	public static LinkRelation<FilterData> dataFilter() {
		return new BaseLinkRelation<>("data:filter", HttpMethod.GET, FilterData.class);
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
	public static LinkRelation<CardTableData> dataAnyKey() {
		return new BaseLinkRelation<>("data:any-key", HttpMethod.GET, CardTableData.class);
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
	public static LinkRelation<CardTableRecord> insert() {
		return new BaseLinkRelation<>("action:insert", HttpMethod.POST, CardTableRecord.class);
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
	public static LinkRelation<CardTableData> create() {
		return new BaseLinkRelation<>("action:create", HttpMethod.POST, CardTableData.class);
	}
}
