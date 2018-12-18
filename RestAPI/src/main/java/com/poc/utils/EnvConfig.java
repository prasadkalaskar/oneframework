
package com.poc.utils;

import java.io.IOException;

public class EnvConfig {

	public static String hostBaseURL;
	public static String authType;
	public static String environment;

	public EnvConfig(){
		environment = getEnvironment();
	}

	public static String getEnvironment() {

		String varValue = System.getenv("env");

		if (varValue == null ){
			varValue = "dev";
		}
		return varValue;
	}



}
