package main.customerPanel.Panels;




import common.objects.CompanyObject;
import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.customerPanel.CustomerPanel;
import main.customerPanel.objects.PeopleObject;

public class PeoplePanel {

	CustomerPanel manager;

	public PeoplePanel(CustomerPanel manager) {
		this.manager = manager;
	}
	
	public static final String CUSTOMER = "customer";
	public static final String SUPERVISOR = "supervisor";
	public static final String MANAGER = "manager";
	
	public static class elements {
		// people panel
	    public static EnhancedBy PEOPLE_LIST_SECTION = Element.byCss(".card-content", "people list section");
	    public static EnhancedBy ADD_PEOPLE_BUTTON = Element.byCss("[href*='add']",  "add people");
	    public static EnhancedBy PEOPLE_ROWS = Element.byCss(".card-content tr", "tabs dropdown");
	    public static EnhancedBy SEARCH_FIELD = Element.byXpath("//input[@placeholder='Search']", "search field");
	    public static EnhancedBy EDIT_BUTTON = Element.byXpath("//span[contains(text(),'Edit')]", "edit button");
	    
	 // add people fields
	    
	    public static EnhancedBy COMPANY_FIELD = Element.byCss(".select", "company");
	    public static EnhancedBy COMPANY_FIELD_OPTION = Element.byCss(".select option", "company name");
	    	    
	    public static EnhancedBy PEOPLE_FIRST_NAME_FIELD = Element.byXpath("//input[@placeholder='First Name']", "site tab");
	    public static EnhancedBy PEOPLE_LAST_NAME_FIELD = Element.byXpath("//input[@placeholder='Last Name']", "people tab");  
	    public static EnhancedBy PEOPLE_NOTES_FIELD = Element.byXpath("//input[@placeholder='Notes']", "people rows"); 
	    
	    public static EnhancedBy PEOPLE_ROLES_FIELD = Element.byCss(".control .select", "first name field");  
	    public static EnhancedBy PEOPLE_ROLES_OPTIONS = Element.byCss(".control .select option", "last name field");  
	    
	    public static EnhancedBy PEOPLE_USERNAME_FIELD = Element.byCss("[placeholder='Username']", "user name field");  
	    public static EnhancedBy PEOPLE_EMAIL_FIELD = Element.byXpath("//input[@placeholder='Email']", "email field");  
	    public static EnhancedBy PEOPLE_PASSWORD_FIELD = Element.byXpath("//input[@placeholder='Password']", "password field");  
	    public static EnhancedBy PEOPLE_REPEAT_PASSWORD_FIELD = Element.byXpath("//input[@placeholder='Repeat Password']", "repeat password field");  
	    public static EnhancedBy PEOPLE_COMPANY_FIELD = Element.byCss(".control .select", "people company field");  
	    public static EnhancedBy PEOPLE_COMPANY_OPTIONS = Element.byCss(".control .select option",  "people company options");  
	    public static EnhancedBy PEOPLE_ADD_BUTTON = Element.byXpath("//button[@class='button is-success']", "people add button");  
	    public static EnhancedBy PEOPLE_ADD_SUCCESS = Element.byCss(".message.is-success", "people add success");
	    
	    public static EnhancedBy DELETE_BUTTON = Element.byXpath("//button[@class='button is-danger is-inverted']", "delete button");
	    public static EnhancedBy POP_UP_DELETE_BUTTON = Element.byXpath("//span[contains(text(),'Delete')]", "pop updelete button");

	}


	/**
	 * adds people by selecting add people button and filling in the fields,
	 * then submitting
	 * 
	 * @param people
	 */
	public void addPeople(PeopleObject people, CompanyObject company) {
		Helper.clickAndExpect(elements.ADD_PEOPLE_BUTTON, elements.PEOPLE_FIRST_NAME_FIELD);
		setPeopleFields(people, company);

		Helper.formSubmit(elements.ADD_PEOPLE_BUTTON, elements.PEOPLE_ADD_SUCCESS);

	}

	/**
	 * set people fields
	 * 
	 * @param people
	 */

	public void setPeopleFields(PeopleObject people, CompanyObject company) {
		Helper.selectDropDown(company.name().get(), elements.COMPANY_FIELD, "Select a company", elements.COMPANY_FIELD_OPTION);

		Helper.selectDropDown(people.roles, elements.PEOPLE_ROLES_FIELD, "Select a role", elements.PEOPLE_ROLES_OPTIONS);
		Helper.setField(elements.PEOPLE_FIRST_NAME_FIELD, people.firstName);
		Helper.setField(elements.PEOPLE_LAST_NAME_FIELD, people.lastName);
		Helper.setField(elements.PEOPLE_NOTES_FIELD, people.notes);
		Helper.setField(elements.PEOPLE_EMAIL_FIELD, people.email);
		Helper.setField(elements.PEOPLE_PASSWORD_FIELD, people.password);
		Helper.setField(elements.PEOPLE_REPEAT_PASSWORD_FIELD, people.repeatPassword);
		Helper.clickAndExpect(elements.PEOPLE_ADD_BUTTON, elements.PEOPLE_ADD_SUCCESS);
	}

	/**
	 * verify selected people exists in the people list
	 * 
	 * @param people
	 */
	public void verifyPeople(PeopleObject people) {
		Helper.verifyIsInList(elements.PEOPLE_ROWS, people.firstName);
	}
	
	public void deleteEmployees(PeopleObject people) {
		
		Helper.waitForElementToLoad(elements.SEARCH_FIELD);
		Helper.setField(elements.SEARCH_FIELD, people.firstName);
		Helper.clickAndExpect(elements.EDIT_BUTTON, elements.DELETE_BUTTON);
		Helper.clickAndExpect(elements.DELETE_BUTTON, elements.POP_UP_DELETE_BUTTON);
		Helper.clickAndExpect(elements.POP_UP_DELETE_BUTTON, elements.SEARCH_FIELD);
		
	}
	
	

}