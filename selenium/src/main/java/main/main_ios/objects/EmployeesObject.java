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


	//Supervisor Values
	public static final String SUPERVISOR_USERNAME = "Supervisor.Last.Name";
	public static final String SUPERVISOR_EMAIL = "maksym.sudik+3@fortify.pro";
	public static final String SUPERVISOR_PASSWORD = "1111111111";
	public static final String SUPERVISOR_CONFIRM_PASSWORD = "1111111111";
	public static final String SUPERVISOR_FIRST_NAME = "Supervisor";
	public static final String SUPERVISOR_LAST_NAME = "LastName";
	public static final String SUPERVISOR_NOTES = "Some Notes";
	
	//Full name
	public static final String SUPERVISOR_FULL_NAME = SUPERVISOR_FIRST_NAME + " " + SUPERVISOR_LAST_NAME;
	
	//Installer Values
	public static final String INSTALLER_USERNAME = "Installer.Last.Name";
	public static final String INSTALLER_EMAIL = "maksym.sudik+4@fortify.pro";
	public static final String INSTALLER_PASSWORD = "1111111111";
	public static final String INSTALLER_CONFIRM_PASSWORD = "1111111111";
	public static final String INSTALLER_FIRST_NAME = "Installer";
	public static final String INSTALLER_LAST_NAME = "LastName";
	public static final String INSTALLER_NOTES = "Some Notes";

			
	
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
