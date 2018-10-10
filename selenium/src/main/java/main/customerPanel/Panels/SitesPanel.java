package main.customerPanel.Panels;


import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.customerPanel.CustomerPanel;
import main.customerPanel.objects.SiteObject;

public class SitesPanel {

	CustomerPanel manager;

	public SitesPanel(CustomerPanel manager) {
		this.manager = manager;
	}
	
	public static class elements {
		// site panel
	    public static EnhancedBy SITE_LIST_SECTION = Element.byCss(".card-content", "site list section");
	    public static EnhancedBy ADD_SITE_BUTTON = Element.byCss(".card-content .is-success",   "add site");
	    public static EnhancedBy SITE_ROWS = Element.byCss(".card-content tr", "site rows");
	    
		// add site fields
	    public static EnhancedBy SITE_NAME_FIELD = Element.byCss("[placeholder='Name']", "site name field");
	    public static EnhancedBy SITE_RADIUS_FIELD = Element.byCss("[placeholder='Detect radius']", "site email field");  
	    public static EnhancedBy SITE_COMPANY_FIELD = Element.byCss(".control .select", "site company field");  
	    public static EnhancedBy SITE_COMPANY_OPTIONS = Element.byCss(".control .select option", "site company options");  
	    public static EnhancedBy SITE_EMAIL = Element.byCss("[placeholder='Email']", "site email field");  
	    public static EnhancedBy SITE_ADDRESS = Element.byCss("[placeholder='Address']", "site address field");  
	    public static EnhancedBy SITE_POSTAL_CODE = Element.byCss("[placeholder='Postal code']", "site postal code field");  
	    public static EnhancedBy SITE_CITY = Element.byCss("[placeholder='City']", "site city field");  
	    public static EnhancedBy SITE_STATE = Element.byCss("[placeholder='State/Province']", "site state field");  
	    public static EnhancedBy SITE_COUNTRY = Element.byCss("[placeholder='Country']", "site country field");  
	    public static EnhancedBy SITE_GPS_BUTTON = Element.byCss( "[name='button']", "fetch gps coordinates button");  
	    public static EnhancedBy SITE_MAP_BUTTON = Element.byCss(".fa-map-o",  "site map");  
	    public static EnhancedBy SITE_ADD_BUTTON = Element.byCss(".is-grouped .is-success", "site add button");  
	    public static EnhancedBy SITE_ADD_SUCCESS = Element.byCss(".message.is-success", "site add success");  
	}


	/**
	 * adds site by selecting add site button and filling in the fields, then
	 * submitting
	 * 
	 * @param site
	 */
	public void addSite(SiteObject site) {
		Helper.clickAndExpect(elements.SITE_ADD_BUTTON, elements.SITE_NAME_FIELD);
		setSiteFields(site);
		Helper.formSubmit(elements.SITE_ADD_BUTTON, elements.SITE_ADD_SUCCESS);

	}

	/**
	 * set site fields
	 * 
	 * @param site
	 */
	public void setSiteFields(SiteObject site) {
		Helper.setField(elements.SITE_NAME_FIELD, site.name);
		Helper.setField(elements.SITE_EMAIL, site.radius);
		Helper.selectDropDown(site.company,elements.SITE_COMPANY_FIELD,elements.SITE_COMPANY_OPTIONS);
		Helper.setField(elements.SITE_ADDRESS, site.address);
		Helper.setField(elements.SITE_POSTAL_CODE, site.postalCode);
		Helper.setField(elements.SITE_CITY, site.city);
		Helper.setField(elements.SITE_STATE, site.state);
		Helper.setField(elements.SITE_COUNTRY, site.country);
		Helper.clickAndExpect(elements.SITE_GPS_BUTTON, elements.SITE_MAP_BUTTON );
	}

	/**
	 * verify selected site exists in the site list
	 * 
	 * @param site
	 */
	public void verifySite(SiteObject site) {
		Helper.verifyIsInList(elements.SITE_ROWS, site.name);
	}

}