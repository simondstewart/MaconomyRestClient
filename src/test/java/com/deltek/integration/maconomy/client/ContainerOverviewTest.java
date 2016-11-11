package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.Constants.JOBS;
import static com.deltek.integration.maconomy.Constants.TIMEREGISTRATION;
import static com.deltek.integration.maconomy.relations.FilterRestriction.none;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataAnyKey;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataEnumValues;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataFilter;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataSearch;
import static com.deltek.integration.maconomy.relations.LinkRelations.specification;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.Links;
import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.Container;
import com.deltek.integration.maconomy.containers.v1.data.FilterData;
import com.deltek.integration.maconomy.containers.v1.specification.Action;
import com.deltek.integration.maconomy.containers.v1.specification.Field;
import com.deltek.integration.maconomy.containers.v1.specification.ForeignKey;
import com.deltek.integration.maconomy.containers.v1.specification.Pane;
import com.deltek.integration.maconomy.containers.v1.specification.RelatedContainer;
import com.deltek.integration.maconomy.containers.v1.specification.Specification;
import com.deltek.integration.maconomy.relations.FilterRestriction;


/**
 * REQUIRES A SERVER CONNECTION!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ContainerOverviewTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	@Autowired
	private Server conf;
	private MaconomyClient maconomyClient;

	@Before
	public void setup() {
		maconomyClient = new MaconomyClient.Builder(conf.getHost(), conf.getPort(), conf.getShortname())
                                           .username(conf.getUsername())
                                           .password(conf.getPassword())
                                           .build();
	}

	@Test
	public void testThatContainerOverviewIsAvailable() {
		final Container jobsContainer = maconomyClient.container(JOBS);
		assertEquals(JOBS, jobsContainer.getContainerName());

		// Check presence of transitions from container overview
		final Links links = jobsContainer.getLinks();
		assertTrue(links.get(specification()).isPresent());
		assertTrue(links.get(dataFilter(none())).isPresent());
		assertTrue(links.get(dataAnyKey()).isPresent());
	}

	@Test
	public void testThatFilterIsMissingOnSingletonContainers() {
		final Links links = maconomyClient.container(TIMEREGISTRATION).getLinks();
		assertTrue(links.get(specification()).isPresent());
		assertFalse(links.get(dataFilter(none())).isPresent()); // <---- missing
		assertTrue(links.get(dataAnyKey()).isPresent());
	}

	@Test
	public void testThatTransitionsFailOnUnknownLinkRelations() {
		expectedEx.expect(ClientException.class);
		final Container container = maconomyClient.container(TIMEREGISTRATION);
		maconomyClient.transition(container, dataFilter(none()));
	}

	@Test
	public void testSpecificationResource() {
		final Container jobsContainer = maconomyClient.container(JOBS);
		final Specification specification = maconomyClient.transition(jobsContainer, specification());
		assertEquals(JOBS, specification.getContainerName());
	}

	@Test
	public void testSpecificationField() {
		final Container jobsContainer = maconomyClient.container(JOBS);
		final Specification specification = maconomyClient.transition(jobsContainer, specification());
		final Pane filter = specification.getPanes().getFilter();
		assertNotNull(filter);
		final Field jobNumber = filter.getFields().get("jobnumber");
		assertNotNull(jobNumber);
		assertTrue(jobNumber.isKey() && jobNumber.getType().equals("string") && jobNumber.getOthers().get("maxLength").equals(255));
	}

	@Test
	public void testSpecificationActions() {
		final Container jobsContainer = maconomyClient.container(JOBS);
		final Specification specification = maconomyClient.transition(jobsContainer, specification());
		final Pane card = specification.getPanes().getCard();
		assertNotNull(card);
		final Map<String, Action> others = card.getActions().getOthers();
		assertTrue(others.containsKey("action:create") &&
				others.containsKey("action:read") &&
				others.containsKey("action:update") &&
				others.containsKey("action:delete"));
	}

	@Test
	public void testSpecificationForeignKey() {
		final Container jobsContainer = maconomyClient.container(JOBS);
		final Specification specification = maconomyClient.transition(jobsContainer, specification());
		final Pane card = specification.getPanes().getCard();
		final ForeignKey jobNumberJobHeader = card.getForeignKeys().get("jobnumber_jobheader");
		assertNotNull(jobNumberJobHeader);
		assertTrue(jobNumberJobHeader.getName().equals("jobnumber_jobheader") &&
				jobNumberJobHeader.getRel().equals("data:key:jobnumber_jobheader") &&
				jobNumberJobHeader.getSearchContainer().equals("jobs") &&
				jobNumberJobHeader.getSearchPane().equals("filter") &&
				jobNumberJobHeader.getTitle().equals("Job") &&
				jobNumberJobHeader.getLinks().get(dataSearch(null, FilterRestriction.none())) != null);
	}

	@Test
	public void testSpecificationRelatedContainers() {
		final Container jobsContainer = maconomyClient.container(JOBS);
		final Specification specification = maconomyClient.transition(jobsContainer, specification());
		final Map<String, RelatedContainer> relatedContainers = specification.getRelatedContainers();
		final RelatedContainer popupCountryType = relatedContainers.get("popup_countrytype");
		assertNotNull(popupCountryType);
		assertTrue(popupCountryType.getContainerName().equals("popup_countrytype") &&
				popupCountryType.getLinks().get(specification()) != null &&
				popupCountryType.getLinks().get(dataEnumValues()) != null);
	}

	@Test
	public void testDataFilterTransition() {
		final Container jobsContainer = maconomyClient.container(JOBS);
		final FilterData jobsFilter = maconomyClient.transition(jobsContainer, dataFilter(none()));
		assertEquals(JOBS, jobsFilter.getMeta().getContainerName());
	}

	@Test
	public void testDataAnyTransition() {
		final Container jobsContainer = maconomyClient.container(TIMEREGISTRATION);
		final CardTableData timeregistration = maconomyClient.transition(jobsContainer, dataAnyKey());
		assertEquals(TIMEREGISTRATION, timeregistration.getMeta().getContainerName());
	}

}
