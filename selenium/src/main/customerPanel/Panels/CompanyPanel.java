package main.customerPanel.Panels;


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

	
	public static class element {
		
		// company panel
		public static EnhancedBy COMPANY_LIST_SECTION = Element.byCss(".card-content", "company list section");
	    public static EnhancedBy ADD_NEW_COMPANY_BUTTON = Element.byCss(".card-content .is-success", "add company");
	    public static EnhancedBy COMPANY_ROWS = Element.byCss(".card-content tr", "company rows");
	    
	    // add company fields
	    public static EnhancedBy COMPANY_NAME_FIELD = Element.byCss("[placeholder='Name']", "company name field");
	    public static EnhancedBy COMPANY_EMAIL_FIELD = Element.byCss("[name='email']", "company email field");
	    public static EnhancedBy COMPANY_TAX_NUMBER_FIELD = Element.byCss("[placeholder='Tax number']", "tax number field");
	    public static EnhancedBy COMPANY_ADDRESS_FIELD = Element.byCss("[placeholder='Address']", "address field");
	    public static EnhancedBy COMPANY_CITY_FIELD = Element.byCss("[placeholder='Enter the name of the city']", "city field");
	    public static EnhancedBy COMPANY_COUNTRY_DROPDOWN = Element.byCss(".select", "country select");
	    public static EnhancedBy COMPANY_DROPDOWN_OPTIONS = Element.byCss(".select option", "drop down options");
	    public static EnhancedBy COMPANY_STATE_DROPDOWN = Element.byCss(".select", "state select");
	    public static EnhancedBy COMPANY_ZIP_CODE_FIELD = Element.byCss("[placeholder='Zip/Postal code']", "zip code field");
	    public static EnhancedBy COMPANY_LICENSE_LIMIT_FIELD = Element.byCss("[placeholder='License limit']", "license limit field");
	   
	    public static EnhancedBy COMPANY_ADD_BUTTON = Element.byCss(".card-content .is-success", "company add button");
	    public static EnhancedBy COMPANY_ADD_SUCCESS = Element.byCss(".message.is-success", "company add success");
	}	

	/**
	 * adds company by selecting add company button and filling in the fields,
	 * then submitting
	 * 
	 * @param company
	 */
	public void addCompany(CompanyObject company) {
		ClickHelper.clickAndExpect(element.ADD_NEW_COMPANY_BUTTON, element.COMPANY_NAME_FIELD);
		setCompanyFields(company);
		FormHelper.formSubmit(element.COMPANY_ADD_BUTTON, element.ADD_NEW_COMPANY_BUTTON);

	}

	/**
	 * set company fields
	 * 
	 * @param company
	 */
	public void setCompanyFields(CompanyObject company) {
		FormHelper.setField(company.name, element.COMPANY_NAME_FIELD);
		FormHelper.setField(company.email, element.COMPANY_EMAIL_FIELD);
		FormHelper.setField(company.taxNumber, element.COMPANY_TAX_NUMBER_FIELD);
		FormHelper.setField(company.address, element.COMPANY_ADDRESS_FIELD);
		FormHelper.setField(company.city, element.COMPANY_CITY_FIELD);
		
		FormHelper.selectDropDown(company.country, element.COMPANY_COUNTRY_DROPDOWN, 0,  element.COMPANY_DROPDOWN_OPTIONS);
		FormHelper.selectDropDown(company.state, element.COMPANY_STATE_DROPDOWN, 1, element.COMPANY_DROPDOWN_OPTIONS);
		
		FormHelper.setField(company.zipCode, element.COMPANY_ZIP_CODE_FIELD);
		FormHelper.setField(company.licenseLimit,element.COMPANY_LICENSE_LIMIT_FIELD);
	}

	/**
	 * verify selected company exists in the company list
	 * 
	 * @param company
	 */
	public void verifyCompany(CompanyObject company) {
		ListHelper.verifyIsInList(element.COMPANY_ROWS, company.name);
	}

}