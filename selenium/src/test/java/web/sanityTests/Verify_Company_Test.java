package test.java.web.sanityTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.customerPanel.Panels.CompanyPanel;
import main.customerPanel.Panels.PanelNavigation;
import main.customerPanel.Panels.PeoplePanel;
import main.customerPanel.objects.CompanyObject;
import main.customerPanel.objects.PeopleObject;
import main.customerPanel.objects.UserObject;
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
		CompanyObject company = new CompanyObject().withCreateDefaultCompany();
		TestLog.Then("I add company " + company.companyName);
		app.customerPanel.company.addCompany(company);
		
		TestLog.Then("company " + company.companyName + " should be added successfully");
		Helper.verifyContainsIsInList(CompanyPanel.elements.COMPANY_ROWS, company.companyName);
	}
	
	@Test
	public void validate_edit_company() {
		UserObject user = new UserObject().withEmail(UserObject.USER_ADMIN).withPassword(UserObject.PASSWORD_ADMIN);
		
		// login
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);

		// create company
		CompanyObject company = new CompanyObject().withCreateDefaultCompany();
		TestLog.Then("I add company " + company.companyName);
		app.customerPanel.company.addCompany(company);
		
		// verify company
		TestLog.Then("company " + company.companyName + " should be added successfully");
		Helper.verifyContainsIsInList(CompanyPanel.elements.COMPANY_ROWS, company.companyName);
		
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
				.withUserName(userName)
				.withEmail(email)
				.withPassword("12345TestUser@")
				.withCompany(company.companyName);

		TestLog.And("I add person " + firstName);
		app.customerPanel.people.addPeople(people);
		
		// relogin  as admin
		TestLog.Then("I relogin as admin user " +  people.userName);
		user.email = people.userName;
		user.password = people.password;
		app.customerPanel.login.relogin(user);
		
		TestLog.When("I navigate to company panel");
		app.customerPanel.navigate.selectPanel(PanelNavigation.COMPANY_PANEL);
		
		TestLog.Then("I set add the additional info for the company " + company.companyName);
		app.customerPanel.company.editCompany(company.withEditDefaultCompany());
		
		
		
		
		
	}
}