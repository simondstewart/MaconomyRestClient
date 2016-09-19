package com.deltek.integration.maconomy.client;

import javax.ws.rs.core.GenericType;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.ExpectedExceptions;

import com.deltek.integration.maconomy.client.MaconomyRestClient.APIHelper;
import com.deltek.integration.maconomy.domain.CardTableContainer;
import com.deltek.integration.maconomy.domain.Endpoint;
import com.deltek.integration.maconomy.domain.FilterContainer;
import com.deltek.integration.maconomy.domain.CardTablePanes;
import com.deltek.integration.maconomy.domain.Record;
import com.deltek.integration.maconomy.domain.to.EmployeeCard;
import com.deltek.integration.maconomy.domain.to.EmployeeTable;
import com.deltek.integration.maconomy.domain.to.HoursJournal;
import com.deltek.integration.maconomy.domain.to.JobBudget;
import com.deltek.integration.maconomy.domain.to.JobBudgetLine;
import com.deltek.integration.maconomy.domain.to.Journal;

@RunWith(SpringJUnit4ClassRunner.class)
public class MaconomyRestClientTest {

	private static final String SERVICE_URL = "http://193.17.206.162:4111/containers/v1/x1demo";
	
	private MaconomyRestClient mrc = new MaconomyRestClient("Administrator", "123456", SERVICE_URL);
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void notFoundError() {
		expectedEx.expect(MaconomyRestClientException.class);
		MaconomyRestClient notFoundMrc = 
				new MaconomyRestClient("Administrator", "123456", SERVICE_URL.concat("/INVALID_ENDPOINT"));
		notFoundMrc.employee().init();
	}

	@Test
	public void authError() {
		expectedEx.expect(MaconomyRestClientException.class);
		MaconomyRestClient invalidMrc = new MaconomyRestClient("Administrator", "BadPassword", SERVICE_URL);
		invalidMrc.employee().init();
	}
	
	@Test
	public void httpAppError() {
		expectedEx.expect(MaconomyRestClientException.class);
		Record<EmployeeCard> templateEmployee = mrc.employee().init();
		Assert.assertNotNull(templateEmployee);
		Assert.assertNotNull(templateEmployee.getData());
		Assert.assertTrue(templateEmployee.getData() instanceof EmployeeCard);
		
		templateEmployee.getData().setEmployeenumber("10101011");
		templateEmployee.getData().setName1("Simon");
		templateEmployee.getData().setCountry("united kingdom");
		//TODO: Create a separate test for the Validation Error thrown here.  Mandatory Fields Are mission here.
		CardTableContainer<EmployeeCard, EmployeeTable> createdEmployee = mrc.employee().createCard(templateEmployee);
	}
	
	
	
	@Test
	public void jobJobJournalEndpoint() {
		Endpoint endPoint = mrc.jobJournal().endPoint();
		Assert.assertEquals("jobjournal", endPoint.getContainerName());
		Assert.assertNotNull(endPoint.getLinks().getLinks().get("data:filter"));
		Assert.assertNotNull(endPoint.getLinks().getLinks().get("specification"));
		Assert.assertNotNull(endPoint.getLinks().getLinks().get("data:any-key"));
	}

	@Test
	public void testJournalInitCreateTableAddRecord(){
		
		Record<Journal> templateJournal = mrc.jobJournal().init();
		Assert.assertNotNull(templateJournal);
		Assert.assertNotNull(templateJournal.getData());
		Assert.assertTrue(templateJournal.getData() instanceof Journal);
		
		CardTableContainer<Journal, HoursJournal> createdJournal = mrc.jobJournal().createCard(templateJournal);
		Assert.assertNotNull(createdJournal);
		
		Record<HoursJournal> hoursJournal = mrc.jobJournal().initTable(createdJournal.getPanes().getTable());
		Assert.assertTrue(hoursJournal.getData() instanceof HoursJournal);
		
		//Populate Mandatory Fields for the HoursJournal
		hoursJournal.getData().setTaskname(200);
		hoursJournal.getData().setJobnumber(1020001);
		hoursJournal.getData().setEmployeenumber(1001);
		
		CardTableContainer<Journal, HoursJournal> journalWithAddedLine = mrc.jobJournal().addTableRecord(hoursJournal);
		Assert.assertTrue(journalWithAddedLine.getPanes().getTable().getRecords().size() == 1);
		Assert.assertTrue(journalWithAddedLine.getPanes().getTable().getRecords().get(0).getData() instanceof HoursJournal);
		
	}
	
	@Test
	public void testBudgetInitCreate() {
		Endpoint budgetEndpoint = mrc.jobBudget().endPoint();
		Assert.assertNotNull(budgetEndpoint);
		CardTableContainer<JobBudget, JobBudgetLine> filterResponse = mrc.jobBudget().filter();


		
		FilterContainer<JobBudget> budgetFilterResponse =
				mrc.jobBudget().getDataFromAction("data:filter", budgetEndpoint, new GenericType<FilterContainer<JobBudget>>(){});
		Assert.assertNotNull(budgetFilterResponse);
	}
	
	@Test
	public void testEmployeeInitCreate() {
		Record<EmployeeCard> templateEmployee = mrc.employee().init();
		Assert.assertNotNull(templateEmployee);
		Assert.assertNotNull(templateEmployee.getData());
		Assert.assertTrue(templateEmployee.getData() instanceof EmployeeCard);
		
		templateEmployee.getData().setEmployeenumber("10101011");
		templateEmployee.getData().setName1("Simon");
		templateEmployee.getData().setCountry("united kingdom");
		//TODO: Create a separate test for the Validation Error thrown here.  Mandatory Fields Are mission here.
		CardTableContainer<EmployeeCard, EmployeeTable> createdEmployee = mrc.employee().createCard(templateEmployee);
		Assert.assertNotNull(createdEmployee);
		Assert.assertTrue(createdEmployee.getPanes().getCard().getRecords().get(0).getData() instanceof EmployeeCard);
		
		Record<EmployeeTable> employeeTableRecord = mrc.employee().initTable(createdEmployee.getPanes().getTable());
		Assert.assertTrue(employeeTableRecord.getData() instanceof EmployeeTable);
	}
	
	//Maybe not as useful as first thought unless various domains have similar supported actions.
	private <CARD_RECORD_TYPE extends Object, TABLE_RECORD_TYPE extends Object> void
				testInitCreateTableAddRecord(APIHelper<CARD_RECORD_TYPE, TABLE_RECORD_TYPE> apiHelper) {
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
