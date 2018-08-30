package main.main_ios.Panels;


import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;

public class MainPanel {

	GaiaIos manager;

	public MainPanel( GaiaIos manager) {
		this.manager = manager;

	}
	
	public enum gaiaPanels {
		REPORTS, 
		SITES,
		EQUIPMENT,
		INSTALLS,
		CUSTOMERS,
		EMPLOYEES,
		STATISTICS,
		SCHEDULING,
		GPS,
		PLANTS, 
	}
	
	public static class elements {
	    public static EnhancedBy REPORTS_PANEL = Element.byAccessibility("Reports", "reports panel");
	    public static EnhancedBy SITES_PANEL = Element.byAccessibility("Sites", "sites panel");
	    public static EnhancedBy EQUIPMENT_PANEL = Element.byAccessibility("Equipment", "equipment panel");
	    public static EnhancedBy INSTALLS_PANEL = Element.byAccessibility("Installs", "installs panel");
	    public static EnhancedBy CUSTOMERS_PANEL = Element.byAccessibility("Customers", "customers panel");
	    public static EnhancedBy EMPLOYEES_PANEL = Element.byAccessibility("Employees", "employees panel");
	    public static EnhancedBy STATISTICS_PANEL = Element.byAccessibility("Statistics", "statistics panel");
	    public static EnhancedBy SCHEDULING_PANEL = Element.byAccessibility("Scheduling", "scheduling panel");
	    public static EnhancedBy GPS_PANEL = Element.byAccessibility("GPS", "gps panel");
	    public static EnhancedBy PLANTS_PANEL = Element.byAccessibility("Plants", "plants panel");
	    public static EnhancedBy GAIA_LOGO = Element.byAccessibility("gaia logo", "gaia logo");
	}

	
	public void selectPanel(gaiaPanels panel) {
		switch (panel) {
		case REPORTS:
			Helper.clickAndExpect(elements.REPORTS_PANEL, ReportsPanel.elements.CLOSE_BUTTON);
			break;
		case SITES:
			Helper.clickAndExpect(elements.SITES_PANEL, SitesPanel.elements.ADD_SITE);
			break;
		case EQUIPMENT:
			Helper.clickAndExpect(elements.EQUIPMENT_PANEL, EquipmentPanel.elements.ADD_PRODUCT_BUTTON);
			break;
		case INSTALLS:
			Helper.clickAndExpect(elements.INSTALLS_PANEL, InstallsPanel.byAddEstimateButton());
			break;
		case CUSTOMERS:
			Helper.clickAndExpect(elements.CUSTOMERS_PANEL, CustomersPanel.elements.ADD_CUSTOMER );
			break;
			//Change to expect
		case EMPLOYEES:
			Helper.clickAndNotExpect(elements.EMPLOYEES_PANEL, elements.EMPLOYEES_PANEL);
			break;
			//Change to expect
		case STATISTICS:
			Helper.clickAndNotExpect(elements.STATISTICS_PANEL, elements.STATISTICS_PANEL);
			break;
			//Change to expect
		case SCHEDULING:
			Helper.clickAndNotExpect(elements.SCHEDULING_PANEL, elements.SCHEDULING_PANEL);
			break;
			//Change to expect
		case GPS:
			Helper.clickAndNotExpect(elements.GPS_PANEL, elements.GPS_PANEL);
			break;
			//Change to expect
		case PLANTS:
			Helper.clickAndNotExpect(elements.PLANTS_PANEL, elements.PLANTS_PANEL);
			break;
		default:
			throw new IllegalStateException("Unsupported panels " + panel);
		}
	}
}