package main.main_ios.Panels;

import core.helpers.ClickHelper;
import core.helpers.Element;
import core.helpers.FormHelper;
import core.webElement.EnhancedBy;
import io.appium.java_client.MobileBy;
import main.main_ios.objects.CustomerObject;

public class CustomersPanel {

	GaiaManager_ios manager;

	public CustomersPanel( GaiaManager_ios manager) {
		this.manager = manager;

	}

	// customer list 
	private static final String ADD_CUSTOMER = "+ Add Customer";
	private static final String CUSTOMER_LIST = "XCUIElementTypeStaticText";
	private static final String SEARCH_FIELD = "XCUIElementTypeSearchField";


	//customer details (information)
	private static final String USERNAME_FIELD = "XCUIElementTypeTextField";
	private static final String EMAIL_FIELD = "XCUIElementTypeTextField";
	private static final String PASSWORD_FIELD = "XCUIElementTypeSecureTextField";
	
	private static final String FIRST_NAME_FIELD = "XCUIElementTypeTextField";
	private static final String LAST_NAME_FIELD = "XCUIElementTypeTextField";
	private static final String PHONE_NUMBER_FIELD = "XCUIElementTypeTextField";

	private static final String DONE_BUTTON = "Done";
	private static final String CANCEL_BUTTON = "Cancel";
	private static final String CLOSE_BUTTON = "Close";

	public static EnhancedBy byAddCustomerButton() {
		return Element.bySelector(MobileBy.AccessibilityId(ADD_CUSTOMER), "add account button");
	}
	
	public static EnhancedBy byCustomerList() {
		return Element.bySelector(MobileBy.className(CUSTOMER_LIST), "customer list");
	}
	
	public static EnhancedBy bySearchField() {
		return Element.bySelector(MobileBy.className(SEARCH_FIELD), "search field");
	}
	
	public static EnhancedBy byCustomerUser(String user) {
		return Element.bySelector(MobileBy.AccessibilityId(user), user);
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
	
	public static EnhancedBy byPhoneNumberField() {
		return Element.bySelector(MobileBy.className(PHONE_NUMBER_FIELD), "phone number field");
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

	
	public void addCustomer(CustomerObject customer) {
		
		ClickHelper.clickAndExpect(byAddCustomerButton(), byDoneButton());
		setField(customer);
		FormHelper.formSubmit(byDoneButton(), byCloseButton());
		FormHelper.formSubmit(byCloseButton(), byAddCustomerButton());
	}
	
	public void setField(CustomerObject customer) {
		
		FormHelper.setField(customer.username, byUserNameField(), 0);
		FormHelper.setField(customer.email, byEmailField(), 1);	
		FormHelper.setField(customer.password, byPasswordField(), 0);	
		FormHelper.setField(customer.password, byPasswordField(), 1);	
		FormHelper.setField(customer.firstname, byFirstNameField(), 2);	
		FormHelper.setField(customer.lastname, byLastNameField(), 3);	
		FormHelper.setField(customer.phoneNumber, byPhoneNumberField(), 4);	
	}
	
	public void searchCustomer(CustomerObject customer) {
		FormHelper.setField(customer.firstname, bySearchField());	
	}
}