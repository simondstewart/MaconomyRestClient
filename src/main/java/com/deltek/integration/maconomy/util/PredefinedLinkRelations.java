package com.deltek.integration.maconomy.util;

import static com.deltek.integration.maconomy.util.Constants.ACTION_NAMESPACE;
import static com.deltek.integration.maconomy.util.Constants.DATA_NAMESPACE;
import static com.deltek.integration.maconomy.util.Constants.DELIMITER;

import com.deltek.integration.maconomy.domain.LinkRelation;

/**
 * Predefined set of link relations of the Maconomy RESTful web service for which the values are assumed to not change over time.
 * Clients can use these link relations to obtain various crucial Maconomy links which can be later used to perform the intended
 * workflow.
 */
public enum PredefinedLinkRelations implements LinkRelation {

  /** Context resource. */
  SELF("self"), //$NON-NLS-1$
  /** Specification for the context container. */
  SPECIFICATION("specification"), //$NON-NLS-1$
  /** File produced as part of handling the request. */
  FILE("file"), //$NON-NLS-1$
  /** Filter used to search for specific resources within the container. */
  DATA_FILTER(DATA_NAMESPACE + DELIMITER + "filter"), //$NON-NLS-1$
  /** Container state that provides possible values of an enumeration type. */
  DATA_ENUMVALUES(DATA_NAMESPACE + DELIMITER + "enumvalues"), //$NON-NLS-1$
  /** Container state that is identified by "any" key. Must be used for singleton containers. Check Maconomy Web Services documentation. */
  DATA_ANY_KEY(DATA_NAMESPACE + DELIMITER + "any-key"), //$NON-NLS-1$
  /** Container state that is identified by the same key as the context resource. */
  DATA_SAME_KEY("DATA_NAMESPACE + DELIMITER + same-key"), //$NON-NLS-1$
  /** Initialize state transition in the insert variant. For a table pane, the new record will be inserted at the position of the record where the action was invoked from. */
  ACTION_INSERT(ACTION_NAMESPACE + DELIMITER + "insert"), //$NON-NLS-1$
  /** Initialize state transition in the add variant. For a table pane, the new record will be added at the end of the table. */
  ACTION_ADD(ACTION_NAMESPACE + DELIMITER + "add"), //$NON-NLS-1$
  /** Create action for saving the context record in the database. */
  ACTION_CREATE(ACTION_NAMESPACE + DELIMITER + "create"), //$NON-NLS-1$
  /** Update action that changes the values of fields of the context resource. */
  ACTION_UPDATE(ACTION_NAMESPACE + DELIMITER + "update"), //$NON-NLS-1$
  /** Delete action that removes the context resource. */
  ACTION_DELETE(ACTION_NAMESPACE + DELIMITER + "delete"), //$NON-NLS-1$
  /** Print action of the context resource. */
  ACTION_PRINT(ACTION_NAMESPACE + DELIMITER + "print"); //$NON-NLS-1$

  private final String value;

  private PredefinedLinkRelations(final String value) {
    this.value = value;
  }

  /** {@inheritDoc} */
  public String value() {
    return value;
  }

  /** {@inheritDoc} */
  public boolean isDataRelation() {
    return value().startsWith(DATA_NAMESPACE + DELIMITER);
  }

  /** {@inheritDoc} */
  public boolean isActionRelation() {
    return value().startsWith(ACTION_NAMESPACE + DELIMITER);
  }

}
