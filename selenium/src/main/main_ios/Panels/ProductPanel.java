package main.main_ios.Panels;

import core.helpers.ClickHelper;
import core.helpers.Element;
import core.helpers.FormHelper;
import core.webElement.EnhancedBy;
import io.appium.java_client.MobileBy;
import main.main_ios.objects.ProductObject;

public class ProductPanel {

	GaiaManager_ios manager;

	public ProductPanel( GaiaManager_ios manager) {
		this.manager = manager;

	}

	private static final String PRODUCT_TYPE_PLANT = "Plant Button";
	private static final String PRODUCT_TYPE_MATERIAL	 = "(//XCUIElementTypeButton[@name=\"Material\"])[2]";
	private static final String PRODUCT_TYPE_LABOR = "Labor Button";
	private static final String PRODUCT_TYPE_DELIVERY = "Delivery Button";
	private static final String PRODUCT_TYPE_DISPOSAL = "Disposal Button";
	private static final String PRODUCT_TYPE_OTHER = "Other Button";
	private static final String PRODUCT_NAME = "Product Name Field";
	private static final String PRICE_PER_UNIT = "Price Per Unit Field";
	private static final String CURRENCY_DROPDOWN_BUTTON = "CurrencyDropDown";
	private static final String CURRENCY_DROPDOWN_OPTION = "XCUIElementTypeCell";
	private static final String UNIT = "Unit Field";
	private static final String SUPPLIER = "Supplier Field";
	private static final String ADDITIONAL_NOTES = "Additional Notes Field";
	private static final String SAVE_BUTTON = "Save";
	private static final String CANCEL_BUTTON = "Cancel";
	private static final String CLOSE_BUTTON = "Close";


	public EnhancedBy byProductTypePlant() {
		return Element.bySelector(MobileBy.AccessibilityId(PRODUCT_TYPE_PLANT), "product type plant");
	}
	
	public EnhancedBy byProductTypeMaterial() {
		return Element.bySelector(MobileBy.xpath(PRODUCT_TYPE_MATERIAL), "product type material");
	}
	
	public EnhancedBy byProductTypeLabor() {
		return Element.bySelector(MobileBy.AccessibilityId(PRODUCT_TYPE_LABOR), "product type labor");
	}
	
	public EnhancedBy byProductTypeDelivery() {
		return Element.bySelector(MobileBy.AccessibilityId(PRODUCT_TYPE_DELIVERY), "product type delivery");
	}
	
	public EnhancedBy byProductTypeDisposal() {
		return Element.bySelector(MobileBy.AccessibilityId(PRODUCT_TYPE_DISPOSAL), "product type disposal");
	}
	
	public EnhancedBy byProductTypeOther() {
		return Element.bySelector(MobileBy.AccessibilityId(PRODUCT_TYPE_OTHER), "product type other");
	}

	public EnhancedBy byProductNameField() {
		return Element.bySelector(MobileBy.AccessibilityId(PRODUCT_NAME), "product name");
	}

	public EnhancedBy byPricePerUnitField() {
		return Element.bySelector(MobileBy.AccessibilityId(PRICE_PER_UNIT), "price per unit");
	}

	public EnhancedBy byCurrencyDropDownButton() {
		return Element.bySelector(MobileBy.AccessibilityId(CURRENCY_DROPDOWN_BUTTON), "currency drop down button");
	}
	
	public EnhancedBy byCurrencyDropDownOption() {
		return Element.bySelector(MobileBy.className(CURRENCY_DROPDOWN_OPTION), "currency drop down option");
	}
	
	public EnhancedBy byUnitOption() {
		return Element.bySelector(MobileBy.AccessibilityId(UNIT), "unit option");
	}
	
	public EnhancedBy bySupplierField() {
		return Element.bySelector(MobileBy.AccessibilityId(SUPPLIER), "supplier field");
	}
	
	public EnhancedBy byAdditionalNotesField() {
		return Element.bySelector(MobileBy.AccessibilityId(ADDITIONAL_NOTES), "additional notes");
	}
	
	public EnhancedBy bySaveButton() {
		return Element.bySelector(MobileBy.AccessibilityId(SAVE_BUTTON), "save button");
	}
	
	public EnhancedBy byCancelButton() {
		return Element.bySelector(MobileBy.AccessibilityId(CANCEL_BUTTON), "cancel button");
	}
	
	public static EnhancedBy byCloseButton() {
		return Element.bySelector(MobileBy.AccessibilityId(CLOSE_BUTTON), "close button");
	}

    /**
     * 
     * @param product
     */
	public void addProduct(ProductObject product) {

		ClickHelper.clickAndExpect(InstallsPanel.byAddProductButton(), byProductNameField());
		setProductFields(product);
		FormHelper.formSubmit(bySaveButton(), byCloseButton());
	}
	
	public void setProductFields(ProductObject product) {
		
		selectProductType(product);
		FormHelper.setField(product.productName, byProductNameField());
		FormHelper.setField(product.pricePerUnit, byPricePerUnitField());
		FormHelper.selectDropDown(product.currency, byCurrencyDropDownButton(), byCurrencyDropDownOption());
		FormHelper.setField(product.unit, byUnitOption());
		FormHelper.setField(product.supplier, bySupplierField());
		FormHelper.setField(product.additionalNotes, byAdditionalNotesField());
	}
	
	public void selectProductType(ProductObject product) {
		if(product.productType == null) return;
		switch (product.productType) {
		case PLANT:
			FormHelper.formSubmit(byProductTypePlant(), bySaveButton());
			break;
		case MATERIAL:
			FormHelper.formSubmit(byProductTypeMaterial(), bySaveButton());
			break;
		case LABOR:
			FormHelper.formSubmit(byProductTypeLabor(), bySaveButton());
			break;
		case DELIVERY:
			FormHelper.formSubmit(byProductTypeDelivery(), bySaveButton());
			break;
		case DISPOSAL:
			FormHelper.formSubmit(byProductTypeDisposal(), bySaveButton());
			break;
		case OTHER:
			FormHelper.formSubmit(byProductTypeOther(), bySaveButton());
			break;
		}
	}
}