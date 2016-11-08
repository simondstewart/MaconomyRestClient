package com.deltek.integration.maconomy.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {

	public static byte[] getFileContents(final Path path) {
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			throw new ClientException("Error while reading file constants", e);
		}
	}

}
