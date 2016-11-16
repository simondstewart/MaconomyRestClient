package com.deltek.integration.maconomy.client.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {

	/** Regular expression pattern that is able to capture an URL. {@link http://stackoverflow.com/questions/15518845/how-to-validate-url-in-java-using-regex}*/
	public static final String URL_PATTERN = "(?:https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

	public static byte[] getFileContents(final Path path) {
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			throw new ClientException("Error while reading file constants", e);
		}
	}

}