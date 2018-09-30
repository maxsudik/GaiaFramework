package ios.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import core.logger.TestLog;
import main.main_ios.Panels.MainPanel;
import main.main_ios.objects.EmployeesObject;

public class ManagerCreatesInstaller extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}
	
	@Test
	public void verifyCreatingInstaller() {
		
		TestLog.When("I login with created user");
		app.gaia.login.loginManager();
		
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.EMPLOYEES);
		
		EmployeesObject employees = new EmployeesObject()
				.withUserName(EmployeesObject.INSTALLER_USERNAME)
				.withEmail(EmployeesObject.INSTALLER_EMAIL)
				.withFirstName(EmployeesObject.INSTALLER_FIRST_NAME)
				.withLastName(EmployeesObject.INSTALLER_LAST_NAME)
				.withPassword(EmployeesObject.INSTALLER_PASSWORD)
				.withConfirmPassword(EmployeesObject.INSTALLER_CONFIRM_PASSWORD)
				.withNotes(EmployeesObject.INSTALLER_NOTES);
		
		TestLog.Then("I create an installer");
		app.gaia.employees.addInstaller(employees);
	}

}
