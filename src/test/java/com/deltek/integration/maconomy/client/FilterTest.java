package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.Constants.NOTES;
import static com.deltek.integration.maconomy.relations.FilterRestriction.none;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataFilter;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.deltek.integration.maconomy.containers.v1.FilterData;
import com.deltek.integration.maconomy.containers.v1.FilterRecord;
import com.deltek.integration.maconomy.relations.FilterRestriction;
import com.deltek.integration.maconomy.relations.FilterRestriction.OrderBy;
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
	private Container notesContainer;

	@Before
	public void setup() {
		maconomyClient = new MaconomyClient.Builder(conf.getHost(), conf.getPort(), conf.getShortname())
			                               .username(conf.getUsername())
			                               .password(conf.getPassword())
			                               .build();
		notesContainer = maconomyClient.container(NOTES);
	}

	@Test
	public void testThatContainerNameMatchesRequestedContainer() {
		final FilterData notes = maconomyClient.transition(notesContainer, dataFilter(none()));
		assertEquals(NOTES, notes.getMeta().getContainerName());
	}

	@Test
	public void testSelfTransitionForFilterData() {
		final FilterData notes = maconomyClient.transition(notesContainer, dataFilter(none()));
		final FilterData self = maconomyClient.transition(notes, LinkRelations.self(FilterData.class));
		assertEquals(notes, self);
	}

	@Test
	public void testRestrictionsForFilterData() {
		final FilterData unrestricted = maconomyClient.transition(notesContainer, dataFilter(none()));
		//assertEquals(FilterRestriction.LIMIT, unrestricted.getPanes().getFilter().getMeta().getRowCount());
		assertEquals(FilterRestriction.OFFSET, unrestricted.getPanes().getFilter().getMeta().getRowOffset());

		final int randomRecord = ThreadLocalRandom.current().nextInt(0, unrestricted.getPanes().getFilter().getMeta().getRowCount());
		final FilterRecord filterRecord = unrestricted.getPanes().getFilter().getRecords().get(randomRecord);
		final String noteNumber = filterRecord.getData().get("notenumber").toString();

		final FilterRestriction restriction = FilterRestriction.restrict("notenumber='" + noteNumber + "'", 1, 0);
		final FilterData restricted = maconomyClient.transition(notesContainer, LinkRelations.dataFilter(restriction));
		assertEquals(1, restricted.getPanes().getFilter().getMeta().getRowCount());
		assertEquals(0, restricted.getPanes().getFilter().getMeta().getRowOffset());
		assertEquals(noteNumber, restricted.getPanes().getFilter().getRecords().get(0).getData().get("notenumber").toString());
	}

	@Test
	public void testOrderingForFilterData() {
		// run ascending search
		final OrderBy ascending = new OrderBy(OrderBy.SortOrder.ASCENDING, "NoteNumber");
		final FilterRestriction ascendingRestriction = FilterRestriction.restrict(FilterRestriction.RESTRICTION,
                                                                                  FilterRestriction.LIMIT,
                                                                                  FilterRestriction.OFFSET,
                                                                                  emptyList(),
                                                                                  singletonList(ascending));
		final FilterData ascendingNotes = maconomyClient.transition(notesContainer, dataFilter(ascendingRestriction));

		// run descending search
		final OrderBy descending = new OrderBy(OrderBy.SortOrder.DESCENDING, "NoteNumber");
		final FilterRestriction descendingRestriction = FilterRestriction.restrict(FilterRestriction.RESTRICTION,
                                                                                  FilterRestriction.LIMIT,
                                                                                  FilterRestriction.OFFSET,
                                                                                  emptyList(),
                                                                                  singletonList(descending));
		final FilterData descendingNotes = maconomyClient.transition(notesContainer, dataFilter(descendingRestriction));

		// verify
		final int rowCount = ascendingNotes.getPanes().getFilter().getMeta().getRowCount();
		assertTrue("There must be more than one record for this test to make sense", rowCount > 1);
		final List<FilterRecord> ascendingRecords = ascendingNotes.getPanes().getFilter().getRecords();
		final List<FilterRecord> decendingRecords = descendingNotes.getPanes().getFilter().getRecords();
		assertEquals(ascendingRecords.get(0).getData().get("NoteNumber"), decendingRecords.get(rowCount - 1).getData().get("NoteNumber"));
		assertEquals(ascendingRecords.get(rowCount - 1).getData().get("NoteNumber"), decendingRecords.get(0).getData().get("NoteNumber"));
	}

	@Test
	public void testSelectionForFilterData() {
		final FilterRestriction restriction = FilterRestriction.restrict(FilterRestriction.RESTRICTION,
				                                                         FilterRestriction.LIMIT,
				                                                         FilterRestriction.OFFSET,
				                                                         singletonList("NoteNumber"),
				                                                         emptyList());
		final FilterData notes = maconomyClient.transition(notesContainer, dataFilter(restriction));
		final FilterRecord filterRecord = notes.getPanes().getFilter().getRecords().get(0);
		assertEquals("There should only be one column in the response", 1, filterRecord.getData().size());
	}

}
