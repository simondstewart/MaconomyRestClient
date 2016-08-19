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
@JsonPropertyOrder({ "journalnumber", "linenumber", "employeenumber", "jobnumber", "activitynumber", "entrydate",
		"taskname", "companynumber", "transactiontimestamp" })
public class HoursJournal {

	@JsonProperty("journalnumber")
	private Integer journalnumber;
	@JsonProperty("linenumber")
	private Integer linenumber;
	@JsonProperty("employeenumber")
	private Integer employeenumber;
	@JsonProperty("jobnumber")
	private Integer jobnumber;
	@JsonProperty("activitynumber")
	private String activitynumber;
	@JsonProperty("entrydate")
	private String entrydate;
	@JsonProperty("taskname")
	private Integer taskname;
	@JsonProperty("companynumber")
	private String companynumber;
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
	 * @return The linenumber
	 */
	@JsonProperty("linenumber")
	public Integer getLinenumber() {
		return linenumber;
	}

	/**
	 * 
	 * @param linenumber
	 *            The linenumber
	 */
	@JsonProperty("linenumber")
	public void setLinenumber(Integer linenumber) {
		this.linenumber = linenumber;
	}

	/**
	 * 
	 * @return The employeenumber
	 */
	@JsonProperty("employeenumber")
	public Integer getEmployeenumber() {
		return employeenumber;
	}

	/**
	 * 
	 * @param employeenumber
	 *            The employeenumber
	 */
	@JsonProperty("employeenumber")
	public void setEmployeenumber(Integer employeenumber) {
		this.employeenumber = employeenumber;
	}

	/**
	 * 
	 * @return The jobnumber
	 */
	@JsonProperty("jobnumber")
	public Integer getJobnumber() {
		return jobnumber;
	}

	/**
	 * 
	 * @param jobnumber
	 *            The jobnumber
	 */
	@JsonProperty("jobnumber")
	public void setJobnumber(Integer jobnumber) {
		this.jobnumber = jobnumber;
	}

	/**
	 * 
	 * @return The activitynumber
	 */
	@JsonProperty("activitynumber")
	public String getActivitynumber() {
		return activitynumber;
	}

	/**
	 * 
	 * @param activitynumber
	 *            The activitynumber
	 */
	@JsonProperty("activitynumber")
	public void setActivitynumber(String activitynumber) {
		this.activitynumber = activitynumber;
	}

	/**
	 * 
	 * @return The entrydate
	 */
	@JsonProperty("entrydate")
	public String getEntrydate() {
		return entrydate;
	}

	/**
	 * 
	 * @param entrydate
	 *            The entrydate
	 */
	@JsonProperty("entrydate")
	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	/**
	 * 
	 * @return The taskname
	 */
	@JsonProperty("taskname")
	public Integer getTaskname() {
		return taskname;
	}

	/**
	 * 
	 * @param taskname
	 *            The taskname
	 */
	@JsonProperty("taskname")
	public void setTaskname(Integer taskname) {
		this.taskname = taskname;
	}

	/**
	 * 
	 * @return The companynumber
	 */
	@JsonProperty("companynumber")
	public String getCompanynumber() {
		return companynumber;
	}

	/**
	 * 
	 * @param companynumber
	 *            The companynumber
	 */
	@JsonProperty("companynumber")
	public void setCompanynumber(String companynumber) {
		this.companynumber = companynumber;
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