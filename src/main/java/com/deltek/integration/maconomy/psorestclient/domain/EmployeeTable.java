package com.deltek.integration.maconomy.psorestclient.domain;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "employeenumber",
        "name1",
        "name2",
        "createddate",
        "transactiontimestamp"
})
public class EmployeeTable {

    @JsonProperty("employeenumber")
    private String employeenumber;
    @JsonProperty("name1")
    private String name1;
    @JsonProperty("name2")
    private String name2;
    @JsonProperty("createddate")
    private String createddate;
    @JsonProperty("transactiontimestamp")
    private String transactiontimestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getEmployeenumber() {
		return employeenumber;
	}

	public void setEmployeenumber(String employeenumber) {
		this.employeenumber = employeenumber;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getTransactiontimestamp() {
		return transactiontimestamp;
	}

	public void setTransactiontimestamp(String transactiontimestamp) {
		this.transactiontimestamp = transactiontimestamp;
	}

	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
