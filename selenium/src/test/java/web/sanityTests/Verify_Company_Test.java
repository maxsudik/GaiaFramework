package web.sanityTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import common.objects.CompanyObject;
import common.objects.UserObject;
import core.helpers.Helper;
import core.logger.TestLog;
import main.customerPanel.Panels.CompanyPanel;
import main.customerPanel.Panels.PanelNavigation;
import main.customerPanel.Panels.PeoplePanel;
import main.customerPanel.objects.PeopleObject;

public class Verify_Company_Test extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.customerPanel.getDriver());
	}

	@Test
	public void validate_add_company() {
		UserObject user = UserObject.user().withAdminLogin();
		
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);

		// add company
		CompanyObject company = CompanyObject.company().withDefaultCompany();
		TestLog.Then("I add company " + company.name().get());
		app.customerPanel.company.addCompany(company);
		
		TestLog.Then("company " + company.name().get() + " should be added successfully");
		Helper.verifyContainsIsInList(CompanyPanel.elements.COMPANY_ROWS, company.name().get());
	}
	
	@Test
	public void validate_edit_company() {
		UserObject user = UserObject.user().withAdminLogin();
		
		// login
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);

		// create company
		CompanyObject company = CompanyObject.company().withDefaultCompany();
		TestLog.Then("I add company " + company.name().get());
		app.customerPanel.company.addCompany(company);
		
		// verify company
		TestLog.Then("company " + company.name().get() + " should be added successfully");
		Helper.verifyContainsIsInList(CompanyPanel.elements.COMPANY_ROWS, company.name().get());
		
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
				.withCompanyName(company.name().get());

		TestLog.And("I add person " + firstName);
		app.customerPanel.people.addPeople(people, company);		
	}
}