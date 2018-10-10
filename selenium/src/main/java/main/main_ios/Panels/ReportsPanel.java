package main.main_ios.Panels;

import java.util.List;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;
import main.main_ios.objects.TaskObject;

public class ReportsPanel {

	GaiaIos manager;

	public ReportsPanel( GaiaIos manager) {
		this.manager = manager;

	}
	
	public static class elements {
	    public static EnhancedBy REPORT_OPTIONS = Element.byClass("XCUIElementTypeButton", "report option");
	    public static EnhancedBy SEND_TO_MANAGER = Element.byAccessibility("Send to Manager", "send to manager");
	    public static EnhancedBy CLOSE_BUTTON = Element.byAccessibility("Close", "close button");
	}
	
	/**
	 * report consists of tasks
	 * @param tasks 
	 */
	public void addReport(List<TaskObject> tasks) {
		
		for(TaskObject task : tasks) {
			setTask(task); 
		}
		Helper.formSubmit(elements.SEND_TO_MANAGER, elements.CLOSE_BUTTON);
	}
 	
   public void setTask(TaskObject task) {
	   Helper.selectElementInList(elements.REPORT_OPTIONS, task.task + task.status); 
   }
}