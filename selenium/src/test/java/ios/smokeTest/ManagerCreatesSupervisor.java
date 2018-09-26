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
				.withUserName(EmployeesObject.USERNAME)
				.withEmail(EmployeesObject.EMAIL)
				.withFirstName(EmployeesObject.FIRST_NAME)
				.withLastName(EmployeesObject.LAST_NAME)
				.withPassword(EmployeesObject.PASSWORD)
				.withConfirmPassword(EmployeesObject.CONFIRM_PASSWORD)
				.withNotes(EmployeesObject.NOTES);
		
		TestLog.Then("I create a supervisor");
		app.gaia.employees.addSupervisor(employees);
	}

}
