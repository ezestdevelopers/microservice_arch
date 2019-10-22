package com.poc.microservice.exception;
import static com.poc.microservice.exception.common.ErrorConstants.INTERNAL_SERVER_ERROR;

import com.poc.microservice.dto.ErrorResponse;

/**
 * The Class BaseException.
 * @author pravin sarode
 */
public class BaseException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -97489601876868146L;

	/** The error. */
	private ErrorResponse error;
	/**
	 *
	 * @param errorMessage
	 */
	public BaseException(String errorMessage) {
		super(errorMessage);
		this.error = new ErrorResponse(errorMessage);
	}

    /**
     * @param errorMessage
     */
    public BaseException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.error = new ErrorResponse(errorCode, errorMessage);
    }
	/**
	 *
	 * @param errorMessage
	 * @param cause
	 */
	public BaseException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
		this.error = new ErrorResponse(errorMessage);
	}

	/**
	 * Default Constructor
	 */
	public BaseException() {
		super();
		this.error = new ErrorResponse(INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
        return this.error.getErrorDescr();
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the new error message
	 */
	public void setErrorMessage(String errorMessage) {
        this.error.setErrorDescr(errorMessage);
	}

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public ErrorResponse getError() {
		return error;
	}

	/**
	 * Sets the error.
	 *
	 * @param error the new error
	 */
	public void setError(ErrorResponse error) {
		this.error = error;
	}
}
