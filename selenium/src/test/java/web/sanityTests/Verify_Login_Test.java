package test.java.web.sanityTests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.java.main.customerPanel.Panels.CompanyPanel;
import main.java.main.customerPanel.Panels.LoginPanel;
import main.java.main.customerPanel.Panels.PanelNavigation;
import main.java.main.customerPanel.objects.UserObject;
import test.java.TestBase;


public class Verify_Login_Test extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.customerPanel.getDriver());
	}
	
	@Test
	public void validate_user_logout() {
		UserObject user = new UserObject().withEmail(UserObject.USER_AUTO_MANAGER).withPassword(UserObject.PASSWORD_AUTO_MANAGER);
		
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
		UserObject user = new UserObject().withEmail(UserObject.USER_ADMIN).withPassword(UserObject.PASSWORD_ADMIN);
		
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify company list is displayed");
		Helper.verifyElementIsDisplayed(CompanyPanel.elements.COMPANY_LIST_SECTION);
	}
	
	@Test
	public void validate_user_login_as_manager() {
		UserObject user = new UserObject().withEmail(UserObject.USER_AUTO_MANAGER).withPassword(UserObject.PASSWORD_AUTO_MANAGER);
		
		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify people list is displayed");
		Helper.verifyElementIsDisplayed(PanelNavigation.elements.REPORT_TAB);
	}
	
	@Test
	public void validate_user_login_as_supervisor() { 
		UserObject user = new UserObject().withEmail(UserObject.USER_AUTO_SUPERVISOR).withPassword(UserObject.PASSWORD_AUTO_SUPERVISOR);
		
		TestLog.When("I login with supervisor user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify people list is displayed");
		Helper.verifyElementIsDisplayed(PanelNavigation.elements.PLANT_TAB);
	}
}