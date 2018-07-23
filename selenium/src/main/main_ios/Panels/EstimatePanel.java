package main.main_ios.Panels;

import core.helpers.ClickHelper;
import core.helpers.Element;
import core.helpers.FormHelper;
import core.webElement.EnhancedBy;
import io.appium.java_client.MobileBy;
import main.main_ios.objects.EstimateObject;

public class EstimatePanel {

	GaiaManager_ios manager;

	public EstimatePanel( GaiaManager_ios manager) {
		this.manager = manager;

	}

	private static final String TITLE = "Estimation Title";
	private static final String CUSTOMER_NAME = "Customer Dropdown";
	private static final String DROP_DOWN_OPTION = "XCUIElementTypeCell";
	private static final String CUSTOMER_SITE = "Site Dropdown";
	private static final String ADDRESS = "Address Field";
	private static final String CITY = "Address Two";
	private static final String POSTAL_CODE = "Address Three";
	private static final String PHONE_NUMBER = "Phone Number Field";
	private static final String EMAIL = "Email Field";
	private static final String DESCRIPTION = "Add Description Field";
	private static final String PHOTOS = "Add Photo Button";
	private static final String CHOOSE_PRODUCT = "Add Product Dropdown";
	private static final String SAVE_BUTTON = "Save";
	private static final String DONE_BUTTON = "Done";
	private static final String PAY_BUTTON = "Pay";
	private static final String CLOSE_BUTTON = "Close";
	
	//pay amount panel
	private static final String CASH_BUTTON = "Cash";
	private static final String CHEQUE_BUTTON = "Cheque";
	private static final String CREDIT_BUTTON = "Credit";
	private static final String TOTAL_FIELD = "total amount";
	
	public EnhancedBy byTitleField() {
		return Element.bySelector(MobileBy.AccessibilityId(TITLE), "title field");
	}

	public EnhancedBy byCustomerNameField() {
		return Element.bySelector(MobileBy.AccessibilityId(CUSTOMER_NAME), "customer name field");
	}
	
	public EnhancedBy byDropDownOption() {
		return Element.bySelector(MobileBy.className(DROP_DOWN_OPTION), "drop down option");
	}

	public EnhancedBy byCustomerSiteField() {
		return Element.bySelector(MobileBy.AccessibilityId(CUSTOMER_SITE), "customer site field");
	}

	public EnhancedBy byAddressField() {
		return Element.bySelector(MobileBy.AccessibilityId(ADDRESS), "address field");
	}
	
	public EnhancedBy byCityField() {
		return Element.bySelector(MobileBy.AccessibilityId(CITY), "city field");
	}
	
	public EnhancedBy byPostalCodeField() {
		return Element.bySelector(MobileBy.AccessibilityId(POSTAL_CODE), "postal code field");
	}
	
	public EnhancedBy byPhoneNumberField() {
		return Element.bySelector(MobileBy.AccessibilityId(PHONE_NUMBER), "phone number field");
	}
	
	public EnhancedBy byEmailField() {
		return Element.bySelector(MobileBy.AccessibilityId(EMAIL), "email field");
	}
	
	public EnhancedBy byDescriptionField() {
		return Element.bySelector(MobileBy.AccessibilityId(DESCRIPTION), "description field");
	}
	
	public EnhancedBy byPhotoField() {
		return Element.bySelector(MobileBy.AccessibilityId(PHOTOS), "photo field");
	}
	
	public EnhancedBy byChooseProductField() {
		return Element.bySelector(MobileBy.AccessibilityId(CHOOSE_PRODUCT), "choose product field");
	}
	
	public EnhancedBy bySaveButton() {
		return Element.bySelector(MobileBy.AccessibilityId(SAVE_BUTTON), "save button");
	}
	
	public EnhancedBy byDoneButton() {
		return Element.bySelector(MobileBy.AccessibilityId(DONE_BUTTON), "done button");
	}
	
	public EnhancedBy byPayButton() {
		return Element.bySelector(MobileBy.AccessibilityId(PAY_BUTTON), "pay button");
	}
	
	public EnhancedBy byCloseButton() {
		return Element.bySelector(MobileBy.AccessibilityId(CLOSE_BUTTON), "close button");
	}
	
	public EnhancedBy byCashButton() {
		return Element.bySelector(MobileBy.AccessibilityId(CASH_BUTTON), "cash button");
	}
	
	public EnhancedBy byChequeButton() {
		return Element.bySelector(MobileBy.AccessibilityId(CHEQUE_BUTTON), "cheque button");
	}
	
	public EnhancedBy byCreditButton() {
		return Element.bySelector(MobileBy.AccessibilityId(CREDIT_BUTTON), "credit button");
	}
	
	public EnhancedBy byTotalField() {
		return Element.bySelector(MobileBy.AccessibilityId(TOTAL_FIELD), "total field");
	}
	
	
	/**
	 * 
	 * @param estimate
	 */
	public void addEstimate(EstimateObject estimate) {
		
		ClickHelper.clickAndExpect(InstallsPanel.byAddEstimateButton(), byCustomerNameField());
		setEstimateFields(estimate);
		FormHelper.formSubmit(bySaveButton(), byCloseButton());
		FormHelper.formSubmit(byCloseButton(), byPayButton());
		payEstimate(estimate);
	}
	
	/**
	 * sets payment panel fields
	 * @param estimate
	 */
	public void payEstimate(EstimateObject estimate) {
		
		FormHelper.formSubmit(byPayButton(), byCashButton());
		FormHelper.clearAndSetField(estimate.total, byTotalField());
		selectPaymentMethod(estimate);
	}
	
	/**
	 * sets estimation fields
	 * @param estimate   
	 */
	public void setEstimateFields(EstimateObject estimate) {
		
		FormHelper.setField(estimate.title, byTitleField());
		FormHelper.selectDropDown(estimate.customerName, byCustomerNameField(), byDropDownOption());
		FormHelper.selectDropDown(estimate.customerSite, byCustomerSiteField(), byDropDownOption());
		FormHelper.clearAndSetField(estimate.address, byAddressField());
		FormHelper.clearAndSetField(estimate.city, byCityField());
		FormHelper.clearAndSetField(estimate.postalCode, byPostalCodeField());
		FormHelper.clearAndSetField(estimate.phoneNumber, byPhoneNumberField());
		FormHelper.clearAndSetField(estimate.email, byEmailField());
		FormHelper.setField(estimate.addDescription, byDescriptionField());
		selectProduct(estimate);
	}
	
	public void selectPaymentMethod(EstimateObject estimate) {
		switch (estimate.payment) {
		case CASH:
			FormHelper.formSubmit(byCashButton(), byCloseButton());
			break;
		case CHEQUE:
			FormHelper.formSubmit(byChequeButton(), byCloseButton());
			break;
		case CREDIT:
			FormHelper.formSubmit(byCreditButton(), byCloseButton());
			break;
		}
	}
	
	public void selectProduct(EstimateObject estimate) {
		FormHelper.selectDropDown(estimate.product.productIndexInList, byChooseProductField(), byDropDownOption());
	}
}