package main.customerPanel.pages;


import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import core.driver.DriverObject;
import core.logger.PropertiesReader;

public class CustomerPanel {

	public static String GAIA_SITE = getUrl();

	public static DriverObject GetDriver() throws Exception {
		DriverObject driverObject = new DriverObject().withCapabilities(getCapability());
		return driverObject;
	}
	
	/**
	 * set url through maven using -D command
	 * eg. -DcraigslistSite = "www.test.com"
	 * @return
	 */
	public static String getUrl() {
	   if (!getUrlFromMaven().isEmpty()) { return getUrlFromMaven(); }
	   else if (!getUrlFromProperties().isEmpty()) { return getUrlFromProperties(); }
	   else return "https://customerdev3.gaialandscape.com/"; 
	}
	
	public static String getUrlFromMaven() {
		String value = System.getProperty("gaiaSite", "");
		return value;
	}
	
	public static String getUrlFromProperties() {
		try {
			return PropertiesReader.Property().getProperty("gaiaSite", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return "";
	}
	
	/**
	 * sets capability for web based apps
	 * 
	 * @return
	 * @throws IOException
	 */
	public static DesiredCapabilities getCapability() throws IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");

		// set phantomjs capabilities
		ArrayList<String> cliArgsCap = new ArrayList<String>();
		cliArgsCap.add("--web-security=false");
		cliArgsCap.add("--ssl-protocol=any");
		cliArgsCap.add("--ignore-ssl-errors=true");
		capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
		capabilities.setCapability("recordVideo", false);
		capabilities.setCapability("takesScreenshot", true);

		LoggingPreferences logs = new LoggingPreferences();
		logs.enable(LogType.DRIVER, Level.SEVERE);

		capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);

		capabilities.setBrowserName(PropertiesReader.getBrowser());
		return capabilities;
	}
}