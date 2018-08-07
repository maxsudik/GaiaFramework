package main.main_ios.Panels;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;
import main.main_ios.objects.ProductObject;

public class ProductPanel {

	GaiaIos manager;

	public ProductPanel( GaiaIos manager) {
		this.manager = manager;

	}
	
	public static class elements {
	    public static EnhancedBy PRODUCT_TYPE_PLANT = Element.byAccessibility("Plant Button", "product type plant");
	    public static EnhancedBy PRODUCT_TYPE_MATERIAL = Element.byXpath("//XCUIElementTypeButton[@name=\"Material\"])[2]", "product type material");
	    public static EnhancedBy PRODUCT_TYPE_LABOR = Element.byAccessibility("Labor Button", "product type labor");
	    public static EnhancedBy PRODUCT_TYPE_DELIVERY = Element.byAccessibility("Delivery Button", "product type delivery");
	    public static EnhancedBy PRODUCT_TYPE_DISPOSAL = Element.byAccessibility("Disposal Button", "product type disposal");
	    public static EnhancedBy PRODUCT_TYPE_OTHER = Element.byAccessibility("Other Button", "product type other");
	    public static EnhancedBy PRODUCT_NAME = Element.byAccessibility("Product Name Field", "product name");
	    public static EnhancedBy PRICE_PER_UNIT = Element.byAccessibility("Price Per Unit Field", "price per unit");
	    public static EnhancedBy CURRENCY_DROPDOWN_BUTTON = Element.byAccessibility("CurrencyDropDown", "currency drop down button");
	    public static EnhancedBy CURRENCY_DROPDOWN_OPTION = Element.byClass("XCUIElementTypeCell", "currency drop down option");
	    public static EnhancedBy UNIT = Element.byAccessibility("Unit Field", "unit option");
	    public static EnhancedBy SUPPLIER = Element.byAccessibility("Supplier Field", "supplier field");
	    public static EnhancedBy ADDITIONAL_NOTES = Element.byAccessibility("Additional Notes Field", "additional notes");
	    public static EnhancedBy SAVE_BUTTON = Element.byAccessibility("Save", "save button");
	    public static EnhancedBy CANCEL_BUTTON = Element.byAccessibility("Cancel", "cancel button");
	    public static EnhancedBy CLOSE_BUTTON = Element.byAccessibility("Close", "close button");

	}

    /**
     * 
     * @param product
     */
	public void addProduct(ProductObject product) {

		Helper.clickAndExpect(InstallsPanel.byAddProductButton(), elements.PRODUCT_NAME);
		setProductFields(product);
		Helper.formSubmit(elements.SAVE_BUTTON, elements.CLOSE_BUTTON);
	}
	
	public void setProductFields(ProductObject product) {
		
		selectProductType(product);
		Helper.setField(elements.PRODUCT_NAME, product.productName);
		Helper.setField(elements.PRICE_PER_UNIT, product.pricePerUnit);
		Helper.selectDropDown(product.currency, elements.CURRENCY_DROPDOWN_BUTTON, elements.CURRENCY_DROPDOWN_OPTION);
		Helper.setField(elements.UNIT, product.unit);
		Helper.setField(elements.SUPPLIER, product.supplier);
		Helper.setField(elements.ADDITIONAL_NOTES, product.additionalNotes);
	}
	
	public void selectProductType(ProductObject product) {
		if(product.productType == null) return;
		switch (product.productType) {
		case PLANT:
			Helper.formSubmit(elements.PRODUCT_TYPE_PLANT, elements.SAVE_BUTTON);
			break;
		case MATERIAL:
			Helper.formSubmit(elements.PRODUCT_TYPE_MATERIAL, elements.SAVE_BUTTON);
			break;
		case LABOR:
			Helper.formSubmit(elements.PRODUCT_TYPE_LABOR, elements.SAVE_BUTTON);
			break;
		case DELIVERY:
			Helper.formSubmit(elements.PRODUCT_TYPE_DELIVERY, elements.SAVE_BUTTON);
			break;
		case DISPOSAL:
			Helper.formSubmit(elements.PRODUCT_TYPE_DISPOSAL, elements.SAVE_BUTTON);
			break;
		case OTHER:
			Helper.formSubmit(elements.PRODUCT_TYPE_OTHER, elements.SAVE_BUTTON);
			break;
		}
	}
}