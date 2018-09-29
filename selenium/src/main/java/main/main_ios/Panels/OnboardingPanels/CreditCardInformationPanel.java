package main.java.main.main_ios.Panels.OnboardingPanels;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.java.main.main_ios.GaiaIos;
import main.java.main.main_ios.Panels.MainPanel;
import main.java.main.main_ios.objects.CompanyObjectIOS;

public class CreditCardInformationPanel {
	
	GaiaIos manager;
	
	public CreditCardInformationPanel( GaiaIos manager) {
		this.manager = manager;
	}
	
	public static class elements{
		
		public static EnhancedBy CREDIT_CARD_NAME_ON_CARD_FIELD = Element.byClass("XCUIElementTypeTextField", "Name on card");
		
		public static EnhancedBy CREDIT_CARD_LICENSES_DDL = Element.byClass("XCUIElementTypeTextField", "Licenses");
		public static EnhancedBy withLicensesDDLMI(String licences) {
			return Element.byAccessibility(licences, licences);
	}
		
		public static EnhancedBy CREDIT_CARD_ADDRESS_LINE_1_FIELD = Element.byClass("XCUIElementTypeTextField", "Address line 1");
		public static EnhancedBy CREDIT_CARD_ADDRESS_LINE_2_FIELD = Element.byClass("XCUIElementTypeTextField", "Address line 2");
		public static EnhancedBy CREDIT_CARD_CITY_FILED = Element.byClass("XCUIElementTypeTextField", "City");
		
		public static EnhancedBy CREDIT_CARD_COUNTRY_DDL = Element.byClass("XCUIElementTypeTextField", "Country");
		public static EnhancedBy withCountryDDLMI(String country) {
			return Element.byAccessibility(country, country);
	}
		public static EnhancedBy CREDIT_CARD_STATE_DDL = Element.byClass("XCUIElementTypeTextField", "State");
		public static EnhancedBy withSateDDLMI(String state) {
			return Element.byAccessibility(state, state);
	}
		
		public static EnhancedBy CREDIT_CARD_POSTAL_CODE_FIELD = Element.byClass("XCUIElementTypeTextField", "Postal code");
		public static EnhancedBy REGISTER_BUTTON = Element.byAccessibility("Register", "Register");

	}
	
	public void enterCreditcardInformation (CompanyObjectIOS company) {
		
		Helper.setField(company.creditCardNameOnCard().get(), elements.CREDIT_CARD_NAME_ON_CARD_FIELD, 0);
		Helper.clickAndExpect(elements.CREDIT_CARD_LICENSES_DDL, 7, elements.withLicensesDDLMI(company.creditCardLicenseDDLMI().get()));
		Helper.clickAndExpect(elements.withLicensesDDLMI(company.creditCardLicenseDDLMI().get()), elements.CREDIT_CARD_ADDRESS_LINE_1_FIELD);
		Helper.setField(company.creditCardAddressLine1().get(), elements.CREDIT_CARD_ADDRESS_LINE_1_FIELD, 9);
		Helper.setField(company.creditCardAddressLine2().get(), elements.CREDIT_CARD_ADDRESS_LINE_2_FIELD, 10);
		Helper.setField(company.creditCardCity().get(), elements.CREDIT_CARD_CITY_FILED, 11);
		Helper.clickAndExpect(elements.CREDIT_CARD_COUNTRY_DDL, 12, elements.withCountryDDLMI(company.creditCardCountry().get()));
		Helper.clickAndExpect(elements.withCountryDDLMI(company.creditCardCountry().get()), elements.CREDIT_CARD_STATE_DDL);
		Helper.clickAndExpect(elements.CREDIT_CARD_STATE_DDL, 14, elements.withSateDDLMI(company.creditCardState().get()));
		Helper.clickAndExpect(elements.withSateDDLMI(company.creditCardState().get()), elements.CREDIT_CARD_POSTAL_CODE_FIELD);
		Helper.setField(company.creditCardPostalCode().get(), elements.CREDIT_CARD_POSTAL_CODE_FIELD, 16);
		Helper.clickAndExpect(elements.REGISTER_BUTTON, MainPanel.elements.GAIA_LOGO);
	}
	

}
