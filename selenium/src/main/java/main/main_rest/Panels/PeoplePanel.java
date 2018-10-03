package main.main_rest.Panels;

import java.util.List;

import common.objects.CompanyObject;
import core.api.Interfaces.restApiInterface;
import core.api.Objects.ApiObject;
import core.configReader.Config;
import core.driver.objects.TestObject;
import core.logger.TestLog;
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


	public void deleteAllPeople(String prefix) {
		// gets all people
		ApiObject api = TestObject.getApiDef("getUsers");
		restApiInterface.RestfullApiInterface(api);

		// gets names and ids as list
		List<String> peopleNames = Config.getValueList("peopleNames");
		List<String> peopleIds = Config.getValueList("peopleIds");

		// deletes all people with prefix
		for (int i = 0; i < peopleNames.size(); i++) {
			if (peopleNames.get(i).contains(prefix)) {
				TestLog.logPass("deleting user: " + peopleNames.get(i));
				Config.putValue("personId", peopleIds.get(i));
				api = TestObject.getApiDef("deleteUser");
				restApiInterface.RestfullApiInterface(api);
			}
		}
	}
}