package com.deltek.integration.maconomy.domain;

import java.util.List;

/**
 * Collection of Maconomy links that allows locating a Maconomy link based on a link relation property.
 */
public interface Links {

  /**
   * @return a list of Maconomy links that are present in this collection.
   */
  List<Link> get();

  /**
   * @param relation
   * @return a Maconomy link for {@code relation}, if not present an empty link will be returned.
   */
  Link get(final LinkRelation relation);

  /**
   * @param keyword
   * @return a list of Maconomy links with link relations containing {@code keyword} that are present in this collection.
   */
  List<Link> get(final String keyword);

  /**
   * @return a list of Maconomy links that are used to perform an action among the links in this collection.
   */
  List<Link> getActions();

  /**
   * @return a list of Maconomy links that are used for data fetching from the associated resources.
   */
  List<Link> getData();

}
