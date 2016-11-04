package com.deltek.integration.maconomy.client;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.Constants;
import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.containers.v1.data.Container;
import com.deltek.integration.maconomy.containers.v1.handshake.Containers;
import com.deltek.integration.maconomy.containers.v1.handshake.Language;
import com.deltek.integration.maconomy.containers.v1.specification.Specification;
import com.deltek.integration.maconomy.containers.v1.specification.Panes;
import com.deltek.integration.maconomy.relations.LinkRelations;

/**
 * REQUIRES A SERVER CONNECTION! 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LanguageTest {

	private static final String DANISH_TAG = "da-DK";

	@Autowired
	private Server conf;
	private List<Language> languages;

	@Before
	public void setup() {
		final MaconomyClient maconomyClient =
				new MaconomyClient.Builder(conf.getHost(), conf.getPort(), conf.getShortname())
				                  .username(conf.getUsername())
				                  .password(conf.getPassword())
				                  .build();
		final Containers containers = maconomyClient.containers();
		languages = containers.getLanguages();
	}

	@Test
	public void testDanishNotesPaneTitles() {
		if (hasLanguage(DANISH_TAG)) {
			final MaconomyClient danishClient = getClientWithLanguage(DANISH_TAG);
			final Container notesContainer = danishClient.container(Constants.NOTES);
			final Specification specification = danishClient.transition(notesContainer, LinkRelations.specification());
			final Panes specificationPanes = specification.getPanes();
			assertEquals("Liste med noter", specificationPanes.getFilter().getTitle());
			assertEquals("Noter", specificationPanes.getCard().getTitle());
			assertEquals("Knudelinier", specificationPanes.getTable().getTitle());
		}
	}

	private MaconomyClient getClientWithLanguage(final String langaugeTag) {
		return new MaconomyClient.Builder(conf.getHost(), conf.getPort(), conf.getShortname())
		                         .username(conf.getUsername())
		                         .password(conf.getPassword())
		                         .language(langaugeTag)
		                         .build();
	}

	private boolean hasLanguage(final String langaugeTag) {
		return languages.stream().anyMatch(language -> language.getTag().equals(langaugeTag));
	}

}
