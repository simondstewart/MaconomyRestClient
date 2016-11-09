package com.deltek.integration.maconomy.filedrop.v1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FiledropContents {

	private static final Log LOG = LogFactory.getLog(FiledropContents.class);

	private final String type;
	private final byte[] data;

	public FiledropContents(final String type, final byte[] data) {
		this.type = type;
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public byte[] getData() {
		return data;
	}

	/**
	 * Helper method used to write this filedrop contents to a given file.
	 * 
	 * @param bArray
	 * @param file
	 */
	public void writeToFile(final File file) {
		try {  
			final OutputStream out = new FileOutputStream(file);
			out.write(data);
			out.close(); 
		} catch (Exception e) {  
			LOG.error("Error writing to the specified file", e);  
		}  
	}

}
