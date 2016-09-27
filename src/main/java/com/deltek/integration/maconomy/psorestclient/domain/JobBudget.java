package com.deltek.integration.maconomy.psorestclient.domain;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
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
