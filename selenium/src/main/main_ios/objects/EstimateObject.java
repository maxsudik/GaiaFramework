package main.main_ios.objects;

public class EstimateObject {

	// set int to -1 default value
	public String title;
	public int customerName = -1;
	public int customerSite = -1;
	public String address;
	public String city;
	public String postalCode;
	public String phoneNumber;
	public String email;
	public String addDescription;
	public ProductObject product;
	public String total;
	public paymentType payment;
	
	public enum paymentType {
		CASH, 
		CHEQUE, 
		CREDIT
	}
	
	public EstimateObject withTitle(String title) {
		this.title = title;
		return this;
	}
	
	public EstimateObject withCustomerName(int customerName) {
		this.customerName = customerName;
		return this;
	}

	public EstimateObject withCustomerSite(int customerSite) {
		this.customerSite = customerSite;
		return this;
	}

	public EstimateObject withAddress(String address) {
		this.address = address;
		return this;
	}
	
	public EstimateObject withCity(String city) {
		this.city = city;
		return this;
	}
	
	public EstimateObject withPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}
	
	public EstimateObject withPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	
	public EstimateObject withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public EstimateObject withAddDescription(String addDescription) {
		this.addDescription = addDescription;
		return this;
	}
	
	public EstimateObject withProduct(ProductObject product) {
		this.product = product;
		return this;
	}
	
	public EstimateObject withTotal(String total) {
		this.total = total;
		return this;
	}
	
	public EstimateObject withPaymentType(paymentType payment) {
		this.payment = payment;
		return this;
	}
}