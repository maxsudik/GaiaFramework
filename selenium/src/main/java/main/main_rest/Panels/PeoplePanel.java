package main.main_rest.Panels;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import common.objects.UserObject;
import core.logger.TestLog;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import main.main_rest.GaiaRest;
import main.main_rest.objects.PeopleObject;

public class PeoplePanel {

	// category
	public interface search {
	}

	GaiaRest manager;

	public PeoplePanel(GaiaRest manager) {
		this.manager = manager;
	}

	public static class apis {

		public static String PEOPLE_API = "/people";
	}

	public PeopleObject createPerson(UserObject user, PeopleObject people) {
		Response response = given().header("Authorization", user.loginId().get()).contentType(ContentType.JSON)
				.body(people).when().post(apis.PEOPLE_API).then().contentType(ContentType.JSON).extract().response();

		String id = response.path("id");
		people = PeopleObject.Builder.from(people).id(id).buildPartial();

		return people;
	}

	public void deletePerson(UserObject user, PeopleObject people) {

		given().header("Authorization", user.loginId().get()).contentType(ContentType.JSON).body(people).when()
				.delete(apis.PEOPLE_API + "/" + people.id().get()).then().contentType(ContentType.JSON).statusCode(200)
				.extract().response();
	}

	public ArrayList<PeopleObject> getAllPeople(UserObject user) {
		JSONArray people = new JSONArray();
		try {
			Response response = given().header("Authorization", user.loginId().get()).contentType(ContentType.JSON)
					.when().get(apis.PEOPLE_API).then().contentType(ContentType.JSON).statusCode(200).extract()
					.response();

			people = new JSONArray(response.body().asString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getPeopleFromJson(people);
	}

	public PeopleObject getPersonFromJson(JSONArray people) {
		return getPeopleFromJson(people).get(0);
	}

	public ArrayList<PeopleObject> getPeopleFromJson(JSONArray people) {
		ArrayList<PeopleObject> personList = new ArrayList<PeopleObject>();
		try {
			for (int i = 0; i < people.length(); i++) {
				PeopleObject person;

				person = new PeopleObject.Builder().firstName(people.getJSONObject(i).getString("firstName"))
						.lastName(people.getJSONObject(i).getString("lastName"))
						.roleName(people.getJSONObject(i).getString("roleName"))
						.username(people.getJSONObject(i).getString("username"))
						.email(people.getJSONObject(i).getString("email")).id(people.getJSONObject(i).getString("id"))
						.buildPartial();
				personList.add(person);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return personList;
	}

	public void deleteAllPeople(UserObject user, String criteria) {
		ArrayList<PeopleObject> people = getAllPeople(user);

		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).firstName().get().toLowerCase().contains(criteria)) {
				deletePerson(user, people.get(i));
				TestLog.And("I delete person: " + people.get(i).firstName().get());
				System.out.println("person deleted:" + people.get(i).firstName().get() + " index: " + i);
			}
		}
	}
}