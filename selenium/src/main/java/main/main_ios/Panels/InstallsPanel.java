package main.main_ios.Panels;




import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;
import main.main_ios.objects.EmployeesObject;
import main.main_ios.objects.InstallsObject;
import main.main_ios.objects.SiteObject;

public class InstallsPanel {

	GaiaIos manager;

	public InstallsPanel( GaiaIos manager) {
		this.manager = manager;

	}
	
	public static class elements {

		//Main installs panel
		public static EnhancedBy ADD_ESTIMATE_BUTTON = Element.byAccessibility("+ Add Estimate", "add estimate");
		public static EnhancedBy SELECT_SITE_BUTTON = Element.byAccessibility("Select Site", "select side");
		
		
		
		//Float left Panel
		public static EnhancedBy DOUBLE_ARROW = Element.byXpath("//XCUIElementTypeApplication[@name=\"Gaia\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]", "double arrow");
		public static EnhancedBy ADD_PRODUCTS_BUTTON = Element.byAccessibility("+ Add Product", "add estimate");
		
		
		
		//Add product pop up window
		public static EnhancedBy PRODUCT_PLANT_BUTTON = Element.byAccessibility("Plant Button", "plant");
		public static EnhancedBy PRODUCT_PRODUCT_NAME_FIELD = Element.byAccessibility("Product Name Field", "product name");
		public static EnhancedBy PRODUCT_RETAIL_PRICE_FIELD = Element.byXpath("(//XCUIElementTypeTextField[@name=\"Price Per Unit Field\"])[1]", "retail price");
		
		public static EnhancedBy PRODUCT_CURRENCY_DDL = Element.byXpath("(//XCUIElementTypeButton[@name=\"CurrencyDropDown\"])[1]", "currency");
		public static EnhancedBy PRODUCT_CURRENCY_CAD_DDLMI = Element.byXpath("//XCUIElementTypeApplication[@name=\"Gaia\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeTable/XCUIElementTypeCell[1]", "CAD");

		public static EnhancedBy PRODUCT_UNIT_DDL = Element.byXpath("(//XCUIElementTypeButton[@name=\"CurrencyDropDown\"])[2]", "unit");
		public static EnhancedBy PRODUCT_CM_DDLMI = Element.byXpath("//XCUIElementTypeApplication[@name=\"Gaia\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeTable/XCUIElementTypeCell[1]", "unit");

		public static EnhancedBy PRODUCT_TAG_FIELD = Element.byXpath("(//XCUIElementTypeTextField[@name=\"Price Per Unit Field\"])[2]", "tag");
		public static EnhancedBy PRODUCT_ADDITIONAL_NOTES_FIELD = Element.byAccessibility("Additional Notes Field", "additional notes");
		public static EnhancedBy PRODUCT_CANCEL_BUTTON = Element.byAccessibility("Cancel", "cancel");
		public static EnhancedBy PRODUCT_SAVE_BUTTON = Element.byAccessibility("Save", "save");
		public static EnhancedBy PRODUCT_POP_UP_CLOSE_BUTTON = Element.byAccessibility("Close", "close");
		
		
		
		//Pop-up pick a site window
		public static EnhancedBy ESTIMATE_SITE_NAME_BUTTON = Element.byAccessibility(SiteObject.DEFAULT_SITE, "site name");
		public static EnhancedBy DONE_KEYBOARD_BUTTON = Element.byAccessibility("Toolbar Done Button", "KeyBoard Done");

		
		
		//Customer info pop-up
		public static EnhancedBy ESTIMATE_TITLE_OF_ESTIMATE_FIELD = Element.byAccessibility("Estimation Title", "title of estimate");
		public static EnhancedBy ESTIMATE_CUSTOMER_SITE_BUTTON = Element.byClass("XCUIElementTypeOther", "6 customer site");
		public static EnhancedBy ESTIMATE_SITE_NAME_DDL = Element.byAccessibility("Customer Dropdown", "site name");
		public static EnhancedBy ESTIMATE_CUSTOMER_NAME_DDL = Element.byAccessibility("Site Dropdown", "customer name");
		public static EnhancedBy ESTIMATE_PHONE_NUMBER_FIELD = Element.byAccessibility("Phone Number Field", "phone number");
		public static EnhancedBy ESTIMATE_EMAIL_FIELD = Element.byAccessibility("Email Field", "email");
		public static EnhancedBy ESTIMATE_ADD_DESCRIPTION_FIELD = Element.byAccessibility("Add Description Field", "add description");
		
		public static EnhancedBy ESTIMATE_PHOTOS_ICON = Element.byAccessibility("Add Photo Button", "photos");
		//Pick a photo pop-up
		public static EnhancedBy ESTIMATE_SELECT_FROM_LIBRARY_BUTTON = Element.byAccessibility("Select from Library", "select from library");
		public static EnhancedBy ESTIMATE_PHOTO_CATEGOTY_ICON = Element.byAccessibility("Moments", "moments");
		public static EnhancedBy ESTIMATE_PHOTO = Element.byAccessibility("Photo, Landscape, October 09, 2009, 2:09 PM", "photo");
		
		public static EnhancedBy ESTIMATE_PRODUCTS_DDL = Element.byAccessibility("Add Product Dropdown", "products");
		//Products														  (//XCUIElementTypeTextField[@name="Choose Product"])[1]
		public static EnhancedBy PRODUCT_NAME_OPTION = Element.byAccessibility(InstallsObject.PRODUCT_NAME, "product name");
		public static EnhancedBy ADD_PRODUCT_BUTTON = Element.byAccessibility("Add Product", "add product");
		
		public static EnhancedBy ESTIMATE_EMPLOYEES_DDL = Element.byAccessibility("Add Employees Dropdown", "employees");
		//Employees
		public static EnhancedBy EMPLOYEES_NAME_OPTION = Element.byAccessibility(EmployeesObject.SUPERVISOR_FULL_NAME, "employees name");
		public static EnhancedBy ADD_EMPLOYEES_BUTTON = Element.byAccessibility("Add Employee", "add employee");
		
		//Hours counter for employees
		public static EnhancedBy START_FIELD = Element.byAccessibility("Start Time TextField", "start");
		public static EnhancedBy END_FIELD = Element.byAccessibility("End Time TextField", "end");
		//Spinner
		public static EnhancedBy DAY_SPINNER = Element.byClass("XCUIElementTypePickerWheel", "day");
		public static EnhancedBy HOURS_SPINNER = Element.byClass("XCUIElementTypePickerWheel", "hours");
		public static EnhancedBy MINUTES_SPINNER = Element.byClass("XCUIElementTypePickerWheel", "minutes");
		public static EnhancedBy NOON_SPINNER = Element.byClass("XCUIElementTypePickerWheel", "noon");
		public static EnhancedBy DONE_SPINNER_BUTTON = Element.byAccessibility("Done", "Done");
		
		//Bottom object
		public static EnhancedBy INSTALL_PROGRESS_OBJECT = Element.byAccessibility("Install Progress", "install progress");

		
		//Pop up Close
		public static EnhancedBy CLOSE_BUTTON = Element.byAccessibility("Close", "close");
		public static EnhancedBy BACK_BUTTON = Element.byAccessibility("gaia logo", "close");



		public static EnhancedBy ESTIMATE_SAVE_BUTTON = Element.byAccessibility("Save", "save");
		public static EnhancedBy ESTIMATE_SEND_BUTTON = Element.byAccessibility("Send", "send");
		public static EnhancedBy ESTIMATE_PROCESS_PAYMENT_BUTTON = Element.byAccessibility("Process Payment", "process payment");
		
		
		//Pay estimate objects
		public static EnhancedBy ESTIMATE_NAME = Element.byXpath("(//XCUIElementTypeStaticText[@name=\"TitleName\"])[1]", "kukuku");
		public static EnhancedBy ESTIMATE_CLOSE_BUTTON = Element.byAccessibility("close btn", "");
		public static EnhancedBy ESTIMATE_TOTAL_FIELD = Element.byAccessibility("total amount", "");
		public static EnhancedBy ESTIMATE_CASH_BUTTON = Element.byAccessibility("Cash", "");
		public static EnhancedBy ESTIMATE_CHEQUE_BUTTON = Element.byAccessibility("Cheque", "cheque");
		public static EnhancedBy ESTIMATE_CREDIT_BUTTON = Element.byAccessibility("Credit", "credit");
		public static EnhancedBy ESTIMATE_POP_UP_CLOSE_BUTTON = Element.byAccessibility("Close", "close");
		public static EnhancedBy ESTIMATE_FULLY_PAID = Element.byXpath("(//XCUIElementTypeStaticText[@name=\"FULLY PAID\"])[1]", "fully paid");

		
		
	}
	
	public void addEstimate (InstallsObject installs) {
		
		
		Helper.clickAndExpect(elements.ADD_ESTIMATE_BUTTON, elements.ESTIMATE_SITE_NAME_BUTTON);
		Helper.clickAndExpect(elements.ESTIMATE_SITE_NAME_BUTTON, elements.ESTIMATE_TITLE_OF_ESTIMATE_FIELD);
		
		Helper.setField(elements.ESTIMATE_TITLE_OF_ESTIMATE_FIELD, installs.titleOfEstimate);
		Helper.setField(elements.ESTIMATE_ADD_DESCRIPTION_FIELD, installs.description);
		
		Helper.clickAndExpect(elements.ESTIMATE_PHOTOS_ICON, elements.ESTIMATE_SELECT_FROM_LIBRARY_BUTTON);
		Helper.clickAndNotExpect(elements.ESTIMATE_SELECT_FROM_LIBRARY_BUTTON, elements.ESTIMATE_SELECT_FROM_LIBRARY_BUTTON);
		Helper.clickAndExpect(elements.ESTIMATE_PHOTO_CATEGOTY_ICON, elements.ESTIMATE_PHOTO);
		Helper.clickAndNotExpect(elements.ESTIMATE_PHOTO, elements.ESTIMATE_PHOTO);
		Helper.mobile_hideKeyboard();
		
		//Helper.mobile_scrollToiOS(elements.INSTALL_PROGRESS_OBJECT);
		//new MobileHelper().scrollToDirection_iOS_XCTest(elements.INSTALL_PROGRESS_OBJECT, "d");
		//new MobileHelper().swipeToDirection_iOS_XCTest(elements.INSTALL_PROGRESS_OBJECT, "d");
		Helper.scrollDownAndroid();
		
		
		Helper.clickAndExpect(elements.ESTIMATE_PRODUCTS_DDL, elements.PRODUCT_NAME_OPTION);
		Helper.clickAndExpect(elements.PRODUCT_NAME_OPTION, elements.ADD_PRODUCT_BUTTON);
		Helper.clickAndExpect(elements.ADD_PRODUCT_BUTTON, elements.ESTIMATE_SAVE_BUTTON);
		//Helper.clickAndExpect(elements.ESTIMATE_PRODUCTS_DDL, elements.ESTIMATE_SAVE_BUTTON);
		Helper.scrollDownAndroid();
		
		Helper.clickAndExpect(elements.ESTIMATE_EMPLOYEES_DDL, elements.EMPLOYEES_NAME_OPTION);
		Helper.clickAndExpect(elements.EMPLOYEES_NAME_OPTION, elements.ADD_EMPLOYEES_BUTTON);
		Helper.clickAndExpect(elements.ADD_EMPLOYEES_BUTTON, elements.ESTIMATE_SAVE_BUTTON);
		//Helper.clickAndExpect(elements.ESTIMATE_EMPLOYEES_DDL, elements.ESTIMATE_SAVE_BUTTON);
		Helper.scrollDownAndroid();
		
		Helper.clickAndExpect(elements.START_FIELD, elements.DAY_SPINNER);
		//Can't set the value for day
		//Helper.setField(installs.start_day, elements.DAY_SPINNER, 0);
		Helper.setField(installs.start_hours, elements.HOURS_SPINNER, 1);
		Helper.setField(installs.start_minutes, elements.MINUTES_SPINNER, 2);
		Helper.setField(installs.start_noon, elements.NOON_SPINNER, 3);
		Helper.clickAndExpect(elements.DONE_SPINNER_BUTTON, elements.END_FIELD);
		
		
		Helper.clickAndExpect(elements.END_FIELD, elements.DAY_SPINNER);
		//Can't set the value for day
		//Helper.setField(installs.end_day, elements.DAY_SPINNER, 0);
		Helper.setField(installs.end_hours, elements.HOURS_SPINNER, 1);
		Helper.setField(installs.end_minutes, elements.MINUTES_SPINNER, 2);
		Helper.setField(installs.end_noon, elements.NOON_SPINNER, 3);
		Helper.clickAndExpect(elements.DONE_SPINNER_BUTTON, elements.ESTIMATE_SAVE_BUTTON);
		
		Helper.clickAndExpect(elements.ESTIMATE_SAVE_BUTTON, elements.CLOSE_BUTTON);
		Helper.clickAndExpect(elements.CLOSE_BUTTON, elements.BACK_BUTTON);
	}
	public void addProduct(InstallsObject installs) {
		Helper.clickAndExpect(elements.DOUBLE_ARROW, elements.ADD_PRODUCTS_BUTTON);
		Helper.clickAndExpect(elements.ADD_PRODUCTS_BUTTON, elements.PRODUCT_SAVE_BUTTON);
		Helper.clickAndExpect(elements.PRODUCT_PLANT_BUTTON, elements.PRODUCT_PRODUCT_NAME_FIELD);
		Helper.setField(elements.PRODUCT_PRODUCT_NAME_FIELD, installs.productName);
		Helper.setField(elements.PRODUCT_RETAIL_PRICE_FIELD, installs.retailPrice);
		Helper.clickAndExpect(elements.PRODUCT_CURRENCY_DDL, elements.PRODUCT_CURRENCY_CAD_DDLMI);
		Helper.clickAndExpect(elements.PRODUCT_CURRENCY_CAD_DDLMI, elements.PRODUCT_UNIT_DDL);
		Helper.clickAndExpect(elements.PRODUCT_UNIT_DDL, elements.PRODUCT_CM_DDLMI);
		Helper.clickAndExpect(elements.PRODUCT_CM_DDLMI, elements.PRODUCT_TAG_FIELD);
		Helper.setField(elements.PRODUCT_TAG_FIELD, installs.tag);
		Helper.setField(elements.PRODUCT_ADDITIONAL_NOTES_FIELD, installs.additionalNotes);
		Helper.clickAndExpect(elements.PRODUCT_SAVE_BUTTON, elements.PRODUCT_POP_UP_CLOSE_BUTTON);
		Helper.clickAndExpect(elements.PRODUCT_POP_UP_CLOSE_BUTTON, elements.ADD_PRODUCTS_BUTTON);
	}
	
	public void payEstimate(InstallsObject installs) {
		Helper.clickAndExpect(elements.ESTIMATE_NAME, elements.ESTIMATE_SEND_BUTTON);
		Helper.clickAndExpect(elements.ESTIMATE_PROCESS_PAYMENT_BUTTON, elements.ESTIMATE_TOTAL_FIELD);
		Helper.clearAndSetField(elements.ESTIMATE_TOTAL_FIELD, installs.paymentAmount);
		Helper.clickAndExpect(elements.ESTIMATE_CASH_BUTTON, elements.ESTIMATE_POP_UP_CLOSE_BUTTON);
		Helper.clickAndExpect(elements.ESTIMATE_POP_UP_CLOSE_BUTTON, elements.BACK_BUTTON);
		Helper.clickAndExpect(elements.BACK_BUTTON, elements.ESTIMATE_FULLY_PAID);
		Helper.verifyElementIsDisplayed(elements.ESTIMATE_FULLY_PAID);
	}

}
