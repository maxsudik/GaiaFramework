package main.main_ios.Panels;

import core.helpers.ElementHelper;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import io.appium.java_client.MobileBy;

public class MainPanel {

	GaiaManager_ios manager;

	public MainPanel( GaiaManager_ios manager) {
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

	private static final String REPORTS_PANEL = "Reports";
	private static final String SITES_PANEL = "Sites";
	private static final String PLANTS_PANEL = "Plants";
	private static final String CUSTOMERS_PANEL = "Customers";
	private static final String ACCOUNTS_PANEL = "Accounts";
	private static final String INSTALLS_PANEL = "Installs";
	private static final String GAIA_LOGO = "gaia logo";

	public static EnhancedBy byReportsPanel() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(REPORTS_PANEL), "reports panel");
	}

	public static EnhancedBy bySitesPanel() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(SITES_PANEL), "sites panel");
	}

	public static EnhancedBy byPlantsPanel() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(PLANTS_PANEL), "plants panel");
	}
	
	public static EnhancedBy byCustomersPanel() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(CUSTOMERS_PANEL), "customers panel");
	}
	
	public static EnhancedBy byAccountsPanel() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(ACCOUNTS_PANEL), "accounts panel");
	}
	
	public static EnhancedBy byInstallsPanel() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(INSTALLS_PANEL), "installs panel");
	}
	
	public static EnhancedBy byGaiaLogo() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(GAIA_LOGO), "gaia logo");
	}
	
	
	
	public void selectPanel(gaiaPanels panel) {
		switch (panel) {
		case ACCOUNTS:
			Helper.clickAndExpect(byAccountsPanel(), AccountsPanel.bySupervisorTab());
			break;
		case SITES:
			Helper.clickAndExpect(bySitesPanel(), SitesPanel.byAddSiteButton());
			break;	
		case CUSTOMERS:
			Helper.clickAndExpect(byCustomersPanel(), CustomersPanel.byAddCustomerButton());
			break;	
		case INSTALLS:
			Helper.clickAndExpect(byInstallsPanel(), InstallsPanel.byAddEstimateButton());
			break;	
		default:
			throw new IllegalStateException("Unsupported panels " + panel);
		}
	}
}