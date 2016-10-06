package com.deltek.integration.maconomy.domain.util;

import com.deltek.integration.maconomy.domain.HasConcurrencyControl;
import com.deltek.integration.maconomy.domain.HasLinks;
import com.deltek.integration.maconomy.domain.HasLinksAndConcurrencyHolder;
import com.deltek.integration.maconomy.domain.internal.Links;

public class BasicLinksAndConcurrency implements HasLinksAndConcurrencyHolder {

	private final HasLinks hasLinks;
	private final HasConcurrencyControl hasConcurrencyControl;

	public BasicLinksAndConcurrency(HasLinks hasLinks, HasConcurrencyControl hasConcurrencyControl) {
		super();
		this.hasLinks = hasLinks;
		this.hasConcurrencyControl = hasConcurrencyControl;
	}

	public BasicLinksAndConcurrency(HasLinks hasLinks) {
		super();
		this.hasLinks = hasLinks;
		hasConcurrencyControl = new HasConcurrencyControl() {

			@Override
			public String getConcurrencyControl() {
				return "";
			}
		};
	}

	@Override
	public Links getLinks() {
		return hasLinks.getLinks();
	}

	@Override
	public HasConcurrencyControl getMeta() {
		return hasConcurrencyControl;
	}

}
