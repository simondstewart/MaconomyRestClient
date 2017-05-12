package com.deltek.integration.maconomy.configuration;

public class MaconomyServerConfiguration {

	private String url;
	private String port;
	private String shortName;
	private String maconomyUser;
	private String maconomyPassword;
	
	public MaconomyServerConfiguration(String url, String port, String shortName, String maconomyUser,
			String maconomyPassword) {
		super();
		this.url = url;
		this.port = port;
		this.shortName = shortName;
		this.maconomyUser = maconomyUser;
		this.maconomyPassword = maconomyPassword;
	}
	
	public MaconomyServerConfiguration() {
		super();
	}

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
