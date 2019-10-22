package com.poc.microservice.exception;

import com.poc.microservice.exception.common.ErrorConstants;

/**
 * The Class ResourceNotFoundException.
 * @author pravin sarode
 */
public class ResourceNotFoundException extends DAOException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4450639772847469783L;

	/**
	 *
	 */
	public ResourceNotFoundException() {
		super(404, ErrorConstants.RESOURCE_NOT_FOUND_ERROR);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ResourceNotFoundException(String message) {
		super(404, message);
	}
}
