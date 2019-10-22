package com.poc.microservice.exception.common;

/**
 * The Class ErrorConstants.
 * @author pravin sarode 
 */
public final class ErrorConstants {
	
	/** The Constant DATA_VALIDATION_NULL_NAME. */
	public static final String DATA_VALIDATION_NULL_NAME = "Name should not be null";
	
	/** The Constant DATA_VALIDATION_NAME_SIZE. */
	public static final String DATA_VALIDATION_NAME_SIZE = "Name cannot be <1 and >100 characters";
	
	/** The Constant DATA_VALIDATION_NAME_ALPHANUMERIC. */
	public static final String DATA_VALIDATION_NAME_ALPHANUMERIC = "Name must be alphanumeric and '.' ";
	
	/** The Constant DATA_VALIDATION_OUT_OF_BOUNDS. */
	public static final String DATA_VALIDATION_OUT_OF_BOUNDS = "Details length exceeds max size";

	/** The Constant DATA_VALIDATION_DETAILS_PARSING_ERROR. */
	public static final String DATA_VALIDATION_DETAILS_PARSING_ERROR = "Details are not parseable or null";
	
	/** The Constant DATA_VALIDATION_URL_NOT_VALID. */
	public static final String DATA_VALIDATION_URL_NOT_VALID = "URL is not in a valid format";
	
	/** The Constant DATA_VALIDATION_JSON_FAILED. */
	public static final String DATA_VALIDATION_JSON_FAILED = "Json Validation Failed";
	
	/** The Constant POJO_CONVERSION_TO_JSON_FAILED. */
	public static final String POJO_CONVERSION_TO_JSON_FAILED = "Could not convert Java POJO to JSON String.";
	// END: DataValidationUtil Error constants

	/** The Constant NOT_IMPLEMENTED_ERROR. */
	public static final String NOT_IMPLEMENTED_ERROR = "Functionality is not yet implemented or supported";

	/** The Constant RESOURCE_NOT_FOUND_ERROR. */
	public static final String RESOURCE_NOT_FOUND_ERROR = "Requested resource not found";

	/** The Constant ENTITY_NOT_FOUND_ERROR. */
	public static final String ENTITY_NOT_FOUND_ERROR = "Requested entity not found";
	
	/** The Constant JSON_PARSING_FAILED. */
	public static final String JSON_PARSING_FAILED = "Error in parsing JSON";
	
	/** The Constant INCORRECT_JSON_RECEIVED. */
	public static final String INCORRECT_JSON_RECEIVED = "Incorrect JSON received from IDM";
	
	/** The Constant SCIM_PARSING_FAILED. */
	public static final String SCIM_PARSING_FAILED = "Error in parsing SCIM Filter";
	
	/** The Constant DELETE_ASSIGNMENT_ERROR. */
	public static final String DELETE_ASSIGNMENT_ERROR = "Assignment could not be deleted";

	/** The Constant INVALID_REQUEST. */
	public static final String INVALID_REQUEST = "Invalid request";

	/** The Constant INVALID_ENTID_UPDATE. */
	public static final String INVALID_ENTID_UPDATE = "Invalid request to update ent Id";

	/** The Constant ERROR_READING_STREAM. */
	public static final String ERROR_READING_STREAM = "Couldn't read document";

	/** The Constant ERROR_READING_SCHEMA_WITH_SUBSCRIPTION. */
	public static final String ERROR_READING_SCHEMA_WITH_SUBSCRIPTION = "Couldn't read schema document with subscription details";

	/** The Constant SERVICE_ID_NOT_VALID. */
	public static final String SERVICE_ID_NOT_VALID = "Service Id is not valid";
	
	/** The Constant CONF_TYPE_NOT_VALID. */
	public static final String CONF_TYPE_NOT_VALID = "Configuration type is not valid";

	/** The Constant ERROR_SORT_BY_COLUMN. */
	public static final String ERROR_SORT_BY_COLUMN = "Given sortBy column is invalid";
	
	/** The Constant SORTING_ERROR. */
	public static final String SORTING_ERROR = "Error while sorting";
	
	/** The Constant RESOURCE_ALREADY_EXISTS. */
	public static final String RESOURCE_ALREADY_EXISTS = "Incident already exists";
	
	/** The Constant SERVICE_SEPCIFIC_SETTINGS_MISSING. */
	public static final String SERVICE_SEPCIFIC_SETTINGS_MISSING = "Service specific settings missing in the request";
	
	/** The Constant RESOURCE_NOT_FOUND. */
	public static final String RESOURCE_NOT_FOUND = "resource_not_found";
	
	/** The Constant INCIDENT_WITH_TYPE_AND_SUBTYPE_AND_USERGUID_NOT_FOUND. */
	public static final String INCIDENT_WITH_TYPE_AND_SUBTYPE_AND_USERGUID_NOT_FOUND = "No incident found";

    /** The Constant DYNAMIC_QUEUE_NAME_GENERATION_ERROR. */
    public static final String DYNAMIC_QUEUE_NAME_GENERATION_ERROR = "Error generating dynamic queue name.";
    
    /** The Constant CRON_JOB_NOT_SUPPORTED. */
    public static final String CRON_JOB_NOT_SUPPORTED = "Bad request, this cron job not supported by ezest service";
	
	/** The Constant INTERNAL_SERVER_ERROR. */
	public static final String INTERNAL_SERVER_ERROR = "Internal server error";
	
	/** The Constant ERROR_EVENT_PUBLISH_FAILED. */
	public static final String ERROR_EVENT_PUBLISH_FAILED = "Failed to publish event";
	
	/** The Constant UNAUTHORIZED_ERROR. */
	public static final String UNAUTHORIZED_ERROR = "Not authrorized to access resource";
	
	/** The Constant UNAUTHORIZED_USER. */
	public static final String UNAUTHORIZED_USER = "Invalid user credentials";
	
	/** The Constant INVALID_TOKEN. */
	public static final String INVALID_TOKEN = "Invalid token";
	
	/** The Constant AUTH_TOKEN_REQUIRED. */
	public static final String AUTH_TOKEN_REQUIRED = "Authentication credentials required";
	
	/** The Constant BAD_REQUEST. */
	public static final String BAD_REQUEST = "Bad Request";
	
	/** The Constant INVALID_TENANT_ID. */
	public static final String INVALID_TENANT_ID = "Invalid Tenant ID";
	
	/** The Constant ACCESS_DENIED. */
	public static final String ACCESS_DENIED = "Access Denied";
	
	/** The Constant LOCKED_ERROR. */
	public static final String LOCKED_ERROR = "Associated resource has been locked";
}