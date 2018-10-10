package main.customerPanel.objects;

import core.helpers.Helper;

public class PeopleObject {

	public String company;
	public String roles;
	public String firstName;
	public String lastName;
	public String notes;
	public String email;
	public String password;
	public String repeatPassword;

	public static final String ROLES = "Manager";
	public static final String FIRST_NAME = "zzz_Manager";
	public static final String LAST_NAME = "zzz_LastName";
	public static final String NOTES = "Some notes";
	public static final String EMAIL = "maksym.sudik" + Helper.generateRandomString(5) + "@fortify.pro";
	public static final String PASSWORD = "1111111111";
	public static final String REPEAT_PASSWORD = "1111111111";

	public PeopleObject withDefaultManager(String company) {
	  String random = Helper.generateRandomString(5);
	  PeopleObject people = new PeopleObject()
					.withCompanyName(company)
					.withRoles("Manager")
					.withFirstName("zzz_Manager")
					.withLastName("zzz_LastName")
					.withNotes("Some notes")
					.withEmail("maksym.sudik" + random + "@fortify.pro")
					.withPassword("1111111111")
					.withRepeatPassword("1111111111");
		return people;
	}
  
	
	
	public PeopleObject withCompanyName(String company) {
		this.company = company;
		return this;
	}
	
	public PeopleObject withRoles(String roles) {
		this.roles = roles;
		return this;
	}

	public PeopleObject withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public PeopleObject withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public PeopleObject withNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public PeopleObject withEmail(String email) {
		this.email = email;
		return this;
	}

	public PeopleObject withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public PeopleObject withRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
		return this;
	}
}