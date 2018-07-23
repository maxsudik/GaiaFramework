package main.main_ios.Panels;

import core.helpers.ClickHelper;
import core.helpers.Element;
import core.helpers.FormHelper;
import core.helpers.ListHelper;
import core.webElement.EnhancedBy;
import io.appium.java_client.MobileBy;
import main.main_ios.objects.AccountObject;

public class AccountsPanel {

	GaiaManager_ios manager;

	public AccountsPanel( GaiaManager_ios manager) {
		this.manager = manager;

	}

	// account list 
	private static final String ADD_ACCOUNT = "+ Add Account";
	private static final String ACCOUNT_LIST = "XCUIElementTypeStaticText";
	private static final String SEARCH_FIELD = "XCUIElementTypeSearchField";
	

	//tabs
	private static final String SUPERVISOR_TAB = "//XCUIElementTypeButton[@name='Supervisor']";
	private static final String MANAGER_TAB = "//XCUIElementTypeButton[@name='Manager']";
	private static final String INSTALLER_TAB = "//XCUIElementTypeButton[@name='Installer']";

	//account details (information)
	private static final String USERNAME_FIELD = "XCUIElementTypeTextField";
	private static final String EMAIL_FIELD = "XCUIElementTypeTextField";
	private static final String PASSWORD_FIELD = "XCUIElementTypeSecureTextField";
	
	private static final String FIRST_NAME_FIELD = "XCUIElementTypeTextField";
	private static final String LAST_NAME_FIELD = "XCUIElementTypeTextField";
	private static final String ROLE = "XCUIElementTypeButton";
	
	private static final String DONE_BUTTON = "Done";
	private static final String CANCEL_BUTTON = "Cancel";
	private static final String CLOSE_BUTTON = "Close";

	
	public static EnhancedBy byAddAccountButton() {
		return Element.bySelector(MobileBy.AccessibilityId(ADD_ACCOUNT), "add account button");
	}
	
	public static EnhancedBy byAccountList() {
		return Element.bySelector(MobileBy.className(ACCOUNT_LIST), "account list");
	}
	
	public static EnhancedBy byAccountUser(String user) {
		return Element.bySelector(MobileBy.AccessibilityId(user), user);
	}

	public static EnhancedBy bySupervisorTab() {
		return Element.bySelector(MobileBy.xpath(SUPERVISOR_TAB), "supervisor tab");
	}
	
	public static EnhancedBy byManagerTab() {
		return Element.bySelector(MobileBy.xpath(MANAGER_TAB), "manager tab");
	}
	
	public static EnhancedBy byInstallerTab() {
		return Element.bySelector(MobileBy.xpath(INSTALLER_TAB), "installer tab");
	}
	
	public static EnhancedBy bySearchField() {
		return Element.bySelector(MobileBy.className(SEARCH_FIELD), "search field");
	}
	
	public static EnhancedBy byUserNameField() {
		return Element.bySelector(MobileBy.className(USERNAME_FIELD), "username field");
	}
	
	public static EnhancedBy byEmailField() {
		return Element.bySelector(MobileBy.className(EMAIL_FIELD), "email field");
	}
	
	public static EnhancedBy byPasswordField() {
		return Element.bySelector(MobileBy.className(PASSWORD_FIELD), "password field");
	}
	
	public static EnhancedBy byFirstNameField() {
		return Element.bySelector(MobileBy.className(FIRST_NAME_FIELD), "first name field");
	}
	
	public static EnhancedBy byLastNameField() {
		return Element.bySelector(MobileBy.className(LAST_NAME_FIELD), "last name field");
	}
	
	public static EnhancedBy byRoleButton() {
		return Element.bySelector(MobileBy.className(ROLE), "role");
	}
	
	public static EnhancedBy byDoneButton() {
		return Element.bySelector(MobileBy.AccessibilityId(DONE_BUTTON), "done button");
	}
	
	public static EnhancedBy byCancelButton() {
		return Element.bySelector(MobileBy.AccessibilityId(CANCEL_BUTTON), "cancel button");
	}
	
	public static EnhancedBy byCloseButton() {
		return Element.bySelector(MobileBy.AccessibilityId(CLOSE_BUTTON), "close button");
	}

	
	public void addAccount(AccountObject account) {
		
		ClickHelper.clickAndExpect(byAddAccountButton(), byDoneButton());
		setField(account);
		FormHelper.formSubmit(byDoneButton(), byCloseButton());
		FormHelper.formSubmit(byCloseButton(), byAddAccountButton());
	}
	
	public void setField(AccountObject account) {
		
		FormHelper.setField(account.username, byUserNameField(), 0);
		FormHelper.setField(account.email, byEmailField(), 1);	
		FormHelper.setField(account.password, byPasswordField(), 0);	
		FormHelper.setField(account.password, byPasswordField(), 1);	
		FormHelper.setField(account.firstName, byFirstNameField(), 2);	
		FormHelper.setField(account.lastName, byLastNameField(), 3);	
		ListHelper.selectElementInList(byRoleButton(), account.roles);
	}
	
	public void searchAccount(AccountObject account) {
		FormHelper.setField(account.fullName, bySearchField());	
	}
	
	public void deleteAccount(AccountObject account) {
		//MobileHelper.swipeLeft(byAccountUser(account.lastName + ", " + account.firstName), byAccountUser("Supervisor3" + ", " + "Test"));
	}
}