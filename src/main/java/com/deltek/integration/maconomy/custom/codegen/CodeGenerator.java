package com.deltek.integration.maconomy.custom.codegen;

import static java.lang.Character.toLowerCase;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.deltek.integration.maconomy.containers.v1.FilterData;
import com.deltek.integration.maconomy.containers.v1.FilterRecord;
import com.deltek.integration.maconomy.custom.BaseCardPane;
import com.deltek.integration.maconomy.custom.BaseFilterPane;
import com.deltek.integration.maconomy.custom.ICustomContainer;
import com.deltek.integration.maconomy.custom.IHasCard;
import com.deltek.integration.maconomy.custom.IHasFilter;
import com.deltek.integration.maconomy.custom.RStringField;
import com.deltek.integration.maconomy.custom.RWStringField;
import com.deltek.integration.maconomy.custom.codegen.XmlUnmarshaller.Field;
import com.deltek.integration.maconomy.relations.LinkRelations;
import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JLambda;
import com.helger.jcodemodel.JLambdaParam;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JVar;


public class CodeGenerator {

	private final File outputDir;

	public CodeGenerator(final File outputDir) {
		this.outputDir = outputDir;
	}

	public void generate(final String packageName, final URL urlSpecification) {
		final XmlUnmarshaller.Mdsl mdsl = new XmlUnmarshaller().unmarshall(urlSpecification);
		doGenerate(packageName, mdsl);
	}

	public void generate(final String packageName, final File xmlSpecification) {
		final XmlUnmarshaller.Mdsl mdsl = new XmlUnmarshaller().unmarshall(xmlSpecification);
		doGenerate(packageName, mdsl);
	}

	private void doGenerate(final String packageName, final XmlUnmarshaller.Mdsl mdsl) {
		try {
			final JCodeModel codeModel = new JCodeModel();
			final String containerName = mdsl.container.name;
			final JDefinedClass containerClass = codeModel._class(packageName + "." + containerName);
			containerClass.javadoc().append("AUTO-GENERATED IMPLEMENTATION OF THE \"" + containerName.toUpperCase() + "\" CONTAINER. (" + LocalDateTime.now() + ")");
			containerClass._implements(ICustomContainer.class);

			// ctor with "client" field in custom container class
			final String CLIENT_FIELD = "maconomyClient";
			final JMethod ctor = ctor1(JMod.PUBLIC, containerClass, MaconomyClient.class);

			// initialize "container" field in custom container class's constructor
			final String CONTAINER_FIELD = "container";
			final JFieldVar containerField = containerClass.field(JMod.PRIVATE + JMod.FINAL, Container.class, CONTAINER_FIELD);
			ctor.body().assign(JExpr.refthis(CONTAINER_FIELD), JExpr.ref(CLIENT_FIELD).invoke("container").arg(containerName.toLowerCase()));

			final AbstractJClass linkRelationsClass = codeModel.ref(LinkRelations.class);

			if (mdsl.container.filter != null) {
				// filter class
				final JDefinedClass filterClass = paneClass(codeModel, containerClass, "Filter", mdsl.container.filter, BaseFilterPane.class);
				containerClass._implements(codeModel.ref(IHasFilter.class).narrow(filterClass));

				// no-args filter method, TODO: (ANH) implement filtering API here
				final JMethod filterMethod = containerClass.method(JMod.PUBLIC, filterClass, "filter");
				filterMethod.annotate(Override.class);
				final JInvocation invokeDataFilter = linkRelationsClass.staticInvoke("dataFilter");
				final JInvocation invokeTransition = JExpr.ref(CLIENT_FIELD).invoke("transition").arg(containerField).arg(invokeDataFilter);
				final AbstractJClass filterDataClass = codeModel.ref(FilterData.class);
				final JVar filterDataVar = filterMethod.body().decl(JMod.FINAL, filterDataClass, "data", invokeTransition);
				filterMethod.body()._return(JExpr._new(filterClass).arg(filterDataVar));
			}

			if (mdsl.container.card != null) {
				// card class
				final JDefinedClass cardClass = paneClass(codeModel, containerClass, "Card", mdsl.container.card, BaseCardPane.class);
				containerClass._implements(codeModel.ref(IHasCard.class).narrow(cardClass));

				// no-args card method (data:any-key)
				final JMethod cardMethod = containerClass.method(JMod.PUBLIC, cardClass, "card");
				cardMethod.annotate(Override.class);
				final JInvocation invokeDataAnyKey = linkRelationsClass.staticInvoke("dataAnyKey");
				final JInvocation invokeTransition = JExpr.ref(CLIENT_FIELD).invoke("transition").arg(containerField).arg(invokeDataAnyKey);
				final AbstractJClass cardDataClass = codeModel.ref(CardTableData.class);
				final JVar cardDataVar = cardMethod.body().decl(JMod.FINAL, cardDataClass, "data", invokeTransition);
				cardMethod.body()._return(JExpr._new(cardClass).arg(cardDataVar));
			}

			codeModel.build(outputDir);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String classAsIdentifier(final Class<?> clazz) {
		return lowerCaseFirstLetter(clazz.getSimpleName());
	}

	private String lowerCaseFirstLetter(final String input) {
		return toLowerCase(input.charAt(0)) + input.substring(1);
	}

	/** Generate inner pane class which holds init and update record types */
	private JDefinedClass paneClass(final JCodeModel codeModel,
			                        final JDefinedClass containerClass,
			                        final String paneType,
			                        final XmlUnmarshaller.Pane xPane,
			                        final Class<?> basePaneClass) throws JClassAlreadyExistsException {
		final JDefinedClass paneClass = containerClass._class(JMod.PUBLIC + JMod.STATIC, paneType);

		final JDefinedClass initRecordClass = paneClass._class(JMod.PUBLIC + JMod.STATIC, "InitRecord");
		final JDefinedClass recordClass = paneClass._class(JMod.PUBLIC + JMod.STATIC, "Record");
		paneClass._extends(codeModel.ref(basePaneClass).narrow(initRecordClass, recordClass));

		final Class<?> dataType = paneType.equals("Filter") ? FilterData.class : CardTableData.class;
		final Class<?> recordType = paneType.equals("Filter") ? FilterRecord.class : CardTableRecord.class;

		// ctor
		final JMethod paneClassCtor = paneClass.constructor(JMod.PRIVATE);
		final String param1name = lowerCaseFirstLetter(dataType.getSimpleName());
		final JVar param1 = paneClassCtor.param(dataType, param1name);
		paneClassCtor.body().invoke("super")
		                    .arg(param1)
		                    .arg(ctor1fn(initRecordClass))
		                    .arg(ctor1fn(recordClass));

		ctor1(JMod.PRIVATE, initRecordClass, recordType);
		ctor1(JMod.PRIVATE, recordClass, recordType);

		// build field wrappers
		final String record = classAsIdentifier(recordType);
		for(final Field xField: xPane.fields.fields) {
			// initRecordType
			final AbstractJClass initRecordTypeImpl = typeImpl(codeModel, xField.type, !xField.create);
			if (initRecordTypeImpl != null) {
				final JFieldVar recordField = initRecordClass.fields().get(record);
				final JInvocation fieldWrapper =
					JExpr._new(initRecordTypeImpl).arg(recordField.invoke("getData"))
					                              .arg(xField.name.toLowerCase());
				initRecordClass.method(JMod.PUBLIC, initRecordTypeImpl, lowerCaseFirstLetter(xField.name))
				               .body()._return(fieldWrapper);
			}
			// recordType
			final AbstractJClass recordTypeImpl = typeImpl(codeModel, xField.type, !xField.update);
			if (recordTypeImpl != null) {
				final JFieldVar recordField = recordClass.fields().get(record);
				final JInvocation fieldWrapper =
					JExpr._new(recordTypeImpl).arg(recordField.invoke("getData"))
					                              .arg(xField.name.toLowerCase());
				recordClass.method(JMod.PUBLIC, recordTypeImpl, lowerCaseFirstLetter(xField.name))
				           .body()._return(fieldWrapper);
			}
		}
		return paneClass;
	}

	/** Initialize a single, final field based on a 1-args constructor. */
	private JMethod ctor1(final int mods, final JDefinedClass clazz, final Class<?> field1Type) {
		final String field1Name = classAsIdentifier(field1Type);
		clazz.field(JMod.PRIVATE + JMod.FINAL, field1Type, field1Name);
		final JMethod ctor = clazz.constructor(mods);
		ctor.param(field1Type, field1Name);
		ctor.body().assign(JExpr.refthis(field1Name), JExpr.ref(field1Name));
		return ctor;
	}

	/** Returns a 1-args constructor function reference of the given type. */
	private JLambda ctor1fn(final JDefinedClass clazz) {
		final JLambda jLambda = new JLambda();
		final JLambdaParam parameter = jLambda.addParam("record");
		jLambda.body()._return(JExpr._new(clazz).arg(parameter));
		return jLambda;
	}

	/** Determine the implementation class for a field */
	private AbstractJClass typeImpl(final JCodeModel codeModel, final String type, final boolean readonly) {
		switch(type) {
			case "string": return codeModel.ref(readonly ? RStringField.class : RWStringField.class);
			default: return null; // TODO: (ANH) support more than string-fields
		}
	}

}
