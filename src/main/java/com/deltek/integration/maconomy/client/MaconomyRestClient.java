package com.deltek.integration.maconomy.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.deltek.integration.maconomy.domain.Card;
import com.deltek.integration.maconomy.domain.Data;
import com.deltek.integration.maconomy.domain.Endpoint;
import com.deltek.integration.maconomy.domain.Error;
import com.deltek.integration.maconomy.domain.Record;
import com.deltek.integration.maconomy.domain.Table;
import com.deltek.integration.maconomy.domain.to.EmployeeCard;
import com.deltek.integration.maconomy.domain.to.EmployeeTable;
import com.deltek.integration.maconomy.domain.to.HoursJournal;
import com.deltek.integration.maconomy.domain.to.JobBudget;
import com.deltek.integration.maconomy.domain.to.JobBudgetLine;
import com.deltek.integration.maconomy.domain.to.JobJournal;
import com.deltek.integration.maconomy.domain.to.Journal;

public class MaconomyRestClient {

	private final String apiBasePath;
	private final Client client;
	
	public MaconomyRestClient(String maconomyUser, String maconomyPassword, String apiBasePath) {
		this.apiBasePath = apiBasePath;
		this.client = buildClientForCurrentUser(maconomyUser, maconomyPassword);
	}
	
    private Client buildClientForCurrentUser(String maconomyUser, String maconomyPassword) {

        HttpAuthenticationFeature authFeature = HttpAuthenticationFeature.basic(maconomyUser, maconomyPassword);

        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .register(authFeature)
                .build();
        return client;
    }

    //GET base endpoint
    //GET http://193.17.206.162:4111/containers/v1/x1demo/jobjournal
    //follow insert action and POST with empty body.
    //Take the response template, fill out the required fields.
    //follow the 
    
    public class APIHelper<DATA extends Data<CARD_RECORD, TABLE_RECORD>, CARD_RECORD extends Object, TABLE_RECORD extends Object> {

    	private final String endpointPath;
    	private final Class<DATA> dataType;
    	
		public APIHelper(String endpointPath, Class<DATA> dataType) {
			super();
			this.endpointPath = endpointPath;
			this.dataType = dataType;
		}

		public Endpoint endPoint() 
    	{
    		return getEndpoint(endpointPath);
    	}

		public Record<CARD_RECORD> init() {
			return init(endPoint());
		}
		
    	public Record<CARD_RECORD> init(Endpoint endpoint) {
    		return MaconomyRestClient.this.init(endpoint);
        }
    	
    	public DATA createData(Record<CARD_RECORD> cardRecord) {
    		return MaconomyRestClient.this.create(cardRecord, dataType);
    	}
    	
    	public DATA any() {
    		return null;
    	}
    }
    
    public APIHelper<JobJournal, Journal, HoursJournal> jobJournal() {
    	return new APIHelper<>("jobjournal", JobJournal.class);
    }
    
    private Endpoint getEndpoint(String endpointPath) {
    	 WebTarget getTarget = client.target(apiBasePath).path(endpointPath);
         Invocation.Builder getInvocationBuilder = getTarget.request(MediaType.APPLICATION_JSON);
         Response getResponse = getInvocationBuilder.get();

         if (getResponse.getStatus() != 200) {
             throwExceptionFromResponse(getResponse);
         }

         return getResponse.readEntity(new GenericType<Endpoint>(){});
    }
    
    
    
    private <CARD extends Object> Record<CARD> init(Endpoint endpoint) {
    	//Create the Journal.
    	//TODO: Create from the template.
    	String templateJournalLink = endpoint.getLinks().getLinks().get("action:insert").getHref();
    	Response response = client.target(templateJournalLink).request(MediaType.APPLICATION_JSON).post(Entity.entity("",  MediaType.APPLICATION_JSON));
    	Record<CARD> record = response.readEntity(new GenericType<Record<CARD>>(){});
    	return record;
    }
    
    private <DATA extends Data<CARD_RECORD, TABLE_RECORD>, CARD_RECORD extends Object, TABLE_RECORD extends Object> DATA
    	create(Record<CARD_RECORD> templateRecord, Class<DATA> dataType) {
    	String create = templateRecord.getLinks().getLinks().get("action:create").getHref();
    	Response response = client.target(create).request(MediaType.APPLICATION_JSON).post(Entity.entity(templateRecord,  
    										MediaType.APPLICATION_JSON));
    	//Not idea, but the Class type is required to avoid type erasure of generics
    	return response.readEntity(new GenericType<DATA>(dataType){});
    }
    
    public Data<EmployeeCard, EmployeeTable> getMaconomyEmployees(WebTarget target) {
        return executeRequest(target, new GenericType<Data<EmployeeCard, EmployeeTable>>(){});
    }
    
    public Data<JobBudget, JobBudgetLine> getMaconomyBudget(WebTarget target, String jobNumber) {
        String encodedJobNumber = urlSafeEncodedString(jobNumber);
        WebTarget getTarget = target.path("jobbudgets").path(String.format("data;jobnumber=%s", encodedJobNumber));
        return executeRequest(getTarget, new GenericType<Data<JobBudget, JobBudgetLine>>(){});
    }
    
    private String urlSafeEncodedString(String jobNumber){
        try{
            return URLEncoder.encode(jobNumber, "UTF-8").replaceAll("\\+", "%20");
        }catch (UnsupportedEncodingException ex){
            throw new RuntimeException("Error Encoding url for jobNumber: "+jobNumber, ex);
        }
    }
    
    private <CARD extends Object, TABLE extends Object> Data<CARD, TABLE>
    					executeRequest(WebTarget getTarget, GenericType<Data<CARD, TABLE>> type){
        Invocation.Builder getInvocationBuilder = getTarget.request(MediaType.APPLICATION_JSON);
        Response getResponse = getInvocationBuilder.get();

        if (getResponse.getStatus() != 200) {
            throwExceptionFromResponse(getResponse);
        }

        return getResponse.readEntity(type);
    }
    
    private void throwExceptionFromResponse(Response response) {
        String errorMessage = buildErrorMessage(response);
        throw new MaconomyRestClientException(errorMessage);
    }
    
    //TODO: This is broken, HTTP error responses are not handled correctly, they wont have an Error message.
    private String buildErrorMessage(Response response){
        Error restError = response.readEntity(Error.class);
        String message = restError.getErrorMessage();

        StringBuilder errorBuilder = new StringBuilder();
        errorBuilder.append(String.format("Response status: %s %s \n", response.getStatus(), response.getStatusInfo()));
        errorBuilder.append(String.format("Message: %s ", message));
        return errorBuilder.toString();
    }
}
