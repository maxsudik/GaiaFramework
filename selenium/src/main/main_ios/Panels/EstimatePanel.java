package main.main_ios.Panels;

import core.helpers.ElementHelper;
import core.helpers.FormHelper;
import core.helpers.Helper;
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
		return ElementHelper.BySelector(MobileBy.AccessibilityId(TITLE), "title field");
	}

	public EnhancedBy byCustomerNameField() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(CUSTOMER_NAME), "customer name field");
	}
	
	public EnhancedBy byDropDownOption() {
		return ElementHelper.BySelector(MobileBy.className(DROP_DOWN_OPTION), "drop down option");
	}

	public EnhancedBy byCustomerSiteField() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(CUSTOMER_SITE), "customer site field");
	}

	public EnhancedBy byAddressField() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(ADDRESS), "address field");
	}
	
	public EnhancedBy byCityField() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(CITY), "city field");
	}
	
	public EnhancedBy byPostalCodeField() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(POSTAL_CODE), "postal code field");
	}
	
	public EnhancedBy byPhoneNumberField() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(PHONE_NUMBER), "phone number field");
	}
	
	public EnhancedBy byEmailField() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(EMAIL), "email field");
	}
	
	public EnhancedBy byDescriptionField() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(DESCRIPTION), "description field");
	}
	
	public EnhancedBy byPhotoField() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(PHOTOS), "photo field");
	}
	
	public EnhancedBy byChooseProductField() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(CHOOSE_PRODUCT), "choose product field");
	}
	
	public EnhancedBy bySaveButton() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(SAVE_BUTTON), "save button");
	}
	
	public EnhancedBy byDoneButton() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(DONE_BUTTON), "done button");
	}
	
	public EnhancedBy byPayButton() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(PAY_BUTTON), "pay button");
	}
	
	public EnhancedBy byCloseButton() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(CLOSE_BUTTON), "close button");
	}
	
	public EnhancedBy byCashButton() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(CASH_BUTTON), "cash button");
	}
	
	public EnhancedBy byChequeButton() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(CHEQUE_BUTTON), "cheque button");
	}
	
	public EnhancedBy byCreditButton() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(CREDIT_BUTTON), "credit button");
	}
	
	public EnhancedBy byTotalField() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(TOTAL_FIELD), "total field");
	}
	
	
	/**
	 * 
	 * @param estimate
	 */
	public void addEstimate(EstimateObject estimate) {
		
		Helper.clickAndExpect(InstallsPanel.byAddEstimateButton(), byCustomerNameField());
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