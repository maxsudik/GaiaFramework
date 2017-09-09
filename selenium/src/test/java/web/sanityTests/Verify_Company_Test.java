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
import main.customerPanel.constants.UserInfo;
import main.customerPanel.objects.CompanyObject;
import main.customerPanel.objects.UserObject;
import main.customerPanel.pages.CustomerPanel;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class Verify_Company_Test extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
 		setupWebDriver(CustomerPanel.GetDriver().withUrl(CustomerPanel.GAIA_SITE));
	}

	@Category({ login.class, user.class })
	@Test
	public void validate_add_company() {
		UserObject user = new UserObject().withEmail(UserInfo.USER_ADMIN).withPassword(UserInfo.PASSWORD_ADMIN);
		
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);

		String companyName = "zzz_company" + UtilityHelper.generateRandomString(3);
		CompanyObject company = new CompanyObject().withNamel(companyName).withEmail("test@test.com")
				.withLicenseLimit("3");

		TestLog.Then("I add company " + companyName);
		app.customerPanel.company.addCompany(company);
		
		TestLog.Then("company " + companyName + " should be added successfully");
		Helper.verifyElementIsDisplayed(app.customerPanel.company.byCompanyAddSuccess());
	}
}