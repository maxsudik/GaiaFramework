package main.main_ios.Panels.OnboardingPanels;

import org.inferred.freebuilder.FreeBuilder;

import core.helpers.Element;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;

@FreeBuilder
public class CompanyAddressPanel {
	
GaiaIos manager;
	
	public CompanyAddressPanel( GaiaIos manager) {
		this.manager = manager;
	}
	
	public static  EnhancedBy ADDRESS_LINE_1_FIELD = Element.byClass("XCUIElementTypeTextField", "Address Field");
	public static  EnhancedBy ADDRESS_LINE_2_FIELD = Element.byClass("XCUIElementTypeTextField", "Product Name Field");
	public static  EnhancedBy CITY_FIELD = Element.byClass("XCUIElementTypeTextField", "City");
	public static  EnhancedBy COUNTRY_DDL = Element.byClass("XCUIElementTypeButton", "Country");
	public static EnhancedBy withCanadaDDLMI(String country) {
		return Element.byAccessibility(country, country);
	}
	public static  EnhancedBy STATE_DDL = Element.byClass("XCUIElementTypeButton", "State");
	public static  EnhancedBy POSTAL_CODE_FIELD = Element.byClass("XCUIElementTypeTextField", "Postal Code");
	public static  EnhancedBy CONFIRM_BUTTON = Element.byClass("XCUIElementTypeButton", "Confirm");
	
	

}
