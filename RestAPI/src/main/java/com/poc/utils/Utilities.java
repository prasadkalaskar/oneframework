

package com.poc.utils;

import java.io.*;
import java.util.Properties;

import com.poc.rest.validator.RestValidator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Utilities {

	public JSONObject getRequestPayload(String jsonfile){

		JSONObject jsonobject = null;

		try {

			JSONParser parser = new JSONParser();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			File file = new File(loader.getResource("jsontemplates" + "/" + jsonfile).getFile());

			Object parseObject = parser.parse(new FileReader(file));

			jsonobject = (JSONObject) parseObject;



		} catch (Exception e){
			e.getStackTrace();
		}

		return jsonobject;
	}


	public static JSONObject getResponseAsJson (RestValidator response){

		JSONObject jsonobject = null;

		try {


			JSONParser parser = new JSONParser();
			Object testobj = parser.parse(response.getResponse().getResponseBody());
			jsonobject = (JSONObject) testobj;


		} catch (Exception e){
			e.getStackTrace();
		}

		return jsonobject;
	}


	public static String extractJSONAttribute (JSONObject jsonObject, String key){
		return (jsonObject.get(key).toString());
	}


	public static String getTDFilePath(String filepath, String filename){

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		File resourcesDirectory = new File(loader.getResource(filepath + "/" + filename).getFile());
		return resourcesDirectory.getAbsolutePath();
	}

}
