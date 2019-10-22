package com.poc.microservice.exception.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ErrorResponse.
 * @author pravin sarode
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ErrorResponse {
	/**
	 * @param description
	 */
	public ErrorResponse(String description) {
		super();
		this.description = description;
	}

	/** The description. */
	private String description;

	/**
	 * Gets the this will represent the error description.
	 *
	 * @return the this will represent the error description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the this will represent the error description.
	 *
	 * @param errorDescr the new this will represent the error description
	 */
	public void setDescription(String errorDescr) {
		this.description = errorDescr;
	}
}
