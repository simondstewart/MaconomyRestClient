package com.deltek.integration.maconomy.filedrop.v1;

import com.deltek.integration.maconomy.client.api.IFiledrop;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FiledropImpl implements IFiledrop {

	private String location;

	@Override
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
