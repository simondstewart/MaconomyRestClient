package com.deltek.integration.maconomy.client;

import static org.assertj.core.util.Files.contentOf;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.inmemory.InMemoryTestContainerFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.containers.v1.ApplicationPackagingUnit;
import com.deltek.integration.maconomy.containers.v1.ContainersConstants;
import com.deltek.integration.maconomy.containers.v1.Containers;
import com.deltek.integration.maconomy.containers.v1.Language;
import com.deltek.integration.maconomy.containers.v1.ToolsPackagingUnit;
import com.deltek.integration.maconomy.containers.v1.Versions;

/**
 * These tests are "offline" in the sense that they do NOT require a live server.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OfflineTests extends JerseyTest {

	private static final String SHORTNAME = "w17";
	private static final String PATH = ContainersConstants.PATH + "/" + SHORTNAME;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	private MaconomyClient maconomyClient;

	public OfflineTests() {
		super(new InMemoryTestContainerFactory());
	}

	@Override
	protected ResourceConfig configure() {
		final ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.packages(this.getClass().getPackage().getName());
		return resourceConfig;
	}

	@Path(PATH)
	public static class TestResource {
		@GET
		public String getSomething() throws IOException {
			final File file = new ClassPathResource("containers.json").getFile();
			assertTrue(file.exists(), "Test data should be available");
			return contentOf(file, "UTF-8");
		}
	}

	@Before
	public void setup() throws URISyntaxException, IOException {
		final URI baseUri = getBaseUri();
		final String host = baseUri.getScheme() + "://" + baseUri.getHost();
		final String port = "" + baseUri.getPort();
		maconomyClient = new MaconomyClient.Builder(host, port, SHORTNAME)
				.client(getClient())
				.build();
	}

	@Test
	public void checkShortName() {
		final Containers containers = maconomyClient.containers();
		assertEquals(SHORTNAME, containers.getShortname());
	}

	@Test
	public void checkVersions() {
		final Containers containers = maconomyClient.containers();
		final Versions versions = containers.getVersions();
		assertNotNull(versions);
		final ToolsPackagingUnit tpu = versions.getTpu();
		assertNotNull(tpu);
		assertEquals(tpu.getMajor(), "17");
		final ApplicationPackagingUnit apu = versions.getApu();
		assertNotNull(apu);
	}

	@Test
	public void checkLanguages() {
		final Containers containers = maconomyClient.containers();
		final List<Language> languages = containers.getLanguages();
		assertEquals(23, languages.size());
	}

}
