package main.java.main.customerPanel.objects;




public class CompanyObject {
	
	public String name;
	public String email;
	public String tax;
	public String type;
	public String currency;
	public String description;
	
	public static final String COMPANY_NAME = "CompanyName";
	public static final String COMPANY_EMAIL = "maksym.sudik@frotify.pro";
	public static final String COMPANY_TAX_NUMBER = "111";
	public static final String COMPANY_TYPE = "Landscape";
	public static final String COMPANY_CURRENCY = "CAD";
	public static final String COMPANY_DESCRIPTION = "Some description";

	
	public CompanyObject withName(String name) {
		this.name = name;
		return this;
	}
	
	public CompanyObject withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public CompanyObject withTax(String tax) {
		this.tax = tax;
		return this;
	}
	
	public CompanyObject withType(String type) {
		this.type = type;
		return this;
	}
	
	public CompanyObject withCurrency(String currency) {
		this.currency = currency;
		return this;
	}
	
	public CompanyObject withDescription(String description) {
		this.description = description;
		return this;
	}
	

}