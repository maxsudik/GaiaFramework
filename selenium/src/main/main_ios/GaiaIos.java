package main.main_ios;


import core.driver.driverProperties.driverType.DriverType;
import core.driver.driverProperties.capabilities.IosCapability;
import core.driver.objects.DriverObject;
import main.main_ios.Panels.CustomersPanel;
import main.main_ios.Panels.EmployeesPanel;
import main.main_ios.Panels.EquipmentPanel;
import main.main_ios.Panels.EstimatePanel;
import main.main_ios.Panels.InstallsPanel;
import main.main_ios.Panels.LoginPanel;
import main.main_ios.Panels.MainPanel;
import main.main_ios.Panels.ProductPanel;
import main.main_ios.Panels.ReportsPanel;
import main.main_ios.Panels.SitesPanel;
import main.main_ios.Panels.OnboardingPanels.CompanyAddressPanel;
import main.main_ios.Panels.OnboardingPanels.CompanyBankInformationPanel;
import main.main_ios.Panels.OnboardingPanels.CreditCardInfoPanel;
import main.main_ios.Panels.OnboardingPanels.CreditCardInformationPanel;
import main.main_ios.Panels.OnboardingPanels.LegalEntityPanel;
import main.main_ios.Panels.OnboardingPanels.ScanCreditCardPanel;





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
        IosCapability capability = new IosCapability()
                .withIosCapability();
        return new DriverObject().withDriverType(DriverType.IOS_DRIVER)
                .withCapabilities(capability.getCapability());
    }
}
