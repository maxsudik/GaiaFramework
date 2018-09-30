package test.java.web.sanityTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.java.common.objects.CompanyObject;
import main.java.common.objects.UserObject;
import main.java.main.customerPanel.Panels.PanelNavigation;
import main.java.main.customerPanel.Panels.PeoplePanel;
import main.java.main.customerPanel.objects.PeopleObject;
import test.java.TestBase;

public class Verify_People_Test extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.customerPanel.getDriver());
	}

	/**
	 * When I login as admin Then I create a company And I a person to that
	 * company Then I should successfully create a site
	 */
	@Test
	public void validate_add_people() {
		UserObject user = UserObject.user().withManagerUser();
		CompanyObject company = CompanyObject.company().withDefaultCompany();
		
		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);

		// select people panel
		TestLog.When("I select people panel");
		app.customerPanel.navigate.selectPanel(PanelNavigation.PEOPLE_PANEL);

		// add people
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
				.withCompanyName("AutoInc");

		TestLog.And("I add person " + firstName);
		app.customerPanel.people.addPeople(people, company);
		
		TestLog.Then("Person should be added successfully");
		Helper.verifyElementIsDisplayed(PeoplePanel.elements.PEOPLE_ADD_SUCCESS);
	}
}