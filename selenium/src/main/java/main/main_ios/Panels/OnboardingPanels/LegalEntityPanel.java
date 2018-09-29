package main.java.main.main_ios.Panels.OnboardingPanels;



import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.java.main.main_ios.GaiaIos;
import main.java.main.main_ios.objects.CompanyObjectIOS;

public class LegalEntityPanel {

GaiaIos manager;
	
	public LegalEntityPanel ( GaiaIos manager) {
		this.manager = manager;
	}
	
	public static class elements{
		public static EnhancedBy LEGAL_FIRST_NAME_FIELD = Element.byClass("XCUIElementTypeTextField", "Legal First Name");
		public static EnhancedBy LEGAL_LAST_NAME_FIELD = Element.byClass("XCUIElementTypeTextField", "Legal Last Name");
		
		public static EnhancedBy BIRTHDAY_FIELD = Element.byClass("XCUIElementTypeTextField", "Birthday");
		public static EnhancedBy BIRTHDAY_MONTH_SPINNER = Element.byClass("XCUIElementTypePickerWheel", "Month");
		public static EnhancedBy BIRTHDAY_DAY_SPINNER = Element.byClass("XCUIElementTypePickerWheel", "Day");
		public static EnhancedBy BIRTHDAY_YEAR_SPINNER = Element.byClass("XCUIElementTypePickerWheel", "Year");
		public static EnhancedBy DONE_BUTTON = Element.byAccessibility("Toolbar Done Button", "Done");
		
		public static EnhancedBy LEGAL_ADDRESS_LINE_1_FIELD = Element.byClass("XCUIElementTypeTextField", "Legal Address Line 1");
		public static EnhancedBy LEGAL_ADDRESS_LINE_2_FIELD = Element.byClass("XCUIElementTypeTextField", "Legal Address Line 2");
		public static EnhancedBy LEGAL_CITY_FIELD = Element.byClass("XCUIElementTypeTextField", "Legal City");
		
		public static EnhancedBy LEGAL_COUNTRY_DDL = Element.byClass("XCUIElementTypeButton", "Legal Country");
		public static EnhancedBy withLegalCountryDDLMI(String legalCountry) {
			return Element.byAccessibility(legalCountry, legalCountry);
	}
		
		public static EnhancedBy LEGAL_STATE_DDL = Element.byClass("XCUIElementTypeButton", "Legal State");
		public static EnhancedBy withLegalStateDDLMI(String legalState) {
			return Element.byAccessibility(legalState, legalState);
	}
		
		public static EnhancedBy LEGAL_POSTAL_CODE_FIELD = Element.byClass("XCUIElementTypeTextField", "Legal Postal Code");
		public static EnhancedBy AUTHENTICATE_BUTTON = Element.byAccessibility("Authenticate", "Authenticate");
	}
	
	public void enterLegalEntity(CompanyObjectIOS company) {
		
		Helper.setField(company.legalFirstName().get(), elements.LEGAL_FIRST_NAME_FIELD, 0);
		Helper.setField(company.legalLastName().get(), elements.LEGAL_LAST_NAME_FIELD, 1);
		Helper.clickAndExpect(elements.BIRTHDAY_FIELD, 2, elements.BIRTHDAY_MONTH_SPINNER);
		Helper.setField(company.leaglBirthdayMonth().get(), elements.BIRTHDAY_MONTH_SPINNER, 0);
		Helper.setField(company.leaglBirthdayDay().get(), elements.BIRTHDAY_DAY_SPINNER, 1);
		Helper.setField(company.leaglBirthdayYear().get(), elements.BIRTHDAY_YEAR_SPINNER, 2);
		Helper.clickAndExpect(elements.DONE_BUTTON, elements.LEGAL_ADDRESS_LINE_1_FIELD);
		Helper.setField(company.legalAddressLine1().get(), elements.LEGAL_ADDRESS_LINE_1_FIELD, 3);
		Helper.setField(company.legalAddressLine2().get(), elements.LEGAL_ADDRESS_LINE_2_FIELD, 4);
		Helper.setField(company.legalCity().get(), elements.LEGAL_CITY_FIELD, 5);
		Helper.clickAndExpect(elements.LEGAL_COUNTRY_DDL, 0, elements.withLegalCountryDDLMI(company.legalCountry().get()));
		Helper.clickAndExpect(elements.withLegalCountryDDLMI(company.legalCountry().get()), elements.LEGAL_STATE_DDL);
		Helper.clickAndExpect(elements.LEGAL_STATE_DDL, 1, elements.withLegalStateDDLMI(company.legalState().get()));
		Helper.clickAndExpect(elements.withLegalStateDDLMI(company.legalState().get()), elements.LEGAL_POSTAL_CODE_FIELD);
		Helper.setField(company.legalPostalCode().get(), elements.LEGAL_POSTAL_CODE_FIELD, 10);
		Helper.clickAndExpect(elements.AUTHENTICATE_BUTTON, ScanCreditCardPanel.elements.CREDIT_CARD_SCAN_ICON);
		
		
	}
}
