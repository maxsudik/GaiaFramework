package main.main_ios.Panels;

import core.helpers.Element;
import core.webElement.EnhancedBy;
import io.appium.java_client.MobileBy;

public class InstallsPanel {

	GaiaManager_ios manager;

	public InstallsPanel( GaiaManager_ios manager) {
		this.manager = manager;

	}

	private static final String ADD_PRODUCT_BUTTON = "+ Add Product";
	private static final String ADD_ESTIMATE_BUTTON = "+ Add Estimate";


	public static EnhancedBy byAddProductButton() {
		return Element.bySelector(MobileBy.AccessibilityId(ADD_PRODUCT_BUTTON), "add products button");
	}
	
	public static EnhancedBy byAddEstimateButton() {
		return Element.bySelector(MobileBy.AccessibilityId(ADD_ESTIMATE_BUTTON), "add estimate button");
	}
}