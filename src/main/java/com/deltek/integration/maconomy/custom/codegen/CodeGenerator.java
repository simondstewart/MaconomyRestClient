package com.deltek.integration.maconomy.custom.codegen;

import static java.lang.Character.toLowerCase;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.function.Function;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.data.Container;
import com.deltek.integration.maconomy.containers.v1.data.FilterData;
import com.deltek.integration.maconomy.containers.v1.data.FilterRecord;
import com.deltek.integration.maconomy.custom.BaseCardPane;
import com.deltek.integration.maconomy.custom.BaseCardTableRecord;
import com.deltek.integration.maconomy.custom.BaseContainer;
import com.deltek.integration.maconomy.custom.BaseFilterPane;
import com.deltek.integration.maconomy.custom.BaseRecord;
import com.deltek.integration.maconomy.custom.BaseTablePane;
import com.deltek.integration.maconomy.custom.ICreateAction;
import com.deltek.integration.maconomy.custom.IHasCard;
import com.deltek.integration.maconomy.custom.IHasClient;
import com.deltek.integration.maconomy.custom.IHasFilter;
import com.deltek.integration.maconomy.custom.IHasTable;
import com.deltek.integration.maconomy.custom.IInitRecord;
import com.deltek.integration.maconomy.custom.IInsertAction;
import com.deltek.integration.maconomy.custom.IRecord;
import com.deltek.integration.maconomy.custom.RStringField;
import com.deltek.integration.maconomy.custom.RWStringField;
import com.deltek.integration.maconomy.custom.codegen.XmlUnmarshaller.Field;
import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.IJExpression;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JLambda;
import com.helger.jcodemodel.JLambdaParam;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JVar;


public class CodeGenerator {

	private static final String SUPER = "super";

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
			containerClass._extends(BaseContainer.class);

			// container class ctor
			final JMethod ctor = containerClass.constructor(JMod.PUBLIC);
			final String clientId = classAsIdentifier(MaconomyClient.class);
			final JVar clientArg = ctor.param(codeModel.ref(MaconomyClient.class), clientId);
			ctor.body().invoke(SUPER).arg(clientArg).arg(containerName);

			if (mdsl.container.filter != null) {
				// filter class
				final JDefinedClass filterClass = paneClass(codeModel, containerClass, "Filter", mdsl.container.filter, BaseFilterPane.class);
				containerClass._implements(codeModel.ref(IHasFilter.class).narrow(filterClass));

				// ctor fn
				final AbstractJClass filterFuncType = codeModel.ref(Function.class).narrow(codeModel.ref(FilterData.class), filterClass);
				final JMethod getFilterCtorFn = containerClass.method(JMod.PUBLIC, filterFuncType, "getFilterCtorFn");
				getFilterCtorFn.annotate(Override.class);
				getFilterCtorFn.body()._return(ctor2fn(filterClass, JExpr._this(), classAsIdentifier(FilterData.class)));
			}

			if (mdsl.container.card != null) {
				// card class
				final JDefinedClass cardClass = paneClass(codeModel, containerClass, "Card", mdsl.container.card, BaseCardPane.class);
				containerClass._implements(codeModel.ref(IHasCard.class).narrow(cardClass));

				// ctor fn
				final AbstractJClass cardFuncType = codeModel.ref(Function.class).narrow(codeModel.ref(CardTableData.class), cardClass);
				final JMethod getCardCtorFn = containerClass.method(JMod.PUBLIC, cardFuncType, "getCardCtorFn");
				getCardCtorFn.annotate(Override.class);
				getCardCtorFn.body()._return(ctor2fn(cardClass, JExpr._this(), classAsIdentifier(CardTableData.class)));
			}

			if (mdsl.container.table != null) {
				// table class
				final JDefinedClass tableClass = paneClass(codeModel, containerClass, "Table", mdsl.container.table, BaseTablePane.class);
				containerClass._implements(codeModel.ref(IHasTable.class).narrow(tableClass));

				// ctor fn
				final AbstractJClass tableFuncType = codeModel.ref(Function.class).narrow(codeModel.ref(CardTableData.class), tableClass);
				final JMethod getTableCtorFn = containerClass.method(JMod.PUBLIC, tableFuncType, "getTableCtorFn");
				getTableCtorFn.annotate(Override.class);
				getTableCtorFn.body()._return(ctor2fn(tableClass, JExpr._this(), classAsIdentifier(CardTableData.class)));
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

		final Class<?> dataType = paneType.equals("Filter") ? FilterData.class : CardTableData.class;
		final Class<?> recordType = paneType.equals("Filter") ? FilterRecord.class : CardTableRecord.class;
		final Class<?> baseRecordType = paneType.equals("Filter") ? BaseRecord.class : BaseCardTableRecord.class;
		final String record = classAsIdentifier(recordType);

		final AbstractJClass cardClass = codeModel.ref(containerClass.fullName() + ".Card");
		final AbstractJClass _superType;
		if (paneType.equals("Filter")) {
			_superType = codeModel.ref(baseRecordType).narrow(recordType);
		} else {
			_superType = codeModel.ref(baseRecordType).narrow(cardClass);
		}


		final JDefinedClass initRecordClass = paneClass._class(JMod.PUBLIC + JMod.STATIC, "InitRecord")
				                                       ._extends(_superType)
				                                       ._implements(IInitRecord.class);
		final JDefinedClass recordClass = paneClass._class(JMod.PUBLIC + JMod.STATIC, "Record")
				                                   ._extends(_superType)
				                                   ._implements(IRecord.class);

		paneClass._extends(codeModel.ref(basePaneClass).narrow(initRecordClass, recordClass));

		if (paneType.equals("Card")) {
			final AbstractJClass paneFuncType = codeModel.ref(Function.class).narrow(codeModel.ref(CardTableRecord.class), initRecordClass);
			final JMethod getInitRecordCtorFn = containerClass.method(JMod.PUBLIC, paneFuncType, "getInitRecordCtorFn");
			getInitRecordCtorFn.annotate(Override.class);
			getInitRecordCtorFn.body()._return(ctor2fn(initRecordClass, JExpr._this(), classAsIdentifier(recordType)));

			final AbstractJClass implementsInsert = codeModel.ref(IInsertAction.class).narrow(codeModel.ref(Container.class), initRecordClass);
			containerClass._implements(implementsInsert);
		}

		final AbstractJClass clientProvider = codeModel.ref(IHasClient.class);
		final String clientProviderName = lowerCaseFirstLetter(IHasClient.class.getSimpleName());

		// ctor
		final JMethod paneClassCtor = paneClass.constructor(JMod.PRIVATE);
		final JVar param1 = paneClassCtor.param(clientProvider, clientProviderName);
		final String param2name = lowerCaseFirstLetter(dataType.getSimpleName());
		final JVar param2 = paneClassCtor.param(dataType, param2name);
		paneClassCtor.body().invoke("super")
		                    .arg(param1)
		                    .arg(param2)
		                    .arg(ctor2fn(initRecordClass, param1, "initRecord"))
		                    .arg(ctor2fn(recordClass, param1, "record"));

		final JMethod initRecordCtor = initRecordClass.constructor(JMod.PRIVATE);
		final JVar initRecordCtorParam1 = initRecordCtor.param(clientProvider, clientProviderName);
		final JVar initRecordCtorParam2 = initRecordCtor.param(recordType, record);
		if (paneType.equals("Filter")) {
			initRecordCtor.body().invoke(SUPER).arg(initRecordCtorParam1).arg(initRecordCtorParam2);
		} else {
			initRecordClass._implements(codeModel.ref(ICreateAction.class).narrow(cardClass));

			final JLambda cardCtor = ctor2fn(cardClass, initRecordCtorParam1, classAsIdentifier(CardTableData.class));
			initRecordCtor.body().invoke(SUPER).arg(initRecordCtorParam1).arg(initRecordCtorParam2).arg(cardCtor);
		}

		final JMethod recordCtor = recordClass.constructor(JMod.PRIVATE);
		final JVar recordCtorParam1 = recordCtor.param(clientProvider, clientProviderName);
		final JVar recordCtorParam2 = recordCtor.param(recordType, record);
		if (paneType.equals("Filter")) {
			recordCtor.body().invoke(SUPER).arg(recordCtorParam1).arg(recordCtorParam2);
		} else {
			final JLambda cardCtor = ctor2fn(cardClass, recordCtorParam1, classAsIdentifier(CardTableData.class));
			recordCtor.body().invoke(SUPER).arg(recordCtorParam1).arg(recordCtorParam2).arg(cardCtor);
		}

		// build field wrappers
		for(final Field xField: xPane.fields.fields) {
			// initRecordType
			final AbstractJClass initRecordTypeImpl = typeImpl(codeModel, xField.type, !xField.create);
			if (initRecordTypeImpl != null) {
				final JInvocation fieldWrapper =
					JExpr._new(initRecordTypeImpl).arg(JExpr.invoke("getContext").invoke("getData"))
					                              .arg(xField.name.toLowerCase());
				initRecordClass.method(JMod.PUBLIC, initRecordTypeImpl, lowerCaseFirstLetter(xField.name))
				               .body()._return(fieldWrapper);
			}
			// recordType
			final AbstractJClass recordTypeImpl = typeImpl(codeModel, xField.type, !xField.update);
			if (recordTypeImpl != null) {
				final JInvocation fieldWrapper =
					JExpr._new(recordTypeImpl).arg(JExpr.invoke("getContext").invoke("getData"))
					                          .arg(xField.name.toLowerCase());
				recordClass.method(JMod.PUBLIC, recordTypeImpl, lowerCaseFirstLetter(xField.name))
				           .body()._return(fieldWrapper);
			}
		}
		return paneClass;
	}

	/** Returns a 2-args constructor function reference of the given type. */
	private JLambda ctor2fn(final AbstractJClass clazz, final IJExpression arg, final String lambdaArg) {
		final JLambda jLambda = new JLambda();
		final JLambdaParam parameter = jLambda.addParam(lambdaArg);
		jLambda.body()._return(JExpr._new(clazz).arg(arg).arg(parameter));
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
