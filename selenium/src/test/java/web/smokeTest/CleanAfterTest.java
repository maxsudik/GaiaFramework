package test.java.web.smokeTest;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.logger.TestLog;
import main.java.main.customerPanel.objects.CompanyObject;
import main.java.main.customerPanel.objects.PeopleObject;
import main.java.main.customerPanel.objects.UserObject;
import test.java.TestBase;

public class CleanAfterTest extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.customerPanel.getDriver());
	}
	
	@Test
	public void cleanCompaniesAfterTest() {
		
		UserObject user = new UserObject()
				.withEmail(UserObject.USER_ADMIN)
				.withPassword(UserObject.PASSWORD_ADMIN);
		
		CompanyObject company = new CompanyObject()
				.withName(CompanyObject.COMPANY_NAME);
		
		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);
		
		TestLog.Then("I delete company");
		app.customerPanel.company.deleteCompanies(company);
	}
	
	@Test
	public void cleanEmployeesAfterTest() {
		
		UserObject user = new UserObject()
				.withEmail(UserObject.USER_ADMIN)
				.withPassword(UserObject.PASSWORD_ADMIN);
		
		PeopleObject people = new PeopleObject()
				.withFirstName(PeopleObject.FIRST_NAME);
		
		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);
		
		TestLog.When("I select people panel");
		app.customerPanel.navigate.selectEmployee();
		
		TestLog.Then("I delete employee");
		app.customerPanel.people.deleteEmployees(people);
		
	}

}
