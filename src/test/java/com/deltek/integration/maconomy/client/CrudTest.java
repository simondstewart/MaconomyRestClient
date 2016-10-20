package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.Constants.NOTES;
import static com.deltek.integration.maconomy.relations.LinkRelations.add;
import static com.deltek.integration.maconomy.relations.LinkRelations.create;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataAnyKey;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataFilter;
import static com.deltek.integration.maconomy.relations.LinkRelations.delete;
import static com.deltek.integration.maconomy.relations.LinkRelations.insert;
import static com.deltek.integration.maconomy.relations.LinkRelations.self;
import static com.deltek.integration.maconomy.relations.LinkRelations.update;
import static java.time.Instant.now;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

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
	private Container notesContainer;

	@Before
	public void setup() {
		maconomyClient =
			new MaconomyClient.Builder(conf.getHost(), conf.getPort(), conf.getShortname())
			                  .username(conf.getUsername())
			                  .password(conf.getPassword())
			                  .build();
		notesContainer = maconomyClient.container(NOTES);
	}

	@Test
	public void testInsertAndCreateCardRecord() {
		// load filter to store before-state
		final FilterData notesFilter = maconomyClient.transition(notesContainer, dataFilter());
		final CardTableData notesCardTable = maconomyClient.transition(notesContainer, dataAnyKey());
		final int rowCountBefore = notesFilter.getPanes().getFilter().getMeta().getRowCount();

		final CardTablePane card = notesCardTable.getPanes().getCard();
		// run action:insert to receive initialization data
		final CardTableRecord initData = maconomyClient.transition(card, insert());
		assertTrue(initData.getLinks().get(create(initData)).isPresent());
		assertThat(initData.getData().get("instancekey").toString(), startsWith("NoteHeader"));

		// run action:create to receive initialization data
		final String noteNumber = "Note_" + now().getEpochSecond();
		initData.getData().put("notenumber", noteNumber);
		/*final CardTableData created = */ maconomyClient.transition(initData, create(initData));

		// load filter to store see after-stats
		final FilterData updatedFilter = maconomyClient.transition(notesFilter, self(FilterData.class));
		final int rowCountAfter = updatedFilter.getPanes().getFilter().getMeta().getRowCount();
		assertEquals(rowCountBefore + 1, rowCountAfter);
	}

	@Test
	public void testAddAndCreateAndDeleteTableRecord() {
		// load filter to store before-state
		final CardTableData notesCardTable = maconomyClient.transition(notesContainer, dataAnyKey());
		final int rowCountBeforeCreate = notesCardTable.getPanes().getTable().getMeta().getRowCount();

		final CardTablePane table = notesCardTable.getPanes().getTable();
		// run action:add to receive initialization data, TODO: (ANH) it would be nice to avoid the null-arg here
		final CardTableRecord initData = maconomyClient.transition(table, add());
		assertTrue(initData.getLinks().get(create(initData)).isPresent());
		final int originalLineNumber = Integer.parseInt(initData.getData().get("linenumber").toString());
		assertSame(originalLineNumber, 0);

		// run action:create to receive initialization data
		final CardTableData afterCreate = maconomyClient.transition(initData, create(initData));

		// load filter to store see after-stats
		final int rowCountAfterCreate = afterCreate.getPanes().getTable().getMeta().getRowCount();
		assertEquals(rowCountBeforeCreate + 1, rowCountAfterCreate);

		final List<CardTableRecord> records = afterCreate.getPanes().getTable().getRecords();
		final CardTableRecord cardTableRecord = records.get(records.size() - 1);
		final CardTableData afterDelete = maconomyClient.transition(cardTableRecord, delete());

		// load filter to store see after-stats
		final int rowCountAfterDelete = afterDelete.getPanes().getTable().getMeta().getRowCount();
		assertEquals(rowCountBeforeCreate, rowCountAfterDelete);
	}

	@Test
	public void testUpdateOnCard() {
		final CardTableData notesCardTable = maconomyClient.transition(notesContainer, dataAnyKey());
		final List<CardTableRecord> records = notesCardTable.getPanes().getCard().getRecords();
		assertEquals(1, records.size());
		final CardTableRecord cardRecord = records.get(0);
		final String description = "description";
		final String oldDescription = cardRecord.getData().get(description).toString();
		final String timestamp = LocalDateTime.now().toString();
		cardRecord.getData().put(description, timestamp);
		final CardTableData updated = maconomyClient.transition(cardRecord, update(cardRecord));
		final CardTableRecord updatedRecord = updated.getPanes().getCard().getRecords().get(0);
		assertNotEquals(oldDescription, updatedRecord.getData().get(description));
		assertEquals(timestamp, updatedRecord.getData().get(description));
	}

}
