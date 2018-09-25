package main.main_ios.Panels;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.main_ios.GaiaIos;
import main.main_ios.Panels.OnboardingPanels.CreditCardInfoPanel;
import main.main_ios.objects.UserObject_Ios;

public class LoginPanel {

	GaiaIos manager;

	public LoginPanel( GaiaIos manager) {
		this.manager = manager;

	}
	
	public static class elements {
	    public static EnhancedBy USERNAME_FIELD = Element.byClass("XCUIElementTypeTextField", "email field");
	    public static EnhancedBy PASSWORD_FIELD = Element.byClass("XCUIElementTypeSecureTextField", "password field");
	    public static EnhancedBy AUTHENTICATE_BUTTON = Element.byAccessibility("Authenticate", "submit");
	    public static EnhancedBy GO_BUTTON = Element.byAccessibility("Go", "go button");
	    public static EnhancedBy FORGOT_PASSWORD_BUTTON = Element.byAccessibility("Forgot Password", "Forgot password");
	    public static EnhancedBy POP_UP_EMAIL_FIELD = Element.byClass("XCUIElementTypeTextField", "Email");
	    public static EnhancedBy POP_UP_RESET_BUTTON = Element.byAccessibility("Reset", "Reset");
	    public static EnhancedBy POP_UP_CANCEL_BUTTON = Element.byAccessibility("Cancel", "Cancel");
	    public static EnhancedBy POP_UP_CLOSE = Element.byAccessibility("Close", "Close");
	    public static EnhancedBy REMEMBER_ME_CHECKBOX = Element.byAccessibility("Remember Me", "Remember me");

	}

	public void login(UserObject_Ios user) {
		// dismiss alerts
		Helper.waitForSeconds(5);
		Helper.acceptAlert();
		Helper.waitForSeconds(2);
		Helper.acceptAlert();
		
		Helper.setField(elements.USERNAME_FIELD, user.username);
		Helper.setField(elements.PASSWORD_FIELD, user.password);
		Helper.formSubmit(elements.AUTHENTICATE_BUTTON, elements.GO_BUTTON);
		Helper.formSubmit(elements.GO_BUTTON, MainPanel.elements.GAIA_LOGO);
	}

	public void loginManagerOnboarding(UserObject_Ios user) {
		// dismiss alerts
		Helper.waitForSeconds(5);
		Helper.acceptAlert();
		Helper.waitForSeconds(2);
		Helper.acceptAlert();
		
		Helper.setField(elements.USERNAME_FIELD, user.username);
		Helper.setField(elements.PASSWORD_FIELD, user.password);
		Helper.formSubmit(elements.AUTHENTICATE_BUTTON, elements.GO_BUTTON);
		Helper.formSubmit(elements.GO_BUTTON, CreditCardInfoPanel.elements.SCAN_ID);
	}
	
	public void loginManager() {
		UserObject_Ios user = new UserObject_Ios()
				.withUsername(UserObject_Ios.MANAGER_USERNAME)
				.withPassword(UserObject_Ios.MANAGER_PASSWORD);
		login(user);
	}
	
	public void loginSupervisor() {
		UserObject_Ios user = new UserObject_Ios()
				.withUsername(UserObject_Ios.SUPERVISOR_USERNAME)
				.withPassword(UserObject_Ios.SUPERVISOR_PASSWORD);
		login(user);
	}
	
	public void recoverPassword(UserObject_Ios user) {
		Helper.waitForSeconds(5);
		Helper.acceptAlert();
		Helper.waitForSeconds(2);
		Helper.acceptAlert();
		Helper.waitForElementToBeClickable(elements.FORGOT_PASSWORD_BUTTON);
		Helper.clickAndExpect(elements.FORGOT_PASSWORD_BUTTON, elements.POP_UP_RESET_BUTTON);
		Helper.setField(elements.POP_UP_EMAIL_FIELD, user.email);
		Helper.clickAndExpect(elements.POP_UP_RESET_BUTTON, elements.POP_UP_CLOSE);
		Helper.clickAndExpect(elements.POP_UP_CLOSE, elements.AUTHENTICATE_BUTTON);
	}
}