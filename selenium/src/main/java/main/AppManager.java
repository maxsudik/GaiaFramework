package main.java.main;

import main.java.main.customerPanel.CustomerPanel;
import main.java.main.main_ios.GaiaIos;
import main.java.main.main_rest.GaiaRest;

/**
 * Manages all existing apps Abstract driver refers to this manager to call
 * methods in different apps
 */
public class AppManager{


	public CustomerPanel customerPanel = new CustomerPanel();
	public GaiaIos gaia = new GaiaIos();
	public GaiaRest rest = new GaiaRest();
}