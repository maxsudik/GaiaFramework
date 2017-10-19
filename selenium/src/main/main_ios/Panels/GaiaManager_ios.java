package main.main_ios.Panels;

import main.main_ios.pages.GaiaIos;

public class GaiaManager_ios extends GaiaIos {

	public LoginPanel login = new LoginPanel(this);
	public MainPanel main = new MainPanel(this);
	public InstallsPanel installs = new InstallsPanel(this);
	public ProductPanel product = new ProductPanel(this);
	public EstimatePanel estimate = new EstimatePanel(this);
	public AccountsPanel accounts = new AccountsPanel(this);
	public SitesPanel sites = new SitesPanel(this);
	public CustomersPanel customer = new CustomersPanel(this);
	public ReportsPanel report = new ReportsPanel(this);
}