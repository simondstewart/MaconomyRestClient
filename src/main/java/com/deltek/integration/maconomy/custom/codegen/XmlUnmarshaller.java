package com.deltek.integration.maconomy.custom.codegen;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

class XmlUnmarshaller {

	private final Unmarshaller unmarshaller;

	XmlUnmarshaller() {
		try {
			final JAXBContext context = JAXBContext.newInstance(
					Mdsl.class,
					Container.class,
					Pane.class,
					Field.class);
			unmarshaller = context.createUnmarshaller();
		} catch (final JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	XmlUnmarshaller.Mdsl unmarshall(final URL url) {
		try {
			return (XmlUnmarshaller.Mdsl) unmarshaller.unmarshal(url);
		} catch (final JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	XmlUnmarshaller.Mdsl unmarshall(final File xmlSpecification) {
		try {
			return (XmlUnmarshaller.Mdsl) unmarshaller.unmarshal(xmlSpecification);
		} catch (final JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	@XmlRootElement(name="MDSL", namespace="http://www.deltek.com/ns/mdsl")
	static class Mdsl {
		@XmlElement(name="Container")
		Container container;
		@Override
		public String toString() {
			return "Mdsl [container=" + container + "]";
		}
	}

	static class Container {
		@XmlAttribute
		String name;
		@XmlElement(name="Filter")
		Pane filter;
		@XmlElement(name="Card")
		Pane card;
		@XmlElement(name="Table")
		Pane table;
		@Override
		public String toString() {
			return "Container [name=" + name + ", filter=" + filter + ", card=" + card + ", table=" + table + "]";
		}
	}

	static class Pane {
		@XmlElement(name="Fields")
		Fields fields;
		@Override
		public String toString() {
			return "Pane [fields=" + fields + "]";
		}
	}

	static class Fields {
		@XmlElement(name="Field")
		ArrayList<Field> fields;
		@Override
		public String toString() {
			return "Fields [" + fields + "]";
		}
	}

	static class Field {
		@XmlAttribute
		String name;
		@XmlAttribute
		String type;
		@XmlAttribute
		boolean create;
		@XmlAttribute
		boolean update;
		@Override
		public String toString() {
			return "Field [name=" + name + ", type=" + type + ", create=" + create + ", update=" + update + "]";
		}
	}

}
