package rest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import core.logger.TestLog;
import common.objects.CompanyObject;
import common.objects.UserObject;
import main.main_rest.objects.site.SiteObject;

public class verifySitesTest extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}

	@Test
	public void verifyCreateSite() {

		TestLog.When("I login with admin user");
		UserObject user = UserObject.user().withAdminLogin();
		user = app.rest.login.login(user);

		CompanyObject company = CompanyObject.company().withDefaultCompany();
		TestLog.And("I create company '" + company.name().get() + "'");
		company = app.rest.company.createCompany(user, company);

		SiteObject site = SiteObject.site().withDefaultSite();
		site = SiteObject.Builder.from(site).companyId(company.id().get()).buildPartial();
		TestLog.And("I create site '" + site.name().get() + "'");
		site = app.rest.site.createSite(user, site);

		TestLog.Then("I delete the site '" + site.name().get() + "'");
		app.rest.site.deleteSite(user, site);

		TestLog.Then("I delete the company '" + company.name().get() + "'");
		app.rest.company.deleteCompany(user, company);
	}
}