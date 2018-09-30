package main.java.main.customerPanel.Panels;


import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.java.common.objects.UserObject;
import main.java.main.customerPanel.CustomerPanel;

public class LoginPanel {

	CustomerPanel manager;

	public LoginPanel(CustomerPanel manager) {
		this.manager = manager;

	}

	public static class elements {
	    public static EnhancedBy USER_NAME_FIELD = Element.byCss("[placeholder='Username']", "email field");
	    public static EnhancedBy PASSWORD_FIELD = Element.byCss("[placeholder='Password']", "password field");
	    public static EnhancedBy LOGIN_SUBMIT = Element.byCss(".control .is-success", "submit button");
	    public static EnhancedBy CONTINUE_BUTTON = Element.byCss(".subtitle + .is-success", "continue button");
	    public static EnhancedBy LOGOUT_BUTTON = Element.byCss("[href*='logout']", "logout button");  
	}
	
	
	/**
	 * enter login info and click login button
	 * 
	 * @param user
	 */
	public void login(UserObject user) {
		setLoginFields(user);
		Helper.formSubmit(elements.LOGIN_SUBMIT, elements.CONTINUE_BUTTON);
		Helper.formSubmit(elements.CONTINUE_BUTTON, PanelNavigation.elements.NAVIGATION_MENU);

	}
	
	public void relogin(UserObject user) {
		logout();
		login(user);
	}

	public void setLoginFields(UserObject user) {
		Helper.setField(elements.USER_NAME_FIELD, user.username().get());
		Helper.setField(elements.PASSWORD_FIELD, user.password().get());
	}
	
	public void logout() {
		Helper.clickAndExpect(elements.LOGOUT_BUTTON, elements.LOGIN_SUBMIT);
	}
}