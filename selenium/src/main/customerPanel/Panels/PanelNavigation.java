package main.customerPanel.Panels;


import org.openqa.selenium.By;

import core.helpers.ElementHelper;
import core.helpers.Helper;
import core.helpers.WaitHelper;
import core.webElement.EnhancedBy;

public class PanelNavigation {

	CustomerPanelManager manager;

	public PanelNavigation(CustomerPanelManager manager) {
		this.manager = manager;
	}

	public enum Panels {
		COMPANY, SITES, PEOPLE, REPORTS, PLANTS;
	}

	// panel tabs
	private final String COMPANY_TAB = "[href*='companies']";
	private final String SITE_TAB = "[href*='sites']";
	private final String PEOPLE_TAB = "[href*='people']";
	private final String REPORT_TAB = "[href*='reports']";
	private final String PLANT_TAB = "[href*='plants']";

	public EnhancedBy byCompanyTab() {
		return ElementHelper.BySelector(By.cssSelector(COMPANY_TAB), "company tab");
	}

	public EnhancedBy bySitesTab() {
		return ElementHelper.BySelector(By.cssSelector(SITE_TAB), "site tab");
	}

	public EnhancedBy byPeopleTab() {
		return ElementHelper.BySelector(By.cssSelector(PEOPLE_TAB), "people tab");
	}

	public EnhancedBy byReportTab() {
		return ElementHelper.BySelector(By.cssSelector(REPORT_TAB), "report tab");
	}

	public EnhancedBy byPlantTab() {
		return ElementHelper.BySelector(By.cssSelector(PLANT_TAB), "plant tab");
	}

	public void selectPanel(String panel) {
		Panels panelTab = Enum.valueOf(Panels.class, panel);

		switch (panelTab) {
		case COMPANY:
			Helper.clickAndExpect(byCompanyTab(), manager.company.byAddCompanyButton());
			break;
		case SITES:
			Helper.clickAndExpect(bySitesTab(), manager.sites.byAddSiteButton());
			break;
		case PEOPLE:
			Helper.clickAndExpect(byPeopleTab(), manager.people.byAddPeopleButton());
			break;
		case REPORTS:
			Helper.clickAndExpect(byReportTab(), manager.company.byCompanyListSection());
			break;
		case PLANTS:
			Helper.clickAndExpect(byPlantTab(), manager.company.byCompanyListSection());
			break;
		default:
			throw new IllegalStateException("Unsupported browsertype " + panel);
		}
		WaitHelper.waitForSeconds(1);
	}

}