package com.poc.microservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Constants.
 * @author pravin sarode
 */
public class Constants {
	
	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(Constants.class);

	/** The Constant API_VERSION. */
	public static final String API_VERSION = "1.0";
	
	/** The Constant API_VERSION_V2. */
	public static final String API_VERSION_V2 = "2.0";

	/** The Constant API_VERSION_V3. */
	public static final String API_VERSION_V3 = "3.0";

	/** The Constant SUPPORTED_LANGUAGES. */
	public static final String[] SUPPORTED_LANGUAGES = new String[] { "en", "es", "de", "ja", "fr", "pt_BR", "pt_PT",
			"zh_CN", "nl", "sv", "it", "da", "fi", "no" };

	/** The Constant BASIC_AUTH. */
	public static final String BASIC_AUTH = "Basic Authentication";
	
	/** The Constant DELIMITER_PIPELINE. */
	final static String DELIMITER_PIPELINE = "([|]+)|([|]+)";
	
	/** The Constant LOGGING_CSV_DELIMITER. */
    public static final String LOGGING_CSV_DELIMITER = "####";

}
