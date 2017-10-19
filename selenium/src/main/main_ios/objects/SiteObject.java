package main.main_ios.objects;

public class SiteObject {

	public String sitename;
	public String street;
	public String postalCode;
	public String city;
	public String state;
	public String country;
	

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