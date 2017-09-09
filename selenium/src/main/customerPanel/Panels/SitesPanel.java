package main.customerPanel.Panels;


import org.openqa.selenium.By;

import core.helpers.ElementHelper;
import core.helpers.FormHelper;
import core.helpers.Helper;
import core.helpers.ListHelper;
import core.webElement.EnhancedBy;
import main.customerPanel.objects.SiteObject;

public class SitesPanel {

	CustomerPanelManager manager;

	public SitesPanel(CustomerPanelManager manager) {
		this.manager = manager;
	}

	// site panel
	private final String SITE_LIST_SECTION = ".card-content";
	private final String ADD_SITE_BUTTON = ".card-content .is-success";
	private final String SITE_ROWS = ".card-content tr";

	// add site fields
	private final String SITE_NAME_FIELD = "[placeholder='Name']";
	private final String SITE_RADIUS_FIELD = "[placeholder='Detect radius']";
	private final String SITE_COMPANY_FIELD = ".control .select";
	private final String SITE_COMPANY_OPTIONS = ".control .select option";
	private final String SITE_ADD_BUTTON = ".card-content .is-success";
	private final String SITE_ADD_SUCCESS = ".message.is-success";

	public EnhancedBy bySiteListSection() {
		return ElementHelper.BySelector(By.cssSelector(SITE_LIST_SECTION), "site list section");
	}

	public EnhancedBy byAddSiteButton() {
		return ElementHelper.BySelector(By.cssSelector(ADD_SITE_BUTTON), "add site");
	}

	public EnhancedBy bySiteRows() {
		return ElementHelper.BySelector(By.cssSelector(SITE_ROWS), "site rows");
	}

	public EnhancedBy bySiteNameField() {
		return ElementHelper.BySelector(By.cssSelector(SITE_NAME_FIELD), "site name field");
	}

	public EnhancedBy bySiteEmailField() {
		return ElementHelper.BySelector(By.cssSelector(SITE_RADIUS_FIELD), "site email field");
	}

	public EnhancedBy bySiteCompanyField() {
		return ElementHelper.BySelector(By.cssSelector(SITE_COMPANY_FIELD), "site company field");
	}

	public EnhancedBy bySiteCompanyOptionField() {
		return ElementHelper.BySelector(By.cssSelector(SITE_COMPANY_OPTIONS), "site company options");
	}

	public EnhancedBy bySiteAddButton() {
		return ElementHelper.BySelector(By.cssSelector(SITE_ADD_BUTTON), "site add button");
	}

	public EnhancedBy bySiteAddSuccess() {
		return ElementHelper.BySelector(By.cssSelector(SITE_ADD_SUCCESS), "site add success");
	}

	/**
	 * adds site by selecting add site button and filling in the fields, then
	 * submitting
	 * 
	 * @param site
	 */
	public void addSite(SiteObject site) {
		Helper.clickAndExpect(byAddSiteButton(), bySiteNameField());
		setSiteFields(site);
		FormHelper.formSubmit(bySiteAddButton(), bySiteAddSuccess());

	}

	/**
	 * set site fields
	 * 
	 * @param site
	 */
	public void setSiteFields(SiteObject site) {
		FormHelper.setField(site.name, bySiteNameField());
		FormHelper.setField(site.radius, bySiteEmailField());
		FormHelper.selectDropDown(site.company, bySiteCompanyField(), bySiteCompanyOptionField());
	}

	/**
	 * verify selected site exists in the site list
	 * 
	 * @param site
	 */
	public void verifySite(SiteObject site) {
		ListHelper.verifyIsInList(bySiteRows(), site.name);
	}

}