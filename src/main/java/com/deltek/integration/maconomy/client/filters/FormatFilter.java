package com.deltek.integration.maconomy.client.filters;

import static com.deltek.integration.maconomy.containers.v1.ContainersConstants.MACONOMY_FORMAT;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

import com.deltek.integration.maconomy.custom.MaconomyFormat;

/** Filter for format selection. */
public class FormatFilter implements ClientRequestFilter {

	private final MaconomyFormat format;

	public FormatFilter(final MaconomyFormat format) {
		this.format = format;
	}

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().add(MACONOMY_FORMAT, format.toHeaderValue());
	}

}
