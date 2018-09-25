package main.main_ios.objects;

public class UserObject_Ios {

	public String email;
	public String username;
	public String password;
	public String firstName;
	public String lastName;
	
	public static final String MANAGER_USERNAME = "First.Name.Last.Name";
	public static final String MANAGER_PASSWORD = "1111111111";
	public static final String MANAGER_EMAIL = "maksym.sudik+1@fortify.pro";
	
	public static final String SUPERVISOR_USERNAME = "zzzauto1";
	public static final String SUPERVISOR_PASSWORD = "zzzautosupervisor1";

	public UserObject_Ios withEmail(String email) {
		this.email = email;
		return this;
	}

	public UserObject_Ios withUsername(String username) {
		this.username = username;
		return this;
	}

	public UserObject_Ios withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public UserObject_Ios withFirstName(String firstName) {
		this.password = firstName;
		return this;
	}
	
	public UserObject_Ios withLastName(String lastName) {
		this.password = lastName;
		return this;
	}
}