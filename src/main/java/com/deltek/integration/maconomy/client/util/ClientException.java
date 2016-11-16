package com.deltek.integration.maconomy.client.util;

/**
 * Represents exception originating from the REST API/Server.
 */
public class ClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClientException(final String message) {
		super(message);
	}

	public ClientException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
