package main.customerPanel.Panels;


import org.openqa.selenium.By;

import core.helpers.ClickHelper;
import core.helpers.Element;
import core.helpers.FormHelper;
import core.helpers.ListHelper;
import core.webElement.EnhancedBy;
import main.customerPanel.objects.PeopleObject;

public class PeoplePanel {

	CustomerPanelManager manager;

	public PeoplePanel(CustomerPanelManager manager) {
		this.manager = manager;
	}

	// people panel
	private final String PEOPLE_LIST_SECTION = ".card-content";
	private final String ADD_PEOPLE_BUTTON = "[href*='add']";
	private final String PEOPLE_ROWS = ".card-content tr";

	// add people fields
	private final String PEOPLE_FIST_NAME_FIELD = "[placeholder='First name']";
	private final String PEOPLE_LAST_NAME_FIELD = "[placeholder='Last name']";
	private final String PEOPLE_NOTES_FIELD = "[placeholder='Notes']";
	private final String PEOPLE_ROLES_FIELD = ".control .select";
	private final String PEOPLE_ROLES_OPTIONS = ".control .select option";
	private final String PEOPLE_USERNAME_FIELD = "[placeholder='Username']";
	private final String PEOPLE_EMAIL_FIELD = "[placeholder='Email']";
	private final String PEOPLE_PASSWORD_FIELD = "[placeholder='Password']";
	private final String PEOPLE_REPEAT_PASSWORD_FIELD = "[placeholder='Repeat password']";
	private final String PEOPLE_COMPANY_FIELD = ".control .select";
	private final String PEOPLE_COMPANY_OPTIONS = ".control .select option";
	private final String PEOPLE_ADD_BUTTON = ".card-content button.is-success";
	private final String PEOPLE_ADD_SUCCESS = ".message.is-success";

	public EnhancedBy byPeopleListSection() {
		return Element.bySelector(By.cssSelector(PEOPLE_LIST_SECTION), "people list section");
	}

	public EnhancedBy byAddPeopleButton() {
		return Element.bySelector(By.cssSelector(ADD_PEOPLE_BUTTON), "add people");
	}

	public EnhancedBy byPeopleRows() {
		return Element.bySelector(By.cssSelector(PEOPLE_ROWS), "people rows");
	}

	public EnhancedBy byPeopleFirstNameField() {
		return Element.bySelector(By.cssSelector(PEOPLE_FIST_NAME_FIELD), "first name field");
	}

	public EnhancedBy byPeopleLastNameField() {
		return Element.bySelector(By.cssSelector(PEOPLE_LAST_NAME_FIELD), "last name field");
	}

	public EnhancedBy byPeopleNoteField() {
		return Element.bySelector(By.cssSelector(PEOPLE_NOTES_FIELD), "note field");
	}

	public EnhancedBy byPeopleRolesField() {
		return Element.bySelector(By.cssSelector(PEOPLE_ROLES_FIELD), "roles field");
	}

	public EnhancedBy byPeopleRolesOptions() {
		return Element.bySelector(By.cssSelector(PEOPLE_ROLES_OPTIONS), "roles options");
	}

	public EnhancedBy byPeopleUserNameField() {
		return Element.bySelector(By.cssSelector(PEOPLE_USERNAME_FIELD), "user name field");
	}

	public EnhancedBy byPeopleEmailField() {
		return Element.bySelector(By.cssSelector(PEOPLE_EMAIL_FIELD), "email field");
	}

	public EnhancedBy byPeoplePasswordField() {
		return Element.bySelector(By.cssSelector(PEOPLE_PASSWORD_FIELD), "password field");
	}

	public EnhancedBy byPeopleRepeatPasswordField() {
		return Element.bySelector(By.cssSelector(PEOPLE_REPEAT_PASSWORD_FIELD), "repeat password field");
	}

	public EnhancedBy byPeopleCompanyField() {
		return Element.bySelector(By.cssSelector(PEOPLE_COMPANY_FIELD), "people company field");
	}

	public EnhancedBy byPeopleCompanyOptionField() {
		return Element.bySelector(By.cssSelector(PEOPLE_COMPANY_OPTIONS), "people company options");
	}

	public EnhancedBy byPeopleAddButton() {
		return Element.bySelector(By.cssSelector(PEOPLE_ADD_BUTTON), "people add button");
	}

	public EnhancedBy byPeopleAddSuccess() {
		return Element.bySelector(By.cssSelector(PEOPLE_ADD_SUCCESS), "people add success");
	}

	/**
	 * adds people by selecting add people button and filling in the fields,
	 * then submitting
	 * 
	 * @param people
	 */
	public void addPeople(PeopleObject people) {
		ClickHelper.clickAndExpect(byAddPeopleButton(), byPeopleFirstNameField());

		setPeopleFields(people);

		FormHelper.formSubmit(byPeopleAddButton(), byPeopleAddSuccess());

	}

	/**
	 * set people fields
	 * 
	 * @param people
	 */
	public void setPeopleFields(PeopleObject people) {
		FormHelper.setField(people.firstName, byPeopleFirstNameField());
		FormHelper.setField(people.lastName, byPeopleLastNameField());
		FormHelper.setField(people.notes, byPeopleNoteField());
		FormHelper.selectDropDown(people.roles, byPeopleRolesField(), "Select a role", byPeopleRolesOptions());
		FormHelper.setField(people.userName, byPeopleUserNameField());
		FormHelper.setField(people.email, byPeopleEmailField());
		FormHelper.setField(people.password, byPeoplePasswordField());
		FormHelper.setField(people.password, byPeopleRepeatPasswordField());
		FormHelper.selectDropDown(people.company, byPeopleCompanyField(), "Select a company", byPeopleCompanyOptionField());
	}

	/**
	 * verify selected people exists in the people list
	 * 
	 * @param people
	 */
	public void verifyPeople(PeopleObject people) {
		ListHelper.verifyIsInList(byPeopleRows(), people.firstName);
	}

}