package com.poc.microservice.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class UnauthorizedException.
 * @author pravin sarode
 */
public class UnauthorizedException extends BaseException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2137553429285272182L;


    /** The Constant UNAUTHORIZED_EXCEPTION. */
    public static final String UNAUTHORIZED_EXCEPTION = "Exception occurred in authorization. Reason: ";

    /**
     *
     */
    public UnauthorizedException() {
        super(UNAUTHORIZED_EXCEPTION);
    }

    /**
     * @param message
     */
    public UnauthorizedException(String message) {
        super(UNAUTHORIZED_EXCEPTION + message);
    }

    public UnauthorizedException(int errorCode, String message) {
        super(errorCode, UNAUTHORIZED_EXCEPTION + message);
    }

    /**
     * @param message
     * @param cause
     */
    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}