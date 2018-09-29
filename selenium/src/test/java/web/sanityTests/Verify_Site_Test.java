package test.java.web.sanityTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.java.main.customerPanel.Panels.PanelNavigation;
import main.java.main.customerPanel.Panels.SitesPanel;
import main.java.main.customerPanel.objects.SiteObject;
import main.java.main.customerPanel.objects.UserObject;
import test.java.TestBase;

public class Verify_Site_Test extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.customerPanel.getDriver());
	}

	/**
	 * When I login as admin Then I create a company And I create a site and add
	 * to that company Then I should successfully create a site
	 */
	@Test
	public void validate_add_site() {
		UserObject user = new UserObject().withEmail(UserObject.USER_AUTO_MANAGER).withPassword(UserObject.PASSWORD_AUTO_MANAGER);
		
		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);

		// select site panel
		TestLog.When("I select site panel");
		app.customerPanel.navigate.selectPanel(PanelNavigation.SITE_PANEL);

		// add site
		String siteName = "zzz_site" + Helper.generateRandomString(3);
		SiteObject site = new SiteObject()
				.withName(siteName)
				.withRadius("33")
				.withAddress("3067 east kent avenue north")
				.withCity("vancouver")
				.withCountry("canada")
				.withPostalCode("v5s4p6")
				.withstate("BC");

		TestLog.And("I add site " + siteName);
		app.customerPanel.sites.addSite(site);
		
		TestLog.Then("Site " + siteName + " should be added successfully");
		Helper.verifyElementIsDisplayed(SitesPanel.elements.SITE_ADD_SUCCESS);
	}
}