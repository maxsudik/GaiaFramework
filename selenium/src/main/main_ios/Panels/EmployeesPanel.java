package main.main_ios.Panels;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;
import main.main_ios.objects.EmployeesObject;
import main.main_ios.objects.SiteObject;

public class EmployeesPanel {

	GaiaIos manager;

	public EmployeesPanel( GaiaIos manager) {
		this.manager = manager;

	}
	
	public static class elements {
		// account list 
	    public static EnhancedBy ADD_ACCOUNT = Element.byAccessibility("+ Add Employee", "add employee button");
	    //public static EnhancedBy ACCOUNT_LIST = Element.byClass("XCUIElementTypeStaticText", "account list");
	    public static EnhancedBy SEARCH_FIELD = Element.byAccessibility("Search", "search field");
	   
	    //tabs
	    public static EnhancedBy SUPERVISOR_TAB = Element.byAccessibility("Supervisor", "supervisor tab");
	    public static EnhancedBy MANAGER_TAB = Element.byAccessibility("Manager", "manager tab");
	    public static EnhancedBy INSTALLER_TAB = Element.byAccessibility("Installer", "installer tab");
	    
		//account details (information)
	    public static EnhancedBy USERNAME_FIELD = Element.byClass("XCUIElementTypeTextField", "username field");//0
	    public static EnhancedBy EMAIL_FIELD = Element.byClass("XCUIElementTypeTextField", "email field");//1
	    public static EnhancedBy PASSWORD_FIELD = Element.byClass("XCUIElementTypeSecureTextField", "password field");//0
	    public static EnhancedBy CONFIRM_PASSWORD_FIELD = Element.byClass("XCUIElementTypeSecureTextField", "confirm password field");//1

	    public static EnhancedBy FIRST_NAME_FIELD = Element.byClass("XCUIElementTypeTextField", "first name field");//2
	    public static EnhancedBy LAST_NAME_FIELD = Element.byClass("XCUIElementTypeTextField", "last name field");//3
	    public static EnhancedBy NOTES_FIELD = Element.byClass("XCUIElementTypeTextField", "last name field");//4

	    public static EnhancedBy ROLE_SUPERVISOR = Element.byClass("XCUIElementTypeButton", "supervisor");//9
	    public static EnhancedBy ROLE_MANAGER = Element.byClass("XCUIElementTypeButton", "manager");//10
	    public static EnhancedBy ROLE_INSTALLER = Element.byClass("XCUIElementTypeButton", "installer");//11
	    
	    public static EnhancedBy SITES_BUTTON = Element.byAccessibility("More Info", "sites");
	    //Sites Internal Panel
	    public static EnhancedBy SITE_NAME = Element.byAccessibility(SiteObject.DEFAULT_SITE, "site name");
	    public static EnhancedBy DONE_BUTTON_INTERNAL = Element.byAccessibility("Done", "internal done");
	    
	    public static EnhancedBy LICENSED_USER_SWITCHER = Element.byClass("XCUIElementTypeSwitch", "licensed user");
	    
	    public static EnhancedBy DONE_BUTTON = Element.byAccessibility("Done", "done button");
	    public static EnhancedBy CANCEL_BUTTON = Element.byAccessibility("Cancel", "cancel button");
	    public static EnhancedBy CLOSE_BUTTON = Element.byAccessibility("Close", "close button");   
	}

	

	
//	public static EnhancedBy byAccountUser(String user) {
//		return Element.bySelector(MobileBy.AccessibilityId(user), user);
//	}

	
	public void addSupervisor(EmployeesObject employees) {
		
		Helper.clickAndExpect(elements.SUPERVISOR_TAB, elements.ADD_ACCOUNT);
		Helper.clickAndExpect(elements.ADD_ACCOUNT, elements.DONE_BUTTON);
		setField(employees);
		Helper.clickAndExpect(elements.ROLE_SUPERVISOR, 9, elements.SITES_BUTTON);
		Helper.clickAndExpect(elements.SITES_BUTTON, elements.SITE_NAME);
		Helper.clickAndExpect(elements.SITE_NAME, elements.DONE_BUTTON_INTERNAL);
		Helper.clickAndExpect(elements.DONE_BUTTON_INTERNAL, elements.LICENSED_USER_SWITCHER);
		Helper.clickAndExpect(elements.LICENSED_USER_SWITCHER, elements.DONE_BUTTON);
		Helper.formSubmit(elements.DONE_BUTTON, elements.CLOSE_BUTTON);
		Helper.formSubmit(elements.CLOSE_BUTTON,elements.ADD_ACCOUNT);
	}
	
	public void addInstaller(EmployeesObject employees) {
		
		Helper.clickAndExpect(elements.INSTALLER_TAB, elements.ADD_ACCOUNT);
		Helper.clickAndExpect(elements.ADD_ACCOUNT, elements.DONE_BUTTON);
		setField(employees);
		Helper.clickAndExpect(elements.ROLE_INSTALLER, 11, elements.SITES_BUTTON);
		Helper.clickAndExpect(elements.SITES_BUTTON, elements.SITE_NAME);
		Helper.clickAndExpect(elements.SITE_NAME, elements.DONE_BUTTON_INTERNAL);
		Helper.clickAndExpect(elements.DONE_BUTTON_INTERNAL, elements.LICENSED_USER_SWITCHER);
		Helper.clickAndExpect(elements.LICENSED_USER_SWITCHER, elements.DONE_BUTTON);
		Helper.formSubmit(elements.DONE_BUTTON, elements.CLOSE_BUTTON);
		Helper.formSubmit(elements.CLOSE_BUTTON,elements.ADD_ACCOUNT);
	}
	
	public void setField(EmployeesObject employees) {
		
		Helper.setField(employees.username, elements.USERNAME_FIELD, 0);
		Helper.setField(employees.email, elements.EMAIL_FIELD, 1);	
		Helper.setField(employees.password, elements.PASSWORD_FIELD, 0);	
		Helper.setField(employees.confirmPassword, elements.CONFIRM_PASSWORD_FIELD, 1);	
		Helper.setField(employees.firstName, elements.FIRST_NAME_FIELD, 2);	
		Helper.setField(employees.lastName, elements.LAST_NAME_FIELD, 3);	
		Helper.setField(employees.notes, elements.NOTES_FIELD, 4);
	}
	
	public void searchAccount(EmployeesObject employees) {
		Helper.setField(elements.SEARCH_FIELD, employees.username);	
	}
	
	public void deleteAccount(EmployeesObject account) {
		//MobileHelper.swipeLeft(byAccountUser(account.lastName + ", " + account.firstName), byAccountUser("Supervisor3" + ", " + "Test"));
	}
}