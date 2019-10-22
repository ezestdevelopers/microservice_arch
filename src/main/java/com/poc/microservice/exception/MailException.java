/**
 * 
 */
package com.poc.microservice.exception;


/**
 * This is the application specific exception class for Lighthouse IDMe.
 * Any custom error codes or exceptions due to business validations or
 * business rules-engine will be defined here.
 * @author anshu.gupta
 * @since  1.0
 */
public class MailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -97489601876868146L;
	
	/**
	 * This will represent the error code i.e Standard HTTP Codes.
	 * 
	 */
	private int errorCode;
	/**
	 * This will represent the error description
	 */
	private String errorDescr;
	
	/**
	 * Reason for the error
	 */
	private int reasonCode;
	
	/**
	 * @param message
	 * @param cause
	 */
	public MailException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public MailException(String message) {
		super(message);
	}

	/**
	 * Default Constructor
	 */
	public MailException() {
        super();
    }

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorDescr
	 */
	public String getErrorDescr() {
		return errorDescr;
	}

	/**
	 * @param errorDescr the errorDescr to set
	 */
	public void setErrorDescr(String errorDescr) {
		this.errorDescr = errorDescr;
	}
	
	 /**
     * @return the reasonCode
     */
    public int getReasonCode() {
        return reasonCode;
    }

    /**
     * @param errorDescr the errorDescr to set
     */
    public void setReasonCode(int reasonCode) {
        this.reasonCode = reasonCode;
    }

	/**
	 * @param errorCode
	 * @param errorDescr
	 */
	public MailException(int errorCode, String errorDescr) {
		this.errorCode = errorCode;
		this.errorDescr = errorDescr;
	}
	
	/**
    * @param errorCode
    * @param errorDescr
    * @param reasonCode
    */
    public MailException(int errorCode, String errorDescr, int reasonCode) {
        this.errorCode = errorCode;
        this.errorDescr = errorDescr;
        this.reasonCode = reasonCode;
    }
}
