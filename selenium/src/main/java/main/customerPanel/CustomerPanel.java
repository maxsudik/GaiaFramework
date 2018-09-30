package main.customerPanel;




import core.driver.driverProperties.capabilities.webCapability;
import core.driver.objects.DriverObject;
import main.customerPanel.Panels.CompanyPanel;
import main.customerPanel.Panels.LoginPanel;
import main.customerPanel.Panels.PanelNavigation;
import main.customerPanel.Panels.PeoplePanel;
import main.customerPanel.Panels.SitesPanel;


public class CustomerPanel {

	// app info
	public static String APP = "customerPanel";
	public static String URL = "https://customerdev7.gaialandscape.com/";
	
	// panel list
	public LoginPanel login = new LoginPanel(this);
	public PanelNavigation navigate = new PanelNavigation(this);
	public CompanyPanel company = new CompanyPanel(this);
	public SitesPanel sites = new SitesPanel(this);
	public PeoplePanel people = new PeoplePanel(this);

	
	

	/**
	 * sets url and  browser capabilities
	 * URL from maven or properties file will override the current url
	 * @return driver object
	 */
	public DriverObject getDriver() {
		webCapability capability = new webCapability().withBrowserCapability();
		
		return new DriverObject()
				.withApp(APP)
				.withDriverType(capability.getWebDriverType())
				.withBrowserType(capability.getBrowser())
				.withDriverVersion(capability.getDriverVersion())
				.withUrl(capability.getUrl(APP, URL))
				
				.withCapabilities(capability.getCapability());
	}	
}