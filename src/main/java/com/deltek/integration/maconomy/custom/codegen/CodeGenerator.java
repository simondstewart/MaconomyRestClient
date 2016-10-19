package com.deltek.integration.maconomy.custom.codegen;

import java.io.File;
import java.time.LocalDateTime;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public class CodeGenerator {

	private final File outputDir;

	public CodeGenerator(final File outputDir) {
		this.outputDir = outputDir;
	}

	public void generate(final String packageName, final File xmlSpecification) {
		try {
			final XmlUnmarshaller.Mdsl mdsl = new XmlUnmarshaller().unmarshall(xmlSpecification);
			final JCodeModel codeModel = new JCodeModel();
			final JDefinedClass containerClass = codeModel._class(packageName + "." + mdsl.container.name);
			containerClass.javadoc().append("AUTO-GENERATED IMPLEMENTATION OF THE \"" + mdsl.container.name.toUpperCase() + "\" CONTAINER. (" + LocalDateTime.now() + ")");


			codeModel.build(outputDir);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

}
