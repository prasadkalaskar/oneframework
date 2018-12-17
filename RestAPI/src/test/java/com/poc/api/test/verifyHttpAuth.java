package com.poc.api.test;

import com.poc.rest.executor.RestExecutor;
import com.poc.rest.executor.RestResponse;
import com.poc.rest.initializer.TestInitializer;
import com.poc.rest.validator.RestValidator;
import com.poc.utils.AuthenticationUtil;
import com.poc.utils.EnvConfig;
import com.poc.utils.RequestBuilder;
import com.poc.utils.Utilities;
import org.cts.hybrid.ConfigProvider.ConfigProvider;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;


public class verifyHttpAuth extends TestInitializer {

	/* Sample test case for verify Http Auth */

	@Test()
	public void verifyGetService() {

		/*HTTPS REQUEST CREATION MECHANISM*/

		RequestBuilder requestBuilder = new RequestBuilder();
		AuthenticationUtil authenticationUtil = new AuthenticationUtil();
		RestExecutor restExecutor = new RestExecutor();

		// setup base URL From environment configuration / env selection at run time / read from .properties files of resource directory
		//.getURLConfiguration("dev", "T2_API_URL"));
		requestBuilder.setURL(ConfigProvider.loadProperty(EnvConfig.environment,"config", "T2_API_URL"));
		// setup base URL From environment configuration / env selection at run time / read from .properties files of resource directory


		// Perform HTTP GET
		RestValidator restValidator = restExecutor.get(requestBuilder, authenticationUtil);
		// Perform HTTP GET

		/*
		REQUEST VALIDATION MECHANISM
		*/

		// verify http response code
		restValidator.expectCode(200);
		// verify http response code
		System.out.println(restValidator.getResponse().getResponseBody().toString());

	}

}
