package test.java.api;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.api.apiRunner;
import core.api.dataProvider;
import test.java.TestBase;

public class apiTestRunner extends TestBase  {

	@BeforeClass(alwaysRun = true)
	public void beforeMethod() throws Exception {
	}
	
	@Test(dataProvider = "parallelRun", dataProviderClass = dataProvider.class, threadPoolSize = 1, invocationCount = 1)
	public void parallelApiRunner(String TestSuite, String TestCaseID, String RunFlag, String Description,
			String InterfaceType, String UriPath, String ContentType, String Method, String Option,
			String RequestHeaders, String TemplateFile, String RequestBody, String OutputParams, String RespCodeExp,
			String ExpectedResponse, String PartialExpectedResponse, String NotExpectedResponse, String TcComments,
			String tcName, String tcIndex) throws Exception {

		apiRunner.TestRunner(TestSuite, TestCaseID, RunFlag, Description,
			InterfaceType, UriPath, ContentType,  Method,  Option,
			 RequestHeaders,  TemplateFile,  RequestBody,  OutputParams,  RespCodeExp,
			 ExpectedResponse,  PartialExpectedResponse,  NotExpectedResponse,  TcComments,
			 tcName, tcIndex);
	}
}