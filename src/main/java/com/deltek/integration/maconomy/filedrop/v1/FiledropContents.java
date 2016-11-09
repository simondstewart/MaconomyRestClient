package com.deltek.integration.maconomy.filedrop.v1;

public class FiledropContents {

	private final String type;
	private final byte[] data;

	public FiledropContents(final String type, final byte[] data) {
		this.type = type;
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public byte[] getData() {
		return data;
	}

}
