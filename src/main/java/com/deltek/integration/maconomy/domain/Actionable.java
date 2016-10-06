package com.deltek.integration.maconomy.domain;

/**
 * Marks entities that have action links.
 */
public interface Actionable {

  /**
   * Performs the action of the {@code link} previously obtained from the Maconomy web service. Uses HTTP POST method with no request
   * entity. Returns the updated container state on successful completion.
   * @param link
   * @return the updated container state.
   */
  ContainerState action(final Link link);

  /**
   * Performs the action of the {@code link} previously obtained from the Maconomy web service with the {@code record} sent as a request entity.
   * Uses HTTP POST method with {@code record} as the request entity. Returns the updated container state on successful completion.
   * @param link
   * @param record
   * @return the updated container state.
   */
  ContainerState action(final Link link, final Record record);

  /**
   * Initiates an insert of a new record. For a table pane, the new record will be inserted at the position of the record where the
   * action was invoked from. Template record is returned on successful completion.
   * @return the template record.
   */
  Record actionInsert();

  /**
   * Initiates an add of a new record. For a table pane, the new record will be added at the end of the table. Template record is
   * returned on successful completion.
   * @return the template record.
   */
  Record actionAdd();

  /**
   * Invokes a create action that saves new {@code record} in the database. Returns the updated container state on successful completion.
   * @param record to create in the database
   * @return the updated container state.
   */
  ContainerState actionCreate(final Record record);

  /**
   * Invokes an update action on the context resource that changes the values of fields to the ones that are contained in {@code record}.
   * Returns the updated container state on successful completion.
   * @param record with fields to update
   * @return the updated container state.
   */
  ContainerState actionUpdate(final Record record);

  /**
   * Invokes a delete action that removes the context resource. Uses HTTP DELETE method. Returns the updated container state on
   * successful completion.
   * @return the updated container state.
   */
  ContainerState actionDelete();

  /**
   * Invokes a print action of the context resource. Returns the updated container state on successful completion.
   * @return the updated container state.
   */
  ContainerState actionPrint();

}
