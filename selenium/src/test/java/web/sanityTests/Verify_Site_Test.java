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
import main.customerPanel.objects.CompanyObject;
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
		UserObject user = new UserObject().withEmail(UserInfo.USER_ADMIN).withPassword(UserInfo.PASSWORD_ADMIN);
		
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);

		// add company
		String companyName = "zzz_company" + UtilityHelper.generateRandomString(3);
		CompanyObject company = new CompanyObject().withNamel(companyName).withEmail("test@test.com")
				.withLicenseLimit("3");

		TestLog.Then("I add company " + companyName);
		app.customerPanel.company.addCompany(company);

		// select site panel
		TestLog.When("I select site panel");
		app.customerPanel.panel.selectPanel(PanelList.SITE_PANEL);

		// add site
		String siteName = "zzz_site" + UtilityHelper.generateRandomString(3);
		SiteObject site = new SiteObject()
				.withName(siteName)
				.withRadius("33")
				.withCompany(company.name)
				.withAddress("knight street")
				.withCity("vancouver")
				.withCountry("canada")
				.withPostalCode("v5s4p3")
				.withstate("BC");

		TestLog.And("I add site " + siteName);
		app.customerPanel.sites.addSite(site);
		
		TestLog.Then("Site " + siteName + " should be added successfully");
		Helper.verifyElementIsDisplayed(app.customerPanel.sites.bySiteAddSuccess());
	}
}