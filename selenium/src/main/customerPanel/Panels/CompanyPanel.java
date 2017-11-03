package main.customerPanel.Panels;


import org.openqa.selenium.By;

import core.helpers.ClickHelper;
import core.helpers.Element;
import core.helpers.FormHelper;
import core.helpers.ListHelper;
import core.webElement.EnhancedBy;
import main.customerPanel.objects.CompanyObject;

public class CompanyPanel {

	CustomerPanelManager manager;

	public CompanyPanel(CustomerPanelManager manager) {
		this.manager = manager;
	}

	// company panel
	private final String COMPANY_LIST_SECTION = ".card-content";
	private final String ADD_COMPANY_BUTTON = ".card-content .is-success";
	private final String COMPANY_ROWS = ".card-content tr";

	// add company fields
	private final String COMPANY_NAME_FIELD = "[placeholder='Name']";
	private final String COMPANY_EMAIL_FIELD = "[placeholder='Email']";
	private final String COMPANY_LICENSE_LIMIT_FIELD = "[placeholder='License limit']";
	private final String COMPANY_ADD_BUTTON = ".card-content .is-success";
	private final String COMPANY_ADD_SUCCESS = ".message.is-success";

	public EnhancedBy byCompanyListSection() {
		return Element.bySelector(By.cssSelector(COMPANY_LIST_SECTION), "company list section");
	}

	public EnhancedBy byAddCompanyButton() {
		return Element.bySelector(By.cssSelector(ADD_COMPANY_BUTTON), "add company");
	}

	public EnhancedBy byCompanyRows() {
		return Element.bySelector(By.cssSelector(COMPANY_ROWS), "company rows");
	}

	public EnhancedBy byCompanyNameField() {
		return Element.bySelector(By.cssSelector(COMPANY_NAME_FIELD), "company name field");
	}

	public EnhancedBy byCompanyEmailField() {
		return Element.bySelector(By.cssSelector(COMPANY_EMAIL_FIELD), "company email field");
	}

	public EnhancedBy byCompanyLicenseLimitField() {
		return Element.bySelector(By.cssSelector(COMPANY_LICENSE_LIMIT_FIELD), "company license limit field");
	}

	public EnhancedBy byCompanyAddButton() {
		return Element.bySelector(By.cssSelector(COMPANY_ADD_BUTTON), "company add button");
	}

	public EnhancedBy byCompanyAddSuccess() {
		return Element.bySelector(By.cssSelector(COMPANY_ADD_SUCCESS), "company add success");
	}

	/**
	 * adds company by selecting add company button and filling in the fields,
	 * then submitting
	 * 
	 * @param company
	 */
	public void addCompany(CompanyObject company) {
		ClickHelper.clickAndExpect(byAddCompanyButton(), byCompanyNameField());
		setCompanyFields(company);
		FormHelper.formSubmit(byCompanyAddButton(), byCompanyAddSuccess());

	}

	/**
	 * set company fields
	 * 
	 * @param company
	 */
	public void setCompanyFields(CompanyObject company) {
		FormHelper.setField(company.name, byCompanyNameField());
		FormHelper.setField(company.email, byCompanyEmailField());
		FormHelper.setField(company.licenseLimit, byCompanyLicenseLimitField());
	}

	/**
	 * verify selected company exists in the company list
	 * 
	 * @param company
	 */
	public void verifyCompany(CompanyObject company) {
		ListHelper.verifyIsInList(byCompanyRows(), company.name);
	}

}