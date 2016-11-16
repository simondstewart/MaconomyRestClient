package com.deltek.integration.maconomy.client.api;

import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.CONTENT_DISPOSITION;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.CONTENT_DISPOSITION_VALUE_FORMAT;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.CONTENT_TYPE;
import static com.deltek.integration.maconomy.filedrop.v1.FiledropConstants.CONTENT_TYPE_VALUE;

import java.nio.file.Path;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.deltek.integration.maconomy.client.internal.IRequestClient;
import com.deltek.integration.maconomy.client.util.Utils;
import com.deltek.integration.maconomy.filedrop.v1.FiledropContents;
import com.deltek.integration.maconomy.relations.HttpMethod;

/**
 * Entry point to the Maconomy REST API in the context of a Maconomy filedrop.
 */
public class Filedrop implements IFiledrop {

	private final IFiledrop filedrop;
	private final IRequestClient requestClient;

	public Filedrop(final IFiledrop filedrop, final IRequestClient requestClient) {
		this.filedrop = filedrop;
		this.requestClient = requestClient;
	}

	@Override
	public String getLocation() {
		return filedrop.getLocation();
	}

	/**
	 * Upload the contents of the file specified at a given path to this filedrop, which should be empty, otherwise an error will be thrown.
	 * 
	 * @param file
	 * @param filedrop
	 */
	public void uploadFile(final Path path) {
		final Invocation.Builder request = requestClient.getClient().target(filedrop.getLocation()).request(MediaType.APPLICATION_JSON)
				                           .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
				                           .header(CONTENT_DISPOSITION, String.format(CONTENT_DISPOSITION_VALUE_FORMAT, path.getFileName().toString()));
		requestClient.executeRequest(request, HttpMethod.POST, Entity.entity(Utils.getFileContents(path), CONTENT_TYPE_VALUE));
	}

	/**
	 * Read the contents of this filedrop.
	 * 
	 * @param filedrop
	 * @return the contents of this filedrop.
	 */
	public FiledropContents readFiledrop() {
		final Invocation.Builder request = requestClient.getClient().target(getLocation()).request(CONTENT_TYPE_VALUE);
		final Response response = requestClient.executeRequest(request, HttpMethod.GET, null);
		final String type = response.getHeaderString(CONTENT_TYPE);
		final byte[] data = response.readEntity(byte[].class);
		return new FiledropContents(type, data);
	}

}
