package main.customerPanel.objects;


public class SiteObject {

	public String name;
	public String radius;
	public String company;

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
}