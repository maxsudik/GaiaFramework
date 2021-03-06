package rest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import common.objects.CompanyObject;
import common.objects.UserObject;
import core.logger.TestLog;

public class verifyCompaniesTest extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}

	@Test
	public void verifyCreateCompany() {

		TestLog.When("I login with admin user");
		UserObject user = UserObject.user().withAdminLogin();
		app.rest.login.login(user);

		CompanyObject company = CompanyObject.company().withDefaultCompany();
		TestLog.And("I create company '" + company.name().get() + "'");
		app.rest.company.createCompany(company);

		TestLog.Then("I delete the company '" + company.name().get() + "'");
		app.rest.company.deleteCompany(company);
	}
}