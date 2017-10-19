package test.java.web.sanityTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import core.helpers.Helper;
import core.helpers.UtilityHelper;
import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.customerPanel.categories.login;
import main.customerPanel.categories.user;
import main.customerPanel.constants.PanelList;
import main.customerPanel.constants.Roles;
import main.customerPanel.constants.UserInfo;
import main.customerPanel.objects.PeopleObject;
import main.customerPanel.objects.UserObject;
import main.customerPanel.pages.CustomerPanel;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class Verify_People_Test extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
 		setupWebDriver(CustomerPanel.GetDriver().withUrl(CustomerPanel.GAIA_SITE));
	}

	/**
	 * When I login as admin Then I create a company And I a person to that
	 * company Then I should successfully create a site
	 */
	@Category({ login.class, user.class })
	@Test
	public void validate_add_people() {
		UserObject user = new UserObject().withEmail(UserInfo.USER_AUTO_MANAGER).withPassword(UserInfo.PASSWORD_AUTO_MANAGER);
		
		TestLog.When("I login with manager user");
		app.customerPanel.login.login(user);

		// select people panel
		TestLog.When("I select people panel");
		app.customerPanel.panel.selectPanel(PanelList.PEOPLE_PANEL);

		// add people
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
				.withCompany("AutoInc");

		TestLog.And("I add person " + firstName);
		app.customerPanel.people.addPeople(people);
		
		TestLog.Then("Person should be added successfully");
		Helper.verifyElementIsDisplayed(app.customerPanel.people.byPeopleAddSuccess());
	}
}