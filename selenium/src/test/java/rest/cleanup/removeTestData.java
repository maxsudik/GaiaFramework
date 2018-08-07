package test.java.rest.cleanup;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.logger.TestLog;
import main.main_rest.objects.UserObject;
import test.java.TestBase;

public class removeTestData extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}
	
	@Test
	public void deleteAllTestCompanies() {
		
		TestLog.When("I login with admin user");
		UserObject user = new UserObject().withAdminLogin();
		user = app.rest.login.login(user);
		
		app.rest.company.deleteAllCompanies(user, "zzz_");
	}
	
	@Test
	public void deleteAllTestSites() {
		
		TestLog.When("I login with admin user");
		UserObject user = new UserObject().withAdminLogin();
		user = app.rest.login.login(user);
		
		app.rest.site.deleteAllSites(user, "zzz_");
	}
	
	@Test
	public void deleteAllTestPeople() {
		
		TestLog.When("I login with admin user");
		UserObject user = new UserObject().withAdminLogin();
		user = app.rest.login.login(user);
		
		app.rest.people.deleteAllPeople(user, "zzz_");
	}
}