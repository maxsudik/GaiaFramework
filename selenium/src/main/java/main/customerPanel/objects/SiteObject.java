package main.customerPanel.objects;


public class SiteObject {

	public String name;
	public String radius;
	public String company;
	public String address;
	public String postalCode;
	public String city;
	public String state;
	public String country;

	public SiteObject withName(String name) {
		this.name = name;
		return this;
	}

	public SiteObject withRadius(String radius) {
		this.radius = radius;
		return this;
	}

	public SiteObject withCompany(String company) {
		this.company = company;
		return this;
	}
	
	public SiteObject withAddress(String address) {
		this.address = address;
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
	
	public SiteObject withstate(String state) {
		this.state = state;
		return this;
	}
	
	public SiteObject withCountry(String country) {
		this.country = country;
		return this;
	}
}