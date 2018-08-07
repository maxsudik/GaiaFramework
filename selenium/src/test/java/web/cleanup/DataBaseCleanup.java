package test.java.web.cleanup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.DatabaseHelper.MongoDbHelper;
import core.helpers.DatabaseHelper.MongoObject;
import core.logger.TestLog;
import test.java.TestBase;


public class DataBaseCleanup extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.rest.getDriver());
	}
	
	@Test
	public void databaseCleanupTest() throws Exception {
		
		String password = "@#Fortify$";
		MongoObject mongo = new MongoObject()
				.withUsername("Fortify")
				.withPassword(password)
				.withDatabase("gaia");
		
		TestLog.When("I delete all test users");
		MongoDbHelper.deleteData(mongo);
	}
}