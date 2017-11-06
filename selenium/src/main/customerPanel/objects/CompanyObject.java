package main.customerPanel.objects;


public class CompanyObject {

	public String name;
	public String email;
	public String taxNumber;
	public String address;
	public String city;
	public String country;
	public String state;
	public String zipCode;
	public String licenseLimit;

	public CompanyObject withName(String name) {
		this.name = name;
		return this;
	}
	
	public CompanyObject withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public CompanyObject withTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
		return this;
	}
	
	public CompanyObject withAddress(String address) {
		this.address = address;
		return this;
	}
	
	public CompanyObject withCity(String city) {
		this.city = city;
		return this;
	}
	
	public CompanyObject withCountry(String country) {
		this.country = country;
		return this;
	}
	
	public CompanyObject withState(String state) {
		this.state = state;
		return this;
	}
	
	public CompanyObject withZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	public CompanyObject withLicenseLimit(String licenseLimit) {
		this.licenseLimit = licenseLimit;
		return this;
	}
}