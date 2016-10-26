package com.deltek.integration.maconomy.psorestclient.domain;

import com.deltek.integration.maconomy.configuration.jackson.MLocalDateTimeDeserialiser;
import com.deltek.integration.maconomy.configuration.jackson.MLocalDateTimeSerialiser;
import com.deltek.integration.maconomy.domain.commontypes.Currency;
import com.deltek.integration.maconomy.domain.commontypes.MLocalDateTime;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.annotation.Generated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
    private MLocalDateTime transactiontimestamp;

    private Currency currency;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
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

	public MLocalDateTime getTransactiontimestamp() {
		return transactiontimestamp;
	}

	public void setTransactiontimestamp(MLocalDateTime transactiontimestamp) {
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
