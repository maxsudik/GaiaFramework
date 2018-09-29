package test.java.rest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.logger.TestLog;
import main.java.main.main_rest.objects.CompanyObject;
import main.java.main.main_rest.objects.PeopleObject;
import main.java.main.main_rest.objects.UserObject;
import test.java.TestBase;

public class verifyPeopleTest extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}

	@Test
	public void verifyCreatePerson() {

		TestLog.When("I login with admin user");
		UserObject user = UserObject.user().withAdminLogin();
		user = app.rest.login.login(user);

		CompanyObject company = CompanyObject.company().withDefaultCompany();
		TestLog.And("I create company '" + company.name().get() + "'");
		company = app.rest.company.createCompany(user, company);

		PeopleObject people = PeopleObject.people().withDefaultPerson();
		people = PeopleObject.Builder.from(people).companyId(company.id().get()).buildPartial();

		TestLog.And("I create person '" + people.firstName().get() + "'");
		people = app.rest.people.createPerson(user, people);

		TestLog.Then("I delete the person '" + people.firstName().get() + "'");
		app.rest.people.deletePerson(user, people);

		TestLog.Then("I delete the company '" + company.name().get() + "'");
		app.rest.company.deleteCompany(user, company);
	}
}