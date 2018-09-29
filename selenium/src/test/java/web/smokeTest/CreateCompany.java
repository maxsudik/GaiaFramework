package test.java.web.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.logger.TestLog;
import main.java.main.customerPanel.objects.CompanyObject;
import main.java.main.customerPanel.objects.UserObject;
import test.java.TestBase;

public class CreateCompany extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.customerPanel.getDriver());
	}
	
	@Test
	public void createCompany() {
		
		UserObject user = new UserObject()
				.withEmail(UserObject.USER_ADMIN)
				.withPassword(UserObject.PASSWORD_ADMIN);
		
		CompanyObject company = new CompanyObject()
				.withName(CompanyObject.COMPANY_NAME)
				.withEmail(CompanyObject.COMPANY_EMAIL)
				.withTax(CompanyObject.COMPANY_TAX_NUMBER)
				.withType(CompanyObject.COMPANY_TYPE)
				.withCurrency(CompanyObject.COMPANY_CURRENCY)
				.withDescription(CompanyObject.COMPANY_DESCRIPTION);
		
		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I create a new company");
		app.customerPanel.company.addCompany(company);
		
	}

}
