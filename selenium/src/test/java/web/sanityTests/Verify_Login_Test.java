package web.sanityTests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import core.helpers.Helper;
import core.logger.TestLog;
import common.objects.UserObject;
import main.customerPanel.Panels.CompanyPanel;
import main.customerPanel.Panels.LoginPanel;
import main.customerPanel.Panels.PanelNavigation;


public class Verify_Login_Test extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.customerPanel.getDriver());
	}
	
	@Test
	public void validate_user_logout() {
		UserObject user = UserObject.user().withManagerUser();

		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify company dashboard is displayed");
		Helper.verifyElementIsDisplayed(CompanyPanel.elements.COMPANY_LIST_SECTION);
		
		TestLog.When("I logout");
		app.customerPanel.login.logout();
		
		TestLog.Then("I should see the login panel");
		Helper.verifyElementIsDisplayed(LoginPanel.elements.LOGIN_SUBMIT);	
	}

	@Test
	public void validate_user_login() {
		UserObject user = UserObject.user().withAdminLogin();
		
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify company list is displayed");
		Helper.verifyElementIsDisplayed(CompanyPanel.elements.COMPANY_LIST_SECTION);
		

		TestLog.When("I logout");
		app.customerPanel.login.logout();
		
		TestLog.Then("I should see the login panel");
		Helper.verifyElementIsDisplayed(LoginPanel.elements.LOGIN_SUBMIT);	
	}
	
	@Test
	public void validate_user_login_as_manager() {
		UserObject user = UserObject.user().withManagerUser();
		
		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify people list is displayed");
		Helper.verifyElementIsDisplayed(PanelNavigation.elements.REPORT_TAB);
	}
	
	@Test
	public void validate_user_login_as_supervisor() { 
		UserObject user = UserObject.user().withSupervisorUser();
		
		TestLog.When("I login with supervisor user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify people list is displayed");
		Helper.verifyElementIsDisplayed(PanelNavigation.elements.PLANT_TAB);
	}
}