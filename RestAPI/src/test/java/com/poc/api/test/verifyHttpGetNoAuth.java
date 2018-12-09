package com.poc.api.test;

import com.poc.rest.executor.RestExecutor;
import com.poc.rest.executor.RestResponse;
import com.poc.rest.initializer.TestInitializer;
import com.poc.rest.validator.RestValidator;
import com.poc.utils.AuthenticationUtil;
import com.poc.utils.EnvConfig;
import com.poc.utils.RequestBuilder;
import com.poc.utils.Utilities;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;


public class verifyHttpGetNoAuth extends TestInitializer {

	/* Sample test case for verify Http Get No Auth */

	@Test()
	public void verifyGetService() {

		/*HTTPS REQUEST CREATION MECHANISM*/

		RequestBuilder requestBuilder = new RequestBuilder();
		AuthenticationUtil authenticationUtil = new AuthenticationUtil();
		RestExecutor restExecutor = new RestExecutor();

		// setup base URL From environment configuration / env selection at run time / read from .properties files of resource directory
		requestBuilder.setURL(EnvConfig.getURLConfiguration("dev", "T1_API_URL"));
		// setup base URL From environment configuration / env selection at run time / read from .properties files of resource directory


		// Setup base path for an API
		requestBuilder.setRequestBasePath("/Pune");
		// Setup base path for an API


		// Perform HTTP GET
		RestValidator restValidator = restExecutor.get(requestBuilder, authenticationUtil);
		// Perform HTTP GET

		/*
		REQUEST VALIDATION MECHANISM
		*/

		// get http response
		RestResponse  restResponse = restValidator.getResponse();
		// get http response


		// verify http response code
		restValidator.expectCode(200);
		// verify http response code


		// validate the JSON response using Key / value pair
		restValidator.expectInJSONResponse("Pune","City");
		// validate the JSON response using Key / value pair


		// get http headers map
		restValidator.getHeaders();
		// get http headers map


		// verify Single https header
		restValidator.expectHeader("Server","nginx/1.14.");
		// verify Single https header

		// verify multiple headers
		HashMap <String, String> headers = new HashMap<>();
		headers.put("Server","nginx/1.14.1");
		headers.put("Cache-Control","max-age=2592000");
		headers.put("Connection","keep-alive");
		headers.put("Content-Type","application/json");
		restValidator.expectHeaders(headers);
		// verify multiple headers

		restValidator.expectInBody("Pune");

		System.out.println(restValidator.getResponse().getResponseBody().toString());

	}

}
