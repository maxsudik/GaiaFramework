package test.java.rest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.logger.TestLog;
import main.main_rest.objects.CompanyObject;
import main.main_rest.objects.UserObject;
import test.java.TestBase;

public class verifyCompaniesTest extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}
	
	@Test
	public void verifyCreateCompany1() {
		
		TestLog.When("I login with admin user");
		UserObject user = new UserObject().withAdminLogin();
		user = app.rest.login.login(user);
		
		CompanyObject company = new CompanyObject().withDefaultCompany();
		TestLog.And("I create company '"  + company.name + "'");
		company = app.rest.company.createCompany(user, company);
		
		TestLog.Then("I delete the company '" + company.name + "'");
		app.rest.company.deleteCompany(user, company);	
	}
}