package com.deltek.integration.maconomy.client.filters;

import java.io.IOException;
import java.util.Date;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PerformanceFilter implements ClientRequestFilter, ClientResponseFilter {

	private static final Log LOG = LogFactory.getLog(PerformanceFilter.class);

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		LOG.info(String.format("Performance Log - Request - %s: %s",new Date(), requestContext.getUri()));
	}

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		LOG.info(String.format("Performance Log - Response - %s: %s",new Date(), requestContext.getUri()));
	}

}
