package main;

import main.customerPanel.Panels.CustomerPanelManager;
import main.main_ios.Panels.GaiaManager_ios;

/**
 * Manages all existing apps Abstract driver refers to this manager to call
 * methods in different apps
 */
public class AppManager{


	public CustomerPanelManager customerPanel = new CustomerPanelManager();
	public GaiaManager_ios gaia = new GaiaManager_ios();
}