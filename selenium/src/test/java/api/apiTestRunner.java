package api;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import common.objects.UserObject;
import core.api.apiRunner;
import core.api.dataProvider;
import core.logger.TestLog;


public class apiTestRunner extends TestBase  {

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		setupApiDriver();
		
		TestLog.When("I login with admin user");
		UserObject user = UserObject.user().withAdminLogin();
		app.rest.login.login(user);
		
		TestLog.And("I delete all companies with prefix zzz_");
		app.rest.company.deleteAllCompanies("zzz_");
		
		TestLog.And("I delete all people with prefix zzz_");
		app.rest.people.deleteAllPeople("zzz_");
		
		TestLog.And("I delete all sites with prefix zzz_");
		app.rest.site.deleteAllSites("zzz_");
		
		TestLog.When("I start test");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() throws Exception {
		setupApiDriver();
		
		TestLog.When("I login with admin user");
		UserObject user = UserObject.user().withAdminLogin();
		app.rest.login.login(user);
		
		TestLog.And("I delete all companies with prefix zzz_");
		app.rest.company.deleteAllCompanies("zzz_");
		
		TestLog.And("I delete all people with prefix zzz_");
		app.rest.people.deleteAllPeople("zzz_");
		
		TestLog.And("I delete all sites with prefix zzz_");
		app.rest.site.deleteAllSites("zzz_");
	
		TestLog.When("I end test");
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