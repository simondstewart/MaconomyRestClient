package com.deltek.integration.maconomy.custom;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.relations.FilterRestriction;

/**
 * TEST HAND-WRITTEN CUSTOM CONTAINER, SEE {@code com.deltek.integration.maconomy.custom.codegen.GeneratedCustomTest}
 *
 * REQUIRES A SERVER CONNECTION!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HandwrittenCustomTest {

	@Autowired
	private Server conf;
	private MaconomyClient maconomyClient;

	@Before
	public void setup() {
		maconomyClient =
			new MaconomyClient.Builder(conf.getHost(), conf.getPort(), conf.getShortname())
			                  .username(conf.getUsername())
			                  .password(conf.getPassword())
			                  .build();
	}


	// TODO: (ANH) Some initial experiments with the typed API.
	@Test
	public void testApi() {
		final Notes notesContainer = new Notes(maconomyClient);
		final Notes.Filter filter = notesContainer.filter(FilterRestriction.none());
		final List<Notes.Filter.Record> records = filter.records();
		final String description = records.get(0).noteNumber().get();
		System.out.println("description: " + description);

		final Notes.Card.Record record = notesContainer.card().records().get(0);
		final String noteNumber = record.noteNumber().get();
		System.out.println("noteNumber: " + noteNumber);

		// it is possible to set this field when the Card is in Update state.
		record.noteNumber().set("some new value");
	}


}
