package com.deltek.integration.maconomy.custom.codegen;

import java.io.File;
import java.time.LocalDateTime;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMod;

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

			final JFieldVar clientField = containerClass.field(JMod.PRIVATE + JMod.FINAL, MaconomyClient.class, "client");
			final JFieldVar containerField = containerClass.field(JMod.PRIVATE + JMod.FINAL, Container.class, "container");

			/*
private final MaconomyClient client;
	private final Container container;

	public Notes(final MaconomyClient client) {
		this.client = client;
		this.container = client.container(CONTAINER_NAME);
	}
			*/
			codeModel.build(outputDir);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

}
