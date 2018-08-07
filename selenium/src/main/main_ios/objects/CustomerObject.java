package main.main_ios.objects;

import java.util.List;

public class CustomerObject {

	public String username;
	public String email;
	public String password;
	public String firstname;
	public String lastname;
	public String fullName;
	public String phoneNumber;
	public List<String> sites;
	
	 // default value for fields
	public static final String DEFAULT_USER_NAME = "zzz_customer";
	public static final String DEFAULT_EMAIL = "zzz_email";
	public static final String DEFAULT_PASSWORD = "1234567890";
	public static final String DEFAULT_FIRST_NAME = "zzz_first";
	public static final String DEFAULT_LAST_NAME= "auto";
	public static final String DEFAULT_PHONE_NUMBER= "6043722381";
	
	public CustomerObject withUserName(String username) {
		this.username = username;
		return this;
	}

	public CustomerObject withEmail(String email) {
		this.email = email;
		return this;
	}

	public CustomerObject withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public CustomerObject withFirstName(String firstname) {
		this.firstname = firstname;
		this.fullName = this.firstname + " " + this.lastname;
		return this;
	}
	
	public CustomerObject withLastName(String lastname) {
		this.lastname = lastname;
		this.fullName = this.firstname + " " + this.lastname;
		return this;
	}
	
	public CustomerObject withPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	
	public CustomerObject withSites(List<String> sites) {
		this.sites = sites;
		return this;
	}
}