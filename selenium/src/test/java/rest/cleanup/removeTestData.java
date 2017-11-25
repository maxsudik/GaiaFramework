package test.java.rest.cleanup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.main_rest.objects.UserObject;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class removeTestData extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}
	
	@Test
	public void deleteAllTestCompanies() {
		
		TestLog.When("I login with admin user");
		UserObject user = new UserObject().withAdminLogin();
		user = app.rest.login.login(user);
		
		app.rest.company.deleteAllCompanies(user, "zzz");
	}
	
	@Test
	public void deleteAllTestSites() {
		
		TestLog.When("I login with admin user");
		UserObject user = new UserObject().withAdminLogin();
		user = app.rest.login.login(user);
		
		app.rest.site.deleteAllSites(user, "zzz");
	}
	
	@Test
	public void deleteAllTestPeople() {
		
		TestLog.When("I login with admin user");
		UserObject user = new UserObject().withAdminLogin();
		user = app.rest.login.login(user);
		
		app.rest.people.deleteAllPeople(user, "zzz");
	}
}