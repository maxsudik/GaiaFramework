package main.main_ios.objects;

public class EmployeesObject {
	
	//Chain
	public String username;
	public String email;
	public String password;
	public String confirmPassword;
	public String firstName;
	public String lastName;
	public String notes;


	//Default values
	public static final String USERNAME = "Supervisor.Last.Name";
	public static final String EMAIL = "maksym.sudik+3@fortify.pro";
	public static final String PASSWORD = "1111111111";
	public static final String CONFIRM_PASSWORD = "1111111111";
	public static final String FIRST_NAME = "Supervisor";
	public static final String LAST_NAME = "LastName";
	public static final String NOTES = "Some Notes";

			
	
	//Constructors
	public EmployeesObject withUserName(String username) {
	this.username = username;
	return this;
	}
	
	public EmployeesObject withEmail(String email) {
	this.email = email;
	return this;
	}
	
	public EmployeesObject withPassword(String password) {
	this.password = password;
	return this;
	}
	
	public EmployeesObject withConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
	return this;
	}
	
	public EmployeesObject withFirstName(String firstName) {
	this.firstName = firstName;
	return this;
	}
	
	public EmployeesObject withLastName(String lastName) {
	this.lastName = lastName;
	return this;
	}
	
	public EmployeesObject withNotes(String notes) {
	this.notes = notes;
	return this;
	}

}
