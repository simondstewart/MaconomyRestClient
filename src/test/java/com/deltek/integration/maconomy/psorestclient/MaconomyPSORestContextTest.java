package com.deltek.integration.maconomy.psorestclient;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.client.APIContainerHelper;
import com.deltek.integration.maconomy.client.MaconomyRestClient;
import com.deltek.integration.maconomy.client.MaconomyRestClientException;
import com.deltek.integration.maconomy.domain.internal.CardTableContainer;
import com.deltek.integration.maconomy.domain.internal.Endpoint;
import com.deltek.integration.maconomy.domain.internal.FilterContainer;
import com.deltek.integration.maconomy.domain.internal.FilterPanes;
import com.deltek.integration.maconomy.domain.internal.RecordImpl;
import com.deltek.integration.maconomy.psorestclient.domain.EmployeeCard;
import com.deltek.integration.maconomy.psorestclient.domain.EmployeeTable;
import com.deltek.integration.maconomy.psorestclient.domain.HoursJournal;
import com.deltek.integration.maconomy.psorestclient.domain.JobBudget;
import com.deltek.integration.maconomy.psorestclient.domain.Journal;
import com.deltek.integration.maconomy.values.MaconomyIntegerValue;
import com.deltek.integration.maconomy.values.MaconomyStringValue;

@RunWith(SpringJUnit4ClassRunner.class)
public class MaconomyPSORestContextTest {

	private static final String SERVICE_URL = "http://193.17.206.162:4111/containers/v1/x1demo";
	private MaconomyPSORestContext restClientContext;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Before
	public void setup() {
		 final MaconomyRestClient mrc = new MaconomyRestClient("Administrator", "123456", SERVICE_URL);
		 restClientContext = new MaconomyPSORestContext(mrc);
	}

	@Test
	public void missingMandatoryEmployeeError() {
		expectedEx.expect(MaconomyRestClientException.class);
		final RecordImpl templateEmployee = restClientContext.employee().init();
		Assert.assertNotNull(templateEmployee);
		Assert.assertNotNull(templateEmployee.getData());
		Assert.assertTrue(templateEmployee.getData() instanceof EmployeeCard);

		Mockito.when(templateEmployee.getData().get("employeenumber")).thenReturn(MaconomyStringValue.create("10101011"));
		Mockito.when(templateEmployee.getData().get("name1")).thenReturn(MaconomyStringValue.create(""));
		Mockito.when(templateEmployee.getData().get("country")).thenReturn(MaconomyStringValue.create("invalid country"));
		final CardTableContainer<EmployeeCard, EmployeeTable> createdEmployee = restClientContext.employee().createCard(templateEmployee);
	}

	@Test
	public void jobJobJournalEndpoint() {
		final Endpoint endPoint = restClientContext.jobJournal().endPoint();
		Assert.assertEquals("jobjournal", endPoint.getContainerName());
		Assert.assertNotNull(endPoint.getLinks().getLinks().get("data:filter"));
		Assert.assertNotNull(endPoint.getLinks().getLinks().get("specification"));
		Assert.assertNotNull(endPoint.getLinks().getLinks().get("data:any-key"));
	}

	@Test
	public void testJournalInitCreateTableAddRecord(){

		final RecordImpl templateJournal = restClientContext.jobJournal().init();
		Assert.assertNotNull(templateJournal);
		Assert.assertNotNull(templateJournal.getData());
		Assert.assertTrue(templateJournal.getData() instanceof Journal);

		final CardTableContainer<Journal, HoursJournal> createdJournal = restClientContext.jobJournal().createCard(templateJournal);
		Assert.assertNotNull(createdJournal);

		final RecordImpl hoursJournal = restClientContext.jobJournal().initTable(createdJournal.getPanes().getTable());
		Assert.assertTrue(hoursJournal.getData() instanceof HoursJournal);

		//Populate Mandatory Fields for the HoursJournal
		Mockito.when(hoursJournal.getData().get("taskname")).thenReturn(MaconomyIntegerValue.create(200));
		Mockito.when(hoursJournal.getData().get("jobnumber")).thenReturn(MaconomyIntegerValue.create(1020001));
		Mockito.when(hoursJournal.getData().get("employeenumber")).thenReturn(MaconomyIntegerValue.create(1001));

		final CardTableContainer<Journal, HoursJournal> journalWithAddedLine = restClientContext.jobJournal().addTableRecord(hoursJournal);
		Assert.assertTrue(journalWithAddedLine.getPanes().getTable().getRecords().size() == 1);
		Assert.assertTrue(journalWithAddedLine.getPanes().getTable().getRecords().get(0).getData() instanceof HoursJournal);
		Assert.assertNotNull(journalWithAddedLine.getPanes().getTable().getMeta());


	}

	@Test
	public void testBudgetFilter() {
		final Endpoint budgetEndpoint = restClientContext.jobBudget().endPoint();
		Assert.assertNotNull(budgetEndpoint);
		final FilterContainer<JobBudget> filterResponse = restClientContext.jobBudget().filter();
		Assert.assertNotNull(filterResponse);
		Assert.assertTrue(filterResponse.getPanes() instanceof FilterPanes);

	}

	@Test
	public void testEmployeeInitCreate() {
		final RecordImpl templateEmployee = restClientContext.employee().init();
		Assert.assertNotNull(templateEmployee);
		Assert.assertNotNull(templateEmployee.getData());
		Assert.assertTrue(templateEmployee.getData() instanceof EmployeeCard);

		//TODO: If we are creating unique data, remove this expected exception.
		expectedEx.expect(MaconomyRestClientException.class);

		Mockito.when(templateEmployee.getData().get("employeenumber")).thenReturn(MaconomyStringValue.create("10101011"));
    Mockito.when(templateEmployee.getData().get("name1")).thenReturn(MaconomyStringValue.create("Simon"));
    Mockito.when(templateEmployee.getData().get("country")).thenReturn(MaconomyStringValue.create("united kingdom"));

		final CardTableContainer<EmployeeCard, EmployeeTable> createdEmployee = restClientContext.employee().createCard(templateEmployee);
		Assert.assertNotNull(createdEmployee);
		Assert.assertTrue(createdEmployee.getPanes().getCard().getRecords().get(0).getData() instanceof EmployeeCard);

		final RecordImpl employeeTableRecord = restClientContext.employee().initTable(createdEmployee.getPanes().getTable());
		Assert.assertTrue(employeeTableRecord.getData() instanceof EmployeeTable);
	}

	//Maybe not as useful as first thought unless various domains have similar supported actions.
	private <CARD_RECORD_TYPE extends Object, TABLE_RECORD_TYPE extends Object> void
				testInitCreateTableAddRecord(final APIContainerHelper<CARD_RECORD_TYPE, TABLE_RECORD_TYPE> apiHelper) {
		final RecordImpl cardTemplateRecord = apiHelper.init();
		Assert.assertNotNull(cardTemplateRecord);
		Assert.assertNotNull(cardTemplateRecord.getData());
//		Assert.assertTrue(templateJournal.getData() instanceof Journal);

		final CardTableContainer<CARD_RECORD_TYPE, TABLE_RECORD_TYPE> createdCardRecord = apiHelper.createCard(cardTemplateRecord);
		Assert.assertNotNull(createdCardRecord);

		final RecordImpl tableTemplateRecord = apiHelper.initTable(createdCardRecord.getPanes().getTable());
		Assert.assertNotNull(tableTemplateRecord);
//		Assert.assertTrue(hoursJournal.getData() instanceof HoursJournal);

		//Populate Mandatory Fields
//		hoursJournal.getData().setTaskname(200);
//		hoursJournal.getData().setJobnumber(1020001);
//		hoursJournal.getData().setEmployeenumber(1001);

//		Data<Journal, HoursJournal> journalWithAddedLine = mrc.jobJournal().addTableRecord(hoursJournal);
//		Assert.assertTrue(journalWithAddedLine.getPanes().getTable().getRecords().size() == 1);
//		Assert.assertTrue(journalWithAddedLine.getPanes().getTable().getRecords().get(0).getData() instanceof HoursJournal);

	}

}
