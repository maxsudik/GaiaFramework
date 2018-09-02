package main.main_ios.objects;

import core.helpers.Helper;

public class InstallsObject {
	
	public String titleOfEstimate;
	public String phoneNumber;
	public String email;
	public String description;
	
	//Default values for fields
	public static final String DEFAULT_TITLE_NAME = "Title name";
	public static final String DEFAULT_PHONE_NUMBER = "7781111111";
	public static final String DEFAULT_EMAIL = "maksym.sudik+1@fortify.pro";
	public static final String DEFAULT_DESCRIPTION = "Some notes add description";
	
	//Random values for fields
	public static final String RANDOM_TITLE_NAME_STRING = DEFAULT_TITLE_NAME + Helper.generateRandomInteger(3);
	
	
	
	public InstallsObject withTitleOfEstimate(String titleOfEstimate) {
		this.titleOfEstimate = titleOfEstimate;
		return this;
	}
	
	public InstallsObject withPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	
	public InstallsObject withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public InstallsObject withDescription(String description) {
		this.description = description;
		return this;
	}
}
