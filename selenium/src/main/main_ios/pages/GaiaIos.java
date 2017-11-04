package main.main_ios.pages;


import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

import core.driver.DriverObject;
import core.driver.DriverObject.WebDriverType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class GaiaIos {
	
	public static boolean isTestRunning = false;
	
	public static DriverObject GetDriver() {
		DriverObject driverObject = new DriverObject().withDriverType(WebDriverType.IOS_DRIVER).withCapabilities(getIosCapability());
		return driverObject;
	}
	
	/**
	 * sets capability of ios based apps
	 * 
	 * @return
	 */
	public static DesiredCapabilities getIosCapability() {
		// https://github.com/appium/appium
		// user appium desktop app for locator
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "../apps/");
		File app = new File(appDir, "Gaia.app");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.1");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPad Air 2");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		//capabilities.setCapability("orientation", ScreenOrientation.LANDSCAPE);
		//capabilities.setCapability("bundleId", "com.conquermobile.HeadCheck");
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("noReset", false);
       // capabilities.setCapability("wdaLocalPort", 8001 + random);
       // capabilities.setCapability("useNewWDA", true);
		
		isTestRunning = false;
		if(isTestRunning)
			capabilities.setCapability("noReset", true);
		else {
			capabilities.setCapability("noReset", false);
			isTestRunning = true;
		}

		return capabilities;
	}
}