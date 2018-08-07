package main.main_ios;


import core.driver.driverProperties.driverType.DriverType;
import core.driver.driverProperties.capabilities.IosCapability;
import core.driver.objects.DriverObject;
import main.main_ios.Panels.AccountsPanel;
import main.main_ios.Panels.CustomersPanel;
import main.main_ios.Panels.EstimatePanel;
import main.main_ios.Panels.InstallsPanel;
import main.main_ios.Panels.LoginPanel;
import main.main_ios.Panels.MainPanel;
import main.main_ios.Panels.ProductPanel;
import main.main_ios.Panels.ReportsPanel;
import main.main_ios.Panels.SitesPanel;

public class GaiaIos {
    
	
	// panel list
	public LoginPanel login = new LoginPanel(this);
	public MainPanel main = new MainPanel(this);
	public InstallsPanel installs = new InstallsPanel(this);
	public ProductPanel product = new ProductPanel(this);
	public EstimatePanel estimate = new EstimatePanel(this);
	public AccountsPanel accounts = new AccountsPanel(this);
	public SitesPanel sites = new SitesPanel(this);
	public CustomersPanel customer = new CustomersPanel(this);
	public ReportsPanel report = new ReportsPanel(this);
	

    /**
     * sets url and browser capabilities URL from maven or properties file will
     * override the current url
     *
     * @return driver object
     */
    public DriverObject getDriver() {
        IosCapability capability = new IosCapability()
                .withIosCapability();
        return new DriverObject().withDriverType(DriverType.IOS_DRIVER)
                .withCapabilities(capability.getCapability());
    }
}
