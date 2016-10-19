package com.deltek.integration.maconomy.custom;

import static com.deltek.integration.maconomy.relations.LinkRelations.dataAnyKey;
import static com.deltek.integration.maconomy.relations.LinkRelations.dataFilter;

import java.util.ArrayList;
import java.util.List;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.deltek.integration.maconomy.containers.v1.FilterData;
import com.deltek.integration.maconomy.containers.v1.FilterRecord;

/**
 * AUTO-GENERATED IMPLEMENTATION OF THE "NOTES" CONTAINER.
 * DO NOT EDIT THIS FILE BY HAND!
 */
public class Notes implements ICustomContainer, IHasFilter<Notes.Filter>, IHasCard<Notes.Card> {

	private final MaconomyClient client;
	private final Container container;

	public Notes(final MaconomyClient client) {
		this.client = client;
		this.container = client.container("notes");
	}

	@Override
	public Notes.Filter filter() {
		final FilterData filterData = this.client.transition(container, dataFilter());
		return new Notes.Filter(filterData);
	}

	public static class Filter implements IFilter<Notes.Filter.InitRecord, Notes.Filter.Record>  {

		private final FilterData data;

		private Filter(final FilterData data) {
			this.data = data;
		}

		@Override
		public List<Notes.Filter.Record> records() {
			final List<Notes.Filter.Record> records = new ArrayList<>();
			for(final FilterRecord record : data.getPanes().getFilter().getRecords()) {
				records.add(new Notes.Filter.Record(record));
			}
			return records;
		}

		public static class InitRecord {
		}

		public static class Record {

			private final FilterRecord record;

			private Record(final FilterRecord record) {
				this.record = record;
			}

			public RStringField noteNumber() {
				return new RStringField(record.getData(), "notenumber");
			}

		}

	}

	@Override
	public Notes.Card card() {
		final CardTableData cardTableData = this.client.transition(container, dataAnyKey());
		return new Notes.Card(cardTableData);
	}

	public static class Card implements ICard<Notes.Card.InitRecord, Notes.Card.Record>  {

		private final CardTableData cardTableData;

		private Card(final CardTableData cardTableData) {
			this.cardTableData = cardTableData;
		}

		@Override
		public List<Notes.Card.Record> records() {
			final List<Notes.Card.Record> records = new ArrayList<>();
			for(final CardTableRecord record : cardTableData.getPanes().getCard().getRecords()) {
				records.add(new Notes.Card.Record(record));
			}
			return records;
		}

		public static class InitRecord {
		}

		public static class Record {

			private final CardTableRecord record;

			private Record(final CardTableRecord cardTableRecord) {
				this.record = cardTableRecord;
			}

			public RWStringField noteNumber() {
				return new RWStringField(this.record.getData(), "notenumber");
			}

		}

	}

}
