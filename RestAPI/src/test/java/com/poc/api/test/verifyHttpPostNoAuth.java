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


public class verifyHttpPostNoAuth extends TestInitializer {

	/* Sample test case verify Http Post No Auth */

	@Test
	public void verifyPostService(){


		RequestBuilder requestBuilder = new RequestBuilder();
		JSONObject requestParams = new JSONObject();
		AuthenticationUtil authenticationUtil = new AuthenticationUtil();

		requestBuilder.setURL(EnvConfig.getURLConfiguration("dev", "T3_API_URL"));
		requestBuilder.setRequestBasePath("/register");
		requestParams = Utilities.getRequestPayload("topics.json");


		RestValidator restValidator = RestExecutor.post(requestBuilder,requestParams,authenticationUtil);

		System.out.println(restValidator.getResponse().getResponseBody());
		restValidator.expectCode(201);

	}
}
