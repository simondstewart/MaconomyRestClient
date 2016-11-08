package com.deltek.integration.maconomy.filedrop.v1;

import javax.ws.rs.core.MediaType;

public class FiledropConstants {

	/** Path for version 1 of the filedrop API. */
	public static final String PATH = "/filedrop/v1";

	/** Subpath used to create a new filedrop. */
	public static final String NEW_FILEDROP_PATH = "new";

	public static final String MACONOMY_FILE_CALLBACK = "Maconomy-File-Callback";

	public static final String CONTENT_TYPE = "Content-Type";

	public static final String CONTENT_TYPE_VALUE = MediaType.APPLICATION_OCTET_STREAM;

	public static final String CONTENT_DISPOSITION = "Content-Disposition";

	/** Format used for the content disposition header value, where a filename has to be supplied to complete it. */
	public static final String CONTENT_DISPOSITION_VALUE_FORMAT = "attachment; filename=\"%s\"";

}
