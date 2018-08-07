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
		PLANTS, 
		INSTALLS, 
		ACCOUNTS, 
		CUSTOMERS
	}
	
	public static class elements {
	    public static EnhancedBy REPORTS_PANEL = Element.byAccessibility("Reports", "reports panel");
	    public static EnhancedBy SITES_PANEL = Element.byAccessibility("Sites", "sites panel");
	    public static EnhancedBy PLANTS_PANEL = Element.byAccessibility("Plants", "plants panel");
	    public static EnhancedBy CUSTOMERS_PANEL = Element.byAccessibility("Customers", "customers panel");
	    public static EnhancedBy ACCOUNTS_PANEL = Element.byAccessibility("Accounts", "accounts panel");
	    public static EnhancedBy INSTALLS_PANEL = Element.byAccessibility("Installs", "installs panel");
	    public static EnhancedBy GAIA_LOGO = Element.byAccessibility("gaia logo", "gaia logo");
	}

	
	public void selectPanel(gaiaPanels panel) {
		switch (panel) {
		case ACCOUNTS:
			Helper.clickAndExpect(elements.ACCOUNTS_PANEL, AccountsPanel.elements.SUPERVISOR_TAB);
			break;
		case SITES:
			Helper.clickAndExpect(elements.SITES_PANEL, SitesPanel.elements.ADD_SITE);
			break;	
		case CUSTOMERS:
			Helper.clickAndExpect(elements.CUSTOMERS_PANEL, CustomersPanel.elements.ADD_CUSTOMER );
			break;	
		case INSTALLS:
			Helper.clickAndExpect(elements.INSTALLS_PANEL, InstallsPanel.byAddEstimateButton());
			break;	
		default:
			throw new IllegalStateException("Unsupported panels " + panel);
		}
	}
}