package main.main_rest.Panels;


import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.http.ContentType;

import core.logger.TestLog;
import main.main_rest.GaiaRest;
import main.main_rest.objects.PeopleObject;
import main.main_rest.objects.UserObject;

public class PeoplePanel {

	// category
	public interface search {}
	
	GaiaRest manager; 	
	public PeoplePanel(GaiaRest manager) {
		this.manager = manager;
	}
	
	public static class apis {
	
		public static String PEOPLE_API = "/people";	
	}
	
	public PeopleObject createPerson(UserObject user, PeopleObject people) {
		PeopleObject person = 
				given()
					.header("Authorization", user.loginId)
					.contentType(ContentType.JSON)
					.body(people)
				.when().post(apis.PEOPLE_API)
					.then()
				.contentType(ContentType.JSON).extract().response().as(PeopleObject.class);	
		
		return person;
	}
	
	public void deletePerson(UserObject user, PeopleObject people) {
		 
				given()
					.header("Authorization", user.loginId)
					.contentType(ContentType.JSON)
					.body(people)
				.when().delete(apis.PEOPLE_API + "/" + people.id)
					.then()
				.contentType(ContentType.JSON).statusCode(200).extract().response();	
	}
	
  public PeopleObject[] getAllPeople(UserObject user) {
	 PeopleObject[] people =
	 given()
		.header("Authorization", user.loginId)
		.contentType(ContentType.JSON)
	 .when().get(apis.PEOPLE_API)
		.then()
	 .contentType(ContentType.JSON).statusCode(200).extract().response().as(PeopleObject[].class);	
	
	  return people;
  }
  
  public void deleteAllPeople(UserObject user, String criteria) {
	  PeopleObject[] people = getAllPeople(user);
	    
		for(int i= 0; i < people.length; i++) {
			if(people[i].firstName.toLowerCase().contains(criteria)) {
				deletePerson(user, people[i]);
				TestLog.And("I delete person: " + people[i].firstName);
				System.out.println("person deleted:" + people[i].firstName + " index: " + i);
			}
		}	
  }
}