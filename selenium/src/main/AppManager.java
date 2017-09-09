package main;

import main.customerPanel.Panels.CustomerPanelManager;

/**
 * Manages all existing apps Abstract driver refers to this manager to call
 * methods in different apps
 */
public class AppManager{


	public CustomerPanelManager customerPanel = new CustomerPanelManager();
}