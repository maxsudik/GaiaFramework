package main.main_ios.objects;

import core.helpers.Helper;

public class InstallsObject {
	
	//Product
	public String productName;
	public String retailPrice;
	public String tag;
	public String additionalNotes;

	
	//Estimate
	public String titleOfEstimate;
	public String phoneNumber;
	public String email;
	public String description;
	//Hours wheel START
	public String start_day;
	public String start_hours;
	public String start_minutes;
	public String start_noon;
	//Hours wheel END
	public String end_day;
	public String end_hours;
	public String end_minutes;
	public String end_noon;
	
	//Payment amount
	public String paymentAmount;
	
	//Default values for Estimate
	public static final String DEFAULT_TITLE_NAME = "TitleName";
	public static final String DEFAULT_PHONE_NUMBER = "7781111111";
	public static final String DEFAULT_DESCRIPTION = "Some notes add description";
	//Spinner values SATRT HRS
	public static final String SATRT_DAY = "Mon Sep 24";
	public static final String SATRT_HOURS = "10";
	public static final String SATRT_MINUTES = "00";
	public static final String SATRT_NOON = "AM";
	//Spinner values END HRS
	public static final String END_DAY = "Wed Sep 26";
	public static final String END_HOURS = "6";
	public static final String END_MINUTES = "00";
	public static final String END_NOON = "PM";
	
	//Values for Payment amount
	public static final String PAYMENT_AMOUNT = "10.5";

	
	//Default values for Products
	public static final String PRODUCT_NAME = "ProductName";
	public static final String RETAIL_PRICE = "10";
	public static final String TAG = "First Product";
	public static final String ADDITIONAL_NOTES = "Some notes";

	
	//Random values for fields
	public static final String RANDOM_TITLE_NAME_STRING = DEFAULT_TITLE_NAME + Helper.generateRandomInteger(3);
	
	public InstallsObject withProductName(String productName) {
		this.productName = productName;
		return this;
	}
	

	
	public InstallsObject withProdcutRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
		return this;
	}
	
	public InstallsObject withProductTag(String tag) {
		this.tag = tag;
		return this;
	}
	
	public InstallsObject withProductAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
		return this;
	}
	
	public InstallsObject withEstimateTitle(String titleOfEstimate) {
		this.titleOfEstimate = titleOfEstimate;
		return this;
	}
	
	public InstallsObject withEstimateDescription(String description) {
		this.description = description;
		return this;
	}
	
	public InstallsObject withStartDay(String start_day) {
		this.start_day = start_day;
		return this;
	}
	
	public InstallsObject withStartHours(String start_hours) {
		this.start_hours = start_hours;
		return this;
	}
	
	public InstallsObject withStartMinutes(String start_day) {
		this.start_minutes = start_day;
		return this;
	}
	
	public InstallsObject withStartNoon(String start_noon) {
		this.start_noon = start_noon;
		return this;
	}
	
	public InstallsObject withEndDay(String end_day) {
		this.end_day = end_day;
		return this;
	}
	
	public InstallsObject withEndHours(String end_hours) {
		this.end_hours = end_hours;
		return this;
	}
	
	public InstallsObject withEndMinutes(String end_minutes) {
		this.end_minutes = end_minutes;
		return this;
	}
	
	public InstallsObject withEndNoon(String end_noon) {
		this.end_noon = end_noon;
		return this;
	}
	
	public InstallsObject withPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
		return this;
	}
}
