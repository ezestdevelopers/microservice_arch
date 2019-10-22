package com.poc.microservice.utils;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class LogUtility.
 * @author pravin sarode
 */

public class LogUtility {

	// Logging Request Details
	/**
	 * This method will log all incoming request. This will log the HTTP params
	 * & URL Info.
	 * 
	 * @param url
	 *            request URL
	 * @param ipAddress
	 *            Ip address of request url
	 * @param requestParameters
	 * @return log request in string
	 */
	public static String logRequest(String url, String ipAddress, String method, Object... requestParameters) {
		StringBuilder sb = new StringBuilder();
		ObjectMapper mapper = new ObjectMapper();
		try {
			sb.append(logRequest(url, ipAddress, method))
					.append("Request: " + mapper.writeValueAsString(requestParameters));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String logRequest(String url, String remoteAddr, String method) {
		StringBuilder sb = new StringBuilder();
		sb.append("Client IP Address: " + remoteAddr + Constants.LOGGING_CSV_DELIMITER);
		sb.append("Method:" + method + Constants.LOGGING_CSV_DELIMITER);
		sb.append("Url: " + url + Constants.LOGGING_CSV_DELIMITER);
		sb.append("Time: " + new Date() + Constants.LOGGING_CSV_DELIMITER);
		return sb.toString();
	}

	// Logging Response Details
	/**
	 * This method will log all outgoing response. This will log all outgoing
	 * HTTP response.
	 *
	 * @param url
	 * @param obj
	 * @return log response in string
	 */
	public static String logResponse(String url, String method, Object obj) {
		StringBuilder sb = new StringBuilder();
		try {
			ObjectMapper mapper = new ObjectMapper();
			sb.append("Client IP Address: " + url + Constants.LOGGING_CSV_DELIMITER);
			sb.append("Method:" + method + Constants.LOGGING_CSV_DELIMITER);
			sb.append("Time: " + new Date() + Constants.LOGGING_CSV_DELIMITER);
			sb.append("Response: " + mapper.writeValueAsString(obj));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * printJsonString used to show object value as json
	 * 
	 * @param log
	 *            Logger instance
	 *
	 * @param appDto
	 *            Object instance
	 */
	public static void printJsonString(Logger log, Object appDto) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (log.isDebugEnabled())
				log.debug(mapper.writeValueAsString(appDto));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
