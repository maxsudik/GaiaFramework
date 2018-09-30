package test.java.web.productionTests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.java.common.objects.UserObject;
import main.java.main.customerPanel.Panels.CompanyPanel;
import main.java.main.customerPanel.Panels.LoginPanel;
import test.java.TestBase;


public class Verify_Login_Test extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.customerPanel.getDriver());
	}

	@Test
	public void validate_user_login_as_manager() {
		UserObject user = UserObject.user().withProductionManagerUser();
		
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify company list is displayed");
		Helper.verifyElementIsDisplayed(CompanyPanel.elements.COMPANY_LIST_SECTION);
	}

	
	@Test
	public void validate_user_login_as_supervisor() { 
		UserObject user = UserObject.user().withProductionSupervisorUser();
		
		TestLog.When("I login with supervisor user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify people list is displayed");
		Helper.verifyElementIsDisplayed(LoginPanel.elements.LOGOUT_BUTTON);
	}
}