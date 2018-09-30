package main.main_ios.Panels.OnboardingPanels;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;

public class CreditCardInfoPanel {
	
	GaiaIos manager;
	
	public CreditCardInfoPanel( GaiaIos manager) {
		this.manager = manager;
	}

	public static class elements {
		public static EnhancedBy SCAN_ID = Element.byAccessibility("scanId", "scanId");
		public static EnhancedBy SELECT_FROM_LIBRARY_BUTTON = Element.byAccessibility("Select from Library", "Select from Library");
		public static EnhancedBy MONENTS_ICON = Element.byAccessibility("Moments", "Moments");
		public static EnhancedBy PHOTO_ICON = Element.byAccessibility("Photo, Landscape, October 09, 2009, 2:09 PM", "Photo, Landscape, October 09, 2009, 2:09 PM");
		public static EnhancedBy SKIP_BUTTON = Element.byAccessibility("Skip", "Skip");
		
	}
	
	public void scanID() {
		
		Helper.clickAndExpect(elements.SCAN_ID, elements.SELECT_FROM_LIBRARY_BUTTON);
		Helper.clickAndExpect(elements.SELECT_FROM_LIBRARY_BUTTON, elements.MONENTS_ICON);
		Helper.clickAndExpect(elements.MONENTS_ICON, elements.PHOTO_ICON);
		Helper.clickAndExpect(elements.PHOTO_ICON, elements.SCAN_ID);
		Helper.clickAndExpect(elements.SCAN_ID, elements.SKIP_BUTTON);
		Helper.clickAndExpect(elements.SKIP_BUTTON, CompanyAddressPanel.elements.ADDRESS_LINE_1_FIELD);
	}
}
