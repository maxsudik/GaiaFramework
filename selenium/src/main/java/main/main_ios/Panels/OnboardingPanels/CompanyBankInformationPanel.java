package main.main_ios.Panels.OnboardingPanels;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;
import main.main_ios.objects.CompanyObjectIOS;

public class CompanyBankInformationPanel {
	
GaiaIos manager;
	
	public CompanyBankInformationPanel ( GaiaIos manager) {
		this.manager = manager;
	}
	
	public static class elements {
		public static EnhancedBy INSTITUTION_NUMBER_FIELD = Element.byAccessibility("Address Field", "Institution Number");
		public static EnhancedBy TRANSIT_NUMBER_FIELD = Element.byClass("XCUIElementTypeTextField", "Transit Number");
		public static EnhancedBy ACCOUNT_NUMBER_FIELD = Element.byClass("XCUIElementTypeTextField", "Account Number");
		public static EnhancedBy ACCOUNT_HOLDER_NAME_FIELD = Element.byClass("XCUIElementTypeTextField", "Account Holder Name");
		
		public static EnhancedBy ACCOUNT_TYPE_DDL = Element.byClass("XCUIElementTypeButton", "Account Type");
		public static EnhancedBy withAccountTypeDDLMI(String companyType) {
			return Element.byAccessibility(companyType, companyType);
	}
		
		public static EnhancedBy AUTHENTICATE_BUTTON = Element.byAccessibility("Authenticate", "Authenticate");
	}
		
		public void enterCompanyBankInformation (CompanyObjectIOS company) {
			
			Helper.setField(company.institutionNumber().get(), elements.INSTITUTION_NUMBER_FIELD, 0);
			Helper.setField(company.transitNumber().get(), elements.TRANSIT_NUMBER_FIELD, 1);
			Helper.setField(company.accountNumber().get(), elements.ACCOUNT_NUMBER_FIELD, 2);
			Helper.setField(company.accountHolderName().get(), elements.ACCOUNT_HOLDER_NAME_FIELD, 3);
			Helper.clickAndExpect(elements.ACCOUNT_TYPE_DDL, elements.withAccountTypeDDLMI(company.accountType().get()));
			Helper.clickAndExpect(elements.withAccountTypeDDLMI(company.accountType().get()), elements.AUTHENTICATE_BUTTON);
			Helper.clickAndExpect(elements.AUTHENTICATE_BUTTON, LegalEntityPanel.elements.AUTHENTICATE_BUTTON);
		
		}
}
