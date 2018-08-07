package main.customerPanel.Panels;


import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.customerPanel.CustomerPanel;
import main.customerPanel.objects.CompanyObject;

public class CompanyPanel {

	CustomerPanel manager;

	public CompanyPanel(CustomerPanel manager) {
		this.manager = manager;
	}

	
	public static class elements {
		
		// company panel
		public static EnhancedBy COMPANY_LIST_SECTION = Element.byCss(".card-content", "company list section");
	    public static EnhancedBy ADD_NEW_COMPANY_BUTTON = Element.byCss(".card-content .is-success", "add company");
	    public static EnhancedBy COMPANY_ROWS = Element.byCss(".card-content tr", "company rows");
	    public static EnhancedBy COMPANY_EDIT_BUTTON = Element.byCss(".fa-address-card-o", "company edit button");
	    
	    // edit company info
	    public static EnhancedBy COMPANYINFO_NAME = Element.byId("company_name", "company name field");
	    public static EnhancedBy COMPANYINFO_EMAIL = Element.byId("company_email", "company email field");
	    public static EnhancedBy COMPANYINFO_TAX_NUMBER = Element.byId("tax_number", "tax number field");
	    public static EnhancedBy COMPANYINFO_TYPE = Element.byCss(".select", "company type field");
	    public static EnhancedBy COMPANYINFO_TYPE_OPTIONS = Element.byCss(".select option", "companytype field options");
	    public static EnhancedBy CCOMPANYINFO_WEBSITE = Element.byId("website", "website field");
	    public static EnhancedBy COMPANYINFO_EDIT_BUTTON = Element.byCss(".tag", "company info edit");
	   
	    // address info
	    public static EnhancedBy COMPANY_ADDRESS1 = Element.byId("address_one", "address 1");
	    public static EnhancedBy COMPANY_ADDRESS2 = Element.byId("address_two", "address 2 ");
	    public static EnhancedBy COMPANY_CITY = Element.byId("address_city", "city ");
	    public static EnhancedBy COMPANY_COUNTRY_DROPDOWN = Element.byId("address_country", "country select");
	    public static EnhancedBy COMPANY_DROPDOWN_OPTIONS = Element.byCss("#address_country option", "drop down options");
	    public static EnhancedBy COMPANY_STATE_DROPDOWN = Element.byId("address_state", "state select");
	    public static EnhancedBy COMPANY_STATE_DROPDOWN_OPTIONS = Element.byCss("#address_state option", "state select");
	    public static EnhancedBy COMPANY_ZIP_CODE = Element.byId("address_postalcode", "zip code ");
	    public static EnhancedBy COMPANY_ADDRESS_EDIT = Element.byCss("[placeholder='Zip/Postal code']", "address save edit");
	    public static EnhancedBy COMPANY_ADDRESS_SAVE = Element.byId("address_submit", "address save button");
	    public static EnhancedBy COMPANY_ADDRESS_SAVE_SUCCESS = Element.byCss(".message.is-success", "add address success");
	    
	    
	    // credit card info
	    public static EnhancedBy CARD_LICENSE_LIMIT = Element.byId("card_license_limit", "license limit ");
	    public static EnhancedBy CARD_NUMBER = Element.byId("card_number", "card number");
	    public static EnhancedBy CARD_NAME = Element.byId("card_name", "card name ");
	    public static EnhancedBy CARD_EXPIRATION_MONTH = Element.byId("card_expiration_month", "card expiration month");
	    public static EnhancedBy CARD_EXPIRATION_MONTH_OPTIONS = Element.byCss("#card_expiration_month option", "card expiration month");
	    public static EnhancedBy CARD_EXPIRATION_YEAR = Element.byId("card_address_one", "card expiration year");
	    public static EnhancedBy CARD_EXPIRATION_YEAR_OPTION = Element.byCss("#card_expiration_year option", "card expiration year");
	    public static EnhancedBy CARD_EXPIRATION_CVV = Element.byId("card_cvv", "card cvv");
	    public static EnhancedBy CARD_ADDRESS1 = Element.byId("card_address_one", "card address 1");
	    public static EnhancedBy CARD_ADDRESS2 = Element.byId("card_address_two", "card address 2");
	    public static EnhancedBy CARD_CITY = Element.byId("card_city", "card city");
	    public static EnhancedBy CARD_COUNTRY_DROPDOWN = Element.byId("card_country", "card country");
	    public static EnhancedBy CARD_COUNTRY_DROPDOWN_OPTIONS = Element.byCss("#card_country option", "card country");
	    public static EnhancedBy CARD_STATE = Element.byId("card_state", "card state");
	    public static EnhancedBy CARD_STATE_OPTIONS = Element.byCss("#card_state option", "card state dropdown");
	    public static EnhancedBy CARD_POSTAL = Element.byId("card_postal", "card postal code");
	    public static EnhancedBy CARD_EDIT_BUTTON = Element.byCss("[placeholder='Enter the name appears on the card']", "card edit button");
	    public static EnhancedBy CARD_SAVE_BUTTON = Element.byId("card_submit", "card save button");
	    public static EnhancedBy CARD_SAVE_SUCCESS = Element.byCss(".message.is-success", "add card success");
	    
	    // bank account info
	    public static EnhancedBy BANK_INSTITUTION_NUMBER = Element.byId("bank_institution", "bank institution number");
	    public static EnhancedBy BANK_TRANSIT_NUMBER = Element.byId("bank_transit", "bank transit number");
	    public static EnhancedBy BANK_NUMBER = Element.byId("bank_account_number", "bank account");
	    public static EnhancedBy BANK_HOLDER = Element.byId("bank_holder_name", "bank account holder");
	    public static EnhancedBy BANK_TYPE = Element.byId("bank_account_type", "bank account type");
	    public static EnhancedBy BANK_TYPE_OPTIONS = Element.byCss("#bank_account_type option", "bank account holder options");
	    public static EnhancedBy BANK_EDIT_BUTTON = Element.byCss("[placeholder='Enter the name appears on the card']", "bank edit button");
	    public static EnhancedBy BANK_SAVE_BUTTON = Element.byId("account_submit", "bank save button");
	    public static EnhancedBy BANK_SAVE_SUCCESS = Element.byCss(".message.is-success", "add bank success");
	    
	    // legal entity info
	    public static EnhancedBy LEGAL_FIRST_NAME = Element.byId("legal_first_name", "legal first name");
	    public static EnhancedBy LEGAL_LAST_NAME = Element.byId("legal_last_name", "legal last name");
	    public static EnhancedBy LEGAL_BIRTH_YEAR = Element.byId("legal_birth_year", "legal birth year");
	    public static EnhancedBy LEGAL_BIRTH_YEAR_OPTIONS = Element.byCss("legal_birth_year option", "legal birth year");
	    public static EnhancedBy LEGAL_BIRTH_MONTH = Element.byId("legal_birth_month", "legal birth month");
	    public static EnhancedBy LEGAL_BIRTH_MONTH_OPTIONS = Element.byCss("legal_birth_month option", "legal birth month");
	    public static EnhancedBy LEGAL_BIRTH_DAY = Element.byId("legal_birth_day", "legal birth day");
	    public static EnhancedBy LEGAL_BIRTH_DAY_OPTIONS = Element.byCss("legal_birth_day option", "legal birth day");
	    public static EnhancedBy LEGAL_ADDRESS1 = Element.byId("legal_address_one", "legal address 1");
	    public static EnhancedBy LEGAL_ADDRESS2 = Element.byId("legal_address_two", "legal address 2");
	    public static EnhancedBy LEGAL_CITY = Element.byId("legal_city", "legal city");
	    public static EnhancedBy LEGAL_COUNTRY = Element.byId("legal_country", "legal country");
	    public static EnhancedBy LEGAL_COUNTRY_OPTIONS = Element.byCss("#legal_country option", "legal country options");
	    public static EnhancedBy LEGAL_STATE = Element.byId("legal_state", "legal state");
	    public static EnhancedBy LEGAL_STATE_OPTIONS = Element.byCss("#legal_state option", "legal state options");
	    public static EnhancedBy LEGAL_ZIP_CODE = Element.byId("legal_postal_code", "legal zip code");
	    public static EnhancedBy LEGAL_ID = Element.byId("legal_identity_image", "legal id verification");
	    public static EnhancedBy LEGAL_EDIT_BUTTON = Element.byCss("[placeholder='Enter the name appears on the card']", "legal edit button");
	    public static EnhancedBy LEGAL_SAVE_BUTTON = Element.byId("legal_submit", "legal save button");
	    public static EnhancedBy LEGAL_ID_SUCCESS = Element.byCss("[alt='ok']", "legal id success");
	    public static EnhancedBy LEGAL_SAVE_SUCCESS = Element.byCss(".message.is-success", "add legal success");    
	    
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
		Helper.clickAndExpect(elements.ADD_NEW_COMPANY_BUTTON, elements.COMPANYINFO_NAME);
		setCompanyInfoFields(company);
		
		Helper.formSubmit(elements.COMPANY_ADD_BUTTON, elements.ADD_NEW_COMPANY_BUTTON);

	}
	
	public void editCompany(CompanyObject company) {
		setCompanyInfoFields(company);
		Helper.formSubmit(elements.COMPANY_ADDRESS_SAVE, elements.COMPANY_ADDRESS_SAVE_SUCCESS);
		
		setCreditCardInfoFields(company);
		Helper.formSubmit(elements.CARD_SAVE_BUTTON, elements.CARD_SAVE_SUCCESS);
		
		setBankAccountInfoFields(company);
		Helper.formSubmit(elements.BANK_SAVE_BUTTON, elements.BANK_SAVE_SUCCESS);
		
		setLegalEntityInfoFields(company);
		Helper.formSubmit(elements.LEGAL_SAVE_BUTTON, elements.LEGAL_ID_SUCCESS);
	}

	/**
	 * set company fields
	 * 
	 * @param company
	 */
	public void setCompanyInfoFields(CompanyObject company) {
		Helper.setField(elements.COMPANYINFO_NAME, company.companyName);
		Helper.clearAndSetField(elements.COMPANYINFO_EMAIL, company.companyEmail);
		Helper.setField(elements.CCOMPANYINFO_WEBSITE, company.companyWebsite);
		Helper.setField(elements.COMPANYINFO_TAX_NUMBER, company.companyTaxNumber);
		Helper.selectDropDown(company.companyType, elements.COMPANYINFO_TYPE, elements.COMPANYINFO_TYPE_OPTIONS);
		
		if(Helper.isPresent(elements.COMPANYINFO_EDIT_BUTTON))
			Helper.clickAndExpect(elements.COMPANYINFO_EDIT_BUTTON, elements.COMPANY_ADDRESS1);
		Helper.setField(elements.COMPANY_ADDRESS1, company.companyAddress1);
		Helper.setField(elements.COMPANY_ADDRESS2, company.companyAddress2);
		Helper.setField(elements.COMPANY_CITY, company.companyCity);
		Helper.selectDropDown(company.companyCountry, elements.COMPANY_COUNTRY_DROPDOWN, elements.COMPANY_DROPDOWN_OPTIONS);
		Helper.selectDropDown(company.companyState, elements.COMPANY_STATE_DROPDOWN, elements.COMPANY_STATE_DROPDOWN_OPTIONS);
		Helper.setField(elements.COMPANY_ZIP_CODE, company.companyZipCode);
		
	}
	
	public void setCreditCardInfoFields(CompanyObject company) {
		
		Helper.setField(elements.CARD_LICENSE_LIMIT, company.cardLicenseLimit);
		Helper.setField(elements.CARD_NUMBER, company.cardNumber);
		Helper.setField(elements.CARD_NAME, company.cardName);
		Helper.selectDropDown(company.cardExpirationMonth,elements.CARD_EXPIRATION_MONTH, elements.CARD_EXPIRATION_MONTH_OPTIONS);
		Helper.selectDropDown(company.cardExpirationYear,elements.CARD_EXPIRATION_YEAR, elements.CARD_EXPIRATION_YEAR_OPTION);
		Helper.setField(elements.CARD_EXPIRATION_CVV, company.cardExpirationCvv);
		Helper.setField(elements.CARD_ADDRESS1, company.cardAddress1);
		Helper.setField(elements.CARD_ADDRESS2, company.cardAddress2);
		Helper.setField(elements.CARD_CITY, company.cardCity);
		Helper.selectDropDown(company.cardCountry,elements.CARD_COUNTRY_DROPDOWN, elements.CARD_COUNTRY_DROPDOWN_OPTIONS);
		Helper.selectDropDown(company.cardState, elements.CARD_STATE, elements.CARD_STATE_OPTIONS);
		Helper.setField(elements.CARD_POSTAL, company.cardPostal);
	}

	public void setBankAccountInfoFields(CompanyObject company) {
	
		Helper.setField(elements.BANK_INSTITUTION_NUMBER, company.bankInstitutionNumber);
		Helper.setField(elements.BANK_TRANSIT_NUMBER, company.bankTransitNumber);
		Helper.setField(elements.BANK_NUMBER, company.bankNumber);
		Helper.setField(elements.BANK_HOLDER, company.bankHolder);
		Helper.selectDropDown(company.bankType,elements.BANK_TYPE, elements.BANK_TYPE_OPTIONS);
	}
	
	public void setLegalEntityInfoFields(CompanyObject company) {
		
		Helper.setField(elements.LEGAL_FIRST_NAME, company.legalFirstName);
		Helper.setField(elements.LEGAL_LAST_NAME, company.legalLastName);
		Helper.clearAndSetField(elements.LEGAL_BIRTH_YEAR, company.legalBirthYear);
		Helper.clearAndSetField(elements.LEGAL_BIRTH_YEAR, company.legalBirthYear);
		Helper.clearAndSetField(elements.LEGAL_BIRTH_MONTH, company.legalBirthMonth);
		Helper.clearAndSetField(elements.LEGAL_BIRTH_DAY, company.legalBirthDay);
		Helper.setField(elements.LEGAL_ADDRESS1, company.legalAddress1);
		Helper.setField(elements.LEGAL_ADDRESS2, company.legalAddress2);
		Helper.setField(elements.LEGAL_CITY, company.legalCity);
		Helper.selectDropDown(company.legalCountry,elements.LEGAL_COUNTRY, elements.LEGAL_COUNTRY_OPTIONS);
		Helper.selectDropDown(company.legalState,elements.LEGAL_STATE, elements.LEGAL_STATE_OPTIONS);
		Helper.setField(elements.LEGAL_ZIP_CODE, company.legalZipCode);
		Helper.uploadFile(company.legalIdPath, elements.LEGAL_ID);
	}
	
	/**
	 * verify selected company exists in the company list
	 * 
	 * @param company
	 */
	public void verifyCompany(CompanyObject company) {
		Helper.verifyIsInList(elements.COMPANY_ROWS, company.companyName);
	}

}