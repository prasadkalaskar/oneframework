

package com.poc.utils;

import java.io.*;
import java.util.Properties;

import com.poc.rest.validator.RestValidator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Utilities {

	public static JSONObject getRequestPayload(String jsonfile){

		JSONObject jsonobject = null;

		try {

			JSONParser parser = new JSONParser();
			File file = new File(getTDFilePath("jsontemplates/", jsonfile));
			Object testobj = parser.parse(new FileReader(file));
			jsonobject = (JSONObject) testobj;
			//JSONObject testjson = new JSONObject(jsonobject.toString());


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

		File resourcesDirectory = new File("src/test/resources/" + filepath + filename);
		return resourcesDirectory.getAbsolutePath();
	}

	public static String getFrameworkConfigFilePath(){

		File resourcesDirectory = new File("src/test/resources/" + "ofw.properties");
		return resourcesDirectory.getAbsolutePath();
	}

	public static String getTestDataConfig(String sEnv, String sKey) throws IOException {

		Properties prop = new Properties();
		String sPropVal;

		File file = new File(Utilities.getTDFilePath("data/" + sEnv + "/",  "config.properties"));

		try{
			loadFromFile(prop, file);
			sPropVal = prop.getProperty(sKey);
		}
		catch(Exception e){
			sPropVal = "";
		}
		return sPropVal;
	}

	public static String getFrameworkConfig(String sKey)  {

		Properties prop = new Properties();
		String sPropVal;

		File file = new File(Utilities.getFrameworkConfigFilePath());

		try{
			loadFromFile(prop, file);
			sPropVal = prop.getProperty(sKey);
		}
		catch(Exception e){
			sPropVal = "";
		}
		return sPropVal;
	}

	private static void loadFromFile(Properties p, File file) throws IOException {
		if (p == null) {
			return;
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			p.load(fis);
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}
}
