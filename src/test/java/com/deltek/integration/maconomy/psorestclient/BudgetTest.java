package com.deltek.integration.maconomy.psorestclient;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.psorestclient.JobBudgets.Filter;
import com.deltek.integration.maconomy.psorestclient.JobBudgets.Filter.Record;
import com.deltek.integration.maconomy.relations.FilterRestriction;

public class BudgetTest {

	@Autowired
	private Server conf;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	private MaconomyClient maconomyClient;

	@Before
	public void setup() {
		maconomyClient =
				new MaconomyClient.Builder(conf.getHost(), conf.getPort(), conf.getShortname())
				                  .username(conf.getUsername())
				                  .password(conf.getPassword())
				                  .build();
	}

	@Test
	public void filter() {
		JobBudgets jobBudgets = new JobBudgets(maconomyClient);
		Filter budgetsFilter = jobBudgets.filter(FilterRestriction.restrict("jobnumber=102001", 1, 0));
	
	}


}
