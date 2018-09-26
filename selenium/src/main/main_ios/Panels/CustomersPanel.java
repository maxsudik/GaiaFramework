package main.main_ios.Panels;


import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;
import main.main_ios.objects.CustomerObject;

public class CustomersPanel {

	GaiaIos manager;

	public CustomersPanel( GaiaIos manager) {
		this.manager = manager;

	}
	
	public static class elements {

		//Customer list 
	    public static EnhancedBy ADD_CUSTOMER = Element.byAccessibility("+ Add customer", "add customer button");
	  
	    public static EnhancedBy CUSTOMER_LIST = Element.byClass("XCUIElementTypeStaticText", "customer list");
	    public static EnhancedBy SEARCH_FIELD = Element.byClass("XCUIElementTypeSearchField", "search field");
	   

		//Account details (information)
	    public static EnhancedBy USERNAME_FIELD = Element.byClass("XCUIElementTypeTextField", "username field");
	    public static EnhancedBy EMAIL_FIELD = Element.byClass("XCUIElementTypeTextField", "email field");
	    public static EnhancedBy PASSWORD_FIELD = Element.byClass("XCUIElementTypeSecureTextField", "password field");
	    public static EnhancedBy CONFIRM_PASSWORD_FIELD = Element.byClass("XCUIElementTypeSecureTextField", "confirm password field");

	   	   
	    public static EnhancedBy FIRST_NAME_FIELD = Element.byClass("XCUIElementTypeTextField", "first name field");
	    public static EnhancedBy LAST_NAME_FIELD = Element.byClass("XCUIElementTypeTextField", "last name field");
	    public static EnhancedBy PHONE_NUMBER_FIELD = Element.byClass("XCUIElementTypeTextField", "phone number field");
	    
	    
	 //     public static EnhancedBy ADD_NEW_SITE_BUTTON = Element.byAccessibility("", "");
	//    public static EnhancedBy CHOOSE_EXISTING_SITE_BUTTON = Element.byAccessibility("", "");
	//    public static EnhancedBy DIFFERENT_BILLING_ADDRESS_SWITCH = Element.byAccessibility("", "");

	    
	    public static EnhancedBy SAVE_BUTTON = Element.byAccessibility("Save", "save button");
	    public static EnhancedBy CANCEL_BUTTON = Element.byAccessibility("Cancel", "cancel button");
	    public static EnhancedBy CLOSE_BUTTON = Element.byAccessibility("Close", "close button");   
	
	    public static EnhancedBy byCustomerUser(String user) {
			return Element.byAccessibility(user, user);
		}

	}
	
public void addCustomer(CustomerObject customer) {
		
		Helper.clickAndExpect(elements.ADD_CUSTOMER, elements.SAVE_BUTTON);
		setField(customer);
		Helper.formSubmit(elements.SAVE_BUTTON, elements.CLOSE_BUTTON);
		Helper.formSubmit(elements.CLOSE_BUTTON, elements.ADD_CUSTOMER);
		
	}
	
	public void setField(CustomerObject customer) {
	
		Helper.setField(customer.username, elements.USERNAME_FIELD, 0);
		Helper.setField(customer.email, elements.EMAIL_FIELD, 1);	
		Helper.setField(customer.password, elements.PASSWORD_FIELD, 0);	
		Helper.setField(customer.confirmPassword, elements.CONFIRM_PASSWORD_FIELD, 1);	
		Helper.setField(customer.firstname, elements.FIRST_NAME_FIELD, 2);	
		Helper.setField(customer.lastname, elements.LAST_NAME_FIELD , 3);	
		Helper.setField(customer.phoneNumber, elements.PHONE_NUMBER_FIELD, 4);	
		
	}
	
	public void searchCustomer(CustomerObject customer) {
		Helper.setField(elements.SEARCH_FIELD, customer.firstname);	
	}
}
