package com.poc.microservice.exception;


/**
 * The Class AuthException.
 * @author pravin sarode
 */
public class AuthException extends BaseException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2137553429285272182L;

    /** The Constant AUTH_EXCEPTION. */
    public static final String AUTH_EXCEPTION = "Exception occurred in authorization. Reason: ";

    /**
     *
     */
    public AuthException() {
        super(AUTH_EXCEPTION);
    }

    /**
     * @param message
     */
    public AuthException(String message) {
        super(AUTH_EXCEPTION + message);
    }

    public AuthException(int errorCode, String message) {
        super(errorCode, AUTH_EXCEPTION + message);
    }

    /**
     * @param message
     * @param cause
     */
    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}