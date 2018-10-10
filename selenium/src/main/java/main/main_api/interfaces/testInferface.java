package main.main_api.interfaces;


import static io.restassured.RestAssured.given;

import core.api.Helpers.dataHelper;
import core.api.Helpers.jsonHelper;
import core.api.Objects.ApiObject;
import core.configReader.Config;
import core.helpers.Helper;
import core.logger.TestLog;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class testInferface {

	/*
	 * (String TestSuite, String TestCaseID, String RunFlag, String Description,
			String InterfaceType, String UriPath, String ContentType, String Method, String Option,
			String RequestHeaders, String TemplateFile, String RequestBody, String OutputParams, String RespCodeExp,
			String ExpectedResponse, String PartialExpectedResponse, String NotExpectedResponse, String TcComments,
			String tcName, String tcIndex) 
	 */
	
	/**
	 * interface for restfull api calls
	 * @param apiObject
	 * @return 
	 */
	public static Response RestfullApiInterface(ApiObject apiObject) {
		// replace parameters for request body
		apiObject.RequestBody = dataHelper.replaceParameters(apiObject.RequestBody);
		
		// set base uri
		setURI(apiObject);
		
		// send request and receive a response
		Response response = evaluateRequest(apiObject);
		
		// validate the response
		validateResponse(response, apiObject);
		
		return response;	
	}
	

	
	/**
	 * sets base uri for api call
	 */
	public static void setURI(ApiObject apiObject) {
		RestAssured.baseURI = Config.getValue("UriPath");
		TestLog.logPass("baseURI: " +  RestAssured.baseURI);
		
		// replace place holder values for uri
		apiObject.UriPath = dataHelper.replaceParameters(apiObject.UriPath);
		TestLog.logPass("request URI: " + RestAssured.baseURI + apiObject.UriPath);
	}
	
	
	public static void validateResponse(Response response, ApiObject apiObject) {
		
		// fail test if no response is returned
		if(response == null) Helper.assertTrue("no response returned", false);
		
		// validate status code
		if(!apiObject.RespCodeExp.isEmpty()) {
			TestLog.logPass("expected status code: " + apiObject.RespCodeExp + " response status code: " + response.getStatusCode());
			response.then().statusCode(Integer.valueOf(apiObject.RespCodeExp));
		}
		
		// saves response values to config object
		jsonHelper.saveOutboundJsonParameters(response, apiObject.OutputParams);
		
		validateExpectedValues(response, apiObject);	
	}
	
	public static void validateExpectedValues(Response response, ApiObject apiObject) {
		// get response body as string
		String body = response.getBody().asString();
		TestLog.logPass("response: " + body);

		
		// validate response body against expected json string
		if(!apiObject.PartialExpectedResponse.isEmpty()) {
			apiObject.PartialExpectedResponse = dataHelper.replaceParameters(apiObject.PartialExpectedResponse);
	       
			// separate the expected response by &&
			String[] criteria = apiObject.PartialExpectedResponse.split("&&");
            for(String criterion:criteria) {
            	jsonHelper.validateByJsonBody(criterion, response);
            	jsonHelper.validateByKeywords(criterion, response);
            }		
		}	
	}
	

	
	/**
	 * sets the header, content type and body based on specifications
	 * @param apiObject
	 * @return
	 */
	public static RequestSpecification evaluateOption(ApiObject apiObject) {
		// set request
		RequestSpecification request = null;
		
		// if no option specified
		if(apiObject.Option.isEmpty()) {
			return given().contentType(apiObject.ContentType).body(apiObject.RequestBody);
		}
		
		// replace parameters for request body
		apiObject.Option = dataHelper.replaceParameters(apiObject.Option);
		
		// if token is set
		if(apiObject.Option.contains("token:")) {
			String token = apiObject.Option.replace("token:", "");
			request = given().header("Authorization", token);
		}
		
		// if additional options
		switch (apiObject.Option) {
		case "INVALID_TOKEN":
			request = given().header("Authorization", "invalid");
			break;
		case "NO_TOKEN":
			request = given().header("Authorization", "");
			break;
		default:
			break;
		}
		request = request.contentType(apiObject.ContentType).body(apiObject.RequestBody);

		return request;
	}
	
	public static Response evaluateRequest(ApiObject apiObject) {
		Response response = null;
		// set request
		
		RequestSpecification request = evaluateOption(apiObject);

		TestLog.logPass("request body: " +  Helper.stringRemoveLines(apiObject.RequestBody));
		TestLog.logPass("request type: " +  apiObject.Method);

		switch (apiObject.Method) {
		case "POST":
			response = request.when().post(apiObject.UriPath);
			break;
		case "PUT":
			response = request.when().put(apiObject.UriPath);
			break;
		case "PATCH":
			response = request.when().patch(apiObject.UriPath);
			break;
		case "DELETE":
			response = request.when().delete(apiObject.UriPath);
			break;
		case "GET":
			response = request.when().get(apiObject.UriPath);
			break;
		case "OPTIONS":
			response = request.when().options(apiObject.UriPath);
			break;
		case "HEAD":
			response = request.when().head(apiObject.UriPath);
			break;
		default:
			Helper.assertTrue("request type not found", false);
			break;
		}
		TestLog.logPass("response: " + response.getBody().asString());

		return response.then().contentType(apiObject.ContentType).extract().response();
	}
}
