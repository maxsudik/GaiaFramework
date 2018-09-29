package test.java.ios.sanityTests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.java.main.main_ios.Panels.MainPanel;
import main.java.main.main_ios.objects.UserObject_Ios;
import test.java.TestBase;

public class LoginTest extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}

	@Test
	public void verifyManagerLoginTest() {
		UserObject_Ios user = new UserObject_Ios().withUsername(UserObject_Ios.MANAGER_USERNAME).withPassword(UserObject_Ios.MANAGER_PASSWORD);
		
		TestLog.When("I login with manager user");
		app.gaia.login.login(user);
		
		TestLog.Then("I verify the user has logged in");
		Helper.verifyElementIsDisplayed(MainPanel.elements.INSTALLS_PANEL);
	}
	
	@Test
	public void verifySupervisorLoginTest() {
		UserObject_Ios user = new UserObject_Ios().withUsername(UserObject_Ios.SUPERVISOR_USERNAME).withPassword(UserObject_Ios.SUPERVISOR_PASSWORD);
		
		TestLog.When("I login with default user");
		app.gaia.login.login(user);
		
		TestLog.Then("I verify the user has logged in");
		Helper.verifyElementIsDisplayed(MainPanel.elements.GAIA_LOGO);
	}
}