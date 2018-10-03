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
		manager.company.findCompany(company.name().get());
		
		Config.putValue("personFirstName", people.firstName().get());
		Config.putValue("personLastName", people.lastName().get());
		Config.putValue("personRoleName", people.roleName().get());
		Config.putValue("personUsername", people.username().get());
		Config.putValue("personEmail", people.email().get());
		Config.putValue("personPassword", people.password().get());


		ApiObject userAPI = TestObject.getApiDef("createUser");
		restApiInterface.RestfullApiInterface(userAPI);	
	}

	public void deletePerson(PeopleObject people) {
		findUser(people.username().get());
		
		ApiObject api = TestObject.getApiDef("deleteUser");
		restApiInterface.RestfullApiInterface(api);	
	}
	
	public void findUser(String userName) {
		Config.putValue("personUsername", userName);
		ApiObject api = TestObject.getApiDef("findUser");
		restApiInterface.RestfullApiInterface(api);	
	}

	public void deleteAllPeople(String prefix) {
		// gets all people
		ApiObject api = TestObject.getApiDef("getUsers");
		restApiInterface.RestfullApiInterface(api);

		// gets names and ids as list
		List<String> peopleNames = Config.getValueList("peopleNames");

		// deletes all people with prefix
		for (int i = 0; i < peopleNames.size(); i++) {
			if (peopleNames.get(i).contains(prefix)) {
				TestLog.logPass("deleting user: " + peopleNames.get(i));
				findUser(peopleNames.get(i));
				api = TestObject.getApiDef("deleteUser");
				restApiInterface.RestfullApiInterface(api);
			}
		}
	}
}