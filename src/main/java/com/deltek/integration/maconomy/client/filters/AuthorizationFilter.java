package com.deltek.integration.maconomy.client.filters;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.HttpHeaders;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Base64Utils;

import com.deltek.integration.maconomy.containers.v1.ContainersConstants;

/** Filter for authorization. */
public final class AuthorizationFilter implements ClientRequestFilter, ClientResponseFilter {

	private static final Log LOG = LogFactory.getLog(AuthorizationFilter.class);

	private final String username, password;
	private String reconnectToken;

	public AuthorizationFilter(final String username, final String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().add(ContainersConstants.MACONOMY_AUTHENTICATION, ContainersConstants.X_RECONNECT);
		if (reconnectToken != null) {
			requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION, ContainersConstants.X_RECONNECT + " " + reconnectToken);
			LOG.info("Using reconnect token");
		} else if (username != null && password != null) {
			final String combined = username + ":" + password;
			final byte[] utf8_bytes = combined.getBytes(Charset.forName("UTF-8"));
			final String base64 = Base64Utils.encodeToString(utf8_bytes);
			requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION, "BASIC " + base64);
			LOG.info("Using basic authentication");
		}
		// TODO: (ANH) handle domain credentials
	}

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext)
			throws IOException {
		final String newReconnectToken = responseContext.getHeaderString(ContainersConstants.MACONOMY_RECONNECT);
		if (newReconnectToken != null) {
			reconnectToken = newReconnectToken;
		}
	}

}
