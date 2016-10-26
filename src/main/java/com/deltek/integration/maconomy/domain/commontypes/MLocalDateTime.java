package com.deltek.integration.maconomy.domain.commontypes;

import java.time.LocalDateTime;

/**
 * An example of how we would map a custom type. 
 * 
 * We shouldn't need to do this for dates specifically if we can decide/align with the different date/time formats used
 * on the Maconomy side.
 * 
 * @author simonstewart
 *
 */
public class MLocalDateTime {

	private LocalDateTime value;

	public MLocalDateTime() {
		super();
	}

	public MLocalDateTime(LocalDateTime value) {
		super();
		this.value = value;
	}

	public LocalDateTime getValue() {
		return value;
	}

	public void setValue(LocalDateTime value) {
		this.value = value;
	}
	
}
