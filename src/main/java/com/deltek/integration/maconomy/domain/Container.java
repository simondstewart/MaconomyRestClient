package com.deltek.integration.maconomy.domain;


/**
 * Maconomy container entry.
 */
public interface Container extends LinkProvider, DataProvider, Actionable {

  /**
   * @return the name of the context Maconomy container.
   */
  String containerName();

  /**
   * Container state that is identified by "any" key. Must be used for singleton containers. Check Maconomy Web Services documentation.
   * @return the container state for "any" key.
   */
  ContainerState dataAnyKey();

  /**
   * @return the container state obtained using the default search criteria.
   */
  ContainerState filter();

  /**
   * @param criteria used to specify the records that appear in the result container state.
   * @return the container state obtained using {@code criteria}.
   */
  ContainerState filter(Criteria criteria);

  /**
   * @return the specification of the context Maconomy container.
   */
  Specification specification();

}
