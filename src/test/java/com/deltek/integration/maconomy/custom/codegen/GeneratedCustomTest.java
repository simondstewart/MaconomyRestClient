package com.deltek.integration.maconomy.custom.codegen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.configuration.Server;

/**
 * TEST GENERATED CUSTOM CONTAINER, SEE {@code com.deltek.integration.maconomy.custom.HandwrittenCustomTest}
 *
 * REQUIRES A SERVER CONNECTION!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GeneratedCustomTest {

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


	// TODO: (ANH) tie this test to generated rather than hand-written code
	@Test
	public void testApi() {

		// Rmove comments in this method body and run the test after generating the custom "notes" container in CodeGeneratorTest.
		// Used as a functional test of the generated code

//		final Notes notesContainer = new Notes(maconomyClient);
//		final Notes.Filter filter = notesContainer.filter();
//		final List<Notes.Filter.Record> records = filter.records();
//		final String description = records.get(0).noteNumber().get();
//		System.out.println("description: " + description);
//
//		final Notes.Card.Record record = notesContainer.card().records().get(0);
//		final String noteNumber = record.noteNumber().get();
//		System.out.println("noteNumber: " + noteNumber);
//
//		record.description().set("some new value");
	}


}
