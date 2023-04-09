package com.mazen.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mazen.common.model.ResponseObject;

public class ResponseUtil {
	
	private static final Logger LOGGER =LoggerFactory.getLogger(ResponseUtil.class);

	public static <T> ResponseObject<T> createSuccessResponse(T object) {
		ResponseObject<T> responseObject = new ResponseObject<T>();
		responseObject.setResult(object);
		responseObject.setSuccess(true);
		responseObject.setErrorMessage(null);
		
		return responseObject;
	}
	
	public static <T> ResponseObject<T> createSuccessWithWarning(T object, String errorMessage) {
		ResponseObject<T> responseObject = new ResponseObject<T>();
		responseObject.setResult(object);
		responseObject.setSuccess(true);
		responseObject.setErrorMessage(errorMessage);
		
		return responseObject;
	}
	
	public static <T> ResponseObject<T> createErrorResponse(String errorMessage) {
		ResponseObject<T> responseObject = new ResponseObject<T>();
		responseObject.setResult(null);
		responseObject.setSuccess(true);
		responseObject.setErrorMessage(errorMessage);
		
		return responseObject;
	}
	
	public static String generateJsonResponse(String message, boolean success) {
		ObjectMapper mapper = new ObjectMapper();
		try 
		{
			if(success) {
				return mapper.writeValueAsString(ResponseUtil.createSuccessResponse(message));
			}
			return mapper.writeValueAsString(ResponseUtil.createErrorResponse(message));
		}
		catch(JsonProcessingException e) {
			LOGGER.error("Error while generating JSON message", e);
		}
		return "()";
		}

}
