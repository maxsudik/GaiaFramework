package main.main_ios.objects;

import core.helpers.Helper;

public class CustomerObject {

	public String username;
	public String email;
	public String password;
	public String confirmPassword;
	public String firstname;
	public String lastname;
	public String fullName;
	public String phoneNumber;
	//public List<String> sites;
	
	 //Default value for fields
	public static final String DEFAULT_CUSTOMER_USERNAME = "Username";
	public static final String DEFAULT_CUSTOMER_EMAIL = "maksym.sudik+1@fortify.pro";
	public static final String DEFAULT_CUSTOMER_PASSWORD = "1111111111";
	public static final String DEFAULT_CUSTOMER__CONFIRM_PASSWORD = "1111111111";
	public static final String DEFAULT_CUSTOMER_FIRST_NAME = "First";
	public static final String DEFAULT_CUSTOMER_LAST_NAME= "Last";
	public static final String DEFAULT_CUSTOMER_PHONE_NUMBER= "7781111111";
	
	//Random value for fields
	public static final String RANDOW_CUSTOMER_USERNAME = DEFAULT_CUSTOMER_USERNAME + Helper.generateRandomInteger(3);
	
	
	
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
	
	public CustomerObject withConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return this;
	}
	
	public CustomerObject withFirstName(String firstname) {
		this.firstname = firstname;
		this.fullName = this.firstname + " " + this.lastname;
		return this;
	}
	
	public CustomerObject withLastName(String lastname) {
		this.lastname = lastname;
		/*this.fullName = this.firstname + " " + this.lastname;*/
		return this;
	}
	
	public CustomerObject withPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	
/*	public CustomerObject withSites(List<String> sites) {
		this.sites = sites;
		return this;
	}*/
}