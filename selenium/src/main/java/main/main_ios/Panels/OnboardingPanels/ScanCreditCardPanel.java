package main.java.main.main_ios.Panels.OnboardingPanels;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.java.main.main_ios.GaiaIos;
import main.java.main.main_ios.objects.CompanyObjectIOS;

public class ScanCreditCardPanel {
	
	GaiaIos manager;
	
	public ScanCreditCardPanel( GaiaIos manager) {
		this.manager = manager;
	}
	
	public static class elements {
		public static EnhancedBy CREDIT_CARD_SCAN_ICON = Element.byAccessibility("Button", "Credit card scan button");
		public static EnhancedBy CARD_NUMBER_FILED = Element.byClass("XCUIElementTypeTextField", "Card number");
		public static EnhancedBy MM_YY_FIELD = Element.byClass("XCUIElementTypeTextField", "MM/YY");
		public static EnhancedBy CVV_FILED = Element.byClass("XCUIElementTypeTextField", "CVV");
		public static EnhancedBy DONE_BUTTON = Element.byAccessibility("Done", "Done");
		
	}
	
	public void scanCreditCard (CompanyObjectIOS company) {
		
		Helper.clickAndExpect(elements.CREDIT_CARD_SCAN_ICON, elements.CARD_NUMBER_FILED);
		Helper.setField(company.cardNumber().get(), elements.CARD_NUMBER_FILED, 0);
		Helper.setField(company.MMYY().get(), elements.MM_YY_FIELD, 2);
		Helper.setField(company.CVV().get(), elements.CVV_FILED, 1);
		Helper.clickAndExpect(elements.DONE_BUTTON, CreditCardInformationPanel.elements.REGISTER_BUTTON);
	}

}
