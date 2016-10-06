package com.deltek.integration.maconomy.client;

import javax.ws.rs.core.GenericType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.deltek.integration.maconomy.domain.internal.CardTableContainer;
import com.deltek.integration.maconomy.domain.internal.FilterContainer;
import com.deltek.integration.maconomy.domain.internal.FilterPanes;
import com.deltek.integration.maconomy.domain.internal.RecordImpl;
import com.deltek.integration.maconomy.psorestclient.domain.HoursJournal;
import com.deltek.integration.maconomy.psorestclient.domain.JobBudget;
import com.deltek.integration.maconomy.psorestclient.domain.Journal;

public class GenericMaconomyRestClientTest {

	private static final String SERVICE_URL = "http://193.17.206.162:4111/containers/v1/x1demo";

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	private MaconomyRestClient mrc;

	@Before
	public void setup() {
		 mrc = new MaconomyRestClient("Administrator", "123456", SERVICE_URL);
	}

	@Test
	public void notFoundError() {
		expectedEx.expect(MaconomyRestClientException.class);
		final MaconomyRestClient notFoundMrc =
				new MaconomyRestClient("Administrator", "123456", SERVICE_URL.concat("/INVALID_ENDPOINT"));
		createTestContextHelper(notFoundMrc).init();
	}

	@Test
	public void authError() {
		expectedEx.expect(MaconomyRestClientException.class);
		final MaconomyRestClient badAuthMrc = new MaconomyRestClient("Administrator", "BadPassword", SERVICE_URL);
		createTestContextHelper(badAuthMrc).init();
	}

	@Test
	public void testGenericMaconomyClientGet() {
		final FilterContainer<JobBudget> budgetFilterResponse =
				mrc.getDataFromAction("data:filter",
						mrc.getEndpoint("jobbudgets"),
						new GenericType<FilterContainer<JobBudget>>(){});
		Assert.assertNotNull(budgetFilterResponse);
		Assert.assertTrue(budgetFilterResponse.getPanes() instanceof FilterPanes);
	}

	public APIContainerHelper<?, ?> createTestContextHelper(final MaconomyRestClient restClient) {
		return new APIContainerHelper<>(restClient, "jobjournal", new GenericType<CardTableContainer<Journal, HoursJournal>>() {
		}, new GenericType<FilterContainer<Journal>>() {
		}, new GenericType<RecordImpl>() {
		}, new GenericType<RecordImpl>() {
		});
	}

}
