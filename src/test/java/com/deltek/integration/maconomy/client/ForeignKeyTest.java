package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.Constants.PROJECT_MANAGER_NUMBER;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataAnyKey;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataKey;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataSearch;
import static com.deltek.integration.maconomy.relations.LinkRelations.specification;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.Constants;
import com.deltek.integration.maconomy.client.api.Container;
import com.deltek.integration.maconomy.client.util.ImportantContainers;
import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.Link;
import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.CardTablePane;
import com.deltek.integration.maconomy.containers.v1.data.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.data.FilterData;
import com.deltek.integration.maconomy.containers.v1.specification.Field;
import com.deltek.integration.maconomy.containers.v1.specification.ForeignKey;
import com.deltek.integration.maconomy.containers.v1.specification.Pane;
import com.deltek.integration.maconomy.containers.v1.specification.Specification;
import com.deltek.integration.maconomy.relations.EntityLinkRelation;
import com.deltek.integration.maconomy.relations.FilterRestriction;
import com.deltek.integration.maconomy.relations.SafeLinkRelation;

/**
 * REQUIRES A SERVER CONNECTION!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ForeignKeyTest {

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
	public void testForeighKeySearchWithoutRestriction() {
		final Optional<FilterData> foreignKeySearchData = getForeignKeySearchData(FilterRestriction.none());
		assertTrue(foreignKeySearchData.isPresent());
	}

	@Test
	public void testForeignKeySearchWithRestriction() {
		final Optional<FilterData> foreignKeySearchData = getForeignKeySearchData(FilterRestriction.restrict("true", 1, 0));
		assertTrue(foreignKeySearchData.isPresent());
		assertNotNull(foreignKeySearchData.get().getPanes().getFilter());
		assertTrue(foreignKeySearchData.get().getPanes().getFilter().getRecords().size() == 1);
	}

	@Test
	public void testForeignKeyNavigation() {
		final Container expensesheetsContainer = maconomyClient.container(ImportantContainers.EXPENSESHEETS.getName());
		final CardTableData expensesheetsData = expensesheetsContainer.transition(dataAnyKey());
		final CardTablePane expensesheetsTablePane = expensesheetsData.getPanes().getTable();
		assertNotNull(expensesheetsTablePane);
		final List<CardTableRecord> expensesheetTableRecords = expensesheetsTablePane.getRecords();
		if (expensesheetTableRecords.size() > 0) {
			final CardTableRecord expensesheetTableRecord = expensesheetTableRecords.get(0);
			final SafeLinkRelation<CardTableData> foreignKeyNavigationLinkRelation = dataKey(Constants.ACTIVITYNUMBER_ACTIVITY_FOREIGN_KEY);
			final Optional<Link> foreignKeyNavigationLink = expensesheetTableRecord.getLinks().get(foreignKeyNavigationLinkRelation);
			assertTrue(foreignKeyNavigationLink.isPresent());
			//TODO: (KSL) the name of the container substitution should be obtained from specification
			final CardTableData foreignKeyNavigationResult = maconomyClient.foreignKey(foreignKeyNavigationLink.get(), foreignKeyNavigationLinkRelation, "activities");
			assertNotNull(foreignKeyNavigationResult);
		}
	}

	private Optional<FilterData> getForeignKeySearchData(final FilterRestriction restriction) {
		final Container jobsContainer = maconomyClient.container(ImportantContainers.JOBS.getName());
		final Specification jobsSpecification = jobsContainer.transition(specification());
		final Pane jobsCardSpecification = jobsSpecification.getPanes().getCard();
		if (jobsCardSpecification.getFields().containsKey(PROJECT_MANAGER_NUMBER)) {
			final Field field = jobsCardSpecification.getFields().get(PROJECT_MANAGER_NUMBER);
			if (field.getReferences().size() > 0) {
				final String foreignKeyName = field.getReferences().get(0);
				if (jobsCardSpecification.getForeignKeys().containsKey(foreignKeyName)) {
					final ForeignKey foreignKey = jobsCardSpecification.getForeignKeys().get(foreignKeyName);
					final CardTableData cardTableData = maconomyClient.transition(jobsContainer, dataAnyKey());
					final CardTablePane cardTablePane = cardTableData.getPanes().getCard();
					if (cardTablePane != null && cardTablePane.getRecords().size() > 0) {
						final EntityLinkRelation<CardTableRecord, FilterData> dataSearch = dataSearch(cardTablePane.getRecords().get(0), restriction);
						final Optional<Link> foreignKeyLink = foreignKey.getLinks().get(dataSearch);
						if (foreignKeyLink.isPresent()) {
							return Optional.of(maconomyClient.foreignKey(foreignKeyLink.get(), dataSearch));
						}
					}
				}
			}
		}
		return Optional.empty();
	}

}
