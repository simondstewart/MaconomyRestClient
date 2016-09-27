package com.deltek.integration.maconomy.psorestclient;

import javax.ws.rs.core.GenericType;

import com.deltek.integration.maconomy.client.APIContainerHelper;
import com.deltek.integration.maconomy.client.MaconomyRestClient;
import com.deltek.integration.maconomy.domain.CardTableContainer;
import com.deltek.integration.maconomy.domain.FilterContainer;
import com.deltek.integration.maconomy.domain.Record;
import com.deltek.integration.maconomy.psorestclient.domain.EmployeeCard;
import com.deltek.integration.maconomy.psorestclient.domain.EmployeeTable;
import com.deltek.integration.maconomy.psorestclient.domain.HoursJournal;
import com.deltek.integration.maconomy.psorestclient.domain.JobBudget;
import com.deltek.integration.maconomy.psorestclient.domain.JobBudgetLine;
import com.deltek.integration.maconomy.psorestclient.domain.Journal;

public class MaconomyPSORestContext {

	private final MaconomyRestClient restClient;
	
	public MaconomyPSORestContext(MaconomyRestClient restClient) {
		super();
		this.restClient = restClient;
	}

	public APIContainerHelper<Journal, HoursJournal> jobJournal() {
		return new APIContainerHelper<>(restClient, "jobjournal", new GenericType<CardTableContainer<Journal, HoursJournal>>() {
		}, new GenericType<FilterContainer<Journal>>() {
		}, new GenericType<Record<Journal>>() {
		}, new GenericType<Record<HoursJournal>>() {
		});
	}

	public APIContainerHelper<JobBudget, JobBudgetLine> jobBudget() {
		return new APIContainerHelper<>(restClient, "jobbudgets", new GenericType<CardTableContainer<JobBudget, JobBudgetLine>>() {
		}, new GenericType<FilterContainer<JobBudget>>() {
		}, new GenericType<Record<JobBudget>>() {
		}, new GenericType<Record<JobBudgetLine>>() {
		});
	}

	public APIContainerHelper<EmployeeCard, EmployeeTable> employee() {
		return new APIContainerHelper<>(restClient, "employees", new GenericType<CardTableContainer<EmployeeCard, EmployeeTable>>() {
		}, new GenericType<FilterContainer<EmployeeCard>>() {
		}, new GenericType<Record<EmployeeCard>>() {
		}, new GenericType<Record<EmployeeTable>>() {
		});
	}
}
