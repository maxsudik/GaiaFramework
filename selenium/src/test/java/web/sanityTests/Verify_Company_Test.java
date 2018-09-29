package test.java.web.sanityTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.java.main.customerPanel.Panels.CompanyPanel;
import main.java.main.customerPanel.Panels.PanelNavigation;
import main.java.main.customerPanel.Panels.PeoplePanel;
import main.java.main.customerPanel.objects.CompanyObject;
import main.java.main.customerPanel.objects.PeopleObject;
import main.java.main.customerPanel.objects.UserObject;
import test.java.TestBase;

public class Verify_Company_Test extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.customerPanel.getDriver());
	}

	@Test
	public void validate_add_company() {
		UserObject user = new UserObject().withEmail(UserObject.USER_ADMIN).withPassword(UserObject.PASSWORD_ADMIN);
		
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);

		// add company
		CompanyObject company = new CompanyObject();
		TestLog.Then("I add company " + company.name);
		app.customerPanel.company.addCompany(company);
		
		TestLog.Then("company " + company.name + " should be added successfully");
		Helper.verifyContainsIsInList(CompanyPanel.elements.COMPANY_ROWS, company.name);
	}
	
	@Test
	public void validate_edit_company() {
		UserObject user = new UserObject().withEmail(UserObject.USER_ADMIN).withPassword(UserObject.PASSWORD_ADMIN);
		
		// login
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);

		// create company
		CompanyObject company = new CompanyObject();
		TestLog.Then("I add company " + company.name);
		app.customerPanel.company.addCompany(company);
		
		// verify company
		TestLog.Then("company " + company.name + " should be added successfully");
		Helper.verifyContainsIsInList(CompanyPanel.elements.COMPANY_ROWS, company.name);
		
		// select people panel
		TestLog.When("I select people panel");
		app.customerPanel.navigate.selectPanel(PanelNavigation.PEOPLE_PANEL);
		
		// create manager
		String firstName = "zzz_first" + Helper.generateRandomString(3);
		String lastName = "zzz_last" + Helper.generateRandomString(3);
		String userName = "zzz_user" + Helper.generateRandomString(3);
		String email = "test@" + Helper.generateRandomString(5) + ".com";
		PeopleObject people = new PeopleObject()
				.withFirstName(firstName)
				.withLastName(lastName)
				.withNotes("test note")
				.withRoles(PeoplePanel.MANAGER)
				.withEmail(email)
				.withPassword("12345TestUser@")
				.withCompanyName(company.name);

		TestLog.And("I add person " + firstName);
		app.customerPanel.people.addPeople(people, company);
		
		// relogin  as admin
		TestLog.Then("I relogin as admin user " +  people.firstName);
		user.email = people.firstName;
		user.password = people.password;
		app.customerPanel.login.relogin(user);
		
		TestLog.When("I navigate to company panel");
		app.customerPanel.navigate.selectPanel(PanelNavigation.COMPANY_PANEL);
		
		
		
		
		
		
	}
}