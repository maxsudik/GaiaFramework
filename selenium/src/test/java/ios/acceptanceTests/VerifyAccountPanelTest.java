package test.java.ios.acceptanceTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.main_ios.objects.EmployeesObject;
import test.java.TestBase;

public class VerifyAccountPanelTest extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}

	@Test
	public void verifyCreateAccount() {
		
		TestLog.When("I login with manager user");
		app.gaia.login.loginManager();
		
		TestLog.Then("I navigate to accounts panel");
		//app.gaia.main.selectPanel(MainPanel.gaiaPanels.ACCOUNTS);
	
	
		TestLog.Then("I add an accounts");
		String username = "zzz_auto" + Helper.generateRandomString(3);
		String firstName = "zzz_first" + Helper.generateRandomString(3);
		String email = "fortify" + Helper.generateRandomString(3) + "@test.com";
		EmployeesObject account = new EmployeesObject()
				.withFirstName(firstName)
				.withEmail(email)
				.withPassword("1234567890")
				.withFirstName(firstName)
				.withLastName("auto");
		
		app.gaia.employees.addSupervisor(account);
	}
}