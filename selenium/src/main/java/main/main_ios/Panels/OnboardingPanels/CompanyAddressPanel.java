package main.java.main.main_ios.Panels.OnboardingPanels;


import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.java.main.main_ios.GaiaIos;
import main.java.main.main_ios.objects.CompanyObjectIOS;


public class CompanyAddressPanel {
	
GaiaIos manager;
	
	public CompanyAddressPanel( GaiaIos manager) {
		this.manager = manager;
	}
	
	
	public static class elements {
		public static  EnhancedBy ADDRESS_LINE_1_FIELD = Element.byAccessibility("Address Field", "Address Field 1");
		public static  EnhancedBy ADDRESS_LINE_2_FIELD = Element.byClass("XCUIElementTypeTextField", "Address Field 2");
		public static  EnhancedBy CITY_FIELD = Element.byClass("XCUIElementTypeTextField", "City");
	
		public static  EnhancedBy COUNTRY_DDL = Element.byClass("XCUIElementTypeButton", "Country");
		public static EnhancedBy withCountryDDLMI(String country) {
			return Element.byAccessibility(country, country);
	}
	
		public static  EnhancedBy STATE_PROVINCE_DDL = Element.byClass("XCUIElementTypeButton", "State");
		public static EnhancedBy withProvinceDDLMI(String province) {
			return Element.byAccessibility(province, province);
	}
	
		public static  EnhancedBy POSTAL_CODE_FIELD = Element.byClass("XCUIElementTypeTextField", "Postal Code");
		public static  EnhancedBy CONFIRM_BUTTON = Element.byAccessibility("Confirm", "Confirm");
	}
	
	public void enterCompanyAddress(CompanyObjectIOS company) {
		
		Helper.setField(elements.ADDRESS_LINE_1_FIELD, company.addressLine1().get());
		Helper.setField(company.addressLine2().get(), elements.ADDRESS_LINE_2_FIELD, 1);
		Helper.setField(company.city().get(), elements.CITY_FIELD, 2);
		Helper.clickAndExpect(elements.COUNTRY_DDL, 0, elements.withCountryDDLMI(company.country().get()));
		Helper.clickAndExpect(elements.withCountryDDLMI(company.country().get()), elements.STATE_PROVINCE_DDL);
		Helper.clickAndExpect(elements.STATE_PROVINCE_DDL, 1, elements.withProvinceDDLMI(company.state().get()));
		Helper.clickAndExpect(elements.withProvinceDDLMI(company.state().get()), elements.POSTAL_CODE_FIELD);
		Helper.setField(company.postalCode().get(), elements.POSTAL_CODE_FIELD, 7);
		Helper.clickAndExpect(elements.CONFIRM_BUTTON, CompanyBankInformationPanel.elements.AUTHENTICATE_BUTTON);
	}
	
}
