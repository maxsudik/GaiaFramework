package main.customerPanel.objects;


public class CompanyObject {

	public String name;
	public String email;
	public String licenseLimit;

	public CompanyObject withNamel(String name) {
		this.name = name;
		return this;
	}

	public CompanyObject withEmail(String email) {
		this.email = email;
		return this;
	}

	public CompanyObject withLicenseLimit(String licenseLimit) {
		this.licenseLimit = licenseLimit;
		return this;
	}
}