package main.java.main.main_rest.Panels;


import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import main.java.main.main_rest.GaiaRest;
import main.java.main.main_rest.objects.UserObject;

public class LoginPanel {

	// category
	public interface search {}
	
	GaiaRest manager; 	
	public LoginPanel(GaiaRest manager) {
		this.manager = manager;
	}
	
	public static class apis {
	
		public static String LOGIN_API = "/people/login";
		
	}
	
	/**
	 * set login info and returns login id
	 * 
	 * @param user
	 */
	public UserObject login(UserObject user) {
		Response response = 
				given()
					.contentType(ContentType.JSON)
					.body(user)
				.when()
					.post(apis.LOGIN_API)
				.then()
					.contentType(ContentType.JSON).statusCode(200).extract().response();
       
		String id = response.path("login.id");
		user = UserObject.Builder.from(user).loginId(id).buildPartial();
		return user;	
	}
}