package com.poc.utils;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class RequestBuilder {
	
	private String apiPath;
	private RequestSpecBuilder builder;
	private RequestSpecification spec;
	private String url;
	
	public RequestBuilder() {
		builder = new RequestSpecBuilder();
	}
	
	public RequestSpecification getRequestSpecification(){
		return spec;
	}
	
	public void buildRequestSpecification(){
        spec = builder.build();
	}
	
	public void addRequestHeader(String name,String value){
		builder.addHeader(name,value);
	}
	
	public void addRequestHeaders(Map<String,String> headers){
		builder.addHeaders(headers);
	}
	
	public void setRequestBasePath(String apiPath){
		this.apiPath = apiPath;
	}
	
	public String getRequestBasePath(){
		return apiPath;
	}


	public void setURL(String url){
		this.url = url.trim();
	}

	public String getURL(){
		return url;
	}
}
