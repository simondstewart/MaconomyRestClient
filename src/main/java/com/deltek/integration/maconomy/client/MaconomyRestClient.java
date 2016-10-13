package com.deltek.integration.maconomy.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.client.filter.EncodingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.message.GZipEncoder;

import com.deltek.integration.maconomy.configuration.Server;
import com.deltek.integration.maconomy.domain.Endpoint;
import com.deltek.integration.maconomy.domain.Error;
import com.deltek.integration.maconomy.domain.HasConcurrencyControl;
import com.deltek.integration.maconomy.domain.HasLinks;
import com.deltek.integration.maconomy.domain.HasLinksAndConcurrencyHolder;

public class MaconomyRestClient {

	private static final Log LOG = LogFactory.getLog(MaconomyRestClient.class);

	private final String apiBasePath;
	private final Client client;

	public MaconomyRestClient(final String maconomyUser, final String maconomyPassword, final String apiBasePath) {
		this.apiBasePath = apiBasePath;
		this.client = buildClientForCurrentUser(maconomyUser, maconomyPassword);
	}

	public MaconomyRestClient(final Server serverConfiguration) {
		this.apiBasePath = serverConfiguration.getHost();
		this.client =
				buildClientForCurrentUser(serverConfiguration.getUsername(), serverConfiguration.getPassword());
	}

	private final Client buildClientForCurrentUser(final String maconomyUser, final String maconomyPassword) {

		final HttpAuthenticationFeature authFeature = HttpAuthenticationFeature.basic(maconomyUser, maconomyPassword);

		final Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).register(authFeature)
				.register(EncodingFilter.class).register(GZipEncoder.class).register(LoggingFeature.class).build();
		return client;
	}

	public Endpoint getEndpoint(final String endpointPath) {
		final WebTarget getTarget = client.target(apiBasePath).path(endpointPath);
		final Invocation.Builder getInvocationBuilder = getTarget.request(MediaType.APPLICATION_JSON);
		final Response getResponse = getInvocationBuilder.get();

		checkThrowApplicationExceptionFromResponse(getResponse);
		return getResponse.readEntity(new GenericType<Endpoint>() {
		});
	}

	public <RESPONSE extends Object, REQUEST_BODY extends Object> RESPONSE postDataToAction(final String action,
			final HasLinksAndConcurrencyHolder metaAndLinks, final REQUEST_BODY requestBody, final GenericType<RESPONSE> responseType) {
		final String templateJournalLink = metaAndLinks.getLinks().getLinks().get(action).getHref();
		Invocation.Builder invocationBuilder = client.target(templateJournalLink).request(MediaType.APPLICATION_JSON);
		invocationBuilder = decorateConcurrencyControl(invocationBuilder, metaAndLinks.getMeta());
		final Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		checkThrowApplicationExceptionFromResponse(response);
		final RESPONSE record = response.readEntity(responseType);
		return record;
	}

	public <RESPONSE extends Object> RESPONSE getDataFromAction(final String action, final HasLinks links,
			final GenericType<RESPONSE> responseType) {
		final String templateJournalLink = links.getLinks().getLinks().get(action).getHref();
		final Invocation.Builder getInvocationBuilder = client.target(templateJournalLink)
				.request(MediaType.APPLICATION_JSON);
		final Response getResponse = getInvocationBuilder.get();

		checkThrowApplicationExceptionFromResponse(getResponse);
		return getResponse.readEntity(responseType);
	}

	public void checkThrowApplicationExceptionFromResponse(final Response response) {

		// No error, HTTP Ok.
		if (response.getStatus() == 200) {
			return;
		}

		StringBuilder errorBuilder = new StringBuilder();
		errorBuilder.append(String.format("Error Performing HTTP Request. Response status: %s %s \n",
				response.getStatus(), response.getStatusInfo()));
		// attempt to serialise an Error object from the response for extra
		// information.
		errorBuilder = buildErrorMessageFromAppError(response, errorBuilder);

		final String errorMessage = errorBuilder.toString();
		if (LOG.isInfoEnabled()) {
			LOG.info("HTTP Response contained error: \n" + errorMessage);
		}
		throw new MaconomyRestClientException(errorMessage);

	}

	public String getApiBasePath() {
		return apiBasePath;
	}

	private StringBuilder buildErrorMessageFromAppError(final Response response, final StringBuilder errorStringBuilder) {
		try {
			final Error restError = response.readEntity(Error.class);
			final String message = restError.getErrorMessage();
			errorStringBuilder.append(String.format("Message: %s ", message));
			restError.getAdditionalProperties().keySet().forEach(
					key -> errorStringBuilder.append("\n" + key + ":" + restError.getAdditionalProperties().get(key)));
		} catch (final ProcessingException pe) {
			if (LOG.isTraceEnabled()) {
				LOG.trace(
						"Cannot Marshal an Error object from the Http response, this may be expected for some HTTP errors",
						pe);
			}
		}
		return errorStringBuilder;
	}

	private Invocation.Builder decorateConcurrencyControl(final Invocation.Builder builder, final HasConcurrencyControl cc) {
		if (cc.getConcurrencyControl() == null || cc.getConcurrencyControl().trim().isEmpty()) {
			return builder;
		}

		return builder.header("Maconomy-Concurrency-Control", cc.getConcurrencyControl());
	}

	// TODO - this was in the TrafficLIVE integration client code, may need to
	// consider for a more generic solution.
	private String urlSafeEncodedString(final String getParameter) {
		try {
			return URLEncoder.encode(getParameter, "UTF-8").replaceAll("\\+", "%20");
		} catch (final UnsupportedEncodingException ex) {
			throw new RuntimeException("Error Encoding url for jobNumber: " + getParameter, ex);
		}
	}

}
