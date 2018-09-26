package test.java.ios.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.logger.TestLog;
import main.main_ios.Panels.MainPanel;
import main.main_ios.objects.SiteObject;
import test.java.TestBase;



public class ManagerCreatesSite extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}
	
	@Test
	public void verifyCreatingSite() {
		
		TestLog.When("I login with created user");
		app.gaia.login.loginManager();
		
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.SITES);
		
		SiteObject site = new SiteObject()
				.withSiteName(SiteObject.RANDOM_SITE)
				.withStreetName(SiteObject.DEFAULT_STREET)
				.withPostalCode(SiteObject.DEFAULT_POSTAL_CODE)
				.withState(SiteObject.DEFAULT_STATE)
				.withCity(SiteObject.DEFAULT_CITY)
				.withCountry(SiteObject.DEFAULT_COUTRY);
		
		TestLog.Then("I create a site");
		app.gaia.sites.addSite(site);
	}
}
