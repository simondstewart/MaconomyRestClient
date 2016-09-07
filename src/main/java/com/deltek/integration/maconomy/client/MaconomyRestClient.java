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
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.message.GZipEncoder;

import com.deltek.integration.maconomy.domain.Card;
import com.deltek.integration.maconomy.domain.Data;
import com.deltek.integration.maconomy.domain.Endpoint;
import com.deltek.integration.maconomy.domain.Error;
import com.deltek.integration.maconomy.domain.HasConcurrencyControl;
import com.deltek.integration.maconomy.domain.HasLinksAndConcurrencyHolder;
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

	private static final Log LOG = LogFactory.getLog(MaconomyRestClient.class);
	
	private final String apiBasePath;
	private final Client client;
	
	public MaconomyRestClient(String maconomyUser, String maconomyPassword, String apiBasePath) {
		this.apiBasePath = apiBasePath;
		this.client = buildClientForCurrentUser(maconomyUser, maconomyPassword);
	}
	
    private final Client buildClientForCurrentUser(String maconomyUser, String maconomyPassword) {

        HttpAuthenticationFeature authFeature = HttpAuthenticationFeature.basic(maconomyUser, maconomyPassword);

        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .register(authFeature)
                .register(EncodingFilter.class)
                .register(GZipEncoder.class)
                .register(LoggingFeature.class)
                .build();
        return client;
    }

    public class APIHelper<CARD_RECORD extends Object, 
    						TABLE_RECORD extends Object> {

    	private final String endpointPath;
		private final GenericType<Data<CARD_RECORD, TABLE_RECORD>> dataGenericType;
		private final GenericType<Record<TABLE_RECORD>> tableRecordGenericType;
		private final GenericType<Record<CARD_RECORD>> cardRecordGenericType;
    	
    	//TODO: Is there a better way to do this, should be able to infer the generic type of the records from dataGenericType
		public APIHelper(String endpointPath,  
								GenericType<Data<CARD_RECORD, TABLE_RECORD>> dataGenericType,
								GenericType<Record<CARD_RECORD>> cardRecordGenericType,
								GenericType<Record<TABLE_RECORD>> tableRecordGenericType) {
			super();
			this.endpointPath = endpointPath;
			this.dataGenericType = dataGenericType;
			this.tableRecordGenericType = tableRecordGenericType;
			this.cardRecordGenericType = cardRecordGenericType;
		}

		public Endpoint endPoint() 
    	{
    		return getEndpoint(endpointPath);
    	}

		public Record<CARD_RECORD> init() {
			return init(endPoint());
		}
		
    	public Record<CARD_RECORD> init(Endpoint endpoint) {
    		return initInternal(endpoint);
        }
    	
    	public Data<CARD_RECORD, TABLE_RECORD> createCard(Record<CARD_RECORD> cardRecord) {
    		return createInternal(cardRecord);
    	}
    	
    	public Record<TABLE_RECORD> initTable(Table<TABLE_RECORD> table) {
    		//Why would the Table have an add action instead of the insert action used for the card?  
    		//TODO: Check if this is consistent with the model
    		return postDataToAction("action:add", table, "", tableRecordGenericType);
    	}
        
        private Record<CARD_RECORD> initInternal(Endpoint endpoint) {
        	//Create the Journal.
        	String templateJournalLink = endpoint.getLinks().getLinks().get("action:insert").getHref();
        	Response response = client.target(templateJournalLink).request(MediaType.APPLICATION_JSON).post(Entity.entity("",  MediaType.APPLICATION_JSON));
        	Record<CARD_RECORD> record = response.readEntity(cardRecordGenericType);
        	return record;
        } 
        
        private Data<CARD_RECORD, TABLE_RECORD> createInternal(Record<?> templateRecord) {	
        	return postDataToAction("action:create", templateRecord, templateRecord, dataGenericType);
        }
	   
		private <RESPONSE extends Object, REQUEST_BODY extends Object> 
    		RESPONSE postDataToAction(String action, HasLinksAndConcurrencyHolder metaAndLinks, 
    				REQUEST_BODY requestBody, 
    				GenericType<RESPONSE> responseType) {
        	String templateJournalLink = metaAndLinks.getLinks().getLinks().get(action).getHref();
            Invocation.Builder invocationBuilder = client.target(templateJournalLink).request(MediaType.APPLICATION_JSON);
            invocationBuilder = decorateConcurrencyControl(invocationBuilder, metaAndLinks.getMeta());
        	Response response = invocationBuilder.post(Entity.entity(requestBody,  MediaType.APPLICATION_JSON));
        	checkThrowApplicationExceptionFromResponse(response);
        	RESPONSE record = response.readEntity(responseType);
        	return record;    		
    	}
    	
        
    	public Data<CARD_RECORD, TABLE_RECORD> addTableRecord(Record<TABLE_RECORD> tableRecord) {
    		return createInternal(tableRecord);
    	}
    	
    	//TODO: Traverse the any link, 
    	public Data<CARD_RECORD, TABLE_RECORD> any() {
    		return null;	
    	}
    	
    	public Data<CARD_RECORD, TABLE_RECORD> filter() {
    		return null;
    	}
    	
    }
    private Invocation.Builder decorateConcurrencyControl(Invocation.Builder builder, HasConcurrencyControl cc) {
    	if(cc.getConcurrencyControl() == null || cc.getConcurrencyControl().trim().isEmpty())
    		return builder;
    	
        return builder.header("Maconomy-Concurrency-Control", cc.getConcurrencyControl());
    }
    
    public APIHelper<Journal, HoursJournal> jobJournal() {
    	return new APIHelper<>("jobjournal",  
    			new GenericType<Data<Journal, HoursJournal>>(){},
    			new GenericType<Record<Journal>>(){},
    			new GenericType<Record<HoursJournal>>(){});
    }
    
    public APIHelper<JobBudget, JobBudgetLine> jobBudget() {
    	return new APIHelper<>("jobbudgets", 
    			new GenericType<Data<JobBudget, JobBudgetLine>>(){}, 
    			new GenericType<Record<JobBudget>>(){}, 
    			new GenericType<Record<JobBudgetLine>>(){});
    }
    
    public APIHelper<EmployeeCard, EmployeeTable> employee() {
    	return new APIHelper<>("employees", 
    			new GenericType<Data<EmployeeCard, EmployeeTable>>(){}, 
    			new GenericType<Record<EmployeeCard>>(){}, 
    			new GenericType<Record<EmployeeTable>>(){});
    }
    
    private Endpoint getEndpoint(String endpointPath) {
    	 WebTarget getTarget = client.target(apiBasePath).path(endpointPath);
         Invocation.Builder getInvocationBuilder = getTarget.request(MediaType.APPLICATION_JSON);
         Response getResponse = getInvocationBuilder.get();

         checkThrowApplicationExceptionFromResponse(getResponse);
         return getResponse.readEntity(new GenericType<Endpoint>(){});
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

        checkThrowApplicationExceptionFromResponse(getResponse);
        return getResponse.readEntity(type);
    }
    
    private void checkThrowApplicationExceptionFromResponse(Response response) {

    	//No error, HTTP Ok.
    	if(response.getStatus() == 200) 
    		return;
    	
        StringBuilder errorBuilder = new StringBuilder();
        errorBuilder.append(String.format("Error Performing HTTP Request. Response status: %s %s \n", response.getStatus(), response.getStatusInfo()));
        //attempt to serialise an Error object from the response for extra information.
        errorBuilder = buildErrorMessageFromAppError(response, errorBuilder);
        
        String errorMessage = errorBuilder.toString();
        if(LOG.isInfoEnabled()) {
        	LOG.info("HTTP Response contained error: \n"+errorMessage);
        }
        throw new MaconomyRestClientException(errorMessage);
        
    }
    
    private StringBuilder buildErrorMessageFromAppError(Response response, StringBuilder errorStringBuilder){
    	try {
            Error restError = response.readEntity(Error.class);
            String message = restError.getErrorMessage();
            errorStringBuilder.append(String.format("Message: %s ", message));
            restError.getAdditionalProperties().keySet().forEach(
            		key -> errorStringBuilder.append("\n"+key+ ":"+restError.getAdditionalProperties().get(key)));
    	} catch (ProcessingException pe) {
    		if(LOG.isTraceEnabled()) {
    			LOG.trace("Cannot Marshal an Error object from the Http response, this may be expected for some HTTP errors", pe);
    		}
    	}
        return errorStringBuilder;
    }
}
