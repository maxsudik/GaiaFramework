package main.main_api;



import core.api.apiRunner;
import core.api.Objects.ApiObject;
import core.driver.AbstractDriverTestNG;
import main.main_api.interfaces.testInferface;

public class apiManager {

	
	private static final String TEST_INTERFACE = "RESTfulAPI";


	public static void TestRunner(String TestSuite, String TestCaseID, String RunFlag, String Description,
			String InterfaceType, String UriPath, String ContentType, String Method, String Option,
			String RequestHeaders, String TemplateFile, String RequestBody, String OutputParams, String RespCodeExp,
			String ExpectedResponse, String PartialExpectedResponse, String NotExpectedResponse, String TcComments,
			String tcName, String tcIndex) throws Exception {

		// add parameters to ApiObject
		ApiObject apiObject = new ApiObject().setApiObject(TestSuite, TestCaseID, RunFlag, Description, InterfaceType, UriPath, ContentType, Method, Option, RequestHeaders, TemplateFile, RequestBody, OutputParams, RespCodeExp, ExpectedResponse, PartialExpectedResponse, NotExpectedResponse, TcComments, tcName, tcIndex);;
     
		// setup api driver
		AbstractDriverTestNG.setupApiDriver(apiObject);
				
		 switch (InterfaceType) {
         case  TEST_INTERFACE: 
        	  testInferface.RestfullApiInterface(apiObject);
              break;
         default:
        	 apiRunner.TestRunner(apiObject);
        	 break;
		 }	
	}	
}