package main.main_ios.Panels;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;
import main.main_ios.objects.EstimateObject;

public class EstimatePanel {

	GaiaIos manager;

	public EstimatePanel( GaiaIos manager) {
		this.manager = manager;

	}
	
	public static class elements {
		// customer list 
	    public static EnhancedBy TITLE = Element.byAccessibility("Estimation Title", "title field");
	    public static EnhancedBy CUSTOMER_NAME = Element.byClass("Customer Dropdown", "customer name field");
	    public static EnhancedBy DROP_DOWN_OPTION = Element.byClass("XCUIElementTypeCell", "drop down option");
	    public static EnhancedBy CUSTOMER_SITE = Element.byClass("Site Dropdown", "customer site field");
	    public static EnhancedBy ADDRESS = Element.byClass("Address Field", "address field");
	    public static EnhancedBy CITY = Element.byClass("Address Two", "city field");
	    public static EnhancedBy POSTAL_CODE = Element.byClass("Address Three", "postal code field");
	    public static EnhancedBy PHONE_NUMBER = Element.byClass("Phone Number Field", "phone number field");
	    public static EnhancedBy EMAIL = Element.byClass("Email Field", "email field");
	    public static EnhancedBy DESCRIPTION = Element.byClass("Add Description Field", "add description field");
	    public static EnhancedBy PHOTOS = Element.byClass("Add Photo Button", "photo field");
	    public static EnhancedBy CHOOSE_PRODUCT = Element.byClass("Add Product Dropdown", "add product field");
	    public static EnhancedBy SAVE_BUTTON = Element.byClass("Save", "save button");
	    public static EnhancedBy DONE_BUTTON = Element.byClass("Done", "done button");
	    public static EnhancedBy PAY_BUTTON = Element.byClass("Pay", "pay button");
	    public static EnhancedBy CLOSE_BUTTON = Element.byClass("Close", "close button");
	  
	    //pay amount panel
	    public static EnhancedBy CASH_BUTTON = Element.byClass("Cash", "cash button");
	    public static EnhancedBy CHEQUE_BUTTON = Element.byClass("Cheque", "cheque button");
	    public static EnhancedBy CREDIT_BUTTON = Element.byClass("Credit", "credit button");
	    public static EnhancedBy TOTAL_FIELD = Element.byClass("total amount", "total field");
	}

	
	
	/**
	 * 
	 * @param estimate
	 */
	public void addEstimate(EstimateObject estimate) {
		
		Helper.clickAndExpect(InstallsPanel.byAddEstimateButton(), elements.CUSTOMER_NAME);
		setEstimateFields(estimate);
		Helper.formSubmit(elements.SAVE_BUTTON, elements.CLOSE_BUTTON);
		Helper.formSubmit(elements.CLOSE_BUTTON, elements.PAY_BUTTON);
		payEstimate(estimate);
	}
	
	/**
	 * sets payment panel fields
	 * @param estimate
	 */
	public void payEstimate(EstimateObject estimate) {
		
		Helper.formSubmit(elements.PAY_BUTTON, elements.CASH_BUTTON);
		Helper.clearAndSetField(elements.TOTAL_FIELD, estimate.total);
		selectPaymentMethod(estimate);
	}
	
	/**
	 * sets estimation fields
	 * @param estimate   
	 */
	public void setEstimateFields(EstimateObject estimate) {
		
		Helper.setField(elements.TITLE, estimate.title);
		Helper.selectDropDown(estimate.customerName, elements.CUSTOMER_NAME, elements.DROP_DOWN_OPTION);
		Helper.selectDropDown(estimate.customerSite, elements.CUSTOMER_SITE, elements.DROP_DOWN_OPTION);
		Helper.clearAndSetField(elements.ADDRESS, estimate.address);
		Helper.clearAndSetField(elements.CITY, estimate.city);
		Helper.clearAndSetField(elements.POSTAL_CODE, estimate.postalCode);
		Helper.clearAndSetField(elements.PHONE_NUMBER, estimate.phoneNumber);
		Helper.clearAndSetField(elements.EMAIL, estimate.email);
		Helper.setField(elements.DESCRIPTION, estimate.addDescription);
		selectProduct(estimate);
	}
	
	public void selectPaymentMethod(EstimateObject estimate) {
		switch (estimate.payment) {
		case CASH:
			Helper.formSubmit(elements.CASH_BUTTON, elements.CLOSE_BUTTON);
			break;
		case CHEQUE:
			Helper.formSubmit(elements.CHEQUE_BUTTON, elements.CLOSE_BUTTON);
			break;
		case CREDIT:
			Helper.formSubmit(elements.CREDIT_BUTTON, elements.CLOSE_BUTTON);
			break;
		}
	}
	
	public void selectProduct(EstimateObject estimate) {
		Helper.selectDropDown(estimate.product.productIndexInList, elements.CHOOSE_PRODUCT, elements.DROP_DOWN_OPTION);
	}
}