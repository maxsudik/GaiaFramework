package test.java.ios.acceptanceTests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.main_ios.Panels.CustomersPanel;
import main.main_ios.Panels.MainPanel;
import main.main_ios.objects.CustomerObject;
import test.java.TestBase;

public class VerifyCustomerPanelTest extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}

	@Test
	public void verifyCustomerSite() {
		
		TestLog.When("I login with manager user");
		app.gaia.login.loginManager();
		
		TestLog.Then("I navigate to customer panel");
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.CUSTOMERS);
		
		TestLog.Then("I add a customer");
		String userName = CustomerObject.DEFAULT_CUSTOMER_USERNAME + Helper.generateRandomString(3);
		String firstName = CustomerObject.DEFAULT_CUSTOMER_FIRST_NAME + Helper.generateRandomString(3);
		String email = CustomerObject.DEFAULT_CUSTOMER_EMAIL + Helper.generateRandomString(3) + "@test.com";
		CustomerObject customer = new CustomerObject()
				.withUserName(userName)
				.withEmail(email)
				.withPassword(CustomerObject.DEFAULT_CUSTOMER_PASSWORD)
				.withFirstName(firstName)
				.withLastName(CustomerObject.DEFAULT_CUSTOMER_LAST_NAME)
				.withPhoneNumber(CustomerObject.DEFAULT_CUSTOMER_PHONE_NUMBER);
		app.gaia.customer.addCustomer(customer);
		
		TestLog.Then("I verify the customer has been added");
		Helper.verifyElementIsDisplayed(CustomersPanel.elements.byCustomerUser(customer.fullName));
		
		app.gaia.customer.searchCustomer(customer);
		
		
	}
}