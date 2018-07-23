package main.main_ios.objects;

public class UserObject_Ios {

	public String email;
	public String username;
	public String password;
	public String firstName;
	public String lastName;

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