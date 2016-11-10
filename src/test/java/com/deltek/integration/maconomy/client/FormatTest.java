package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.relations.LinkRelations.dataAnyKey;
import static com.deltek.integration.maconomy.relations.LinkRelations.print;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.Constants;
import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.Link;
import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.CardTablePane;
import com.deltek.integration.maconomy.containers.v1.data.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.data.Container;
import com.deltek.integration.maconomy.custom.MaconomyFormat;
import com.deltek.integration.maconomy.filedrop.v1.Filedrop;
import com.deltek.integration.maconomy.filedrop.v1.FiledropContents;

/**
 * REQUIRES A SERVER CONNECTION! 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FormatTest {

	@Autowired
	private Server conf;

	@Test
	public void testDanishDateFormatPrint() {
		final MaconomyFormat format = new MaconomyFormat.Builder().dateFormat("yyyy-mm-dd").build();
		printNotesContainerTableRecord(format, "yyyy-mm-dd.pdf");
	}

	@Test
	public void testPolishDateFormatPrint() {
		final MaconomyFormat format = new MaconomyFormat.Builder().dateFormat("dd.mm.yyyy").build();
		printNotesContainerTableRecord(format, "dd.mm.yyyy.pdf");
	}

	private void printNotesContainerTableRecord(final MaconomyFormat format, final String filename) {
		final MaconomyClient maconomyClient = getClientWithFormat(format);
		final Container notesContainer = maconomyClient.container(Constants.NOTES);
		final CardTableData notesCardTable = maconomyClient.transition(notesContainer, dataAnyKey());
		final CardTablePane notesTable = notesCardTable.getPanes().getTable();
		if (notesTable.getRecords().size() > 0) {
			final CardTableRecord record = notesTable.getRecords().get(0);
			final Optional<Link> print = record.getLinks().get(print());
			if (print.isPresent()) {
				final Optional<Filedrop> filedrop = maconomyClient.filedrop(record, print());
				if (filedrop.isPresent()) {
					final FiledropContents filedropContents = maconomyClient.readFiledrop(filedrop.get());
					if (filedropContents.getType() != null && filedropContents.getType().equals("application/pdf") 
							&& filedropContents.getData() != null) {
						final File output = new File(Constants.TEST_OUTPUT);
						output.mkdirs();
						final File outputFile = new File(output, filename);
						filedropContents.writeToFile(outputFile);
						assertTrue(outputFile.length() > 0);
					}
				}
			}
		}
	}

	private MaconomyClient getClientWithFormat(final MaconomyFormat format) {
		return new MaconomyClient.Builder(conf.getHost(), conf.getPort(), conf.getShortname())
				                 .username(conf.getUsername()).password(conf.getPassword())
				                 .format(format)
				                 .build();
	}

}
