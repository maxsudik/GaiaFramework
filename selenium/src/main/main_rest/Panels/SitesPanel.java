package main.main_rest.Panels;


import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import core.logger.TestLog;
import main.main_rest.GaiaRest;
import main.main_rest.objects.UserObject;
import main.main_rest.objects.site.SiteObject;

public class SitesPanel {

	// category
	public interface search {}
	
	GaiaRest manager; 	
	public SitesPanel(GaiaRest manager) {
		this.manager = manager;
	}
	
	public static class apis {
	
		public static String SITES_API = "/sites";
		
	}
	
	public SiteObject createSite(UserObject user, SiteObject site) {
			Response response = 
				given()
					.header("Authorization", user.loginId)
					.contentType(ContentType.JSON)
					.body(site)
				.when().post(apis.SITES_API)
					.then()
				.contentType(ContentType.JSON).statusCode(200).extract().response();
		
		site.setId(response.path("id"));
		return site;
	}
	
	public void deleteSite(UserObject user, SiteObject site) {
		 
				given()
					.header("Authorization", user.loginId)
					.contentType(ContentType.JSON)
					.body(site)
				.when().delete(apis.SITES_API + "/" + site.id)
					.then()
				.contentType(ContentType.JSON).statusCode(200).extract().response();	
	}
	
  public SiteObject[] getAllSites(UserObject user) {
	  SiteObject[] sites =
	 given()
		.header("Authorization", user.loginId)
		.contentType(ContentType.JSON)
	 .when().get(apis.SITES_API)
		.then()
	 .contentType(ContentType.JSON).statusCode(200).extract().response().as(SiteObject[].class);	
	
	  return sites;
  }
  
  public void deleteAllSites(UserObject user, String criteria) {
	    SiteObject[] sites = getAllSites(user);
	    
		for(int i= 0; i < sites.length; i++) {
			if(sites[i].name.toLowerCase().contains(criteria)) {
				deleteSite(user, sites[i]);
				TestLog.And("I delete site: " + sites[i].name);
				System.out.println("company deleted:" + sites[i].name + " index: " + i);
			}
		}	
  }
}