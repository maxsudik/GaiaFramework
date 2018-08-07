package test.java.web.productionTests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.customerPanel.Panels.CompanyPanel;
import main.customerPanel.Panels.LoginPanel;
import main.customerPanel.objects.UserObject;
import test.java.TestBase;


public class Verify_Login_Test extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.customerPanel.getDriver());
	}

	@Test
	public void validate_user_login_as_manager() {
		UserObject user = new UserObject().withEmail(UserObject.USER_PRODUCTION_MANAGER).withPassword(UserObject.PASSWORD_PRODUCTION_MANAGER);
		
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify company list is displayed");
		Helper.verifyElementIsDisplayed(CompanyPanel.elements.COMPANY_LIST_SECTION);
	}

	
	@Test
	public void validate_user_login_as_supervisor() { 
		UserObject user = new UserObject().withEmail(UserObject.USER_PRODUCTION_SUPERVISOR).withPassword(UserObject.PASSWORD_PRODUCTION_SUPERVISOR);
		
		TestLog.When("I login with supervisor user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify people list is displayed");
		Helper.verifyElementIsDisplayed(LoginPanel.elements.LOGOUT_BUTTON);
	}
}