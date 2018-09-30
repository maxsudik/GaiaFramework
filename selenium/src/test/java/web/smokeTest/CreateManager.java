package web.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import core.helpers.Helper;
import core.logger.TestLog;
import common.objects.CompanyObject;
import common.objects.UserObject;
import main.customerPanel.Panels.PeoplePanel;
import main.customerPanel.objects.PeopleObject;

public class CreateManager extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}
	@Test
	public void createManager() throws Exception {
		// create company through api
		TestLog.And("I create a company");
		CompanyObject company = app.rest.company.loginAndCreateCompany();
		
		// switch to web driver
		setupWebDriver(app.customerPanel.getDriver());
		
		UserObject user = UserObject.user().withAdminLogin();

		TestLog.When("I login with admin user");
		app.customerPanel.login.login(user);
			
		TestLog.When("I select people panel");
		app.customerPanel.navigate.selectEmployee();					
		
		PeopleObject people = new PeopleObject().withDefaultManager(company.name().get());
		TestLog.And("I add person " + people.firstName);
		app.customerPanel.people.addPeople(people, company);

		TestLog.Then("Person should be added successfully");
		Helper.verifyElementIsDisplayed(PeoplePanel.elements.PEOPLE_ADD_SUCCESS);
	}
}


