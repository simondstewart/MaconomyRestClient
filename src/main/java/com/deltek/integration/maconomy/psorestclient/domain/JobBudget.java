package com.deltek.integration.maconomy.psorestclient.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "jobnumber",
        "showbudgettypevar",
        "revisionremark1var"
})
public class JobBudget {

    @JsonProperty("jobnumber")
    private String jobnumber;
    @JsonProperty("showbudgettypevar")
    private String showbudgettypevar;
    @JsonProperty("revisionremark1var")
    private String revisionremark1var;
    @JsonProperty("approvedvar")
    private Boolean approvedvar;
    @JsonProperty("submittedvar")
    private Boolean submittedvar;
    
    //e.g. "customernumber": "10000"
    private String customernumber;
    
    //e.g. "accountmanagernumber": "1001"
    private Long accountmanagernumber;
    
    //e.g. "createddate": "2016-03-22"
    private LocalDate createddate;
    
    //We define this type mapping globally, but it is also possible to defing a custom serialiser for a specific field.
    //  @JsonDeserialize(using = MLocalDateTimeDeserialiser.class)
    //  @JsonSerialize(using = MLocalDateTimeSerialiser.class)
    //e.g. "transactiontimestamp": "2016-03-22 12:13:18.130"
    private LocalDateTime transactiontimestamp;

    private String currency;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCustomernumber() {
		return customernumber;
	}

	public void setCustomernumber(String customernumber) {
		this.customernumber = customernumber;
	}

	public Long getAccountmanagernumber() {
		return accountmanagernumber;
	}

	public void setAccountmanagernumber(Long accountmanagernumber) {
		this.accountmanagernumber = accountmanagernumber;
	}

	public LocalDate getCreateddate() {
		return createddate;
	}

	public void setCreateddate(LocalDate createddate) {
		this.createddate = createddate;
	}

	public LocalDateTime getTransactiontimestamp() {
		return transactiontimestamp;
	}

	public void setTransactiontimestamp(LocalDateTime transactiontimestamp) {
		this.transactiontimestamp = transactiontimestamp;
	}

	/**
     *
     * @return
     * The jobnumber
     */
    @JsonProperty("jobnumber")
    public String getJobnumber() {
        return jobnumber;
    }

    /**
     *
     * @param jobnumber
     * The jobnumber
     */
    @JsonProperty("jobnumber")
    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

    /**
     *
     * @return
     * The showbudgettypevar
     */
    @JsonProperty("showbudgettypevar")
    public String getShowbudgettypevar() {
        return showbudgettypevar;
    }

    /**
     *
     * @param showbudgettypevar
     * The showbudgettypevar
     */
    @JsonProperty("status")
    public void setShowbudgettypevar(String showbudgettypevar) {
        this.showbudgettypevar = showbudgettypevar;
    }

    /**
     *
     * @return
     * The revisionremark1var
     */
    @JsonProperty("revisionremark1var")
    public String getRevisionremark1var() {
        return revisionremark1var;
    }

    public Boolean getApprovedvar() {
        return approvedvar;
    }

    public void setApprovedvar(Boolean approvedvar) {
        this.approvedvar = approvedvar;
    }

    public Boolean getSubmittedvar() {
        return submittedvar;
    }

    public void setSubmittedvar(Boolean submittedvar) {
        this.submittedvar = submittedvar;
    }

    /**
     *
     * @param revisionremark1var
     * The revisionremark1var
     */
    @JsonProperty("revisionremark1var")
    public void setRevisionremark1var(String revisionremark1var) {
        this.revisionremark1var = revisionremark1var;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
