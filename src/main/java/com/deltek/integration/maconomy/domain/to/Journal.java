package com.deltek.integration.maconomy.domain.to;

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
@JsonPropertyOrder({ "journalnumber", "journaltype", "createddate", "period", "transactiontimestamp" })
public class Journal {

	@JsonProperty("journalnumber")
	private Integer journalnumber;
	@JsonProperty("journaltype")
	private String journaltype;
	@JsonProperty("createddate")
	private String createddate;
	@JsonProperty("period")
	private String period;
	@JsonProperty("transactiontimestamp")
	private String transactiontimestamp;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The journalnumber
	 */
	@JsonProperty("journalnumber")
	public Integer getJournalnumber() {
		return journalnumber;
	}

	/**
	 * 
	 * @param journalnumber
	 *            The journalnumber
	 */
	@JsonProperty("journalnumber")
	public void setJournalnumber(Integer journalnumber) {
		this.journalnumber = journalnumber;
	}

	/**
	 * 
	 * @return The journaltype
	 */
	@JsonProperty("journaltype")
	public String getJournaltype() {
		return journaltype;
	}

	/**
	 * 
	 * @param journaltype
	 *            The journaltype
	 */
	@JsonProperty("journaltype")
	public void setJournaltype(String journaltype) {
		this.journaltype = journaltype;
	}

	/**
	 * 
	 * @return The createddate
	 */
	@JsonProperty("createddate")
	public String getCreateddate() {
		return createddate;
	}

	/**
	 * 
	 * @param createddate
	 *            The createddate
	 */
	@JsonProperty("createddate")
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	/**
	 * 
	 * @return The period
	 */
	@JsonProperty("period")
	public String getPeriod() {
		return period;
	}

	/**
	 * 
	 * @param period
	 *            The period
	 */
	@JsonProperty("period")
	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * 
	 * @return The transactiontimestamp
	 */
	@JsonProperty("transactiontimestamp")
	public String getTransactiontimestamp() {
		return transactiontimestamp;
	}

	/**
	 * 
	 * @param transactiontimestamp
	 *            The transactiontimestamp
	 */
	@JsonProperty("transactiontimestamp")
	public void setTransactiontimestamp(String transactiontimestamp) {
		this.transactiontimestamp = transactiontimestamp;
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
