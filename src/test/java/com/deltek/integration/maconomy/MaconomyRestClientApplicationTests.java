package com.deltek.integration.maconomy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=Suite.class)
@SuiteClasses(value = {
    com.deltek.integration.maconomy.client.OfflineTests.class,
	com.deltek.integration.maconomy.client.AuthenticationTest.class,
	com.deltek.integration.maconomy.client.ContainerOverviewTest.class,
	com.deltek.integration.maconomy.client.SingletonCardTableTest.class,
	com.deltek.integration.maconomy.client.FilterTest.class,
	com.deltek.integration.maconomy.client.CrudTest.class,
	com.deltek.integration.maconomy.custom.HandwrittenCustomTest.class,
	com.deltek.integration.maconomy.custom.codegen.GeneratedCustomTest.class,
	com.deltek.integration.maconomy.custom.codegen.CodeGeneratorTest.class,
})
public class MaconomyRestClientApplicationTests {
}
