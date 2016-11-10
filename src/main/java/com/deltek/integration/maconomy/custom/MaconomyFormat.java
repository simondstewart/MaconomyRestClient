package com.deltek.integration.maconomy.custom;

import static com.deltek.integration.maconomy.containers.v1.ContainersConstants.DATE_FORMAT;
import static com.deltek.integration.maconomy.containers.v1.ContainersConstants.DECIMAL_SEPARATOR;
import static com.deltek.integration.maconomy.containers.v1.ContainersConstants.NUMBER_OF_DECIMALS;
import static com.deltek.integration.maconomy.containers.v1.ContainersConstants.THOUSAND_SEPARATOR;
import static com.deltek.integration.maconomy.containers.v1.ContainersConstants.TIME_FORMAT;

import java.util.Optional;

/** 
 * Represents the Maconomy format that is used to customize the print data formats. Check the details of this class to see what parameters can be customized. 
 */
public class MaconomyFormat {

	private final Optional<String> dateFormat;
	private final Optional<String> timeFormat;
	private final Optional<Character> thousandSeparator;
	private final Optional<Character> decimalSeparator;
	private final Optional<Integer> numberOfDecimals;

	private MaconomyFormat(final Optional<String> dateFormat, final Optional<String> timeFormat,
			               final Optional<Character> thousandSeparator, final Optional<Character> decimalSeparator,
			               final Optional<Integer> numberOfDecimals) {
		this.dateFormat = dateFormat;
		this.timeFormat = timeFormat;
		this.thousandSeparator = thousandSeparator;
		this.decimalSeparator = decimalSeparator;
		this.numberOfDecimals = numberOfDecimals;
	}

	/**
	 * @return if this Maconomy format is valid and can be applied for the server requests.
	 */
	public boolean isValid() {
		return dateFormat.isPresent() || timeFormat.isPresent() || thousandSeparator.isPresent() || decimalSeparator.isPresent() || numberOfDecimals.isPresent();
	}

	/**
	 * @return the value of the {@code ContainersConstants#MACONOMY_FORMAT} request header.
	 */
	public String toHeaderValue() {
		final StringBuilder headerValue = new StringBuilder();
		if (dateFormat.isPresent()) appendHeaderValuePart(headerValue, DATE_FORMAT, dateFormat.get());
		if (timeFormat.isPresent()) appendHeaderValuePart(headerValue, TIME_FORMAT, timeFormat.get());
		if (thousandSeparator.isPresent()) appendHeaderValuePart(headerValue, THOUSAND_SEPARATOR, thousandSeparator.get());
		if (decimalSeparator.isPresent()) appendHeaderValuePart(headerValue, DECIMAL_SEPARATOR, decimalSeparator.get());
		if (numberOfDecimals.isPresent()) appendHeaderValuePart(headerValue, NUMBER_OF_DECIMALS, numberOfDecimals.get());
		return headerValue.toString();
	}

	private void appendHeaderValuePart(final StringBuilder headerValue, final String partName, final Object part) {
		if (headerValue.length() > 0) {
			headerValue.append(", ");
		}
		headerValue.append(partName).append('=');
		final boolean useQuotes = part instanceof String || part instanceof Character;
		if (useQuotes) headerValue.append('"');
		headerValue.append(part);
		if (useQuotes) headerValue.append('"');
	}

	/** Use to create a Maconomy format instance. */
	public static final class Builder {

		private Optional<String> dateFormat = Optional.empty();
		private Optional<String> timeFormat = Optional.empty();
		private Optional<Character> thousandSeparator = Optional.empty();
		private Optional<Character> decimalSeparator = Optional.empty();
		private Optional<Integer> numberOfDecimals = Optional.empty();

		/** Default constructor. */
		public Builder() { }

		/** How the server should format date values. */
		public Builder dateFormat(final String dateFormat) {
			this.dateFormat = Optional.of(dateFormat);
			return this;
		}

		/** How the server should format time values. */
		public Builder timeFormat(final String timeFormat) {
			this.timeFormat = Optional.of(timeFormat);
			return this;
		}

		/** Indicates the character used as a thousand separator. */
		public Builder thousandSeparator(final Character thousandSeparator) {
			this.thousandSeparator = Optional.of(thousandSeparator);
			return this;
		}

		/** Indicates the character used as a decimal separator. */
		public Builder decimalSeparator(final Character decimalSeparator) {
			this.decimalSeparator = Optional.of(decimalSeparator);
			return this;
		}

		/** Indicates the number of decimals to include. */
		public Builder numberOfDecimals(final Integer numberOfDecimals) {
			this.numberOfDecimals = Optional.of(numberOfDecimals);
			return this;
		}

		/**
		 * @return the Maconomy format instance corresponding to the state of this builder.
		 */
		public MaconomyFormat build() {
			return new MaconomyFormat(dateFormat, timeFormat, thousandSeparator, decimalSeparator, numberOfDecimals);
		}

	}
}
