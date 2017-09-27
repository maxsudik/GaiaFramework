package test.java.web.productionTests;


import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import core.helpers.Helper;
import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.customerPanel.categories.login;
import main.customerPanel.categories.user;
import main.customerPanel.constants.UserInfo;
import main.customerPanel.objects.UserObject;
import main.customerPanel.pages.CustomerPanel;
import test.java.TestBase;


@RunWith(ParallelRunner.class)
public class Verify_Login_Test extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
 		setupWebDriver(CustomerPanel.GetDriver().withUrl(CustomerPanel.GAIA_SITE));
	}

	@Category({ login.class, user.class })
	@Test
	public void validate_user_login_as_manager() {
		UserObject user = new UserObject().withEmail(UserInfo.USER_PRODUCTION_MANAGER).withPassword(UserInfo.PASSWORD_PRODUCTION_MANAGER);
		
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify company list is displayed");
		Helper.verifyElementIsDisplayed(app.customerPanel.company.byCompanyListSection());
	}

	
	@Category({ login.class, user.class })
	@Test
	public void validate_user_login_as_supervisor() { 
		UserObject user = new UserObject().withEmail(UserInfo.USER_PRODUCTION_SUPERVISOR).withPassword(UserInfo.PASSWORD_PRODUCTION_SUPERVISOR);
		
		TestLog.When("I login with supervisor user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I verify people list is displayed");
		Helper.verifyElementIsDisplayed(app.customerPanel.login.byLogout());
	}
}