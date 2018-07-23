package main.customerPanel.Panels;


import org.openqa.selenium.By;

import core.helpers.ClickHelper;
import core.helpers.Element;
import core.helpers.FormHelper;
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
	private static final String TAB = ".is-tab";
	private static final String NAVIGATION_MENU = ".nav-menu";
	private static final String TAB_DROPDOWN_LIST = ".dropdown-content li";
	private static final String SITE_TAB = "[href*='sites']";
	private static final String PEOPLE_TAB = "[href*='people']";
	private static final String REPORT_TAB = "[href*='reports']";
	private static final String PLANT_TAB = "[href*='plants']";

	public static EnhancedBy byTab() {
		return Element.bySelector(By.cssSelector(TAB), "tabs");
	}
	
	public static EnhancedBy byNavigationMenu() {
		return Element.bySelector(By.cssSelector(NAVIGATION_MENU), "navigation menu");
	}
	
	public static EnhancedBy byTabDropDownList() {
		return Element.bySelector(By.cssSelector(TAB_DROPDOWN_LIST), "tabs dropdown");
	}

	public static EnhancedBy bySitesTab() {
		return Element.bySelector(By.cssSelector(SITE_TAB), "site tab");
	}

	public static EnhancedBy byPeopleTab() {
		return Element.bySelector(By.cssSelector(PEOPLE_TAB), "people tab");
	}

	public static EnhancedBy byReportTab() {
		return Element.bySelector(By.cssSelector(REPORT_TAB), "report tab");
	}

	public static EnhancedBy byPlantTab() {
		return Element.bySelector(By.cssSelector(PLANT_TAB), "plant tab");
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
			ClickHelper.clickAndExpect(byReportTab(), CompanyPanel.elements.COMPANY_LIST_SECTION);
			break;
		case PLANTS:
			ClickHelper.clickAndExpect(byPlantTab(), CompanyPanel.elements.COMPANY_LIST_SECTION);
			break;
		default:
			throw new IllegalStateException("Unsupported browsertype " + panel);
		}
		WaitHelper.waitForSeconds(1);
	}
}