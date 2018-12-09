package com.poc.rest.executor;

import com.poc.rest.validator.RestValidator;
import com.poc.utils.AuthenticationUtil;
import com.poc.utils.RequestBuilder;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class RestExecutor {
	
		

	public synchronized RestValidator get(RequestBuilder requestBuilder, AuthenticationUtil authenticationUtil){

		RestAssured.baseURI = requestBuilder.getURL();
		RequestSpecification requestSpecification = RestAssured.given();


		if (!(requestBuilder.getRequestBasePath() == null)) {
			requestSpecification.basePath(requestBuilder.getRequestBasePath());
		}


 		if (authenticationUtil.getIsAuth()){
			if(authenticationUtil.getAuthenticationType().equalsIgnoreCase("basic")){
				requestSpecification.auth().basic(authenticationUtil.getUserName(),authenticationUtil.getPassword());
			}
		}

		Response response = requestSpecification.request(Method.GET);
		int statusCode = response.getStatusCode();
		return (new RestValidator(parseResponse(response)));

	}

	public static synchronized RestValidator post(RequestBuilder requestBuilder, JSONObject jsonObject,AuthenticationUtil authenticationUtil){


		RestAssured.baseURI = requestBuilder.getURL();
		RequestSpecification request = RestAssured.given();



		if (authenticationUtil.getIsAuth()){
			if(authenticationUtil.getAuthenticationType().equalsIgnoreCase("basic")){
				request.auth().basic(authenticationUtil.getUserName(),authenticationUtil.getPassword());
			}
		}

		request.body(jsonObject.toJSONString());
		Response response = request.post("/register");

		return (new RestValidator(parseResponse(response)));

	}


	private static synchronized RestResponse parseResponse(Response response){

		RestResponse resResponse = new RestResponse();
		resResponse.setResponseBody(response.getBody().asString());
		resResponse.setResponseCode(response.getStatusCode());
		Headers headers = response.getHeaders();
		for (Header header : headers) {
			resResponse.setHeader(header.getName(), header.getValue());
		}
		
		return resResponse;
	}

}
