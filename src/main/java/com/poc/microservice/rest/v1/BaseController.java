
package com.poc.microservice.rest.v1;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.core.JsonParseException;
import com.poc.microservice.dto.ErrorResponse;
import com.poc.microservice.exception.AuthException;
import com.poc.microservice.exception.BaseException;
import com.poc.microservice.exception.LockedException;
import com.poc.microservice.exception.ObjectNotFoundException;
import com.poc.microservice.exception.ResourceAlreadyExistsException;
import com.poc.microservice.exception.common.ErrorConstants;
import com.poc.microservice.utils.LogUtility;


/**
 * The Class BaseController.
 * @author pravin sarode
 */
@CrossOrigin(origins = "*")
public class BaseController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	/** The servlet request. */
	@Autowired
	protected HttpServletRequest servletRequest;
	
	/**
	 * Logs incoming request
	 * 
	 * @param requestParameter
	 */
	protected void logRequest(Object... requestParameter) {
		if (servletRequest != null) {
			this.getLogger().info(LogUtility.logRequest(servletRequest.getRequestURL().toString(),
					servletRequest.getRemoteAddr(), servletRequest.getMethod(), requestParameter));
		}
	}

	protected void logRequest() {
		if (servletRequest != null) {
			this.getLogger().info(LogUtility.logRequest(servletRequest.getRequestURL().toString(),
					servletRequest.getRemoteAddr(), servletRequest.getMethod()));
		}
	}

	/**
	 * Logs outgoing response
	 * 
	 * @param responseObject
	 */
	protected void logResponse(Object responseObject) {
		if (servletRequest != null) {
			this.getLogger().info(LogUtility.logResponse(servletRequest.getRequestURL().toString(),
					servletRequest.getMethod(), responseObject));
		}
	}

	/**
	 * Gets the logger.
	 *
	 * @return the logger
	 */
	protected Logger getLogger() {
		return logger;
	}

    /***
     * Returns created resource with 201
     *
     * @param t
     * @return
     */
    protected <T> ResponseEntity<T> created(T t) {
		logResponse(t);
        return new ResponseEntity<T>(t, HttpStatus.CREATED);
    }

    /***
     * Returns created resource with 201
     *
     * @param t
     * @return
     */
    protected <T> ResponseEntity<T> get(T t) {
    	logResponse(t);
        return new ResponseEntity<T>(t, HttpStatus.OK);
    }

    /**
     * Returns updated resource with 200
     *
     * @param t
     * @return
     */
    protected <T> ResponseEntity<T> updated(T t) {
    	logResponse(t);
        return new ResponseEntity<T>(t, HttpStatus.OK);
    }

    /**
     * Return no content with response code 204
     *
     * @param
     * @return
     */
    protected <T> ResponseEntity<?> getNoContentResponse(T t) {
    	logResponse(t);
        return new ResponseEntity<T>(t, HttpStatus.NO_CONTENT);
    }

    /**
     * Return error ResponseEntity
     *
     * @param exception
     * @return
     */
    protected ResponseEntity<ErrorResponse> getErrorResponseEntity(
            Exception exception) {
        ErrorResponse object = null;
        ResponseEntity<ErrorResponse> response = null;
        object = getErrorResponse(exception);
        response = new ResponseEntity<ErrorResponse>(object,
                HttpStatus.valueOf(object.getErrorCode()));
        logResponse(object);
        return response;
    }

    /**
     * Return error response entity from exception
     *
     * @param exception
     * @return
     */
    protected ErrorResponse getErrorResponse(Exception exception) {
        ErrorResponse entity = null;
        if (exception instanceof JsonParseException) {
            entity = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                    ErrorConstants.BAD_REQUEST);
        } else if (exception instanceof ObjectNotFoundException) {
            entity = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                    ErrorConstants.INCIDENT_WITH_TYPE_AND_SUBTYPE_AND_USERGUID_NOT_FOUND);
        } else if (exception instanceof AuthException) {
            entity = new ErrorResponse(HttpStatus.FORBIDDEN.value(),
                    ErrorConstants.AUTH_TOKEN_REQUIRED);
        } else if (exception instanceof ResourceAlreadyExistsException) {
            entity = new ErrorResponse(HttpStatus.CONFLICT.value(),
                    ErrorConstants.RESOURCE_ALREADY_EXISTS);
		} else if (exception instanceof LockedException) {
			entity = new ErrorResponse(HttpStatus.LOCKED.value(), ErrorConstants.LOCKED_ERROR);
		}else if (exception instanceof BaseException) {
            entity = ((BaseException) exception).getError();
        } else {
            entity = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    ErrorConstants.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }
}
