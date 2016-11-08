package com.deltek.integration.maconomy.client;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.nio.file.Path;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.filedrop.v1.Filedrop;

/**
 * REQUIRES A SERVER CONNECTION!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FiledropTest {

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
			final byte[] filedropContents = maconomyClient.readFiledrop(filedrop);
			assertArrayEquals(filedropContents, Utils.getFileContents(path));
		} catch (Exception e) {
			fail("Error while uploading file to a filedrop: " + e.getMessage());
		}
	}

}
