package main.main_rest.Panels;

import org.json.JSONException;

import common.objects.CompanyObject;
import core.api.Interfaces.restApiInterface;
import core.api.Objects.ApiObject;
import core.driver.objects.TestObject;
import core.helpers.Helper;
import main.main_rest.GaiaRest;
import main.main_rest.objects.PeopleObject;

public class PeoplePanel {

	GaiaRest manager;

	public PeoplePanel(GaiaRest manager) {
		this.manager = manager;
	}

	public void createPerson(PeopleObject people, CompanyObject company) {
		
		TestObject.getTestInfo().config.put("personFirstName", people.firstName().get());
		TestObject.getTestInfo().config.put("personLastName", people.lastName().get());
		TestObject.getTestInfo().config.put("personRoleName", people.roleName().get());
		TestObject.getTestInfo().config.put("personUsername", people.username().get());
		TestObject.getTestInfo().config.put("personEmail", people.email().get());
		TestObject.getTestInfo().config.put("personPassword", people.password().get());


		ApiObject userAPI = TestObject.getApiDef("createUser");
		restApiInterface.RestfullApiInterface(userAPI);	
	}

	public void deletePerson(PeopleObject people) {
		
		ApiObject api = TestObject.getApiDef("deleteUser");
		restApiInterface.RestfullApiInterface(api);	
	}


	public void deleteAllPeople(String prefix) throws JSONException {
		Helper.runApiContaining("firstName", "zzz_","getUsers", "id","personId","deleteUser");

	}
}