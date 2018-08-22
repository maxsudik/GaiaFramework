package main.customerPanel.Panels;


import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.customerPanel.CustomerPanel;

public class PanelNavigation {

	CustomerPanel manager;

	public PanelNavigation(CustomerPanel manager) {
		this.manager = manager;
	}

	public enum Panels {
		COMPANY, SITES, PEOPLE, REPORTS, PLANTS
    }
	
	public static final String COMPANY_PANEL = "COMPANY";
	public static final String SITE_PANEL = "SITES";
	public static final String PEOPLE_PANEL = "PEOPLE";
	public static final String REPORTS_PANEL = "REPORTS";
	public static final String PLANTS_PANEL = "PLANTS";
	
	public static class elements {
		// panel tabs
	    public static EnhancedBy TAB = Element.byCss(".is-tab", "tabs");
	    public static EnhancedBy NAVIGATION_MENU = Element.byCss(".nav-menu",  "navigation menu");
	    public static EnhancedBy TAB_DROPDOWN_LIST = Element.byCss(".dropdown-content li", "tabs dropdown");
	    public static EnhancedBy SITE_TAB = Element.byCss("[href*='sites']", "site tab");
	    public static EnhancedBy PEOPLE_TAB = Element.byCss("[href*='people']", "people tab");  
	    public static EnhancedBy REPORT_TAB = Element.byCss("[href*='reports']", "report tab");  
	    public static EnhancedBy PLANT_TAB = Element.byCss("[href*='plants']", "plant tab");  
	}

	public void selectPanel(String panel) {
		Panels panelTab = Enum.valueOf(Panels.class, panel);

		switch (panelTab) {
		case COMPANY:
			Helper.selectDropDown("Company Profile", elements.TAB, "COMPANY", elements.TAB_DROPDOWN_LIST);
			break;
		case SITES:
			Helper.selectDropDown("Sites", elements.TAB, "COMPANY", elements.TAB_DROPDOWN_LIST);
			break;
		case PEOPLE:
			Helper.selectDropDown("People", elements.TAB, "COMPANY", elements.TAB_DROPDOWN_LIST);
			break;
		case REPORTS:
			Helper.clickAndExpect(elements.REPORT_TAB, CompanyPanel.elements.COMPANY_LIST_SECTION);
			break;
		case PLANTS:
			Helper.clickAndExpect(elements.PLANT_TAB, CompanyPanel.elements.COMPANY_LIST_SECTION);
			break;
		default:
			throw new IllegalStateException("Unsupported browsertype " + panel);
		}
		Helper.waitForSeconds(1);
	}
}