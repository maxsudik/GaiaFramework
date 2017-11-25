package main.main_rest.Panels;


import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import main.main_rest.GaiaRest;
import main.main_rest.objects.UserObject;

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
       
		user.loginId = response.path("login.id");
		return user;	
	}
}