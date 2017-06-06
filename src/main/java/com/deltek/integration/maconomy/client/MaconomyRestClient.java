package com.deltek.integration.maconomy.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.logging.Level;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.logging.LoggingFeature.Verbosity;

import com.deltek.integration.maconomy.configuration.MaconomyServerConfiguration;
import com.deltek.integration.maconomy.configuration.jackson.MLocalDateTimeDeserialiser;
import com.deltek.integration.maconomy.configuration.jackson.MLocalDateTimeSerialiser;
import com.deltek.integration.maconomy.domain.Endpoint;
import com.deltek.integration.maconomy.domain.Error;
import com.deltek.integration.maconomy.domain.HasConcurrencyControl;
import com.deltek.integration.maconomy.domain.HasLinks;
import com.deltek.integration.maconomy.domain.HasLinksAndConcurrencyHolder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MaconomyRestClient {

	private final java.util.logging.Logger log = java.util.logging.Logger.getLogger(getClass().getName());

	private final String apiBasePath;
	private final Client client;

	public MaconomyRestClient(String maconomyUser, String maconomyPassword, String apiBasePath) {
		this.apiBasePath = apiBasePath;
		this.client = buildClientForCurrentUser(maconomyUser, maconomyPassword);
	}

	public MaconomyRestClient(MaconomyServerConfiguration serverConfiguration) {
		this.apiBasePath = serverConfiguration.getUrl();
		this.client = 
				buildClientForCurrentUser(serverConfiguration.getMaconomyUser(), serverConfiguration.getMaconomyPassword());
	}
	
	private final Client buildClientForCurrentUser(String maconomyUser, String maconomyPassword) {

		HttpAuthenticationFeature authFeature = HttpAuthenticationFeature.basic(maconomyUser, maconomyPassword);
		LoggingFeature loggingFeature = new LoggingFeature(log, Level.FINE, Verbosity.PAYLOAD_TEXT, (1024 * 1024 * 10)); //10mb

		Client client = ClientBuilder.newBuilder().register(JacksonFeature.class)
				.register(new CustomObjectMapperContextResolver())
				.register(authFeature)
				.register(new MaconomyCredentialFilter())
//				.register(EncodingFilter.class)
//				.register(GZipEncoder.class)
				.register(loggingFeature)
				.build();
		return client;
	}
	
    private class MaconomyCredentialFilter implements ClientRequestFilter {

    	public static final String HEADER_KEY = "Maconomy-Authentication";
    	public static final String HEADER_VALUE = "X-Force-Maconomy-Credentials";
    	
		@Override
		public void filter(ClientRequestContext rc) throws IOException {
			if(!rc.getHeaders().containsKey(HEADER_KEY)) {
				rc.getHeaders().add(HEADER_KEY, HEADER_VALUE);
			}
		}
    }
    
    private class CustomObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

		private final ObjectMapper objectMapper;
		
		public CustomObjectMapperContextResolver() {
			super();
			this.objectMapper = new ObjectMapper()
					//This handles standard Java 8 Time types.
					.registerModule(new JavaTimeModule())
					.registerModule(new CustomSerialisationModule())
					.enable(SerializationFeature.INDENT_OUTPUT)
					.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		}

		@Override
		public ObjectMapper getContext(Class<?> type) {
			return objectMapper;
		}

	}
	
	/**
	 * Mapper wide type serialisation configuration module.
	 * 
	 * @author simonstewart
	 *
	 */
	public class CustomSerialisationModule extends SimpleModule {

		public CustomSerialisationModule() {
			super("CustomSerialisationModule");
			//Map a custom type to the de/serialisers
		    addSerializer(LocalDateTime.class, new MLocalDateTimeSerialiser());
		    addDeserializer(LocalDateTime.class, new MLocalDateTimeDeserialiser());
		}
		
	}
	
	public Endpoint getEndpoint(String endpointPath) {
		WebTarget getTarget = client.target(apiBasePath).path(endpointPath);
		Invocation.Builder getInvocationBuilder = getTarget.request(MediaType.APPLICATION_JSON);
		Response getResponse = getInvocationBuilder.get();

		checkThrowApplicationExceptionFromResponse(getResponse);
		return getResponse.readEntity(new GenericType<Endpoint>() {
		});
	}
	
	public <RESPONSE extends Object, REQUEST_BODY extends Object> RESPONSE postDataToAction(String action,
			HasLinksAndConcurrencyHolder metaAndLinks, REQUEST_BODY requestBody, GenericType<RESPONSE> responseType) {
		String templateJournalLink = metaAndLinks.linkForAction(action);
		Invocation.Builder invocationBuilder = client.target(templateJournalLink).request(MediaType.APPLICATION_JSON);
		invocationBuilder = decorateConcurrencyControl(invocationBuilder, metaAndLinks.getMeta());
		Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		checkThrowApplicationExceptionFromResponse(response);
		RESPONSE record = response.readEntity(responseType);
		return record;
	}


	public <RESPONSE extends Object> RESPONSE deleteRecord(HasLinksAndConcurrencyHolder metaAndLinks, 
																	GenericType<RESPONSE> responseType) {
		String templateJournalLink = metaAndLinks.linkForAction("action:delete");
		Invocation.Builder invocationBuilder = client.target(templateJournalLink).request(MediaType.APPLICATION_JSON);
		invocationBuilder = decorateConcurrencyControl(invocationBuilder, metaAndLinks.getMeta());
		Response response = invocationBuilder.delete();
		checkThrowApplicationExceptionFromResponse(response);
		RESPONSE record = response.readEntity(responseType);
		return record;
	}
	
	public <RESPONSE extends Object> RESPONSE getDataFromAction(String action, HasLinks links,
			GenericType<RESPONSE> responseType) {
		return getResponseFromURL(links.linkForAction(action), responseType);
	}

	public <RESPONSE extends Object> RESPONSE getResponseFromURL(String url, GenericType<RESPONSE> responseType) {
		Invocation.Builder getInvocationBuilder = client.target(url)
				.request(MediaType.APPLICATION_JSON);
		Response getResponse = getInvocationBuilder.get();

		checkThrowApplicationExceptionFromResponse(getResponse);
		return getResponse.readEntity(responseType);
	}
	
	
	public void checkThrowApplicationExceptionFromResponse(Response response) {

		// No error, HTTP Ok.
		if (response.getStatus() == 200)
			return;

		StringBuilder errorBuilder = new StringBuilder();
		errorBuilder.append(String.format("Error Performing HTTP Request. Response status: %s %s \n",
				response.getStatus(), response.getStatusInfo()));
		// attempt to serialise an Error object from the response for extra
		// information.
		errorBuilder = buildErrorMessageFromAppError(response, errorBuilder);

		String errorMessage = errorBuilder.toString();
		if (log.isLoggable(Level.FINE)) {
			log.info("HTTP Response contained error: \n" + errorMessage);
		}
		throw new MaconomyRestClientException(errorMessage);

	}

	public String getApiBasePath() {
		return apiBasePath;
	}

	private StringBuilder buildErrorMessageFromAppError(Response response, StringBuilder errorStringBuilder) {
		try {
			Error restError = response.readEntity(Error.class);
			String message = restError.getErrorMessage();
			errorStringBuilder.append(String.format("Message: %s ", message));
			restError.getAdditionalProperties().keySet().forEach(
					key -> errorStringBuilder.append("\n" + key + ":" + restError.getAdditionalProperties().get(key)));
		} catch (ProcessingException pe) {
			throw new MaconomyRestClientException(pe);
		}
		return errorStringBuilder;
	}
	
	private Invocation.Builder decorateConcurrencyControl(Invocation.Builder builder, HasConcurrencyControl cc) {
		if (cc.getConcurrencyControl() == null || cc.getConcurrencyControl().trim().isEmpty())
			return builder;

		return builder.header("Maconomy-Concurrency-Control", cc.getConcurrencyControl());
	}

	// TODO - this was in the TrafficLIVE integration client code, may need to
	// consider for a more generic solution.
	private String urlSafeEncodedString(String getParameter) {
		try {
			return URLEncoder.encode(getParameter, "UTF-8").replaceAll("\\+", "%20");
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException("Error Encoding url for jobNumber: " + getParameter, ex);
		}
	}


}
