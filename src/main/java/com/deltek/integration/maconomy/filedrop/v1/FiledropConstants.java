package com.deltek.integration.maconomy.filedrop.v1;

import static com.deltek.integration.maconomy.client.util.Utils.URL_PATTERN;

import java.util.regex.Pattern;
import javax.ws.rs.core.MediaType;

public class FiledropConstants {

	/** Path for version 1 of the filedrop API. */
	public static final String PATH = "/filedrop/v1";

	/** Subpath used to create a new filedrop. */
	public static final String NEW_FILEDROP_PATH = "new";

	/** Request header used to supply the uploaded file to. */
	public static final String MACONOMY_FILE_CALLBACK = "Maconomy-File-Callback";

	/** Format used for the Maconomy file callback header value, where a filedrop location has to be supplied to complete it. */
	public static final String MACONOMY_FILE_CALLBACK_VALUE_FORMAT = "<%s>";

	/** Header used to indicate the type of content that is exchanged between the filedrop. */
	public static final String CONTENT_TYPE = "Content-Type";

	/** Value of the content type header, taking into account that the data is being exchanged using the binary format. */
	public static final String CONTENT_TYPE_VALUE = MediaType.APPLICATION_OCTET_STREAM;

	/** Header used to suggest a filename that the server might use to store the file. Used while uploading the file to the filedrop. */
	public static final String CONTENT_DISPOSITION = "Content-Disposition";

	/** Format used for the content disposition header value, where a filename has to be supplied to complete it. */
	public static final String CONTENT_DISPOSITION_VALUE_FORMAT = "attachment; filename=\"%s\"";

	/** Header used to return the filedrop contents. */
	public static final String LINK = "Link";

	/** Pattern used for the link header value. */
	public static final Pattern LINK_VALUE_PATTERN = Pattern.compile("^\\<(" + URL_PATTERN + ")\\>;rel\\=file;type\\=.*$");

}
