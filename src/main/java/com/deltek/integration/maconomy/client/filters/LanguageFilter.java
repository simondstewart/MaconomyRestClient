package com.deltek.integration.maconomy.client.filters;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

import com.deltek.integration.maconomy.containers.v1.Constants;

/** Filter for language selection. */
public final class LanguageFilter implements ClientRequestFilter {

	private final String language;

	public LanguageFilter(final String language) {
		this.language = language;
	}

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().add(Constants.ACCEPT_LANGUAGE, language);
	}

}
