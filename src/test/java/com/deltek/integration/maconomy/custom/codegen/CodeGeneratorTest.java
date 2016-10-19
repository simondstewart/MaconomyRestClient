package com.deltek.integration.maconomy.custom.codegen;

import static org.apache.commons.io.FileUtils.cleanDirectory;
import static org.junit.Assert.fail;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deltek.integration.maconomy.Constants;

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

		final CodeGenerator codeGenerator = new CodeGenerator(outputDir);
		codeGenerator.generate(Constants.CUSTOM_PACKAGE, file);

		System.out.println("-----------------------------------------");
		final File output = new File(outputDir.getAbsolutePath() + "\\com\\deltek\\integration\\maconomy\\custom\\codegen\\Notes.java");
		FileUtils.readLines(output, "UTF-8").forEach(System.out::println);
		System.out.println("-----------------------------------------");

	}


}
