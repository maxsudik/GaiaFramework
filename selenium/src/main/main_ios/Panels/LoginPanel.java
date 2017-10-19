package main.main_ios.Panels;

import core.helpers.ElementHelper;
import core.helpers.FormHelper;
import core.helpers.PageHelper;
import core.helpers.WaitHelper;
import core.webElement.EnhancedBy;
import io.appium.java_client.MobileBy;
import main.main_ios.objects.UserObject_Ios;

public class LoginPanel {

	GaiaManager_ios manager;

	public LoginPanel( GaiaManager_ios manager) {
		this.manager = manager;

	}

	private static final String USERNAME_FIELD = "XCUIElementTypeTextField";
	private static final String PASSWORD_FIELD = "XCUIElementTypeSecureTextField";
	private static final String LOGIN_SUBMIT = "Authenticate";
	private static final String GO_BUTTON = "Go";


	public static EnhancedBy byUserNameField() {
		return ElementHelper.BySelector(MobileBy.className(USERNAME_FIELD), "email field");
	}

	public static EnhancedBy byPasswordField() {
		return ElementHelper.BySelector(MobileBy.className(PASSWORD_FIELD), "password field");
	}

	public static EnhancedBy byLoginSubmit() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(LOGIN_SUBMIT), "submit");
	}
	
	public static EnhancedBy byGoButton() {
		return ElementHelper.BySelector(MobileBy.AccessibilityId(GO_BUTTON), "go button");
	}

	/**
	 * enter login info and click login button
	 * 
	 * @param user
	 */
	public void login(UserObject_Ios user) {
		// dismiss alerts
		PageHelper.dimissAlert();
		WaitHelper.waitForSeconds(1);
		PageHelper.dimissAlert();
	//	WaitHelper.waitForElementToLoad(byLoginSubmit(),1);
		
	//	if(Helper.isPresent( byUserNameField())) {
			FormHelper.setField(user.username, byUserNameField());
			FormHelper.setField(user.password, byPasswordField());
			FormHelper.formSubmit(byLoginSubmit(), byGoButton());
			FormHelper.formSubmit(byGoButton(), MainPanel.byGaiaLogo());
	//	}
	}
}