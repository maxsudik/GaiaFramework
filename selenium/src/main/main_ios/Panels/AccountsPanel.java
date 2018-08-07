package main.main_ios.Panels;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import io.appium.java_client.MobileBy;
import main.main_ios.GaiaIos;
import main.main_ios.objects.AccountObject;

public class AccountsPanel {

	GaiaIos manager;

	public AccountsPanel( GaiaIos manager) {
		this.manager = manager;

	}
	
	public static class elements {
		// account list 
	    public static EnhancedBy ADD_ACCOUNT = Element.byAccessibility("+ Add Account", "add account button");
	    public static EnhancedBy ACCOUNT_LIST = Element.byClass("XCUIElementTypeStaticText", "account list");
	    public static EnhancedBy SEARCH_FIELD = Element.byClass("XCUIElementTypeSearchField", "search field");
	   
	    //tabs
	    public static EnhancedBy SUPERVISOR_TAB = Element.byXpath("//XCUIElementTypeButton[@name='Supervisor']", "supervisor tab");
	    public static EnhancedBy MANAGER_TAB = Element.byXpath("//XCUIElementTypeButton[@name='Manager']", "manager tab");
	    public static EnhancedBy INSTALLER_TAB = Element.byXpath("//XCUIElementTypeButton[@name='Installer']", "installer tab");
	    
		//account details (information)
	    public static EnhancedBy USERNAME_FIELD = Element.byClass("XCUIElementTypeTextField", "username field");
	    public static EnhancedBy EMAIL_FIELD = Element.byClass("XCUIElementTypeTextField", "email field");
	    public static EnhancedBy PASSWORD_FIELD = Element.byClass("XCUIElementTypeSecureTextField", "password field");
	    
	    public static EnhancedBy FIRST_NAME_FIELD = Element.byClass("XCUIElementTypeTextField", "first name field");
	    public static EnhancedBy LAST_NAME_FIELD = Element.byClass("XCUIElementTypeTextField", "last name field");
	    public static EnhancedBy ROLE = Element.byClass("XCUIElementTypeButton", "role");
	    
	    public static EnhancedBy DONE_BUTTON = Element.byAccessibility("Done", "done button");
	    public static EnhancedBy CANCEL_BUTTON = Element.byAccessibility("Cancel", "cancel button");
	    public static EnhancedBy CLOSE_BUTTON = Element.byAccessibility("Close", "close button");   
	}

	

	
	public static EnhancedBy byAccountUser(String user) {
		return Element.bySelector(MobileBy.AccessibilityId(user), user);
	}

	
	public void addAccount(AccountObject account) {
		
		Helper.clickAndExpect(elements.ADD_ACCOUNT, elements.DONE_BUTTON);
		setField(account);
		Helper.formSubmit(elements.DONE_BUTTON, elements.CLOSE_BUTTON);
		Helper.formSubmit(elements.CLOSE_BUTTON,elements.ADD_ACCOUNT);
	}
	
	public void setField(AccountObject account) {
		
		Helper.setField(account.username, elements.USERNAME_FIELD, 0);
		Helper.setField(account.email, elements.EMAIL_FIELD, 1);	
		Helper.setField(account.password, elements.PASSWORD_FIELD, 0);	
		Helper.setField(account.password, elements.PASSWORD_FIELD, 1);	
		Helper.setField(account.firstName, elements.FIRST_NAME_FIELD, 2);	
		Helper.setField(account.lastName, elements.LAST_NAME_FIELD, 3);	
		Helper.selectElementInList(elements.ROLE, account.roles);
	}
	
	public void searchAccount(AccountObject account) {
		Helper.setField(elements.SEARCH_FIELD, account.fullName);	
	}
	
	public void deleteAccount(AccountObject account) {
		//MobileHelper.swipeLeft(byAccountUser(account.lastName + ", " + account.firstName), byAccountUser("Supervisor3" + ", " + "Test"));
	}
}