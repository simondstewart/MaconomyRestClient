package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.relations.LinkRelations.dataAnyKey;
import static com.deltek.integration.maconomy.relations.LinkRelations.print;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.Link;
import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.CardTablePane;
import com.deltek.integration.maconomy.containers.v1.data.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.data.Container;
import com.deltek.integration.maconomy.filedrop.v1.FiledropContents;
import com.deltek.integration.maconomy.filedrop.v1.Filedrop;

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
		final Filedrop filedrop = maconomyClient.createFiledrop();

		assertNotNull(filedrop);
		assertNotNull(filedrop.getLocation());
	}

	@Test
	public void testFileUpload() {
		final Filedrop filedrop = maconomyClient.createFiledrop();
		try {
			final Path path = new ClassPathResource("file.png").getFile().toPath();
			maconomyClient.uploadFile(path, filedrop);
			final FiledropContents contents = maconomyClient.readFiledrop(filedrop);

			assertEquals(contents.getType(), "image/png");
			assertArrayEquals(contents.getData(), Utils.getFileContents(path));
		} catch (IOException e) {
			fail("Error while uploading file to a filedrop: " + e.getMessage());
		}
	}

	@Test
	public void testDoubleFileUploadFails() {
		exception.expect(ServerException.class);
		final Filedrop filedrop = maconomyClient.createFiledrop();
		try {
			final Path path = new ClassPathResource("file.png").getFile().toPath();
			maconomyClient.uploadFile(path, filedrop);
			maconomyClient.uploadFile(path, filedrop);
		} catch (IOException e) {
			fail("Error while uploading file to a filedrop: " + e.getMessage());
		}
	}

	@Test
	public void testPrint() {
		final Container notesContainer = maconomyClient.container(Constants.NOTES);
		final CardTableData notesCardTable = maconomyClient.transition(notesContainer, dataAnyKey());
		final CardTablePane notesTable = notesCardTable.getPanes().getTable();
		if (notesTable.getRecords().size() > 0) {
			final CardTableRecord record = notesTable.getRecords().get(0);
			final Optional<Link> print = record.getLinks().get(print());
			if (print.isPresent()) {
				final Optional<Filedrop> filedrop = maconomyClient.filedrop(record, print());
				assertTrue(filedrop.isPresent());
			}
		}
	}

}
