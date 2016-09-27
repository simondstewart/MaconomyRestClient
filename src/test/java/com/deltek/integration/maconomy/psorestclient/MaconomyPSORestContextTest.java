package com.deltek.integration.maconomy.psorestclient;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.client.APIContainerHelper;
import com.deltek.integration.maconomy.client.MaconomyRestClient;
import com.deltek.integration.maconomy.client.MaconomyRestClientException;
import com.deltek.integration.maconomy.domain.CardTableContainer;
import com.deltek.integration.maconomy.domain.Endpoint;
import com.deltek.integration.maconomy.domain.FilterContainer;
import com.deltek.integration.maconomy.domain.FilterPanes;
import com.deltek.integration.maconomy.domain.Record;
import com.deltek.integration.maconomy.psorestclient.domain.EmployeeCard;
import com.deltek.integration.maconomy.psorestclient.domain.EmployeeTable;
import com.deltek.integration.maconomy.psorestclient.domain.HoursJournal;
import com.deltek.integration.maconomy.psorestclient.domain.JobBudget;
import com.deltek.integration.maconomy.psorestclient.domain.Journal;

@RunWith(SpringJUnit4ClassRunner.class)
public class MaconomyPSORestContextTest {

	private static final String SERVICE_URL = "http://193.17.206.162:4111/containers/v1/x1demo";
	private MaconomyPSORestContext restClientContext;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Before
	public void setup() {
		 MaconomyRestClient mrc = new MaconomyRestClient("Administrator", "123456", SERVICE_URL);
		 restClientContext = new MaconomyPSORestContext(mrc);
	}
	
	@Test
	public void missingMandatoryEmployeeError() {
		expectedEx.expect(MaconomyRestClientException.class);
		Record<EmployeeCard> templateEmployee = restClientContext.employee().init();
		Assert.assertNotNull(templateEmployee);
		Assert.assertNotNull(templateEmployee.getData());
		Assert.assertTrue(templateEmployee.getData() instanceof EmployeeCard);
		
		templateEmployee.getData().setEmployeenumber("10101011");
		templateEmployee.getData().setName1(""); //missing field
		templateEmployee.getData().setCountry("invalid country");
		CardTableContainer<EmployeeCard, EmployeeTable> createdEmployee = restClientContext.employee().createCard(templateEmployee);
	}
	
	@Test
	public void jobJobJournalEndpoint() {
		Endpoint endPoint = restClientContext.jobJournal().endPoint();
		Assert.assertEquals("jobjournal", endPoint.getContainerName());
		Assert.assertNotNull(endPoint.getLinks().getLinks().get("data:filter"));
		Assert.assertNotNull(endPoint.getLinks().getLinks().get("specification"));
		Assert.assertNotNull(endPoint.getLinks().getLinks().get("data:any-key"));
	}

	@Test
	public void testJournalInitCreateTableAddRecord(){
		
		Record<Journal> templateJournal = restClientContext.jobJournal().init();
		Assert.assertNotNull(templateJournal);
		Assert.assertNotNull(templateJournal.getData());
		Assert.assertTrue(templateJournal.getData() instanceof Journal);
		
		CardTableContainer<Journal, HoursJournal> createdJournal = restClientContext.jobJournal().createCard(templateJournal);
		Assert.assertNotNull(createdJournal);
		
		Record<HoursJournal> hoursJournal = restClientContext.jobJournal().initTable(createdJournal.getPanes().getTable());
		Assert.assertTrue(hoursJournal.getData() instanceof HoursJournal);
		
		//Populate Mandatory Fields for the HoursJournal
		hoursJournal.getData().setTaskname(200);
		hoursJournal.getData().setJobnumber(1020001);
		hoursJournal.getData().setEmployeenumber(1001);
		
		CardTableContainer<Journal, HoursJournal> journalWithAddedLine = restClientContext.jobJournal().addTableRecord(hoursJournal);
		Assert.assertTrue(journalWithAddedLine.getPanes().getTable().getRecords().size() == 1);
		Assert.assertTrue(journalWithAddedLine.getPanes().getTable().getRecords().get(0).getData() instanceof HoursJournal);
		
	}
	
	@Test
	public void testBudgetFilter() {
		Endpoint budgetEndpoint = restClientContext.jobBudget().endPoint();
		Assert.assertNotNull(budgetEndpoint);
		FilterContainer<JobBudget> filterResponse = restClientContext.jobBudget().filter();
		Assert.assertNotNull(filterResponse);
		Assert.assertTrue(filterResponse.getPanes() instanceof FilterPanes);
		
	}
	
	@Test
	public void testEmployeeInitCreate() {
		Record<EmployeeCard> templateEmployee = restClientContext.employee().init();
		Assert.assertNotNull(templateEmployee);
		Assert.assertNotNull(templateEmployee.getData());
		Assert.assertTrue(templateEmployee.getData() instanceof EmployeeCard);
		
		//TODO: If we are creating unique data, remove this expected exception.
		expectedEx.expect(MaconomyRestClientException.class);

		templateEmployee.getData().setEmployeenumber("10101011");
		templateEmployee.getData().setName1("Simon");
		templateEmployee.getData().setCountry("united kingdom");
		
		CardTableContainer<EmployeeCard, EmployeeTable> createdEmployee = restClientContext.employee().createCard(templateEmployee);
		Assert.assertNotNull(createdEmployee);
		Assert.assertTrue(createdEmployee.getPanes().getCard().getRecords().get(0).getData() instanceof EmployeeCard);
		
		Record<EmployeeTable> employeeTableRecord = restClientContext.employee().initTable(createdEmployee.getPanes().getTable());
		Assert.assertTrue(employeeTableRecord.getData() instanceof EmployeeTable);
	}
	
	//Maybe not as useful as first thought unless various domains have similar supported actions.
	private <CARD_RECORD_TYPE extends Object, TABLE_RECORD_TYPE extends Object> void
				testInitCreateTableAddRecord(APIContainerHelper<CARD_RECORD_TYPE, TABLE_RECORD_TYPE> apiHelper) {
		Record<CARD_RECORD_TYPE> cardTemplateRecord = apiHelper.init();
		Assert.assertNotNull(cardTemplateRecord);
		Assert.assertNotNull(cardTemplateRecord.getData());
//		Assert.assertTrue(templateJournal.getData() instanceof Journal);
		
		CardTableContainer<CARD_RECORD_TYPE, TABLE_RECORD_TYPE> createdCardRecord = apiHelper.createCard(cardTemplateRecord);
		Assert.assertNotNull(createdCardRecord);
		
		Record<TABLE_RECORD_TYPE> tableTemplateRecord = apiHelper.initTable(createdCardRecord.getPanes().getTable());
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
