package test.java.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.main_rest.objects.CompanyObject;
import main.main_rest.objects.UserObject;
import main.main_rest.objects.site.SiteObject;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class verifySitesTest extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}
	
	@Test
	public void verifyCreateSite() {
		
		TestLog.When("I login with admin user");
		UserObject user = new UserObject().withAdminLogin();
		user = app.rest.login.login(user);
		
		CompanyObject company = new CompanyObject().withDefaultCompany();
		TestLog.And("I create company '"  + company.name + "'");
		company = app.rest.company.createCompany(user, company);
		
		SiteObject site = new SiteObject().withDefaultSite();
		site.setCompanyId(company.id);
		TestLog.And("I create site '"  + site.name + "'");
		site = app.rest.site.createSite(user, site);
		
		TestLog.Then("I delete the site '" + site.name + "'");
		app.rest.site.deleteSite(user, site);	
		
		TestLog.Then("I delete the company '" + company.name + "'");
		app.rest.company.deleteCompany(user, company);	
	}
}