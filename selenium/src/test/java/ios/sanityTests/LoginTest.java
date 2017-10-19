package test.java.ios.sanityTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import core.helpers.Helper;
import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.main_ios.Panels.MainPanel;
import main.main_ios.categories.login;
import main.main_ios.categories.user;
import main.main_ios.constants.UserInfo_Ios;
import main.main_ios.objects.UserObject_Ios;
import main.main_ios.pages.GaiaIos;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class LoginTest extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
		setupWebDriver(GaiaIos.GetDriver());
	}

	@Category({ login.class, user.class })
	@Test
	public void verifyLoginTest() {
		UserObject_Ios user = new UserObject_Ios().withUsername(UserInfo_Ios.MANAGER_USERNAME).withPassword(UserInfo_Ios.MANAGER_PASSWORD);
		
		TestLog.When("I login with default user");
		app.gaia.login.login(user);
		
		TestLog.Then("I verify the user has logged in");
		Helper.verifyElementIsDisplayed(MainPanel.byInstallsPanel());
	}
}