package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.Constants.JOBS;
import static com.deltek.integration.maconomy.Constants.TIMEREGISTRATION;
import static com.deltek.integration.maconomy.relations.FilterRestriction.none;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataAnyKey;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataFilter;
import static com.deltek.integration.maconomy.relations.LinkRelations.specification;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.deltek.integration.maconomy.containers.v1.FilterData;
import com.deltek.integration.maconomy.containers.v1.Links;
import com.deltek.integration.maconomy.containers.v1.specification.Field;
import com.deltek.integration.maconomy.containers.v1.specification.Pane;
import com.deltek.integration.maconomy.containers.v1.specification.Specification;


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
		final Pane filter = specification.getPanes().getFilter();
		assertNotNull(filter);
		final Field jobNumber = filter.getFields().get("jobnumber");
		assertNotNull(jobNumber);
		assertTrue(jobNumber.isKey() && jobNumber.getType().equals("string") && jobNumber.getOthers().get("maxLength").equals(255));
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
