package com.deltek.integration.maconomy.psorestclient;

import static org.apache.commons.io.FileUtils.cleanDirectory;
import static org.junit.Assert.fail;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.Constants;
import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.custom.codegen.CodeGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MaconomyPSORestContextTest {

	// ANH: I tried to convert Simon's tests to the new format based on code generation. I used
	//      sample code generated from my 17-system but I think the tests will run on 19 as well.

	@Autowired
	private Server conf;
	private final File outputDir = new File(Constants.GENERATED);

	@Before
	public void setUp() throws IOException {
		if (!outputDir.exists()) {
			assertTrue(outputDir.mkdir(), "Unable to create " + outputDir.getAbsolutePath());
		} else {
			try {
				cleanDirectory(outputDir);
			} catch (final IOException e) {
				fail("Unable to clean " + outputDir.getAbsolutePath());
			}
		}

		// remove comments here and run once to regenerate the custom containers used in this test class
		regenerateTestCode(new String[]{"employees"});
	}

	private void regenerateTestCode(final String... containers) throws IOException {
		for (final String container : containers) {
			final CodeGenerator codeGenerator = new CodeGenerator(outputDir);
			final String specificationWebServiceUrl = conf.getHost() + ":" + conf.getPort() + "/specifications/v1/mdsl/";
			codeGenerator.generate("com.deltek.integration.maconomy.psorestclient", new URL(specificationWebServiceUrl + container.toLowerCase()));

			System.out.println("#########################################################################");
			final File output = new File(
					outputDir.getAbsolutePath() + "\\com\\deltek\\integration\\maconomy\\psorestclient\\Employees.java");
			FileUtils.readLines(output, "UTF-8").forEach(System.out::println);
			System.out.println("#########################################################################");
		}
	}

	@After
	public void cleanUp() { // Comment out the body of this method to inspect the generated code in "generated/src/test/java/
//		try {
//			cleanDirectory(outputDir);
//		} catch (final IOException e) {
//			fail("Unable to clean " + outputDir.getAbsolutePath());
//		}
	}

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void missingMandatoryEmployeeError() throws IOException {


//		expectedEx.expect(MaconomyRestClientException.class);
//		final Record<EmployeeCard> templateEmployee = restClientContext.employee().init();
//		Assert.assertNotNull(templateEmployee);
//		Assert.assertNotNull(templateEmployee.getData());
//		Assert.assertTrue(templateEmployee.getData() instanceof EmployeeCard);
//
//		templateEmployee.getData().setEmployeenumber("10101011");
//		templateEmployee.getData().setName1(""); //missing field
//		templateEmployee.getData().setCountry("invalid country");
//		final CardTableContainer<EmployeeCard, EmployeeTable> createdEmployee = restClientContext.employee().createCard(templateEmployee);
	}

	@Test
	public void jobJobJournalEndpoint() {
//		final Endpoint endPoint = restClientContext.jobJournal().endPoint();
//		Assert.assertEquals("jobjournal", endPoint.getContainerName());
//		Assert.assertNotNull(endPoint.getLinks().getLinks().get("data:filter"));
//		Assert.assertNotNull(endPoint.getLinks().getLinks().get("specification"));
//		Assert.assertNotNull(endPoint.getLinks().getLinks().get("data:any-key"));
	}

	@Test
	public void testJournalInitCreateTableAddRecord(){
//		final Record<Journal> templateJournal = restClientContext.jobJournal().init();
//		Assert.assertNotNull(templateJournal);
//		Assert.assertNotNull(templateJournal.getData());
//		Assert.assertTrue(templateJournal.getData() instanceof Journal);
//
//		final CardTableContainer<Journal, HoursJournal> createdJournal = restClientContext.jobJournal().createCard(templateJournal);
//		Assert.assertNotNull(createdJournal);
//
//		final Record<HoursJournal> hoursJournal = restClientContext.jobJournal().initTable(createdJournal.getPanes().getTable());
//		Assert.assertTrue(hoursJournal.getData() instanceof HoursJournal);
//
//		//Populate Mandatory Fields for the HoursJournal
//		hoursJournal.getData().setTaskname(200);
//		hoursJournal.getData().setJobnumber(1020001);
//		hoursJournal.getData().setEmployeenumber(1001);
//
//		final CardTableContainer<Journal, HoursJournal> journalWithAddedLine = restClientContext.jobJournal().addTableRecord(hoursJournal);
//		Assert.assertTrue(journalWithAddedLine.getPanes().getTable().getRecords().size() == 1);
//		Assert.assertTrue(journalWithAddedLine.getPanes().getTable().getRecords().get(0).getData() instanceof HoursJournal);
//		Assert.assertNotNull(journalWithAddedLine.getPanes().getTable().getMeta());
	}

	@Test
	public void testBudgetFilter() {
//		final Endpoint budgetEndpoint = restClientContext.jobBudget().endPoint();
//		Assert.assertNotNull(budgetEndpoint);
//		final FilterContainer<JobBudget> filterResponse = restClientContext.jobBudget().filter();
//		Assert.assertNotNull(filterResponse);
//		Assert.assertTrue(filterResponse.getPanes() instanceof FilterPanes);

	}

	@Test
	public void testEmployeeInitCreate() {
//		final Record<EmployeeCard> templateEmployee = restClientContext.employee().init();
//		Assert.assertNotNull(templateEmployee);
//		Assert.assertNotNull(templateEmployee.getData());
//		Assert.assertTrue(templateEmployee.getData() instanceof EmployeeCard);
//
//		//TODO: If we are creating unique data, remove this expected exception.
//		expectedEx.expect(MaconomyRestClientException.class);
//
//		templateEmployee.getData().setEmployeenumber("10101011");
//		templateEmployee.getData().setName1("Simon");
//		templateEmployee.getData().setCountry("united kingdom");
//
//		final CardTableContainer<EmployeeCard, EmployeeTable> createdEmployee = restClientContext.employee().createCard(templateEmployee);
//		Assert.assertNotNull(createdEmployee);
//		Assert.assertTrue(createdEmployee.getPanes().getCard().getRecords().get(0).getData() instanceof EmployeeCard);
//
//		final Record<EmployeeTable> employeeTableRecord = restClientContext.employee().initTable(createdEmployee.getPanes().getTable());
//		Assert.assertTrue(employeeTableRecord.getData() instanceof EmployeeTable);
	}

}
