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

import com.deltek.integration.maconomy.domain.HasConcurrencyControl;
import com.deltek.integration.maconomy.domain.HasLinks;
import com.deltek.integration.maconomy.domain.HasLinksAndConcurrencyHolder;
import com.deltek.integration.maconomy.domain.Table;
import com.deltek.integration.maconomy.domain.internal.CardTableContainer;
import com.deltek.integration.maconomy.domain.internal.Endpoint;
import com.deltek.integration.maconomy.domain.internal.Error;
import com.deltek.integration.maconomy.domain.internal.FilterContainer;
import com.deltek.integration.maconomy.domain.internal.Links;
import com.deltek.integration.maconomy.domain.internal.Record;
import com.deltek.integration.maconomy.psorestclient.domain.EmployeeCard;
import com.deltek.integration.maconomy.psorestclient.domain.EmployeeTable;
import com.deltek.integration.maconomy.psorestclient.domain.HoursJournal;
import com.deltek.integration.maconomy.psorestclient.domain.JobBudget;
import com.deltek.integration.maconomy.psorestclient.domain.JobBudgetLine;
import com.deltek.integration.maconomy.psorestclient.domain.Journal;

public class MaconomyRestClient {

	private static final Log LOG = LogFactory.getLog(MaconomyRestClient.class);

	private final String apiBasePath;
	private final Client client;

	public MaconomyRestClient(String maconomyUser, String maconomyPassword, String apiBasePath) {
		this.apiBasePath = apiBasePath;
		this.client = buildClientForCurrentUser(maconomyUser, maconomyPassword);
	}

	private final Client buildClientForCurrentUser(String maconomyUser, String maconomyPassword) {

		HttpAuthenticationFeature authFeature = HttpAuthenticationFeature.basic(maconomyUser, maconomyPassword);

		Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).register(authFeature)
				.register(EncodingFilter.class).register(GZipEncoder.class).register(LoggingFeature.class).build();
		return client;
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
		String templateJournalLink = metaAndLinks.getLinks().getLinks().get(action).getHref();
		Invocation.Builder invocationBuilder = client.target(templateJournalLink).request(MediaType.APPLICATION_JSON);
		invocationBuilder = decorateConcurrencyControl(invocationBuilder, metaAndLinks.getMeta());
		Response response = invocationBuilder.post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
		checkThrowApplicationExceptionFromResponse(response);
		RESPONSE record = response.readEntity(responseType);
		return record;
	}

	public <RESPONSE extends Object> RESPONSE getDataFromAction(String action, HasLinks links,
			GenericType<RESPONSE> responseType) {
		String templateJournalLink = links.getLinks().getLinks().get(action).getHref();
		Invocation.Builder getInvocationBuilder = client.target(templateJournalLink)
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
		if (LOG.isInfoEnabled()) {
			LOG.info("HTTP Response contained error: \n" + errorMessage);
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
			if (LOG.isTraceEnabled()) {
				LOG.trace(
						"Cannot Marshal an Error object from the Http response, this may be expected for some HTTP errors",
						pe);
			}
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
