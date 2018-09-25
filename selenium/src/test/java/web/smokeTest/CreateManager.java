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
		CompanyObject company = new CompanyObject().withCreateDefaultCompany();
		
		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);
		
		TestLog.When("I select people panel");
		app.customerPanel.navigate.selectEmployee();

		// add people
		String firstName = "FirstName";
		String lastName = "LastName";
		String email = "maksym.sudik+1@fortify.pro";
		PeopleObject people = new PeopleObject()
				.withFirstName(firstName)
				.withLastName(lastName)
				.withNotes("tsome notes")
				.withRoles(PeoplePanel.MANAGER)
				.withEmail(email)
				.withPassword("1111111111");

		TestLog.And("I add person " + firstName);
		app.customerPanel.people.addPeople(people, company);
		
		TestLog.Then("Person should be added successfully");
		Helper.verifyElementIsDisplayed(PeoplePanel.elements.PEOPLE_ADD_SUCCESS);
	}
}


