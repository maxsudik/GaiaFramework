package test.java.ios.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.logger.TestLog;
import main.main_ios.Panels.MainPanel;

import main.main_ios.objects.EmployeesObject;
import test.java.TestBase;

public class ManagerCreatesSupervisor extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}
	
	@Test
	public void verifyCreatingSupervisor() {
		
		TestLog.When("I login with created user");
		app.gaia.login.loginManager();
		
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.EMPLOYEES);
		
		EmployeesObject employees = new EmployeesObject()
				.withUserName(EmployeesObject.SUPERVISOR_USERNAME)
				.withEmail(EmployeesObject.SUPERVISOR_EMAIL)
				.withFirstName(EmployeesObject.SUPERVISOR_FIRST_NAME)
				.withLastName(EmployeesObject.SUPERVISOR_LAST_NAME)
				.withPassword(EmployeesObject.SUPERVISOR_PASSWORD)
				.withConfirmPassword(EmployeesObject.SUPERVISOR_CONFIRM_PASSWORD)
				.withNotes(EmployeesObject.SUPERVISOR_NOTES);
		
		TestLog.Then("I create a supervisor");
		app.gaia.employees.addSupervisor(employees);
	}

}
