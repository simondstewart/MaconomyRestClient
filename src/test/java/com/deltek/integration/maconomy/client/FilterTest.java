package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.Constants.NOTES;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataFilter;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.deltek.integration.maconomy.containers.v1.FilterData;
import com.deltek.integration.maconomy.relations.LinkRelations;


/**
 * REQUIRES A SERVER CONNECTION!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FilterTest {

	@Autowired
	private Server conf;
	private MaconomyClient maconomyClient;
	private FilterData notes;

	@Before
	public void setup() {
		maconomyClient = new MaconomyClient.Builder(conf.getHost(), conf.getPort(), conf.getShortname())
			                               .username(conf.getUsername())
			                               .password(conf.getPassword())
			                               .build();
		final Container notesContainer = maconomyClient.container(NOTES);
		notes = maconomyClient.transition(notesContainer, dataFilter());
	}

	@Test
	public void testThatContainerNameMatchesRequestedContainer() {
		assertEquals(NOTES, notes.getMeta().getContainerName());
	}

	@Test
	public void testSelfTransitionForFilterData() {
		final FilterData self = maconomyClient.transition(notes, LinkRelations.self(FilterData.class));
		assertEquals(notes, self);
	}

	// TODO: (ANH) Implement filtering, sorting and field-selection

}
