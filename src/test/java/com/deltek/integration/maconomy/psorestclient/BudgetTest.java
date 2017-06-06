package com.deltek.integration.maconomy.psorestclient;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.deltek.integration.maconomy.client.MaconomyRestClient;
import com.deltek.integration.maconomy.domain.CardTableContainer;
import com.deltek.integration.maconomy.domain.Endpoint;
import com.deltek.integration.maconomy.domain.FilterContainer;
import com.deltek.integration.maconomy.domain.FilterPanes;
import com.deltek.integration.maconomy.domain.Record;
import com.deltek.integration.maconomy.psorestclient.domain.JobBudget;
import com.deltek.integration.maconomy.psorestclient.domain.JobBudgetLine;

@RunWith(BlockJUnit4ClassRunner.class)
public class BudgetTest {

	private MaconomyPSORestContext restClientContext;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Before
	public void setup() {
		 MaconomyRestClient mrc = new MaconomyRestClient("Administrator", "123456", 
					"http://193.17.206.161:4111/containers/v1/x1demo");
		 restClientContext = new MaconomyPSORestContext(mrc);
	}
	
	@Test
	public void testBudgetFilter() {
		Endpoint budgetEndpoint = restClientContext.jobBudget().endPoint();
		Assert.assertNotNull(budgetEndpoint);
		FilterContainer<JobBudget> filterResponse = restClientContext.jobBudget().filter();
		Assert.assertNotNull(filterResponse);
		Assert.assertTrue(filterResponse.getPanes() instanceof FilterPanes);
		
		JobBudget firstBudgetRecord = filterResponse.getPanes().getFilter().getRecords().get(0).getData();
		firstBudgetRecord.getTransactiontimestamp();
		firstBudgetRecord.getAccountmanagernumber();
		firstBudgetRecord.getCreateddate();
		
	}
	
	@Test
	public void getDataThenUpdate() {
        CardTableContainer<JobBudget, JobBudgetLine> budgetData = 
        		restClientContext.jobBudget().data(String.format("jobnumber=%s", "1020123"));
        
        Record<JobBudget> budget = budgetData.getPanes().getCard().getRecords().get(0);
        budget.getData().setShowbudgettypevar("baseline");
        budgetData = restClientContext.jobBudget().update(budget);
        //Not all budgets have the reopen action, it is dependent on state.
//        budgetData = restClientContext.jobBudget().postToAction("action:reopenbudget", budgetData.card());
        
	}
	
	
}
