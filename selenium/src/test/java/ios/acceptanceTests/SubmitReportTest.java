package test.java.ios.acceptanceTests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.main_ios.Panels.ReportsPanel;
import main.main_ios.objects.TaskObject;
import test.java.TestBase;

public class SubmitReportTest extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}
	
	public void verifyCreateReport2() {
	
	}

	@Test
	@Ignore // TODO: location detection on build machine not working, hence not going to reports right away
	public void verifyCreateReport() {
		
		TestLog.When("I login with supervisor user");
		app.gaia.login.loginSupervisor();
		
		TestLog.Then("Reports panel will load for selected site");
		Helper.waitForElementToLoad(ReportsPanel.elements.SEND_TO_MANAGER);
		
		TestLog.Then("I select task mow and edge with status complete");
		// list of tasks
	    List<TaskObject> tasks = new ArrayList<TaskObject>();
		TaskObject task = new TaskObject()
				.withTask(TaskObject.LAWN_MOW_EDGE)
				.withStatus(TaskObject.TASK_COMPLETE);
		tasks.add(task);
		
		TestLog.Then("I select task lime with status complete");
		task = new TaskObject()
				.withTask(TaskObject.LAWN_LIME)
				.withStatus(TaskObject.TASK_COMPLETE);
        tasks.add(task);
		
		app.gaia.report.addReport(tasks);
		
		TestLog.Then("I verify the report has been added");
	}
}