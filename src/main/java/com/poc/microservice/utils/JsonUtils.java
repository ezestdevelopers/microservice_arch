package com.poc.microservice.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.poc.microservice.exception.EzestException;

import org.apache.commons.lang3.StringUtils;

/**
 * The Class JsonUtils.
 * 
 * @author pravin sarode
 */
public class JsonUtils {

	/** The date format. */
	public static DateFormat dateFormat = null;

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

	/**
	 * @param object
	 * @return converted object to the json string
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String toJson(Object object) throws JsonGenerationException, JsonMappingException, IOException {
		if (dateFormat == null) {
			dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:MM:SS a");
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(dateFormat);
		return mapper.writeValueAsString(object);
	}

	/**
	 * Converts a json String into a java object
	 *
	 * @param jsonString JSON string
	 * @param clazz      class of target entity
	 * @return Instance of class of given type
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T fromJson(String jsonString, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonString, clazz);
	}

	/**
	 * Converts a json String into a java object
	 *
	 * @param jsonString JSON string
	 * @param type       class of target entity with template class
	 * @return Instance of class of given type
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T fromJson(String jsonString, JavaType type)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonString, type);
	}

	/**
	 * @param jsonString
	 * @param type
	 * @return T
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T fromJson(String jsonString, TypeReference<T> type)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonString, type);
	}

	/**
	 * Finds a field name in JSON and returns it's value.
	 *
	 * @param json
	 * @param fieldName
	 * @return value
	 */

	public static String getValue(final String json, final String fieldName) throws EzestException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(json);
			return rootNode.findValue(fieldName).textValue();
		} catch (Exception e) {
			log.error("Parsing of incoming JSON FAILED", e);
			throw new EzestException("JSON Parsing failed", e);
		}
	}

	/**
	 * Finds a JSON object in parent JSON and returns it's value.
	 *
	 * @param json
	 * @param fieldName
	 * @return value
	 */

	public static JsonNode getJsonObjectValue(final String json, final String fieldName) throws EzestException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(json);
			return rootNode.findValue(fieldName);
		} catch (IOException e) {
			log.error("Parsing of incoming JSON FAILED", e);
			throw new EzestException("JSON Parsing failed", e);
		}
	}

	/**
	 * Check if json string has fieldName.
	 *
	 * @param json
	 * @param fieldName
	 * @return true if json string has fieldName otherwise false.
	 */
	public static boolean hasFieldName(final String json, final String fieldName) throws EzestException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(json);
			return rootNode.has(fieldName);
		} catch (IOException e) {
			log.error("Parsing of incoming JSON FAILED", e);
			throw new EzestException("JSON Parsing failed", e);
		}
	}

	/**
	 * This method convert the json content string to ordered json content string
	 * 
	 * @param jsonBody
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */

	public static String getOrderedJson(String jsonBody) throws JsonParseException, JsonMappingException, IOException {
		if (StringUtils.isEmpty(jsonBody))
			return "";
		TreeMap<?, ?> map = JsonUtils.fromJson(jsonBody, TreeMap.class);
		String orderedJson = JsonUtils.toJson(map);
		if (log.isDebugEnabled())
			log.debug("Ordered JSON is  {} ", orderedJson);
		return orderedJson;
	}

	/**
	 * This is a utility method to convert object to json string.
	 * 
	 * @param jsonBody Java Object containing the json body.
	 * @return JSON String representation of the object
	 */
	public static String getJson(Object jsonBody) {
		ObjectMapper mapper = new ObjectMapper();
		String resp = "";
		if (null != jsonBody) {
			try {
				resp = mapper.writeValueAsString(jsonBody);
			} catch (Exception e) {
				log.error("Could not convert Java POJO to JSON String. Reason : ", e);
				log.error("Complete Stacktrace: ", e);
			}
		}
		return resp;
	}

	/**
	 * @param String, List<String>
	 * @return JSON string after removing attributes.
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static String removeAttributesFromJsonString(String jsonString, String excludedAttributes) {
		// Convert given jsonString to JsonNode object.
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readTree(jsonString);
			List<String> attrToRemove = createListFromString(excludedAttributes);
			for (String str : attrToRemove) {
				if (str.contains("."))
					findAndRemoveJsonNode(jsonNode, str.substring(0, str.lastIndexOf(".")),
							str.substring(str.lastIndexOf(".") + 1, str.length()));
				else
					findAndRemoveJsonNode(jsonNode, str, str);
			}
			return mapper.writeValueAsString(jsonNode);
		} catch (IOException e) {
			log.error("Error while removing attributes from JSON. Reason {} " + e);
		}
		return jsonString;
	}

	/**
	 * @param String, List<String>
	 * @return JSON string after removing attributes.
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static String keepAttributesInJsonString(String jsonString, String attributes) {
		// Convert given jsonString to JsonNode object.
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode;
			jsonNode = mapper.readTree(jsonString);
			findAndKeepJsonNode(jsonNode, "", createListFromString(attributes));
			return mapper.writeValueAsString(jsonNode);
		} catch (IOException e) {
			log.error("Error while keeping attributes from JSON. Reason {} " + e);
		}
		return jsonString;
	}

	/**
	 * @param String, String, String
	 * @return JSON string after removing attributes.
	 */
	private static JsonNode findAndKeepJsonNode(JsonNode jsonNode, String hierarchy, List<String> elementTokeep) {
		if (jsonNode instanceof ArrayNode) {
			for (JsonNode node : jsonNode) {
				jsonNode = findAndKeepJsonNode(node, hierarchy, elementTokeep);
			}
		} else if (jsonNode instanceof ObjectNode) {
			Iterator<Map.Entry<String, JsonNode>> iteratorMails = jsonNode.fields();
			List<String> nodesToRemove = new ArrayList<String>();
			while (iteratorMails.hasNext()) {
				Map.Entry<String, JsonNode> entry = iteratorMails.next();
				if (elementTokeep.contains(hierarchy + entry.getKey())) {
					continue;
				} else if (!checkPresentInList(elementTokeep, hierarchy + entry.getKey())) {
					nodesToRemove.add(entry.getKey());
					continue;
				}
				// Recursive call if any object or array found
				if (entry.getValue() instanceof ObjectNode || entry.getValue() instanceof ArrayNode) {
					findAndKeepJsonNode(entry.getValue(), hierarchy + entry.getKey() + ".", elementTokeep);
				}
			}
			removeAttributesFromJsonNode(jsonNode, nodesToRemove);
			removeEmptyAttributesFromJsonNode(jsonNode);
		}
		return jsonNode;
	}

	/**
	 * @param String, String, String
	 * @return JSON string after removing attributes.
	 */
	private static JsonNode findAndRemoveJsonNode(JsonNode jsonNode, String hierarchy, String elementToRemove) {
		JsonNode retJsonNode = jsonNode;
		if (jsonNode instanceof ArrayNode) {
			for (JsonNode node : jsonNode) {
				retJsonNode = findAndRemoveJsonNode(node, hierarchy, elementToRemove);
			}
		} else if (jsonNode instanceof ObjectNode) {
			if (hierarchy.equals(elementToRemove)) {
				// If there is no hierarchy left, Remove JSON attribute & stop iterating loop
				removeAttributesFromJsonNode(retJsonNode, elementToRemove);
				return retJsonNode;
			}
			String value = hierarchy;
			if (hierarchy.contains(".")) {
				value = hierarchy.substring(0, hierarchy.indexOf("."));
				hierarchy = hierarchy.substring(hierarchy.indexOf(".") + 1, hierarchy.length());
			} else {
				hierarchy = null;
			}
			Iterator<Map.Entry<String, JsonNode>> iteratorMails = jsonNode.fields();
			while (iteratorMails.hasNext()) {
				Map.Entry<String, JsonNode> entry = iteratorMails.next();
				if (value.equals(entry.getKey())) {
					retJsonNode = entry.getValue();
					if (hierarchy == null) {
						// If there is no hierarchy left, Remove JSON attribute & stop iterating loop
						removeAttributesFromJsonNode(retJsonNode, elementToRemove);
						break;
					}
					findAndRemoveJsonNode(retJsonNode, hierarchy, elementToRemove);
					break; // If element is found, stop iterating loop
				}
			}
		}
		return retJsonNode;
	}

	/**
	 * Function used to remove given attribute from JSON.
	 * 
	 * @param JsonNode, List<String>
	 * @return void
	 */
	private static void removeAttributesFromJsonNode(JsonNode jsonNode, String attrToRemove) {
		List<String> attrToRemoveList = new ArrayList<>();
		attrToRemoveList.add(attrToRemove);
		removeAttributesFromJsonNode(jsonNode, attrToRemoveList);
	}

	/**
	 * Function used to remove given list of attributes from JSON.
	 * 
	 * @param JsonNode, List<String>
	 * @return void
	 */
	private static void removeAttributesFromJsonNode(JsonNode jsonNode, List<String> attrToRemove) {
		if (jsonNode instanceof ObjectNode)
			((ObjectNode) jsonNode).remove(attrToRemove);
		else {
			// Removing unwanted attributes if list comes in jsonNode.
			for (JsonNode node : jsonNode) {
				if (node instanceof ObjectNode)
					((ObjectNode) node).remove(attrToRemove);
				else if (node instanceof ArrayNode)
					removeAttributesFromJsonNode(node, attrToRemove);
			}
		}
	}

	/**
	 * Function used to check whether we should keep attribute or not.
	 * 
	 * @param List<String>, String
	 * @return Boolean if it is present in the list.
	 */
	private static boolean checkPresentInList(List<String> elementTokeep, String key) {
		for (String str : elementTokeep) {
			if (str.startsWith(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Function used to remove empty JSON objects.
	 * 
	 * @param JsonNode, List<String>
	 * @return void
	 */
	private static void removeEmptyAttributesFromJsonNode(JsonNode jsonNode) {
		Iterator<JsonNode> itr = jsonNode.iterator();
		while (itr.hasNext()) {
			JsonNode node = itr.next();
			if (node instanceof ObjectNode) {
				if (node.size() == 0) {
					itr.remove();
				}
			} else if (node instanceof ArrayNode) {
				removeEmptyAttributesFromJsonNode(node);
			}
		}
	}

	/**
	 * Function used to create list based on comma separated string
	 * 
	 * @param String
	 * @return List<String>
	 */
	private static List<String> createListFromString(String str) {
		List<String> list = new ArrayList<>();
		if (isEmpty(str)) {
			return list;
		} else if (str.contains(",")) {
			String[] arr = str.split(",");
			for (String s : arr)
				list.add(s.trim());
		} else {
			list.add(str);
		}
		return list;
	}

	/**
	 * Checks if text is empty (characters <= space)
	 * 
	 * @return boolean true if text is null or empty, false otherwise
	 * @param s java.lang.String
	 */
	public static boolean isEmpty(String s) {
		int i = s == null ? 0 : s.length();
		while (i > 0) {
			if (s.charAt(--i) > ' ') {
				return false;
			}
		}
		return true;
	}
}