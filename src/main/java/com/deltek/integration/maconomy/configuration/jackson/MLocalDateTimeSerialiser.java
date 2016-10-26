package com.deltek.integration.maconomy.configuration.jackson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.deltek.integration.maconomy.domain.commontypes.MLocalDateTime;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class MLocalDateTimeSerialiser extends StdSerializer<MLocalDateTime>  {

	//e.g. "2016-03-22 12:13:18.130"
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

	public MLocalDateTimeSerialiser() {
		super(MLocalDateTime.class);
	}

	@Override
	public void serialize(MLocalDateTime value, JsonGenerator gen, SerializerProvider provider)
			throws IOException {
		if(value.getValue() != null) {
			gen.writeNull();
		} else {
			gen.writeString(formatter.format(value.getValue()));
		}
	}
		
}
