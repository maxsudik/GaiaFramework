package test.java.web.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;

import main.customerPanel.Panels.PeoplePanel;
import main.customerPanel.objects.CompanyObject;
import main.customerPanel.objects.PeopleObject;
import main.customerPanel.objects.UserObject;
import test.java.TestBase;

public class CreateManager extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.customerPanel.getDriver());
	}
	@Test
	public void createManager() {
		UserObject user = new UserObject().withEmail(UserObject.USER_ADMIN).withPassword(UserObject.PASSWORD_ADMIN);

		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);
		
		TestLog.When("I select people panel");
		app.customerPanel.navigate.selectEmployee();
		
		PeopleObject people = new PeopleObject()
				.withCompanyName(CompanyObject.COMPANY_NAME)
				.withRoles(PeopleObject.ROLES)
				.withFirstName(PeopleObject.FIRST_NAME)
				.withLastName(PeopleObject.LAST_NAME)
				.withNotes(PeopleObject.NOTES)
				.withEmail(PeopleObject.EMAIL)
				.withPassword(PeopleObject.PASSWORD)
				.withRepeatPassword(PeopleObject.REPEAT_PASSWORD);
		
		CompanyObject company = new CompanyObject()
				.withName(CompanyObject.COMPANY_NAME);
		
		TestLog.And("I add person " + PeopleObject.FIRST_NAME);
		app.customerPanel.people.addPeople(people, company);

		
		TestLog.Then("Person should be added successfully");
		Helper.verifyElementIsDisplayed(PeoplePanel.elements.PEOPLE_ADD_SUCCESS);
	}
}


