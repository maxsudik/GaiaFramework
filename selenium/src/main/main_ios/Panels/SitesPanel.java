package main.main_ios.Panels;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import io.appium.java_client.MobileBy;
import main.main_ios.GaiaIos;
import main.main_ios.objects.SiteObject;

public class SitesPanel {

	GaiaIos manager;

	public SitesPanel( GaiaIos manager) {
		this.manager = manager;

	}
	
	public static class elements {
		// account list 
	    public static EnhancedBy ADD_SITE = Element.byAccessibility("+ Add Site", "add account button");
	    public static EnhancedBy SITE_LIST = Element.byClass("XCUIElementTypeStaticText", "site list");
	    public static EnhancedBy SEARCH_FIELD = Element.byClass("XCUIElementTypeSearchField", "search field");
	    
		//account details (information)
	    public static EnhancedBy SITENAME_FIELD = Element.byClass("XCUIElementTypeTextField", "site name field");
	    public static EnhancedBy STREET_FIELD = Element.byClass("XCUIElementTypeTextField", "street field");
	    public static EnhancedBy POSTAL_CODE_FIELD = Element.byClass("XCUIElementTypeTextField", "postal code field");
	    
	    public static EnhancedBy CITY_FIELD = Element.byClass("XCUIElementTypeTextField", "city field");
	    public static EnhancedBy STATE_FIELD = Element.byClass("XCUIElementTypeTextField", "state field");
	    public static EnhancedBy COUNTRY_FIELD = Element.byClass("XCUIElementTypeTextField", "country field");
	    
	    public static EnhancedBy Save_BUTTON = Element.byAccessibility("Save", "save button");
	    public static EnhancedBy CANCEL_BUTTON = Element.byAccessibility("Cancel", "cancel button");
	    public static EnhancedBy CLOSE_BUTTON = Element.byAccessibility("Close", "close button");

		public static EnhancedBy bySite(String site) {
			return Element.bySelector(MobileBy.AccessibilityId(site), site);
		} 
	}


	
	public void addSite(SiteObject site) {
		
		Helper.clickAndExpect(elements.ADD_SITE, elements.Save_BUTTON);
		setField(site);
		Helper.formSubmit(elements.Save_BUTTON, elements.CLOSE_BUTTON);
		Helper.formSubmit(elements.CLOSE_BUTTON, elements.ADD_SITE);
	}
	
	public void setField(SiteObject site) {
		
		Helper.setField(site.sitename, elements.SITENAME_FIELD, 0);
		Helper.setField(site.street, elements.STREET_FIELD, 1);	
		Helper.setField(site.postalCode, elements.POSTAL_CODE_FIELD, 2);	
		Helper.setField(site.city, elements.CITY_FIELD, 3);	
		Helper.setField(site.state, elements.STATE_FIELD, 4);	
		Helper.setField(site.country, elements.COUNTRY_FIELD, 5);	
	}
	
	public void searchSite(SiteObject site) {
		Helper.setField(elements.SEARCH_FIELD, site.sitename);	
	}
}