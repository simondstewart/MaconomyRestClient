package com.deltek.integration.maconomy.configuration.jackson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.deltek.integration.maconomy.domain.commontypes.MLocalDateTime;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class MLocalDateTimeDeserialiser extends StdDeserializer<MLocalDateTime> {

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

	public MLocalDateTimeDeserialiser(Class<?> vc) {
		super(vc);
	}

	public MLocalDateTimeDeserialiser() {
		this(MLocalDateTime.class);
	}

	@Override
	public MLocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
        String date = p.getText();
        return new MLocalDateTime(LocalDateTime.parse(date, formatter));
	}
	
}
