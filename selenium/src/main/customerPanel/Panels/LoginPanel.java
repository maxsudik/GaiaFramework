package main.customerPanel.Panels;


import org.openqa.selenium.By;

import core.helpers.ElementHelper;
import core.helpers.FormHelper;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.customerPanel.objects.UserObject;

public class LoginPanel {

	CustomerPanelManager manager;

	public LoginPanel(CustomerPanelManager manager) {
		this.manager = manager;

	}

	private static final String EMAIL_FIELD = "[placeholder='Username']";
	private static final String PASSWORD_FIELD = "[placeholder='Password']";
	private static final String LOGIN_SUBMIT = ".control .is-success";
	private static final String CONTINUE_BUTTON = ".subtitle + .is-success";
	private static final String LOGOUT_BUTTON = "[href*='logout']";

	public EnhancedBy byEmailField() {
		return ElementHelper.BySelector(By.cssSelector(EMAIL_FIELD), "email field");
	}

	public EnhancedBy byPasswordField() {
		return ElementHelper.BySelector(By.cssSelector(PASSWORD_FIELD), "password field");
	}

	public EnhancedBy byLoginSubmit() {
		return ElementHelper.BySelector(By.cssSelector(LOGIN_SUBMIT), "submit button");
	}

	public EnhancedBy byContinueButton() {
		return ElementHelper.BySelector(By.cssSelector(CONTINUE_BUTTON), "continue button");
	}
	
	public EnhancedBy byLogout() {
		return ElementHelper.BySelector(By.cssSelector(LOGOUT_BUTTON), "logout button");
	}

	/**
	 * enter login info and click login button
	 * 
	 * @param user
	 */
	public void login(UserObject user) {
		setLoginFields(user);
		FormHelper.formSubmit(byLoginSubmit(), byContinueButton());
		FormHelper.formSubmit(byContinueButton(), manager.company.byCompanyListSection());

	}

	public void setLoginFields(UserObject user) {
		FormHelper.setField(user.email, byEmailField());
		FormHelper.setField(user.password, byPasswordField());
	}
	
	public void logout() {
		Helper.clickAndExpect(byLogout(), byLoginSubmit());
	}
}