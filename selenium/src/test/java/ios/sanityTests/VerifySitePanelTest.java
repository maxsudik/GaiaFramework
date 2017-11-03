package test.java.ios.sanityTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import core.helpers.Helper;
import core.helpers.UtilityHelper;
import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.main_ios.Panels.MainPanel;
import main.main_ios.Panels.SitesPanel;
import main.main_ios.categories.site;
import main.main_ios.constants.SiteInfo;
import main.main_ios.objects.SiteObject;
import main.main_ios.pages.GaiaIos;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class VerifySitePanelTest extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
		setupWebDriver(GaiaIos.GetDriver());
	}

	@Category({ site.class })
	@Test
	public void verifyAddSite() {
		
		TestLog.When("I login with manager user");
		app.gaia.login.loginManager();
		
		TestLog.Then("I navigate to sites panel");
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.SITES);
		
		TestLog.Then("I add a site");
		String sitename = SiteInfo.DEFAULT_CITY + UtilityHelper.generateRandomString(3);
		SiteObject site = new SiteObject()
				.withSiteName(sitename)
				.withStreetName(SiteInfo.DEFAULT_STREET)
				.withPostalCode(SiteInfo.DEFAULT_POSTAL_CODE)
				.withState(SiteInfo.DEFAULT_STATE)
				.withCity(SiteInfo.DEFAULT_CITY)
				.withCountry(SiteInfo.DEFAULT_COUTRY);
		app.gaia.sites.addSite(site);
		
		TestLog.Then("I search for customer");
		app.gaia.sites.searchSite(site);
		
		TestLog.Then("I verify the site has been added");
		Helper.verifyElementIsDisplayed(SitesPanel.bySite(site.sitename));
	}
}