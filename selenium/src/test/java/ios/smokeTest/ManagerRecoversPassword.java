package test.java.ios.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.logger.TestLog;
import main.java.main.main_ios.objects.UserObject_Ios;
import test.java.TestBase;

public class ManagerRecoversPassword extends TestBase {
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}
	
	@Test
	public void verifyRecoveryPassword() {
		
		UserObject_Ios user = new UserObject_Ios().withEmail(UserObject_Ios.MANAGER_EMAIL);
		
		TestLog.When("I recover password");
		app.gaia.login.recoverPassword(user);
		
	}

}
