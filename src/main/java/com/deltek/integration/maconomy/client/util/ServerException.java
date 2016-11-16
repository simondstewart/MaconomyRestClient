package com.deltek.integration.maconomy.client.util;

import javax.ws.rs.core.Response;

import com.deltek.integration.maconomy.containers.v1.ServerError;

/**
 * Represents exception originating from the REST API/Server.
 */
public class ServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ServerError serverError;

	ServerException(final ServerError serverError) {
		super(serverError.getErrorMessage());
		this.serverError = serverError;
	}

	public static ServerException serverException(final Response response) {
		final ServerError serverError = response.readEntity(ServerError.class);
		return new ServerException(serverError);
	}

	@Override
	public String toString() {
		return "ServerException [serverError=" + serverError + "]";
	}

}
