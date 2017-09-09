package main.customerPanel.objects;


public class PeopleObject {

	public String firstName;
	public String lastName;
	public String notes;
	public String roles;
	public String userName;
	public String email;
	public String password;
	public String company;

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

	public PeopleObject withRoles(String roles) {
		this.roles = roles;
		return this;
	}

	public PeopleObject withUserName(String userName) {
		this.userName = userName;
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

	public PeopleObject withCompany(String company) {
		this.company = company;
		return this;
	}
}