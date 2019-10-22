package com.poc.microservice.exception;

/**
 * The Class EzestException.
 * @author pravin sarode
 */
public class EzestException extends BaseException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7824351907664818218L;

	/**
	 * 
	 */
	public EzestException() {
		super();
	}

	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	public EzestException(int errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

	/**
	 * @param errorMessage
	 * @param cause
	 */
	public EzestException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

	/**
	 * @param errorMessage
	 */
	public EzestException(String errorMessage) {
		super(errorMessage);
	}
	
}