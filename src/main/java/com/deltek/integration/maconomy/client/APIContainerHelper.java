package com.deltek.integration.maconomy.client;

import javax.ws.rs.core.GenericType;

import com.deltek.integration.maconomy.domain.internal.CardTableContainer;
import com.deltek.integration.maconomy.domain.internal.Endpoint;
import com.deltek.integration.maconomy.domain.internal.FilterContainer;
import com.deltek.integration.maconomy.domain.internal.Record;
import com.deltek.integration.maconomy.domain.internal.Table;
import com.deltek.integration.maconomy.domain.util.BasicLinksAndConcurrency;

public class APIContainerHelper<CARD_RECORD extends Object, TABLE_RECORD extends Object> {

	private final MaconomyRestClient restClient;
	private final String contextEndpointPath;
	private final GenericType<CardTableContainer<CARD_RECORD, TABLE_RECORD>> dataGenericType;
	private final GenericType<FilterContainer<CARD_RECORD>> filterContainerType;
	private final GenericType<Record<TABLE_RECORD>> tableRecordGenericType;
	private final GenericType<Record<CARD_RECORD>> cardRecordGenericType;

	// TODO: Is there a better way to do this, should be able to infer the
	// generic type of the records from dataGenericType
	public APIContainerHelper(
			final MaconomyRestClient restClient,
			final String endpointPath,
			final GenericType<CardTableContainer<CARD_RECORD, TABLE_RECORD>> dataGenericType,
			final GenericType<FilterContainer<CARD_RECORD>> filterContainerType,
			final GenericType<Record<CARD_RECORD>> cardRecordGenericType,
			final GenericType<Record<TABLE_RECORD>> tableRecordGenericType) {
		super();
		this.restClient = restClient;
		this.contextEndpointPath = endpointPath;
		this.dataGenericType = dataGenericType;
		this.filterContainerType = filterContainerType;
		this.tableRecordGenericType = tableRecordGenericType;
		this.cardRecordGenericType = cardRecordGenericType;
	}

	public Endpoint endPoint() {
		return restClient.getEndpoint(contextEndpointPath);
	}

	public Record<CARD_RECORD> init() {
		return init(endPoint());
	}

	public Record<CARD_RECORD> init(final Endpoint endpoint) {
		return restClient.postDataToAction("action:insert", new BasicLinksAndConcurrency(endpoint), "", cardRecordGenericType);
	}

	public Record<TABLE_RECORD> initTable(final Table<TABLE_RECORD> table) {
		// Why would the Table have an add action instead of the insert
		// action used for the card?
		// TODO: Check if this is consistent with the model
		return restClient.postDataToAction("action:add", table, "", tableRecordGenericType);
	}

	public CardTableContainer<CARD_RECORD, TABLE_RECORD> createCard(final Record<CARD_RECORD> cardRecord) {
		return createInternal(cardRecord);
	}

	private CardTableContainer<CARD_RECORD, TABLE_RECORD> createInternal(final Record<?> templateRecord) {
		return restClient.postDataToAction("action:create", templateRecord, templateRecord, dataGenericType);
	}

	public CardTableContainer<CARD_RECORD, TABLE_RECORD> addTableRecord(final Record<TABLE_RECORD> tableRecord) {
		return createInternal(tableRecord);
	}

	// TODO: Traverse the any link,
	public CardTableContainer<CARD_RECORD, TABLE_RECORD> any() {
		return null;
	}

	public FilterContainer<CARD_RECORD> filter() {
		return restClient.getDataFromAction("data:filter", endPoint(), filterContainerType);
	}

}
