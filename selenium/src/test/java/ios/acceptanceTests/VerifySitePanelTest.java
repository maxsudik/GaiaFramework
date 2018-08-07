package test.java.ios.acceptanceTests;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.main_ios.Panels.MainPanel;
import main.main_ios.Panels.SitesPanel;
import main.main_ios.objects.SiteObject;
import test.java.TestBase;

public class VerifySitePanelTest extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());

	}

	@Test
	public void verifyAddSite() {
		
		TestLog.When("I login with manager user");
		app.gaia.login.loginManager();
		
		TestLog.Then("I navigate to sites panel");
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.SITES);
		
		TestLog.Then("I add a site");
		String sitename = SiteObject.DEFAULT_CITY + Helper.generateRandomString(3);
		SiteObject site = new SiteObject()
				.withSiteName(sitename)
				.withStreetName(SiteObject.DEFAULT_STREET)
				.withPostalCode(SiteObject.DEFAULT_POSTAL_CODE)
				.withState(SiteObject.DEFAULT_STATE)
				.withCity(SiteObject.DEFAULT_CITY)
				.withCountry(SiteObject.DEFAULT_COUTRY);
		app.gaia.sites.addSite(site);
		
		TestLog.Then("I verify the site has been added");
		Helper.verifyElementIsDisplayed(SitesPanel.elements.bySite(site.sitename));
	}
}