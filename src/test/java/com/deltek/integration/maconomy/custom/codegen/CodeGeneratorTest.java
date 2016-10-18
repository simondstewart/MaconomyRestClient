package com.deltek.integration.maconomy.custom.codegen;

import static org.apache.commons.io.FileUtils.cleanDirectory;
import static org.assertj.core.util.Files.contentOf;
import static org.junit.Assert.fail;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.Constants;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CodeGeneratorTest {

	private final File outputDir = new File(Constants.GENERATED);

	@Before
	public void setUp() {
		if (!outputDir.exists()) {
			assertTrue(outputDir.mkdir(), "Unable to create " + outputDir.getAbsolutePath());
		} else {
			try {
				cleanDirectory(outputDir);
			} catch (final IOException e) {
				fail("Unable to clean " + outputDir.getAbsolutePath());
			}
		}
	}

	@After
	public void cleanUp() {
//		try {
//			cleanDirectory(outputDir);
//		} catch (final IOException e) {
//			fail("Unable to clean " + outputDir.getAbsolutePath());
//		}
	}


	@Test
	public void testCodeGen() throws Exception {
		final File file = new ClassPathResource("notes.mdsl.xml").getFile();
		assertTrue(file.exists(), "Test data should be available");
		final String utf8content = contentOf(file, "UTF-8");





		final JCodeModel codeModel = new JCodeModel();
		final JDefinedClass definedClass1 = codeModel._class("net.cardosi.MyNewClass1");
		final JDefinedClass definedClass2 = codeModel._class("net.cardosi.MyNewClass2");

		codeModel.build(outputDir);
		System.out.println(outputDir.getAbsolutePath());

		//Assert.fail(utf8content);
	}


}
