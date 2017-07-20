package com.deltek.integration.maconomy.client;

import com.deltek.integration.maconomy.domain.Error;

public class MaconomyRestClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Error error;
	
	public MaconomyRestClientException() {
		super();
	}

	public MaconomyRestClientException(String message, Throwable cause, Error error) {
		super(message, cause);
		this.error = error;
	}

	public MaconomyRestClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public MaconomyRestClientException(String message, Error error) {
		super(message);
		this.error = error;
	}

	public MaconomyRestClientException(String message) {
		super(message);
	}

	public MaconomyRestClientException(Throwable cause) {
		super(cause);
	}

	public Error getError() {
		return error;
	}

}
