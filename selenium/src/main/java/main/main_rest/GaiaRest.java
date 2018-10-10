package main.main_rest;


import core.driver.driverProperties.driverType.DriverType;
import core.driver.objects.DriverObject;
import main.main_rest.Panels.CompaniesPanel;
import main.main_rest.Panels.LoginPanel;
import main.main_rest.Panels.PeoplePanel;
import main.main_rest.Panels.SitesPanel;

public class GaiaRest {

	// app info
	
	public static String APP = "gaiaApi";
	
	// panel list
	public LoginPanel login = new LoginPanel(this);
	public CompaniesPanel company = new CompaniesPanel(this);
	public SitesPanel site = new SitesPanel(this);
	public PeoplePanel people = new PeoplePanel(this);


	/**
	 * sets url and  browser capabilities
	 * URL from maven or properties file will override the current values
	 * @return driver object
	 */
	public DriverObject getDriver() {	
		return new DriverObject().withDriverType(DriverType.API)
				.withApp(APP);
	}	
}