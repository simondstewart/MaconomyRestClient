package com.deltek.integration.maconomy.domain;

public interface HasLinksAndConcurrencyHolder {

    public Links getLinks(); 
	
    public HasConcurrencyControl getMeta();
    
}
