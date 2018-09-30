package rest.cleanup;


import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import core.logger.TestLog;
import common.objects.UserObject;

public class removeTestData extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}
	
	@Test
	public void deleteAllTestCompanies() throws JSONException {
		
		TestLog.When("I login with admin user");
		UserObject user = UserObject.user().withAdminLogin();

		user = app.rest.login.login(user);
		
		app.rest.company.deleteAllCompanies(user, "zzz_");
	}
	
	@Test
	public void deleteAllTestSites() throws JSONException {
		
		TestLog.When("I login with admin user");
		UserObject user = UserObject.user().withAdminLogin();
		user = app.rest.login.login(user);
		
		app.rest.site.deleteAllSites(user, "zzz_");
	}
	
	@Test
	public void deleteAllTestPeople() {
		
		TestLog.When("I login with admin user");
		UserObject user = UserObject.user().withAdminLogin();
		user = app.rest.login.login(user);
		
		app.rest.people.deleteAllPeople(user, "zzz_");
	}
}