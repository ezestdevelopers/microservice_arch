package com.poc.microservice.exception;


/**
 * The Class LockedException.
 * @author pravin sarode
 */
public class LockedException extends BaseException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant LOCKED_EXCEPTION. */
	public static final String LOCKED_EXCEPTION = "Associated resource has been locked Reason: ";

	/**
	 * @param message
	 */
	public LockedException(String message) {
		super(LOCKED_EXCEPTION + message);
	}

	public LockedException(int errorCode, String message) {
		super(423, message);
	}

	public LockedException() {
		super(423, LOCKED_EXCEPTION);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LockedException(String message, Throwable cause) {
		super(message, cause);
	}
}
