package com.poc.microservice.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class UnknownHostException.
 * @author pravin sarode 
 */
public class UnknownHostException extends BaseException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant UNKNOWNHOST_EXCEPTION. */
	public static final String UNKNOWNHOST_EXCEPTION = "Exception occurred in redirecting url. Reason: ";

	/**
	 * @param message
	 */
	public UnknownHostException(String message) {
		super(UNKNOWNHOST_EXCEPTION + message);
	}

	public UnknownHostException(int errorCode, String message) {
		super(408, message);
	}

	public UnknownHostException() {
		super(408, UNKNOWNHOST_EXCEPTION);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnknownHostException(String message, Throwable cause) {
		super(message, cause);
	}
}
