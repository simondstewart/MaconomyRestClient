package com.deltek.integration.maconomy.client;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class RequestLogger implements ClientRequestFilter {

	private static final Log LOG = LogFactory.getLog(RequestLogger.class);

    @Override
    public void filter(final ClientRequestContext requestContext) throws IOException {
        LOG.info(requestContext.getEntity().toString());
    }
}