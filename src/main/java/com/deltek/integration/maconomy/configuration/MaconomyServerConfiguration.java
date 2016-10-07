package com.deltek.integration.maconomy.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "maconomy.server")
public class MaconomyServerConfiguration {

	private String url;
	private String port;
	private String shortName;
	private String maconomyUser;
	private String maconomyPassword;
	
	public String getMaconomyUser() {
		return maconomyUser;
	}
	public void setMaconomyUser(String maconomyUser) {
		this.maconomyUser = maconomyUser;
	}
	public String getMaconomyPassword() {
		return maconomyPassword;
	}
	public void setMaconomyPassword(String maconomyPassword) {
		this.maconomyPassword = maconomyPassword;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortname) {
		this.shortName = shortname;
	}
	
}
