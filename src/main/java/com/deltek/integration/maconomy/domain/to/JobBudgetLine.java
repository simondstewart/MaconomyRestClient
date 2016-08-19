package com.deltek.integration.maconomy.domain.to;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
