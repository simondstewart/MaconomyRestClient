package com.deltek.integration.maconomy.configuration.jackson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.deltek.integration.maconomy.domain.commontypes.MLocalDateTime;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * Maconomy has a custom date format we need to de-serialise to our LocalDateTime class
 * 
 * @author simonstewart
 *
 */
public class MLocalDateTimeDeserialiser extends StdDeserializer<LocalDateTime> {

	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

	public MLocalDateTimeDeserialiser(Class<?> vc) {
		super(vc);
	}

	public MLocalDateTimeDeserialiser() {
		this(LocalDateTime.class);
	}

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
        String date = p.getText();
        if(date == null || date.isEmpty())
        	return null;
        
        return LocalDateTime.parse(date, formatter);
	}
	
}
