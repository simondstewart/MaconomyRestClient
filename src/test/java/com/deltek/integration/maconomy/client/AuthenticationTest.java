package com.deltek.integration.maconomy.client;

import static com.deltek.integration.maconomy.Constants.JOBS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.handshake.Containers;

/**
 * REQUIRES A SERVER CONNECTION!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthenticationTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	@Autowired
	private Server conf;
	private MaconomyClient.Builder clientBuilder;

	@Before
	public void setup() {
		clientBuilder = new MaconomyClient.Builder(conf.getHost(),
			                                       conf.getPort(),
			                                       conf.getShortname());
	}

	@Test
	public void testThatContainersEndpointIsAvailableWithoutAuthentication() {
		final MaconomyClient maconomyClient = clientBuilder.build(); // no credentials supplied
		final Containers containers = maconomyClient.containers();
		assertEquals(conf.getShortname(), containers.getShortname());
		assertFalse(containers.isAuthenticated());
	}

	@Test
	public void testBasicAuthenticationSuccess() {
		final MaconomyClient maconomyClient = clientBuilder.username(conf.getUsername())
				                                           .password(conf.getPassword())
				                                           .build();
		final Containers containers = maconomyClient.containers();
		assertEquals(conf.getShortname(), containers.getShortname());
		assertTrue(containers.isAuthenticated());
	}

	@Test
	public void testThatMissingCredentailsCausesError() {
		expectedEx.expect(ServerException.class);
		final MaconomyClient maconomyClient = clientBuilder.build(); // no credentials supplied
		maconomyClient.container(JOBS);
	}

	@Ignore // TODO: (ANH) figure out how to implement that test. How do we inspect the request?
	@Test
	public void testThatReconnectTokensArePreferredOverBasicAuthentication() {
	}

}
