package ios.smokeTest;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import core.logger.TestLog;
import main.main_ios.Panels.MainPanel;
import main.main_ios.objects.CustomerObject;

public class ManagerCreatesCustomer extends TestBase {
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}

	@Test
	public void verifyCreatingCustomer() {
		
		TestLog.When("I login with created user");
		app.gaia.login.loginManager();
		
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.CUSTOMERS);
		
		CustomerObject customer = new CustomerObject()
				.withUserName(CustomerObject.DEFAULT_CUSTOMER_USERNAME)
				.withEmail(CustomerObject.DEFAULT_CUSTOMER_EMAIL)
				.withPassword(CustomerObject.DEFAULT_CUSTOMER_PASSWORD)
				.withConfirmPassword(CustomerObject.DEFAULT_CUSTOMER__CONFIRM_PASSWORD)
				.withFirstName(CustomerObject.DEFAULT_CUSTOMER_FIRST_NAME)
				.withLastName(CustomerObject.DEFAULT_CUSTOMER_LAST_NAME)
				.withPhoneNumber(CustomerObject.DEFAULT_CUSTOMER_PHONE_NUMBER);
		
		TestLog.Then("I create a customer");
		app.gaia.customer.addCustomer(customer);
	}

}
