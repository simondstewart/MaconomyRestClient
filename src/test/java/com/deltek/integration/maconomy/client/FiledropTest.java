package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.relations.LinkRelations.dataAnyKey;
import static com.deltek.integration.maconomy.relations.LinkRelations.print;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.Constants;
import com.deltek.integration.maconomy.client.api.Container;
import com.deltek.integration.maconomy.client.api.Filedrop;
import com.deltek.integration.maconomy.client.util.ImportantContainers;
import com.deltek.integration.maconomy.client.util.ServerException;
import com.deltek.integration.maconomy.client.util.Utils;
import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.Link;
import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.CardTablePane;
import com.deltek.integration.maconomy.containers.v1.data.CardTableRecord;
import com.deltek.integration.maconomy.filedrop.v1.FiledropContents;

/**
 * REQUIRES A SERVER CONNECTION!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FiledropTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Autowired
	private Server conf;
	private MaconomyClient maconomyClient;

	@Before
	public void setup() {
		maconomyClient = new MaconomyClient.Builder(conf.getHost(), conf.getPort(), conf.getShortname())
                                           .username(conf.getUsername())
                                           .password(conf.getPassword())
                                           .build();
	}

	@Test
	public void testFiledropCreation() {
		final Filedrop filedropClient = maconomyClient.createFiledrop();

		assertNotNull(filedropClient);
		assertNotNull(filedropClient.getLocation());
	}

	@Test
	public void testFileUpload() {
		final Filedrop filedropClient = maconomyClient.createFiledrop();
		try {
			final Path path = new ClassPathResource("file.png").getFile().toPath();
			filedropClient.uploadFile(path);
			final FiledropContents contents = filedropClient.readFiledrop();

			assertEquals(contents.getType(), "image/png");
			assertArrayEquals(contents.getData(), Utils.getFileContents(path));
		} catch (IOException e) {
			fail("Error while uploading file to a filedrop: " + e.getMessage());
		}
	}

	@Test
	public void testDoubleFileUploadFails() {
		exception.expect(ServerException.class);
		final Filedrop filedropClient = maconomyClient.createFiledrop();
		try {
			final Path path = new ClassPathResource("file.png").getFile().toPath();
			filedropClient.uploadFile(path);
			filedropClient.uploadFile(path);
		} catch (IOException e) {
			fail("Error while uploading file to a filedrop: " + e.getMessage());
		}
	}

	@Test
	public void testPrintCorrectness() {
		final Container notesContainer = maconomyClient.container(ImportantContainers.NOTES.getName());
		final CardTableData notesCardTable = notesContainer.transition(dataAnyKey());
		final CardTablePane notesTable = notesCardTable.getPanes().getTable();
		if (notesTable.getRecords().size() > 0) {
			final CardTableRecord record = notesTable.getRecords().get(0);
			final Optional<Link> print = record.getLinks().get(print());
			if (print.isPresent()) {
				final Filedrop filedropClient = maconomyClient.filedrop(record, print());
				assertFalse(filedropClient.getLocation().isEmpty());
			}
		}
	}

	@Test
	public void testPrintContent() {
		final Container notesContainer = maconomyClient.container(ImportantContainers.NOTES.getName());
		final CardTableData notesCardTable = notesContainer.transition(dataAnyKey());
		final CardTablePane notesTable = notesCardTable.getPanes().getTable();
		if (notesTable.getRecords().size() > 0) {
			final CardTableRecord record = notesTable.getRecords().get(0);
			final Optional<Link> print = record.getLinks().get(print());
			if (print.isPresent()) {
				final Filedrop filedropClient = maconomyClient.filedrop(record, print());
				final FiledropContents filedropContents = filedropClient.readFiledrop();
				if (filedropContents.getType() != null && filedropContents.getType().equals("application/pdf") 
						&& filedropContents.getData() != null) {
					final File output = new File(Constants.TEST_OUTPUT);
					output.mkdirs();
					final File outputFile = new File(output, "print.pdf");
					filedropContents.writeToFile(outputFile);
					assertTrue(outputFile.length() > 0);
				}
			}
		}
	}

}
