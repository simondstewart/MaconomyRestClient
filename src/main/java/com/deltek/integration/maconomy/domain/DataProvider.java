package com.deltek.integration.maconomy.domain;

/**
 * Marks entities that have data fetching links.
 */
public interface DataProvider {

  /**
   * Reads the current data state of the context resource using {@code link} previously obtained from the Maconomy web service.
   * @param link
   * @return the container state for a given data providing link.
   */
  ContainerState getData(final Link link);

  /**
   * Reads the current data state of the context resource using {@code link} previously obtained from the Maconomy web service,
   * and {@code searchCriteria} if they can be applied in the given context.
   * @param link
   * @param criteria
   * @return the container state for a given data providing link and search criteria.
   */
  ContainerState getData(final Link link, final Criteria criteria);

}
