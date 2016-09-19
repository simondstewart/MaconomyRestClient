package com.deltek.integration.maconomy.domain;

public interface HasLinksAndConcurrencyHolder extends HasLinks {
	
    public HasConcurrencyControl getMeta();
    
}
