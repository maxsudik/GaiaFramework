package main.main_ios.Panels.OnboardingPanels;

import org.openqa.selenium.WebElement;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;
import main.main_ios.objects.CompanyObjectIOS;

public class LegalEntityPanel {

GaiaIos manager;
	
	public LegalEntityPanel ( GaiaIos manager) {
		this.manager = manager;
	}
	
	public static class elements{
		public static EnhancedBy LEGAL_FIRST_NAME_FIELD = Element.byClass("XCUIElementTypeTextField", "Legal First Name");
		public static EnhancedBy LEGAL_LAST_NAME_FIELD = Element.byClass("XCUIElementTypeTextField", "Legal Last Name");
		public static EnhancedBy LEGAL_BIRTHDAY_SPINNER = Element.byClass("XCUIElementTypeTextField", "Legal Birthday Spinner");
		public static EnhancedBy LEGAL_ADDRESS_LINE_1_FIELD = Element.byClass("XCUIElementTypeTextField", "Legal Address Line 1");
		public static EnhancedBy LEGAL_ADDRESS_LINE_2_FIELD = Element.byClass("XCUIElementTypeTextField", "Legal Address Line 2");
		public static EnhancedBy LEGAL_CITY_FIELD = Element.byClass("XCUIElementTypeTextField", "Legal City");
		
		public static EnhancedBy LEGAL_COUNTRY_DDLMI = Element.byClass("XCUIElementTypeButton", "Legal Country");
		
		public static EnhancedBy withLegalCountryDDLMI(String legalCountry) {
			return Element.byAccessibility(legalCountry, legalCountry);
	}
		
		public static EnhancedBy LEGAL_STATE_DDLMI = Element.byClass("XCUIElementTypeButton", "Legal State");
		
		public static EnhancedBy withLegalStateDDLMI(String legalState) {
			return Element.byAccessibility(legalState, legalState);
	}
		
		public static EnhancedBy LEGAL_POSTAL_CODE_FIELD = Element.byClass("XCUIElementTypeTextField ", "LEgal Postal Code");
		public static EnhancedBy AUTHENTICATE_BUTTON = Element.byClass("XCUIElementTypeButton", "Authenticate");
	}
	
	public void enterLegalEntity(CompanyObjectIOS company) {
		
		Helper.setField(company.legalFirstName().get(), elements.LEGAL_FIRST_NAME_FIELD, 0);
		Helper.setField(company.legalLastName().get(), elements.LEGAL_LAST_NAME_FIELD, 1);
		
		TouchAction action =new TouchAction();
		
		
		
		  .press({x: 613, y: 1178})
		  .moveTo({x: 627: y: 1302})
		  .release()
		  .perform()
		  
		(new TouchAction(driver))
		  .press({x: 609, y: 1316})
		  .moveTo({x: 602: y: 1176})
		  .release()
		  .perform()
		  
		(new TouchAction(driver))
		  .press({x: 533, y: 1316})
		  .moveTo({x: 528: y: 1184})
		  .release()
		  .perform()
		  
		(new TouchAction(driver))
		  .press({x: 415, y: 1320})
		  .moveTo({x: 415: y: 1180})
		  .release()
		  .perform()
		
	}
}
