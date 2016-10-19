package com.deltek.integration.maconomy.custom.codegen;

import static java.lang.Character.toLowerCase;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.deltek.integration.maconomy.containers.v1.FilterData;
import com.deltek.integration.maconomy.containers.v1.FilterRecord;
import com.deltek.integration.maconomy.custom.ICard;
import com.deltek.integration.maconomy.custom.ICustomContainer;
import com.deltek.integration.maconomy.custom.IFilter;
import com.deltek.integration.maconomy.custom.IHasCard;
import com.deltek.integration.maconomy.custom.IHasFilter;
import com.deltek.integration.maconomy.custom.RStringField;
import com.deltek.integration.maconomy.custom.RWStringField;
import com.deltek.integration.maconomy.custom.codegen.XmlUnmarshaller.Field;
import com.deltek.integration.maconomy.relations.LinkRelations;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JForEach;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JVar;

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
			final String CLIENT_FIELD = "client";
			final JMethod ctor = ctor1(JMod.PUBLIC, containerClass, MaconomyClient.class, CLIENT_FIELD);

			// initialize "container" field in custom container class's constructor
			final String CONTAINER_FIELD = "container";
			final JFieldVar containerField = containerClass.field(JMod.PRIVATE + JMod.FINAL, Container.class, CONTAINER_FIELD);
			ctor.body().assign(JExpr.refthis(CONTAINER_FIELD), JExpr.ref(CLIENT_FIELD).invoke("container").arg(containerName.toLowerCase()));

			final JClass linkRelationsClass = codeModel.ref(LinkRelations.class);

			if (mdsl.container.filter != null) {
				final JDefinedClass filterClass = containerClass._class(JMod.PUBLIC + JMod.STATIC, "Filter");
				containerClass._implements(codeModel.ref(IHasFilter.class).narrow(filterClass));

				final String DATA_VAR = "data";
				ctor1(JMod.PRIVATE, filterClass, FilterData.class, DATA_VAR);

				// no-args filter method, TODO: (ANH) implement filtering API here
				final JMethod filterMethod = containerClass.method(JMod.PUBLIC, filterClass, "filter");
				filterMethod.annotate(Override.class);
				final JInvocation invokeDataFilter = linkRelationsClass.staticInvoke("dataFilter");
				final JInvocation invokeTransition = JExpr.ref(CLIENT_FIELD).invoke("transition").arg(containerField).arg(invokeDataFilter);
				final JClass filterDataClass = codeModel.ref(FilterData.class);
				final JVar filterDataVar = filterMethod.body().decl(JMod.FINAL, filterDataClass, DATA_VAR, invokeTransition);
				filterMethod.body()._return(JExpr._new(filterClass).arg(filterDataVar));

				final JDefinedClass initRecordClass = filterClass._class(JMod.PUBLIC + JMod.STATIC, "InitRecord");
				final JDefinedClass recordClass = filterClass._class(JMod.PUBLIC + JMod.STATIC, "Record");
				filterClass._implements(codeModel.ref(IFilter.class).narrow(initRecordClass, recordClass));

				// Implementation of com.deltek.integration.maconomy.custom.IPane.records()
				iPaneRecords(codeModel, FilterRecord.class, recordClass, filterClass, filterClass.fields().get(DATA_VAR));

				final String RECORD = "record";
				ctor1(JMod.PRIVATE, initRecordClass, FilterRecord.class, RECORD);
				ctor1(JMod.PRIVATE, recordClass, FilterRecord.class, RECORD);

				// build field wrappers on record type
				for(final Field xField: mdsl.container.filter.fields.fields) {
					final JClass typeImpl = typeImpl(codeModel, xField.type, !xField.update);
					if (typeImpl != null) {
						final JFieldVar recordField = recordClass.fields().get(RECORD);
						final JInvocation fieldWrapper = JExpr._new(typeImpl).arg(recordField.invoke("getData")).arg(xField.name.toLowerCase());

						recordClass.method(JMod.PUBLIC, typeImpl, lowerCaseFirstLetter(xField.name))
						           .body()._return(fieldWrapper);
					}
				}

			}

			if (mdsl.container.card != null) {
				final JDefinedClass cardClass = containerClass._class(JMod.PUBLIC + JMod.STATIC, "Card");
				containerClass._implements(codeModel.ref(IHasCard.class).narrow(cardClass));

				final String DATA_VAR = "data";
				ctor1(JMod.PRIVATE, cardClass, CardTableData.class, DATA_VAR);

				// no-args card method (data:any-key)
				final JMethod cardMethod = containerClass.method(JMod.PUBLIC, cardClass, "card");
				cardMethod.annotate(Override.class);
				final JInvocation invokeDataAnyKey = linkRelationsClass.staticInvoke("dataAnyKey");
				final JInvocation invokeTransition = JExpr.ref(CLIENT_FIELD).invoke("transition").arg(containerField).arg(invokeDataAnyKey);
				final JClass cardDataClass = codeModel.ref(CardTableData.class);
				final JVar cardDataVar = cardMethod.body().decl(JMod.FINAL, cardDataClass, DATA_VAR, invokeTransition);
				cardMethod.body()._return(JExpr._new(cardClass).arg(cardDataVar));

				final JDefinedClass initRecordClass = cardClass._class(JMod.PUBLIC + JMod.STATIC, "InitRecord");
				final JDefinedClass recordClass = cardClass._class(JMod.PUBLIC + JMod.STATIC, "Record");
				cardClass._implements(codeModel.ref(ICard.class).narrow(initRecordClass, recordClass));

				// Implementation of com.deltek.integration.maconomy.custom.IPane.records()
				iPaneRecords(codeModel, CardTableRecord.class, recordClass, cardClass, cardClass.fields().get(DATA_VAR));

				final String RECORD = "record";
				ctor1(JMod.PRIVATE, initRecordClass, CardTableRecord.class, RECORD);
				ctor1(JMod.PRIVATE, recordClass, CardTableRecord.class, RECORD);

				// build field wrappers on record type
				for(final Field xField: mdsl.container.card.fields.fields) {
					final JClass typeImpl = typeImpl(codeModel, xField.type, !xField.update);
					if (typeImpl != null) {
						final JFieldVar recordField = recordClass.fields().get(RECORD);
						final JInvocation fieldWrapper = JExpr._new(typeImpl).arg(recordField.invoke("getData")).arg(xField.name.toLowerCase());

						recordClass.method(JMod.PUBLIC, typeImpl, lowerCaseFirstLetter(xField.name))
						           .body()._return(fieldWrapper);
					}
				}

			}

			codeModel.build(outputDir);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String lowerCaseFirstLetter(final String input) {
		return toLowerCase(input.charAt(0)) + input.substring(1);
	}

	/** Initialize a single, final field based on a 1-args constructor. */
	private JMethod ctor1(final int mods, final JDefinedClass clazz, final Class<?> field1Type, final String field1Name) {
		clazz.field(JMod.PRIVATE + JMod.FINAL, field1Type, field1Name);
		final JMethod ctor = clazz.constructor(mods);
		ctor.param(field1Type, field1Name);
		ctor.body().assign(JExpr.refthis(field1Name), JExpr.ref(field1Name));
		return ctor;
	}

	/** Map generic pane records to custom record type. */
	private JMethod iPaneRecords(final JCodeModel codeModel,
			                     final Class<?> fromRecordType,
			                     final JDefinedClass toRecordType,
			                     final JDefinedClass pane,
			                     final JFieldVar dataField) {
		final JClass listOfRecordsInterface = codeModel.ref(List.class).narrow(toRecordType);
		final JClass arrayListOfRecords = codeModel.ref(ArrayList.class).narrow(toRecordType);
		final String RECORDS = "records", RECORD = "record";
		final JMethod recordsMethod = pane.method(JMod.PUBLIC, listOfRecordsInterface, RECORDS);
		recordsMethod.annotate(Override.class);
		recordsMethod.body().decl(JMod.FINAL, listOfRecordsInterface, RECORDS, JExpr._new(arrayListOfRecords));
		final JInvocation getRecordsInvocation = dataField.invoke("getPanes").invoke("get" + pane.name()).invoke("getRecords");
		final JForEach forEach = recordsMethod.body().forEach(codeModel.ref(fromRecordType), RECORD, getRecordsInvocation);
		forEach.body().invoke(JExpr.ref(RECORDS), "add").arg(JExpr._new(toRecordType).arg(JExpr.ref(RECORD)));
		recordsMethod.body()._return(JExpr.ref(RECORDS));
		return recordsMethod;
	}

	/** Determine the implementation class for a field */
	private JClass typeImpl(final JCodeModel codeModel, final String type, final boolean readonly) {
		switch(type) {
			case "string": return codeModel.ref(readonly ? RStringField.class : RWStringField.class);
			default: return null; // TODO: (ANH) support more than string-fields
		}
	}

}
