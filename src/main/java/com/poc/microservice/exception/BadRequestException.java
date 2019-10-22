
package com.poc.microservice.exception;

import com.poc.microservice.exception.common.ErrorConstants;

/**
 * The Class BadRequestException.
 * @author pravin sarode
 */
public class BadRequestException extends DAOException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6726723958342742766L;

	/**
	 * No-arg constructor
	 */
	public BadRequestException() {
        super(400, ErrorConstants.INVALID_REQUEST);
	}

	/**
	 * Constructor for customizing message
	 * @param message new message
	 */
	public BadRequestException(String message) {
        super(400, message);
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public BadRequestException(String message, Throwable cause){
		super(message,cause);
	}
}
