package com.deltek.integration.maconomy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=Suite.class)
@SuiteClasses(value = {
		// does not require a live server
    com.deltek.integration.maconomy.client.OfflineTests.class,
        // does require a live server, see /MaconomyRestClient/src/main/resources/application.properties
	com.deltek.integration.maconomy.client.AuthenticationTest.class,
	com.deltek.integration.maconomy.client.ContainerOverviewTest.class,
	com.deltek.integration.maconomy.client.SingletonCardTableTest.class,
	com.deltek.integration.maconomy.client.FilterTest.class,
	com.deltek.integration.maconomy.client.CrudTest.class,
	com.deltek.integration.maconomy.client.LanguageTest.class,
	com.deltek.integration.maconomy.custom.HandwrittenCustomTest.class,
	com.deltek.integration.maconomy.custom.codegen.GeneratedCustomTest.class,
	com.deltek.integration.maconomy.custom.codegen.CodeGeneratorTest.class,
	com.deltek.integration.maconomy.psorestclient.MaconomyPSORestContextTest.class,
})
public class MaconomyRestClientApplicationTests {
}
