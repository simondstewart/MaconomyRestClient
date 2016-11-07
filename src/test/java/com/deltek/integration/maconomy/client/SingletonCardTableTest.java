package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.Constants.TIMEREGISTRATION;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataAnyKey;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.CardTablePane;
import com.deltek.integration.maconomy.containers.v1.data.Container;
import com.deltek.integration.maconomy.relations.LinkRelations;


/**
 * REQUIRES A SERVER CONNECTION!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SingletonCardTableTest {

	@Autowired
	private Server conf;
	private MaconomyClient maconomyClient;
	private CardTableData timeregistration;

	@Before
	public void setup() {
		maconomyClient =
			new MaconomyClient.Builder(conf.getHost(), conf.getPort(), conf.getShortname())
			                  .username(conf.getUsername())
			                  .password(conf.getPassword())
			                  .build();
		final Container timeregistrationContainer = maconomyClient.container(TIMEREGISTRATION);
		timeregistration = maconomyClient.transition(timeregistrationContainer, dataAnyKey());
	}

	@Test
	public void testThatContainerNameMatchesRequestedContainer() {
		assertEquals(TIMEREGISTRATION, timeregistration.getMeta().getContainerName());
	}

	@Test
	public void testSelfTransitionForCardTableData() {
		final CardTableData self = maconomyClient.transition(timeregistration, LinkRelations.self(CardTableData.class));
		assertEquals(timeregistration, self);
	}

	@Test
	public void testCardMetaInformationIsPresent() {
		final CardTablePane cardPane = timeregistration.getPanes().getCard();
		assertEquals("card", cardPane.getMeta().getPaneName());
		assertThat(cardPane.getMeta().getConcurrencyControl(), isEmptyString());
		assertEquals(1, cardPane.getMeta().getRowCount());
		assertEquals(0, cardPane.getMeta().getRowOffset());
	}

	@Test
	public void testTableMetaInformationIsPresent() {
		final CardTablePane tablePane = timeregistration.getPanes().getTable();
		assertEquals("table", tablePane.getMeta().getPaneName());
		assertThat(tablePane.getMeta().getConcurrencyControl(), startsWith("\"card\"=\""));
		assertThat(tablePane.getMeta().getConcurrencyControl(), endsWith("\""));
		//assertEquals(1, tablePane.getMeta().getRowCount());
		//assertEquals(0, tablePane.getMeta().getRowOffset());
	}

}
