package test.java.web.sanityTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import core.helpers.Helper;
import core.helpers.UtilityHelper;
import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.customerPanel.Panels.CompanyPanel;
import main.customerPanel.categories.login;
import main.customerPanel.categories.user;
import main.customerPanel.constants.PanelList;
import main.customerPanel.constants.Roles;
import main.customerPanel.constants.UserInfo;
import main.customerPanel.objects.CompanyObject;
import main.customerPanel.objects.PeopleObject;
import main.customerPanel.objects.UserObject;
import main.customerPanel.pages.CustomerPanel;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class Verify_Company_Test extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
 		setupWebDriver(CustomerPanel.GetDriver().withUrl(CustomerPanel.GAIA_SITE));
	}

	@Category({ login.class, user.class })
	@Test
	public void validate_add_company() {
		UserObject user = new UserObject().withEmail(UserInfo.USER_ADMIN).withPassword(UserInfo.PASSWORD_ADMIN);
		
		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);

		// add company
		CompanyObject company = new CompanyObject().withCreateDefaultCompany();
		TestLog.Then("I add company " + company.companyName);
		app.customerPanel.company.addCompany(company);
		
		TestLog.Then("company " + company.companyName + " should be added successfully");
		Helper.verifyContainsIsInList(CompanyPanel.elements.COMPANY_ROWS, company.companyName);
	}
	
	@Category({ login.class, user.class })
	@Test
	public void validate_edit_company() {
		UserObject user = new UserObject().withEmail(UserInfo.USER_ADMIN).withPassword(UserInfo.PASSWORD_ADMIN);
		
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
		app.customerPanel.navigate.selectPanel(PanelList.PEOPLE_PANEL);
		
		// create manager
		String firstName = "zzz_first" + UtilityHelper.generateRandomString(3);
		String lastName = "zzz_last" + UtilityHelper.generateRandomString(3);
		String userName = "zzz_user" + UtilityHelper.generateRandomString(3);
		String email = "test@" + UtilityHelper.generateRandomString(5) + ".com";
		PeopleObject people = new PeopleObject()
				.withFirstName(firstName)
				.withLastName(lastName)
				.withNotes("test note")
				.withRoles(Roles.MANAGER)
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
		app.customerPanel.navigate.selectPanel(PanelList.COMPANY_PANEL);
		
		TestLog.Then("I set add the additional info for the company " + company.companyName);
		app.customerPanel.company.editCompany(company.withEditDefaultCompany());
		
		
		
		
		
	}
}