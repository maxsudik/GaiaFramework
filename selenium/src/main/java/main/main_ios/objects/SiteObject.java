package main.java.main.main_ios.objects;

import core.helpers.Helper;

public class SiteObject {

	public String sitename;
	public String street;
	public String postalCode;
	public String city;
	public String state;
	public String country;
	
	// Default value for fields
	public static final String DEFAULT_SITE = "SiteName";
	public static final String DEFAULT_STREET = "123 main street";
	public static final String DEFAULT_POSTAL_CODE = "V0V0V0";
	public static final String DEFAULT_CITY = "Vancouver";
	public static final String DEFAULT_STATE = "BC";
	public static final String DEFAULT_COUTRY = "Canada";
	public static final String DEFAULT_PHONE_NUMBER = "7781111111";
	
	//Random value for fields
	public static final String RANDOM_SITE = DEFAULT_SITE + Helper.generateRandomInteger(3);
	
	

	public SiteObject withSiteName(String sitename) {
		this.sitename = sitename;
		return this;
	}

	public SiteObject withStreetName(String street) {
		this.street = street;
		return this;
	}

	public SiteObject withPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}
	
	public SiteObject withCity(String city) {
		this.city = city;
		return this;
	}
	
	public SiteObject withState(String state) {
		this.state = state;
		return this;
	}
	
	public SiteObject withCountry(String country) {
		this.country = country;
		return this;
	}
}