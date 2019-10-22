package com.poc.microservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ErrorResponse.
 * @author pravin sarode
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {

    /** The error code. */
    private int errorCode = 500;
    
    /** The error descr. */
    private String errorDescr;
    
    /** The reason code. */

    /**
     * Detail on the reson for the error code
     */
    private int reasonCode;

    /**
	 * Gets the this will represent the error description.
	 *
	 * @return the this will represent the error description
	 */
    public String getErrorDescr() {
        return errorDescr;
    }
    
    /**
	 * Sets the this will represent the error description.
	 *
	 * @param errorDescr the new this will represent the error description
	 */
    public void setErrorDescr(String errorDescr) {
        this.errorDescr = errorDescr;
    }
    
    /**
	 * Gets the this will represent the error code i.
	 *
	 * @return the this will represent the error code i
	 */
    public int getErrorCode() {
        return errorCode;
    }
    
    /**
	 * Sets the this will represent the error code i.
	 *
	 * @param errorCode the new this will represent the error code i
	 */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
	 * Gets the reason code.
	 *
	 * @return the reason code
	 */
    public int getReasonCode() {
        return reasonCode;
    }
    
    /**
	 * Sets the reason code.
	 *
	 * @param reasonCode the new reason code
	 */
    public void setReasonCode(int reasonCode) {
        this.reasonCode = reasonCode;
    }

    /**
     * @param errorCode
     * @param errorDescr
     */
    public ErrorResponse(int errorCode, String errorDescr) {
        super();
        this.errorCode = errorCode;
        this.errorDescr = errorDescr;
    }

    /**
     * @param errorCode
     * @param errorDescr
     */
    public ErrorResponse(int errorCode, String errorDescr, int reasonCode) {
        super();
        this.errorCode = errorCode;
        this.errorDescr = errorDescr;
        this.reasonCode = reasonCode;
    }
    /**
     *
     */
    public ErrorResponse() {
        super();
    }

    /**
     * @param errorMessage
     */
    public ErrorResponse(String errorDescr) {
        super();
        this.errorDescr = errorDescr;
    }
}
