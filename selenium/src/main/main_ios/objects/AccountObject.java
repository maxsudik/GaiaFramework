package main.main_ios.objects;

public class AccountObject {

	public String username;
	public String email;
	public String password;
	public String firstName;
	public String lastName;
	public String fullName;
	public String notes;
	public int roles;
	
   // account panel user role button index
	public static final int SUPERVISOR = 9;
	public static final int MANAGER = 10;
	public static final int INSTALLER = 11;
	

	public AccountObject withEmail(String email) {
		this.email = email;
		return this;
	}

	public AccountObject withUsername(String username) {
		this.username = username;
		return this;
	}

	public AccountObject withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public AccountObject withFirstName(String firstName) {
		this.firstName = firstName;
		this.fullName = this.lastName + ", " + this.firstName;
		return this;
	}
	
	public AccountObject withLastName(String lastName) {
		this.lastName = lastName;
		this.fullName = this.lastName + ", " + this.firstName;
		return this;
	}
	
	public AccountObject withNotes(String notes) {
		this.notes = notes;
		return this;
	}
	
	public AccountObject withRoles(int roles) {
		this.roles = roles;
		return this;
	}
}