package test.java.ios.sanityTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import core.helpers.UtilityHelper;
import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.main_ios.Panels.MainPanel;
import main.main_ios.categories.customer;
import main.main_ios.constants.CustomerInfo;
import main.main_ios.constants.SiteInfo;
import main.main_ios.constants.UserInfo_Ios;
import main.main_ios.objects.CustomerObject;
import main.main_ios.objects.UserObject_Ios;
import main.main_ios.pages.GaiaIos;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class VerifyCustomerPanelTest extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
		setupWebDriver(GaiaIos.GetDriver());
	}

	@Category({ customer.class })
	@Test
	public void verifyAddSite() {
		UserObject_Ios user = new UserObject_Ios()
				.withUsername(UserInfo_Ios.MANAGER_USERNAME)
				.withPassword(UserInfo_Ios.MANAGER_PASSWORD);
		
		TestLog.When("I login with manager user");
		app.gaia.login.login(user);
		
		TestLog.Then("I navigate to customer panel");
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.CUSTOMERS);
		
		TestLog.Then("I add a customer");
		String userName = CustomerInfo.DEFAULT_USER_NAME + UtilityHelper.generateRandomString(3);
		String email = CustomerInfo.DEFAULT_EMAIL + UtilityHelper.generateRandomString(3) + "@test.com";
		CustomerObject customer = new CustomerObject()
				.withUserName(userName)
				.withEmail(email)
				.withPassword(SiteInfo.DEFAULT_POSTAL_CODE)
				.withFirstName(SiteInfo.DEFAULT_STATE)
				.withLastName(SiteInfo.DEFAULT_CITY)
				.withPhoneNumber(SiteInfo.DEFAULT_PHONE_NUMBER);
		app.gaia.customer.addCustomer(customer);
		
		TestLog.Then("I verify the customer has been added");
	}
}