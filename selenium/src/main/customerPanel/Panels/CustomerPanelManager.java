package main.customerPanel.Panels;


public class CustomerPanelManager {


	public LoginPanel login = new LoginPanel(this);
	public PanelNavigation navigate = new PanelNavigation(this);
	public CompanyPanel company = new CompanyPanel(this);
	public SitesPanel sites = new SitesPanel(this);
	public PeoplePanel people = new PeoplePanel(this);
}