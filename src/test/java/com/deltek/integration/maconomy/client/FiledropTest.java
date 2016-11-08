package com.deltek.integration.maconomy.client;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.filedrop.v1.Contents;
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
			final Contents contents = maconomyClient.readFiledrop(filedrop);

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

}
