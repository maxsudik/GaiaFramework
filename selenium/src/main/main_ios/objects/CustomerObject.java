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