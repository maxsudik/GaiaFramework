package web.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import core.logger.TestLog;
import common.objects.CompanyObject;
import common.objects.UserObject;

public class CreateCompany extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.customerPanel.getDriver());
	}
	
	@Test
	public void createCompany() {
		
		UserObject user = UserObject.user().withAdminLogin();
		
		CompanyObject company = CompanyObject.company().withDefaultCompany();
		
		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I create a new company");
		app.customerPanel.company.addCompany(company);	
	}
}