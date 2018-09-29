package main.java.main.customerPanel.objects;



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
	public static final String FIRST_NAME = "Manager";
	public static final String LAST_NAME = "LastName";
	public static final String NOTES = "Some notes";
	public static final String EMAIL = "maksym.sudik+1@fortify.pro";
	public static final String PASSWORD = "1111111111";
	public static final String REPEAT_PASSWORD = "1111111111";


	
	
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