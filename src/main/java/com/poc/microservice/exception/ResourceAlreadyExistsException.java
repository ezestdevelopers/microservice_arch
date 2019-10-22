package com.poc.microservice.exception;

import static com.poc.microservice.exception.common.ErrorConstants.RESOURCE_ALREADY_EXISTS;

/**
 * The Class ResourceAlreadyExistsException.
 * @author pravin sarode
 */
public class ResourceAlreadyExistsException extends EzestException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -813537127913756846L;

	/** The entity. */
	private Object entity;
	
	
	/**
	 * No-arg constructor
	 */
	public ResourceAlreadyExistsException() {
		this(RESOURCE_ALREADY_EXISTS);
	}
	
	/**
	 * Constructor for customizing message
	 * @param message new message
	 */
	public ResourceAlreadyExistsException(String message) {
		super(message);
	}
	
	/**
	 * @param entity entity that exists in the system
	 */
	public ResourceAlreadyExistsException(Object entity) {
		this();
		this.entity = entity;
	}
	
	/**
	 * Constructor for customizing message
	 * @param message new message
	 * @param entity entity that exists in the system
	 */
	public ResourceAlreadyExistsException(String message, Object entity) {
		this(message);
		this.entity = entity;
	}

	/**
	 * Gets the entity that exists in the system (optional).
	 *
	 * @return the entity that exists in the system (optional)
	 */
	public Object getEntity() {
		return entity;
	}

	/**
	 * Sets the entity that exists in the system (optional).
	 *
	 * @param entity the new entity that exists in the system (optional)
	 */
	public void setEntity(Object entity) {
		this.entity = entity;
	}

}
