package main.main_ios.Panels;


import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;

import main.main_ios.GaiaIos;
import main.main_ios.objects.InstallsObject;
import main.main_ios.objects.SiteObject;

public class InstallsPanel {

	GaiaIos manager;

	public InstallsPanel( GaiaIos manager) {
		this.manager = manager;

	}
	
	public static class elements {

		//Main installs panel
		public static EnhancedBy ADD_ESTIMATE_BUTTON = Element.byAccessibility("+ Add Estimate", "add estimate");
		public static EnhancedBy SELECT_SITE_BUTTON = Element.byAccessibility("Select Site", "select side");
		public static EnhancedBy ADD_PRODUCTS_BUTTON = Element.byAccessibility("+ Add Product", "add estimate");

		
		//Pop-up pick a site window
		public static EnhancedBy SITE_NAME_BUTTON = Element.byAccessibility(SiteObject.RANDOM_SITE, "site name");
		public static EnhancedBy CLOSE_BUTTON = Element.byAccessibility("Close", "close");
		
		
		//Customer info pop-up
		public static EnhancedBy TITLE_OF_ESTIMATE_FIELD = Element.byAccessibility("Estimation Title", "title of estimate");
		public static EnhancedBy CUSTOMER_SITE_BUTTON = Element.byClass("XCUIElementTypeOther", "6 customer site");
		public static EnhancedBy SITE_NAME_DDL = Element.byAccessibility("Customer Dropdown", "site name");
		public static EnhancedBy CUSTOMER_NAME_DDL = Element.byAccessibility("Site Dropdown", "customer name");
		public static EnhancedBy PHONE_NUMBER_FIELD = Element.byAccessibility("Phone Number Field", "phone number");
		public static EnhancedBy EMAIL_FIELD = Element.byAccessibility("Email Field", "email");
		public static EnhancedBy ADD_DESCRIPTION_FIELD = Element.byAccessibility("Add Description Field", "add description");
		public static EnhancedBy PHOTOS_ICON = Element.byAccessibility("Add Photo Button", "photos");
		public static EnhancedBy PRODUCTS_DDL = Element.byClass("XCUIElementTypeButton ", "7 products");
		public static EnhancedBy EMPLOYEES_DDL = Element.byClass("XCUIElementTypeButton ", "8 employees");
		public static EnhancedBy SAVE_BUTTON = Element.byAccessibility("Save", "save");
		public static EnhancedBy SEND_BUTTON = Element.byAccessibility("Send", "send");
		public static EnhancedBy PROCESS_PAYMENT_BUTTON = Element.byAccessibility("Process Payment", "process payment");
		

		//Pick a photo pop-up
		public static EnhancedBy SELECT_FROM_LIBRARY_BUTTON = Element.byAccessibility("Select from Library", "select from library");
		public static EnhancedBy PHOTO_CATEGOTY_ICON = Element.byAccessibility("Moments", "photo category");
		public static EnhancedBy PHOTO = Element.byAccessibility("Photo, Landscape, October 09, 2009, 2:09 PM", "photo");
	}
	
	public void addEstimate (InstallsObject installs) {
		
		Helper.clickAndExpect(elements.ADD_ESTIMATE_BUTTON, elements.TITLE_OF_ESTIMATE_FIELD);
		Helper.setField(elements.TITLE_OF_ESTIMATE_FIELD, installs.titleOfEstimate);
		Helper.setField(elements.PHONE_NUMBER_FIELD, installs.phoneNumber);
		Helper.setField(elements.ADD_DESCRIPTION_FIELD, installs.description);
		Helper.clickAndExpect(elements.PHOTOS_ICON, elements.SELECT_FROM_LIBRARY_BUTTON);
		Helper.clickAndExpect(elements.SELECT_FROM_LIBRARY_BUTTON, elements.PHOTO_CATEGOTY_ICON);
		Helper.clickAndExpect(elements.PHOTO_CATEGOTY_ICON, elements.PHOTO);
		Helper.clickAndExpect(elements.PHOTO, elements.SAVE_BUTTON);
		
		
	
		
		
		
	}

}
