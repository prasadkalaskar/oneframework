package com.poc.rest.validator;

import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;

import com.poc.rest.executor.RestResponse;

public class RestValidator {
	
	private RestResponse response;

	public RestValidator(RestResponse response) {
		this.response = response;
	}

	public RestValidator expectCode(int expectedCode) {
		Assert.assertEquals(response.getResponseCode(), expectedCode,"Incorrect Response Code");
		return this;
	}

	public RestValidator expectHeader(String headerName, String headerValue) {

		Assert.assertTrue(response.getHeader(headerName).contains(headerValue), "Incorrect header - " + headerName);
		return this;
	}

	public RestValidator expectHeaders(HashMap<String, String> headers) {
		Set<String> keys = headers.keySet();
		for (String key : keys) {
			Assert.assertEquals(response.getHeader(key),headers.get(key),"Incorrect header - " + key);
		}
		return this;
	}

	public RestValidator expectInBody(String content) {
		Assert.assertTrue(response.getResponseBody().contains(content) , "Body doesnt contain string : " + content);
		return this;
	}
	
	public RestValidator expectInJSONResponse(String expected , String actual){
		
		Assert.assertEquals(JsonPath.with(response.getResponseBody()).get(actual).toString(),expected ,"Json Element not found");
		return this;
	}
	
	public RestResponse getResponse(){
		return response;
	}

	public HashMap<String, String> getHeaders(){

		Map<String, String> headers =  this.response.getHeaders();
		HashMap<String, String> headersReturn =  new HashMap<>();


		for (String key : headers.keySet()) {
			String value = headers.get(key);
			headersReturn.put(key,value);
			//System.out.println("Key = " + key + ", Value = " + value);
		}

		return headersReturn;
	}


}
