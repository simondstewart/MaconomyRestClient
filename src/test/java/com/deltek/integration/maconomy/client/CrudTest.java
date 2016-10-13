package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.Constants.NOTES;
import static com.deltek.integration.maconomy.relations.LinkRelations.create;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataAnyKey;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataFilter;
import static com.deltek.integration.maconomy.relations.LinkRelations.insert;
import static com.deltek.integration.maconomy.relations.LinkRelations.self;
import static java.time.Instant.now;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.CardTablePane;
import com.deltek.integration.maconomy.containers.v1.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.deltek.integration.maconomy.containers.v1.FilterData;


/**
 * REQUIRES A SERVER CONNECTION!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CrudTest {

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
	public void testInsertCreateOnCard() {
		// load filter to store before-state
		final int rowCountBefore = notesFilter.getPanes().getFilter().getMeta().getRowCount();

		final CardTablePane card = notesCardTable.getPanes().getCard();
		// run action:insert to receive initialization data
		final CardTableRecord initData = maconomyClient.transition(card, insert());
		assertTrue(initData.getLinks().get(create()).isPresent());
		assertThat(initData.getData().get("instancekey").toString(), startsWith("NoteHeader"));

		// run action:create to receive initialization data
		final String noteNumber = "Note_" + now().getEpochSecond();
		initData.getData().put("notenumber", noteNumber);
		/*final CardTableData created = */ maconomyClient.transition(initData, create(), initData);

		// load filter to store see after-stats
		final FilterData updatedFilter = maconomyClient.transition(notesFilter, self(FilterData.class));
		final int rowCountAfter = updatedFilter.getPanes().getFilter().getMeta().getRowCount();
		assertEquals(rowCountBefore + 1, rowCountAfter);
	}

}
