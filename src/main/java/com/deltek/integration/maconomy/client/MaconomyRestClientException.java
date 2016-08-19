package com.deltek.integration.maconomy.client;

public class MaconomyRestClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MaconomyRestClientException() {
		super();
	}

	public MaconomyRestClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public MaconomyRestClientException(String message) {
		super(message);
	}

	public MaconomyRestClientException(Throwable cause) {
		super(cause);
	}

}
