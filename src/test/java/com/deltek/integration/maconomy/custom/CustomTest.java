package com.deltek.integration.maconomy.custom;

import static com.deltek.integration.maconomy.Constants.NOTES;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataAnyKey;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataFilter;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.deltek.integration.maconomy.containers.v1.FilterData;

/**
 * REQUIRES A SERVER CONNECTION!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomTest {

	@Autowired
	private Server conf;
	private MaconomyClient maconomyClient;
	private FilterData notesFilter;
	private CardTableData notesCardTable;

	@Before
	public void setup() {
		maconomyClient =
			new MaconomyClient.Builder(conf.getHost(), conf.getPort(), conf.getShortname())
			                  .username(conf.getUsername())
			                  .password(conf.getPassword())
			                  .build();
		final Container notesContainer = maconomyClient.container(NOTES);
		notesFilter = maconomyClient.transition(notesContainer, dataFilter());
		notesCardTable = maconomyClient.transition(notesContainer, dataAnyKey());
	}

	@Test
	public void testApi() {
		final Notes notesContainer = new Notes(maconomyClient);
		final Notes.Filter filter = notesContainer.filter();
		final List<Notes.Filter.Update> records = filter.records();
		final String description = records.get(0).noteNumber().get();
		final String noteNumber = notesContainer.card().records().get(0).noteNumber().get();
		System.out.println("noteNumber: " + noteNumber);
	}


}
