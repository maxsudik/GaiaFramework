package test.java.web.sanityTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import core.helpers.Helper;
import core.helpers.UtilityHelper;
import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.customerPanel.categories.login;
import main.customerPanel.categories.user;
import main.customerPanel.constants.PanelList;
import main.customerPanel.constants.UserInfo;
import main.customerPanel.objects.SiteObject;
import main.customerPanel.objects.UserObject;
import main.customerPanel.pages.CustomerPanel;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class Verify_Site_Test extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
 		setupWebDriver(CustomerPanel.GetDriver().withUrl(CustomerPanel.GAIA_SITE));
	}

	/**
	 * When I login as admin Then I create a company And I create a site and add
	 * to that company Then I should successfully create a site
	 */
	@Category({ login.class, user.class })
	@Test
	public void validate_add_site() {
		UserObject user = new UserObject().withEmail(UserInfo.USER_AUTO_MANAGER).withPassword(UserInfo.PASSWORD_AUTO_MANAGER);
		
		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);

		// select site panel
		TestLog.When("I select site panel");
		app.customerPanel.panel.selectPanel(PanelList.SITE_PANEL);

		// add site
		String siteName = "zzz_site" + UtilityHelper.generateRandomString(3);
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
		Helper.verifyElementIsDisplayed(app.customerPanel.sites.bySiteAddSuccess());
	}
}