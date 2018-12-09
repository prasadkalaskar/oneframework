
package com.poc.utils;

import java.io.IOException;

public class EnvConfig {

	public static String hostBaseURL;
	public static String authType;

	public static String getURLConfiguration(String sEnv, String key) {

		String url="";

		try {
			return Utilities.getTestDataConfig(sEnv, key);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return  url;
	}


}
