package test.java.web.cleanup;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import core.helpers.DatabaseHelper.MongoDbHelper;
import core.helpers.DatabaseHelper.MongoObject;
import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.customerPanel.categories.login;
import main.customerPanel.categories.user;
import main.customerPanel.pages.CustomerPanel;
import test.java.TestBase;


@RunWith(ParallelRunner.class)
public class DataBaseCleanup extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
 		setupWebDriver(CustomerPanel.GetDriver().withUrl(CustomerPanel.GAIA_SITE));
	}
	
	@Category({ login.class, user.class })
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