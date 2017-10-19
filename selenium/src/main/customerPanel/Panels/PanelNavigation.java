package main.customerPanel.Panels;


import org.openqa.selenium.By;

import core.helpers.ElementHelper;
import core.helpers.FormHelper;
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
	private final String TAB = ".is-tab";
	private final String TAB_DROPDOWN_LIST = ".dropdown-content li";
	private final String SITE_TAB = "[href*='sites']";
	private final String PEOPLE_TAB = "[href*='people']";
	private final String REPORT_TAB = "[href*='reports']";
	private final String PLANT_TAB = "[href*='plants']";

	public EnhancedBy byTab() {
		return ElementHelper.BySelector(By.cssSelector(TAB), "tabs");
	}
	
	public EnhancedBy byTabDropDownList() {
		return ElementHelper.BySelector(By.cssSelector(TAB_DROPDOWN_LIST), "tabs dropdown");
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
			FormHelper.selectDropDown("Company Profile", byTab(), "COMPANY", byTabDropDownList());
			break;
		case SITES:
			FormHelper.selectDropDown("Sites", byTab(), "COMPANY", byTabDropDownList());
			break;
		case PEOPLE:
			FormHelper.selectDropDown("People", byTab(), "COMPANY", byTabDropDownList());
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