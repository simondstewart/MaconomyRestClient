package com.deltek.integration.maconomy.psorestclient.domain;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "jobnumber",
        "linenumber",
        "text",
        "billingpricecurrency",
        "numberof",
        "taskname",
        "employeecategorynumber",
        "instancekey",
        "parentjobbudgetlineinstancekey",
        "showcostpricelowervar",
        "markuppercentage",
        "linetype"
})
public class JobBudgetLine {

    @JsonProperty("jobnumber")
    private String jobnumber;
    @JsonProperty("linenumber")
    private Integer linenumber;
    @JsonProperty("text")
    private String text;
    @JsonProperty("billingpricecurrency")
    private Integer billingpricecurrency;
    @JsonProperty("numberof")
    private Double numberof;
    @JsonProperty("taskname")
    private String taskname;
    @JsonProperty("employeecategorynumber")
    private String employeecategorynumber;
    @JsonProperty("instancekey")
    private String instancekey;
    @JsonProperty("parentjobbudgetlineinstancekey")
    private String parentjobbudgetlineinstancekey;
    @JsonProperty("showcostpricelowervar")
    private Integer showcostpricelowervar;
    @JsonProperty("linetype")
    private String linetype;
    @JsonProperty("markuppercentage")
    private Double markuppercentage;
    @JsonProperty("thedate")
    private String thedate;
    @JsonProperty("closingdate")
    private String closingdate;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * The linenumber
     */
    @JsonProperty("linenumber")
    public Integer getLinenumber() {
        return linenumber;
    }

    /**
     *
     * @param linenumber
     * The linenumber
     */
    @JsonProperty("linenumber")
    public void setLinenumber(Integer linenumber) {
        this.linenumber = linenumber;
    }

    /**
     *
     * @return
     * The text
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     * The text
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     * The billingpricecurrency
     */
    @JsonProperty("billingpricecurrency")
    public Integer getBillingpricecurrency() {
        return billingpricecurrency;
    }

    /**
     *
     * @param billingpricecurrency
     * The billingpricecurrency
     */
    @JsonProperty("billingpricecurrency")
    public void setBillingpricecurrency(Integer billingpricecurrency) {
        this.billingpricecurrency = billingpricecurrency;
    }

    /**
     *
     * @return
     * The numberof
     */
    @JsonProperty("numberof")
    public Double getNumberof() {
        return numberof;
    }

    /**
     *
     * @param numberof
     * The numberof
     */
    @JsonProperty("numberof")
    public void setNumberof(Double numberof) {
        this.numberof = numberof;
    }

    /**
     *
     * @return
     * The taskname
     */
    @JsonProperty("taskname")
    public String getTaskname() {
        return taskname;
    }

    /**
     *
     * @param taskname
     * The taskname
     */
    @JsonProperty("taskname")
    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    /**
     *
     * @return
     * The employeecategorynumber
     */
    @JsonProperty("employeecategorynumber")
    public String getEmployeecategorynumber() {
        return employeecategorynumber;
    }

    /**
     *
     * @param employeecategorynumber
     * The employeecategorynumber
     */
    @JsonProperty("employeecategorynumber")
    public void setEmployeecategorynumber(String employeecategorynumber) {
        this.employeecategorynumber = employeecategorynumber;
    }

    /**
     *
     * @return
     * The instancekey
     */
    @JsonProperty("instancekey")
    public String getInstancekey() {
        return instancekey;
    }

    /**
     *
     * @param instancekey
     * The instancekey
     */
    @JsonProperty("instancekey")
    public void setInstancekey(String instancekey) {
        this.instancekey = instancekey;
    }

    /**
     *
     * @return
     * The parentjobbudgetlineinstancekey
     */
    @JsonProperty("parentjobbudgetlineinstancekey")
    public String getParentjobbudgetlineinstancekey() {
        return parentjobbudgetlineinstancekey;
    }

    /**
     *
     * @param parentjobbudgetlineinstancekey
     * The parentjobbudgetlineinstancekey
     */
    @JsonProperty("parentjobbudgetlineinstancekey")
    public void setParentjobbudgetlineinstancekey(String parentjobbudgetlineinstancekey) {
        this.parentjobbudgetlineinstancekey = parentjobbudgetlineinstancekey;
    }

    /**
     *
     * @return
     * The showcostpricelowervar
     */
    @JsonProperty("showcostpricelowervar")
    public Integer getShowcostpricelowervar() {
        return showcostpricelowervar;
    }

    /**
     *
     * @param showcostpricelowervar
     * The showcostpricelowervar
     */
    @JsonProperty("showcostpricelowervar")
    public void setShowcostpricelowervar(Integer showcostpricelowervar) {
        this.showcostpricelowervar = showcostpricelowervar;
    }
    /**
     *
     * @return
     * The lintetype
     */
    @JsonProperty("linetype")
    public String getLinetype() {
        return linetype;
    }

    /**
     *
     * @param lintetype
     * The lintetype
     */
    @JsonProperty("linetype")
    public void setLinetype(String linetype) {
        this.linetype = linetype;
    }

    public Double getMarkuppercentage() {
        return markuppercentage;
    }

    public void setMarkuppercentage(Double markuppercentage) {
        this.markuppercentage = markuppercentage;
    }

    public String getThedate() {
		return thedate;
	}

	public void setThedate(String thedate) {
		this.thedate = thedate;
	}

	public String getClosingdate() {
		return closingdate;
	}

	public void setClosingdate(String closingdate) {
		this.closingdate = closingdate;
	}

	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String lookupTrafficUUID(String maconomyUuidproperty) {
    	if(getAdditionalProperties().containsKey(maconomyUuidproperty) && 
    		getAdditionalProperties().get(maconomyUuidproperty) != null) {
    			return getAdditionalProperties().get(maconomyUuidproperty).toString();
    	}
    	return "";
    }
    
    public void applyTrafficUUID(String maconomyUuidproperty, String trafficUUID) {
        setAdditionalProperty(maconomyUuidproperty, trafficUUID);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalProperties == null) ? 0 : additionalProperties.hashCode());
		result = prime * result + ((billingpricecurrency == null) ? 0 : billingpricecurrency.hashCode());
		result = prime * result + ((closingdate == null) ? 0 : closingdate.hashCode());
		result = prime * result + ((employeecategorynumber == null) ? 0 : employeecategorynumber.hashCode());
		result = prime * result + ((instancekey == null) ? 0 : instancekey.hashCode());
		result = prime * result + ((jobnumber == null) ? 0 : jobnumber.hashCode());
		result = prime * result + ((linenumber == null) ? 0 : linenumber.hashCode());
		result = prime * result + ((linetype == null) ? 0 : linetype.hashCode());
		result = prime * result + ((markuppercentage == null) ? 0 : markuppercentage.hashCode());
		result = prime * result + ((numberof == null) ? 0 : numberof.hashCode());
		result = prime * result
				+ ((parentjobbudgetlineinstancekey == null) ? 0 : parentjobbudgetlineinstancekey.hashCode());
		result = prime * result + ((showcostpricelowervar == null) ? 0 : showcostpricelowervar.hashCode());
		result = prime * result + ((taskname == null) ? 0 : taskname.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((thedate == null) ? 0 : thedate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobBudgetLine other = (JobBudgetLine) obj;
		if (additionalProperties == null) {
			if (other.additionalProperties != null)
				return false;
		} else if (!additionalProperties.equals(other.additionalProperties))
			return false;
		if (billingpricecurrency == null) {
			if (other.billingpricecurrency != null)
				return false;
		} else if (!billingpricecurrency.equals(other.billingpricecurrency))
			return false;
		if (closingdate == null) {
			if (other.closingdate != null)
				return false;
		} else if (!closingdate.equals(other.closingdate))
			return false;
		if (employeecategorynumber == null) {
			if (other.employeecategorynumber != null)
				return false;
		} else if (!employeecategorynumber.equals(other.employeecategorynumber))
			return false;
		if (instancekey == null) {
			if (other.instancekey != null)
				return false;
		} else if (!instancekey.equals(other.instancekey))
			return false;
		if (jobnumber == null) {
			if (other.jobnumber != null)
				return false;
		} else if (!jobnumber.equals(other.jobnumber))
			return false;
		if (linenumber == null) {
			if (other.linenumber != null)
				return false;
		} else if (!linenumber.equals(other.linenumber))
			return false;
		if (linetype == null) {
			if (other.linetype != null)
				return false;
		} else if (!linetype.equals(other.linetype))
			return false;
		if (markuppercentage == null) {
			if (other.markuppercentage != null)
				return false;
		} else if (!markuppercentage.equals(other.markuppercentage))
			return false;
		if (numberof == null) {
			if (other.numberof != null)
				return false;
		} else if (!numberof.equals(other.numberof))
			return false;
		if (parentjobbudgetlineinstancekey == null) {
			if (other.parentjobbudgetlineinstancekey != null)
				return false;
		} else if (!parentjobbudgetlineinstancekey.equals(other.parentjobbudgetlineinstancekey))
			return false;
		if (showcostpricelowervar == null) {
			if (other.showcostpricelowervar != null)
				return false;
		} else if (!showcostpricelowervar.equals(other.showcostpricelowervar))
			return false;
		if (taskname == null) {
			if (other.taskname != null)
				return false;
		} else if (!taskname.equals(other.taskname))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (thedate == null) {
			if (other.thedate != null)
				return false;
		} else if (!thedate.equals(other.thedate))
			return false;
		return true;
	}    

}
