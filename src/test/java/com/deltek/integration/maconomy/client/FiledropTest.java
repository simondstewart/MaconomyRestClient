package com.deltek.integration.maconomy.client;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.filedrop.v1.FiledropLocation;

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
		final FiledropLocation filedrop = maconomyClient.createFiledrop();
		assertNotNull(filedrop);
		assertNotNull(filedrop.getLocation());
	}

	@Test
	public void testFileUpload() {
		final FiledropLocation filedrop = maconomyClient.createFiledrop();
		String file;
		try {
			file = new ClassPathResource("file.png").getFile().getAbsolutePath().toString();
			maconomyClient.uploadFile(file, filedrop);
		} catch (IOException e) {
		}
	}

}
