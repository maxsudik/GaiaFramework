package main.main_ios.Panels;

import core.helpers.ElementHelper;
import core.helpers.FormHelper;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import io.appium.java_client.MobileBy;
import main.main_ios.objects.SiteObject;

public class SitesPanel {

	GaiaManager_ios manager;

	public SitesPanel( GaiaManager_ios manager) {
		this.manager = manager;

	}

	// account list 
	private static final String ADD_SITE = "+ Add New Site";
	private static final String SITE_LIST = "XCUIElementTypeStaticText";


	//account details (information)
	private static final String SITENAME_FIELD = "XCUIElementTypeTextField";
	private static final String STREET_FIELD = "XCUIElementTypeTextField";
	private static final String POSTAL_CODE_FIELD = "XCUIElementTypeTextField";
	
	private static final String CITY_FIELD = "XCUIElementTypeTextField";
	private static final String STATE_FIELD = "XCUIElementTypeTextField";
	private static final String COUNTRY_FIELD = "XCUIElementTypeTextField";
	
	private static final String DONE_BUTTON = "Done";
	private static final String CANCEL_BUTTON = "Cancel";
	private static final String CLOSE_BUTTON = "Close";

	public static EnhancedBy byAddSiteButton() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(ADD_SITE), "add account button");
	}
	
	public static EnhancedBy bySiteList() {
		return ElementHelper.BySelector(MobileBy.className(SITE_LIST), "site list");
	}

	public static EnhancedBy bySiteNameField() {
		return ElementHelper.BySelector(MobileBy.className(SITENAME_FIELD), "site name field");
	}
	
	public static EnhancedBy byStreetField() {
		return ElementHelper.BySelector(MobileBy.className(STREET_FIELD), "street field");
	}
	
	public static EnhancedBy byPostalCodeField() {
		return ElementHelper.BySelector(MobileBy.className(POSTAL_CODE_FIELD), "postal code field");
	}
	
	public static EnhancedBy byCityField() {
		return ElementHelper.BySelector(MobileBy.className(CITY_FIELD), "city field");
	}
	
	public static EnhancedBy byStateField() {
		return ElementHelper.BySelector(MobileBy.className(STATE_FIELD), "state field");
	}
	
	public static EnhancedBy byCountryField() {
		return ElementHelper.BySelector(MobileBy.className(COUNTRY_FIELD), "country field");
	}
	
	public static EnhancedBy byDoneButton() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(DONE_BUTTON), "done button");
	}
	
	public static EnhancedBy byCancelButton() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(CANCEL_BUTTON), "cancel button");
	}
	
	public static EnhancedBy byCloseButton() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(CLOSE_BUTTON), "close button");
	}

	
	public void addSite(SiteObject site) {
		
		Helper.clickAndExpect(byAddSiteButton(), byDoneButton());
		setField(site);
		FormHelper.formSubmit(byDoneButton(), byCloseButton());
		FormHelper.formSubmit(byCloseButton(), byAddSiteButton());
	}
	
	public void setField(SiteObject site) {
		
		FormHelper.setField(site.sitename, bySiteNameField(), 0);
		FormHelper.setField(site.street, byStreetField(), 1);	
		FormHelper.setField(site.postalCode, byPostalCodeField(), 2);	
		FormHelper.setField(site.city, byCityField(), 3);	
		FormHelper.setField(site.state, byStateField(), 4);	
		FormHelper.setField(site.country, byCountryField(), 5);	
	}
}