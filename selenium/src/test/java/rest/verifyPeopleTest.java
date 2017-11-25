package test.java.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.main_rest.objects.CompanyObject;
import main.main_rest.objects.PeopleObject;
import main.main_rest.objects.UserObject;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class verifyPeopleTest extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}
	
	@Test
	public void verifyCreatePerson() {
		
		TestLog.When("I login with admin user");
		UserObject user = new UserObject().withAdminLogin();
		user = app.rest.login.login(user);
		
		CompanyObject company = new CompanyObject().withDefaultCompany();
		TestLog.And("I create company '"  + company.name + "'");
		company = app.rest.company.createCompany(user, company);
		
		PeopleObject people = new PeopleObject().withDefaultPerson();
		people.setCompanyId(company.id);
		
		TestLog.And("I create person '"  + people.firstName + "'");
		people = app.rest.people.createPerson(user, people);
		
		TestLog.Then("I delete the person '" + people.firstName + "'");
		app.rest.people.deletePerson(user, people);	
		
		TestLog.Then("I delete the company '" + company.name + "'");
		app.rest.company.deleteCompany(user, company);	
	}
}