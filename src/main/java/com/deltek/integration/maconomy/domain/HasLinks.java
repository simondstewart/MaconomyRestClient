package com.deltek.integration.maconomy.domain;

import com.deltek.integration.maconomy.client.MaconomyRestClientException;

public interface HasLinks {

    public Links getLinks(); 

    default String linkForAction(String action) {
    	if (getLinks() != null && getLinks().getLinks() != null)
    	{
    		if(getLinks().getLinks().containsKey(action)) {
    			return getLinks().getLinks().get(action).getHref();
    		} 
    	}
		throw new MaconomyRestClientException("Link action: "+action + " does not exist for object: "+this);
    }

}
