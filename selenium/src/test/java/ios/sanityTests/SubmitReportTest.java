package test.java.ios.sanityTests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import core.helpers.WaitHelper;
import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.main_ios.Panels.ReportsPanel;
import main.main_ios.categories.report;
import main.main_ios.constants.TaskInfo;
import main.main_ios.constants.UserInfo_Ios;
import main.main_ios.objects.TaskObject;
import main.main_ios.objects.UserObject_Ios;
import main.main_ios.pages.GaiaIos;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class SubmitReportTest extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
		setupWebDriver(GaiaIos.GetDriver());
	}
	
	@Category({ report.class })
	public void verifyCreateReport2() {
	
	}

	@Category({ report.class })
	@Test
	public void verifyCreateReport() {
		UserObject_Ios user = new UserObject_Ios()
				.withUsername(UserInfo_Ios.SUPERVISOR_USERNAME)
				.withPassword(UserInfo_Ios.SUPERVISOR_PASSWORD);
		
		TestLog.When("I login with supervisor user");
		app.gaia.login.login(user);
		
		TestLog.Then("Reports panel will load for selected site");
		WaitHelper.waitForElementToLoad(ReportsPanel.bySendToManager());
		
		TestLog.Then("I select task mow and edge with status complete");
		// list of tasks
	    List<TaskObject> tasks = new ArrayList<TaskObject>();
		TaskObject task = new TaskObject()
				.withTask(TaskInfo.LAWN_MOW_EDGE)
				.withStatus(TaskInfo.TASK_COMPLETE);
		tasks.add(task);
		
		TestLog.Then("I select task lime with status complete");
		task = new TaskObject()
				.withTask(TaskInfo.LAWN_LIME)
				.withStatus(TaskInfo.TASK_COMPLETE);
        tasks.add(task);
		
		app.gaia.report.addReport(tasks);
		
		TestLog.Then("I verify the report has been added");
	}
}