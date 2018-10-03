package web.smokeTest;


import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import common.objects.UserObject;
import core.logger.TestLog;

public class CleanAfterTest extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}
	
	@Test
	public void cleanCompaniesAfterTest() throws JSONException {
		TestLog.When("I login with admin user");
		UserObject user = UserObject.user().withAdminLogin();

		app.rest.login.login(user);
		
		app.rest.company.deleteAllCompanies("zzz_");
	}
}
