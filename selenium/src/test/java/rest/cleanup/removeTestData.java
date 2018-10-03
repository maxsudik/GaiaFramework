package rest.cleanup;


import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.TestBase;
import common.objects.UserObject;
import core.logger.TestLog;

public class removeTestData extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}
	
	@Test
	public void deleteAllTestCompanies() throws JSONException {
		
		TestLog.When("I login with admin user");
		UserObject user = UserObject.user().withAdminLogin();

		app.rest.login.login(user);
		
		app.rest.company.deleteAllCompanies("zzz_");

	}
	
	@Ignore // 
	@Test
	public void deleteAllTestSites() throws JSONException {
		
		TestLog.When("I login with admin user");
		UserObject user = UserObject.user().withAdminLogin();
		app.rest.login.login(user);
		
		app.rest.site.deleteAllSites("zzz_");
	}
	@Ignore 
	@Test
	public void deleteAllTestPeople() {
		
		TestLog.When("I login with admin user");
		UserObject user = UserObject.user().withAdminLogin();
		app.rest.login.login(user);
		
		app.rest.people.deleteAllPeople("zzz_");
	}
}