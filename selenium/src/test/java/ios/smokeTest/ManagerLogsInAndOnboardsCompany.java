package test.java.ios.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.logger.TestLog;
import main.main_ios.objects.UserObject_Ios;
import test.java.TestBase;

public class ManagerLogsInAndOnboardsCompany extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}
	
	@Test
	public void verifyManagerLogsInAndOnboardsCompany( ) {
		
	 UserObject_Ios user = new UserObject_Ios();
	 
	 TestLog.When("I login with created user");

	}

}
