package ios.acceptanceTests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import core.helpers.Helper;
import core.logger.TestLog;
import main.main_ios.Panels.MainPanel;
import main.main_ios.objects.UserObject_Ios;

public class LoginTest extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}

	@Test
	public void verifyLoginTest() {
		UserObject_Ios user = new UserObject_Ios().withUsername(UserObject_Ios.MANAGER_USERNAME).withPassword(UserObject_Ios.MANAGER_PASSWORD);
		
		TestLog.When("I login with default user");
		app.gaia.login.login(user);
		
		TestLog.Then("I verify the user has logged in");
		Helper.verifyElementIsDisplayed(MainPanel.elements.INSTALLS_PANEL);
	}
}