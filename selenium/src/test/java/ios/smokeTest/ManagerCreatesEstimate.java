package ios.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import core.logger.TestLog;
import main.main_ios.Panels.MainPanel;
import main.main_ios.objects.InstallsObject;

public class ManagerCreatesEstimate extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}
	
	@Test
	public void verifyCreatingProduct() {
		
		TestLog.When("I login with created user");
		app.gaia.login.loginManager();
		
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.INSTALLS);
		
		InstallsObject installs = new InstallsObject()
				.withEstimateTitle(InstallsObject.DEFAULT_TITLE_NAME)
				.withEstimateDescription(InstallsObject.DEFAULT_DESCRIPTION)
				.withStartDay(InstallsObject.SATRT_DAY)
				.withStartHours(InstallsObject.SATRT_HOURS)
				.withStartMinutes(InstallsObject.SATRT_MINUTES)
				.withStartNoon(InstallsObject.SATRT_NOON)
				.withEndDay(InstallsObject.END_DAY)
				.withEndHours(InstallsObject.END_HOURS)
				.withEndMinutes(InstallsObject.END_MINUTES)
				.withEndNoon(InstallsObject.END_NOON);

		
		TestLog.Then("I create an estimate");
		app.gaia.installs.addEstimate(installs);
		
	}

}
