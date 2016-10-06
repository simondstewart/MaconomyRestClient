package com.deltek.integration.maconomy.psorestclient;

import javax.ws.rs.core.GenericType;

import com.deltek.integration.maconomy.client.APIContainerHelper;
import com.deltek.integration.maconomy.client.MaconomyRestClient;
import com.deltek.integration.maconomy.domain.internal.CardTableContainer;
import com.deltek.integration.maconomy.domain.internal.FilterContainer;
import com.deltek.integration.maconomy.domain.internal.RecordImpl;
import com.deltek.integration.maconomy.psorestclient.domain.EmployeeCard;
import com.deltek.integration.maconomy.psorestclient.domain.EmployeeTable;
import com.deltek.integration.maconomy.psorestclient.domain.HoursJournal;
import com.deltek.integration.maconomy.psorestclient.domain.JobBudget;
import com.deltek.integration.maconomy.psorestclient.domain.JobBudgetLine;
import com.deltek.integration.maconomy.psorestclient.domain.Journal;

public class MaconomyPSORestContext {

	private final MaconomyRestClient restClient;

	public MaconomyPSORestContext(final MaconomyRestClient restClient) {
		super();
		this.restClient = restClient;
	}

	public APIContainerHelper<Journal, HoursJournal> jobJournal() {
		return new APIContainerHelper<>(restClient, "jobjournal", new GenericType<CardTableContainer<Journal, HoursJournal>>() {
		}, new GenericType<FilterContainer<Journal>>() {
		}, new GenericType<RecordImpl>() {
		}, new GenericType<RecordImpl>() {
		});
	}

	public APIContainerHelper<JobBudget, JobBudgetLine> jobBudget() {
		return new APIContainerHelper<>(restClient, "jobbudgets", new GenericType<CardTableContainer<JobBudget, JobBudgetLine>>() {
		}, new GenericType<FilterContainer<JobBudget>>() {
		}, new GenericType<RecordImpl>() {
		}, new GenericType<RecordImpl>() {
		});
	}

	public APIContainerHelper<EmployeeCard, EmployeeTable> employee() {
		return new APIContainerHelper<>(restClient, "employees", new GenericType<CardTableContainer<EmployeeCard, EmployeeTable>>() {
		}, new GenericType<FilterContainer<EmployeeCard>>() {
		}, new GenericType<RecordImpl>() {
		}, new GenericType<RecordImpl>() {
		});
	}
}
