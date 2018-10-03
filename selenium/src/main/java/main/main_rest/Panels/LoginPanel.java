package main.main_rest.Panels;


import common.objects.UserObject;
import core.api.Interfaces.restApiInterface;
import core.api.Objects.ApiObject;
import core.configReader.Config;
import core.driver.objects.TestObject;
import main.main_rest.GaiaRest;

public class LoginPanel {
	
	GaiaRest manager; 	
	public LoginPanel(GaiaRest manager) {
		this.manager = manager;
	}
	
	public void login(UserObject user) {
		Config.putValue("username", user.username().get());
		Config.putValue("password", user.password().get());

		ApiObject login = TestObject.getApiDef("getToken");
		restApiInterface.RestfullApiInterface(login);	
	}
}