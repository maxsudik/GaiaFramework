package main.java.main.main_rest;


import core.driver.driverProperties.driverType.DriverType;
import core.driver.objects.DriverObject;
import io.restassured.RestAssured;
import main.java.main.main_rest.Panels.CompaniesPanel;
import main.java.main.main_rest.Panels.LoginPanel;
import main.java.main.main_rest.Panels.PeoplePanel;
import main.java.main.main_rest.Panels.SitesPanel;

public class GaiaRest {

	// app info
	
	public static String APP = "gaiaApi";
	public static String URL = "https://apidev7.gaialandscape.com/";
	public static String BASE_PATH ="/api";
	
	// panel list
	public LoginPanel login = new LoginPanel(this);
	public CompaniesPanel company = new CompaniesPanel(this);
	public SitesPanel site = new SitesPanel(this);
	public PeoplePanel people = new PeoplePanel(this);


	/**
	 * sets url and  browser capabilities
	 * URL from maven or properties file will override the current url
	 * @return driver object
	 */
	public DriverObject getDriver() {
		RestAssured.baseURI = URL;
		RestAssured.basePath = BASE_PATH;
		
		return new DriverObject().withDriverType(DriverType.API)
				.withApp(APP);
	}	
}