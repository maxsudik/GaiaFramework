package test.java.ios.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.logger.TestLog;
import main.main_ios.Panels.MainPanel;
import main.main_ios.objects.InstallsObject;
import test.java.TestBase;

public class ManagerPaysEstimate extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}
	
	@Test
	public void verifyPayingEstimate() {
		
		TestLog.When("I login with created user");
		app.gaia.login.loginManager();
		
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.INSTALLS);
		
		InstallsObject installs = new InstallsObject()
				.withPaymentAmount(InstallsObject.PAYMENT_AMOUNT);
		
		app.gaia.installs.payEstimate(installs);
	}

}
