package main.main_ios.Panels;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;
import main.main_ios.objects.UserObject_Ios;

public class LoginPanel {

	GaiaIos manager;

	public LoginPanel( GaiaIos manager) {
		this.manager = manager;

	}
	
	public static class elements {
	    public static EnhancedBy USERNAME_FIELD = Element.byClass("XCUIElementTypeTextField", "email field");
	    public static EnhancedBy PASSWORD_FIELD = Element.byClass("XCUIElementTypeSecureTextField", "password field");
	    public static EnhancedBy LOGIN_SUBMIT = Element.byAccessibility("Authenticate", "submit");
	    public static EnhancedBy GO_BUTTON = Element.byAccessibility("Go", "go button");
	}

	/**
	 * enter login info and click login button
	 * 
	 * @param user
	 */
	public void login(UserObject_Ios user) {
		// dismiss alerts
		Helper.dimissAlert();
		Helper.waitForSeconds(2);
		Helper.dimissAlert();
		
		Helper.setField(elements.USERNAME_FIELD, user.username);
		Helper.setField(elements.PASSWORD_FIELD, user.password);
		Helper.formSubmit(elements.LOGIN_SUBMIT, elements.GO_BUTTON);
		Helper.formSubmit(elements.GO_BUTTON, MainPanel.elements.GAIA_LOGO);
	}
	
	/**
	 * login as default supervisor
	 */
	public void loginSupervisor() {
		UserObject_Ios user = new UserObject_Ios()
				.withUsername(UserObject_Ios.SUPERVISOR_USERNAME)
				.withPassword(UserObject_Ios.SUPERVISOR_PASSWORD);
		login(user);
	}
	
	/**
	 * login as default manager
	 */
	public void loginManager() {
		UserObject_Ios user = new UserObject_Ios()
				.withUsername(UserObject_Ios.MANAGER_USERNAME)
				.withPassword(UserObject_Ios.MANAGER_PASSWORD);
		login(user);
		
		
		
		
	}
}