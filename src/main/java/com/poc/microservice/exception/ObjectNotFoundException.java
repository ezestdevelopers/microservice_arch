/*

 */
package com.poc.microservice.exception;

import static com.poc.microservice.exception.common.ErrorConstants.RESOURCE_NOT_FOUND;

import org.springframework.http.HttpStatus;

/**
 * The Class ObjectNotFoundException.
 *  @author pravin sarode
 */
public class ObjectNotFoundException extends DAOException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Default Constructor
     */
    public ObjectNotFoundException() {
        this(RESOURCE_NOT_FOUND);
    }

    /**
     * Error message string for the resource where conflict happens.
     * 
     * @param message
     */
    public ObjectNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }
}