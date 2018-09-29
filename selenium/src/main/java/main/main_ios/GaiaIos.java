package main.java.main.main_ios;


import core.driver.driverProperties.driverType.DriverType;
import core.driver.driverProperties.capabilities.IosCapability;
import core.driver.objects.DriverObject;
import main.java.main.main_ios.Panels.CustomersPanel;
import main.java.main.main_ios.Panels.EmployeesPanel;
import main.java.main.main_ios.Panels.EquipmentPanel;
import main.java.main.main_ios.Panels.EstimatePanel;
import main.java.main.main_ios.Panels.InstallsPanel;
import main.java.main.main_ios.Panels.LoginPanel;
import main.java.main.main_ios.Panels.MainPanel;
import main.java.main.main_ios.Panels.ProductPanel;
import main.java.main.main_ios.Panels.ReportsPanel;
import main.java.main.main_ios.Panels.SitesPanel;
import main.java.main.main_ios.Panels.OnboardingPanels.CompanyAddressPanel;
import main.java.main.main_ios.Panels.OnboardingPanels.CompanyBankInformationPanel;
import main.java.main.main_ios.Panels.OnboardingPanels.CreditCardInfoPanel;
import main.java.main.main_ios.Panels.OnboardingPanels.CreditCardInformationPanel;
import main.java.main.main_ios.Panels.OnboardingPanels.LegalEntityPanel;
import main.java.main.main_ios.Panels.OnboardingPanels.ScanCreditCardPanel;





public class GaiaIos {
    
	
	// panel list
	public LoginPanel login = new LoginPanel(this);
	public CreditCardInfoPanel creditCardInfo = new CreditCardInfoPanel(this);
	public CompanyAddressPanel companyAddress = new CompanyAddressPanel(this);
	public CompanyBankInformationPanel companyBankInformation = new CompanyBankInformationPanel(this);
	public LegalEntityPanel legalEntity = new LegalEntityPanel(this);
	public ScanCreditCardPanel scanCreditCard = new ScanCreditCardPanel(this);
	public CreditCardInformationPanel creditCardInformation = new CreditCardInformationPanel(this);
	public MainPanel main = new MainPanel(this);
	public ReportsPanel report = new ReportsPanel(this);
	public SitesPanel sites = new SitesPanel(this);
	public InstallsPanel installs = new InstallsPanel(this);
	public CustomersPanel customer = new CustomersPanel(this);
	public EquipmentPanel equipment = new EquipmentPanel(this);
	public EmployeesPanel employees = new EmployeesPanel(this);

	public ProductPanel product = new ProductPanel(this);
	public EstimatePanel estimate = new EstimatePanel(this);
	

    /**
     * sets url and browser capabilities URL from maven or properties file will
     * override the current url
     *
     * @return driver object
     */
    public DriverObject getDriver() {
    	System.setProperty("isSingleSignIn", "true");
        IosCapability capability = new IosCapability()
                .withIosCapability();
        return new DriverObject().withDriverType(DriverType.IOS_DRIVER)
                .withCapabilities(capability.getCapability());
        
    }
}
