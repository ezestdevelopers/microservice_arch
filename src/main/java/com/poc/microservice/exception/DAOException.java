package com.poc.microservice.exception;

/**
 * The Class DAOException.
 * @author pravin sarode
 */
public class DAOException extends BaseException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2137553429285272182L;

	/** The Constant DB_EXCEPTION. */
	public static final String DB_EXCEPTION = "Exception occurred in DB. Reason: ";

	/**
     *
     */
	public DAOException() {
		super(DB_EXCEPTION);
	}

	public DAOException(String message) {
		super(DB_EXCEPTION + message);
	}

    public DAOException(int errorCode, String message) {
        super(errorCode, DB_EXCEPTION + message);
    }

	public DAOException(String message, Throwable cause){
		super(message,cause);
	}
}
