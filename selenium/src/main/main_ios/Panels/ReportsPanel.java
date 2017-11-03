package main.main_ios.Panels;

import java.util.List;

import core.helpers.Element;
import core.helpers.FormHelper;
import core.helpers.ListHelper;
import core.webElement.EnhancedBy;
import io.appium.java_client.MobileBy;
import main.main_ios.objects.TaskObject;

public class ReportsPanel {

	GaiaManager_ios manager;

	public ReportsPanel( GaiaManager_ios manager) {
		this.manager = manager;

	}
	
	//report fields
	private static final String REPORT_OPTIONS = "XCUIElementTypeButton";
	
	private static final String SEND_TO_MANAGER = "Send to Manager";
	private static final String CLOSE_BUTTON = "Close";

	public static EnhancedBy byReportOption() {
		return Element.bySelector(MobileBy.className(REPORT_OPTIONS), "report option");
	}
	
	public static EnhancedBy bySendToManager() {
		return Element.bySelector(MobileBy.AccessibilityId(SEND_TO_MANAGER), "send to manager");
	}
	
	public static EnhancedBy byCloseButton() {
		return Element.bySelector(MobileBy.AccessibilityId(CLOSE_BUTTON), "close button");
	}
	
	/**
	 * report consists of tasks
	 * @param tasks 
	 */
	public void addReport(List<TaskObject> tasks) {
		
		for(TaskObject task : tasks) {
			setTask(task); 
		}
		FormHelper.formSubmit(bySendToManager(), byCloseButton());
	}
 	
   public void setTask(TaskObject task) {
	   ListHelper.selectElementInList(byReportOption(), task.task + task.status); 
   }
}