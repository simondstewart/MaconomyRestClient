package com.deltek.integration.maconomy.util;

/**
 * Status codes used in Maconomy RESTful web service.
 */
public enum MaconomyStatusCodes {

  /** The request has succeeded. */
  OK(200, "The request has succeeded"), //$NON-NLS-1$
  /** Malformed or incomplete request. */
  BAD_REQUEST(400, "Malformed or incomplete request"), //$NON-NLS-1$
  /** User authentication required for the request. */
  UNAUTHORIZED(401, "User authentication required for the request"), //$NON-NLS-1$
  /** The request is not permitted with the supplied credentials. */
  FORBIDDEN(403, "The request is not permitted with the supplied credentials"), //$NON-NLS-1$
  /** The request resource was not found. */
  NOT_FOUND(404, "The request resource was not found"), //$NON-NLS-1$
  /** The HTTP method is not allowed for the resource. */
  METHOD_NOT_ALLOWED(405, "The HTTP method is not allowed for the resource"), //$NON-NLS-1$
  /** The resource cannot be represented in the requested media type. */
  NOT_ACCEPTABLE(406, "The resource cannot be represented in the requested media type"), //$NON-NLS-1$
  /** The client did not produce the request within the server timeout. */
  REQUEST_TIMEOUT(408, "The client did not produce the request within the server timeout"), //$NON-NLS-1$
  /** The resource was updated by another user. */
  CONFLICT(409, "The resource was updated by another user"), //$NON-NLS-1$
  /** The request entity was larger than the maximum size supported by the server. */
  REQUEST_ENTITY_TOO_LARGE(413, "The request entity was larger than the maximum size supported by the server"), //$NON-NLS-1$
  /** The request URI was longer than the maximum length supported by the server. */
  REQUEST_URI_TOO_LONG(414, "The request URI was longer than the maximum length supported by the server"), //$NON-NLS-1$
  /** The server does not support the media type specified in the request. */
  UNSUPPORTED_MEDIA_TYPE(415, "The server does not support the media type specified in the request"), //$NON-NLS-1$
  /** The request validates the application business logic. */
  APPLICATION_ERROR(422, "The request validates the application business logic"), //$NON-NLS-1$
  /** A default status code for unexpected errors. */
  INTERNAL_SERVER_ERROR(500, "A default status code for unexpected errors"); //$NON-NLS-1$

  private final int status;
  private final String description;

  private MaconomyStatusCodes(final int status, final String description) {
    this.status = status;
    this.description = description;
  }

  /**
   * @param otherStatus
   * @return if the other status codes equals with this status code
   */
  public boolean equals(final int otherStatus) {
    return status == otherStatus;
  }

  /**
   * @return description
   */
  public String getDescription() {
    return description;
  }

}
