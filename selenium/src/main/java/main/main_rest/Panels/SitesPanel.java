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
					.header("Authorization", user.loginId().get())
					.contentType(ContentType.JSON)
					.body(site)
				.when().post(apis.SITES_API)
					.then()
				.contentType(ContentType.JSON).statusCode(200).extract().response();
		
		String id = response.path("id");
		site = SiteObject.Builder.from(site).id(id).buildPartial();
		return site;
	}
	
	public void deleteSite(UserObject user, SiteObject site) {
		 
				given()
					.header("Authorization", user.loginId().get())
					.contentType(ContentType.JSON)
					.body(site)
				.when().delete(apis.SITES_API + "/" + site.id().get())
					.then()
				.contentType(ContentType.JSON).statusCode(200).extract().response();	
	}
	
  public  ArrayList<SiteObject> getAllSites(UserObject user) throws JSONException {
	  Response response = 
	 given()
		.header("Authorization", user.loginId().get())
		.contentType(ContentType.JSON)
	 .when().get(apis.SITES_API)
		.then()
	 .contentType(ContentType.JSON).statusCode(200).extract().response();	
	
		JSONArray sites = new JSONArray();
			sites = new JSONArray(response.body().asString());
		return getSitesFromJson(sites);
  }
  
  public SiteObject getSiteFromJson(JSONArray sites) throws JSONException {
	  return getSitesFromJson(sites).get(0);
  }

  public ArrayList<SiteObject> getSitesFromJson(JSONArray sites) throws JSONException {
	  ArrayList<SiteObject> siteList = new ArrayList<SiteObject>();
	  for(int i= 0; i < sites.length(); i++) {
		  SiteObject site = new SiteObject.Builder()
			.name(sites.getJSONObject(i).getString("name"))
			.id(sites.getJSONObject(i).getString("id"))
		    .buildPartial();
		  siteList.add(site);
	  }
	  return siteList;
  }
  
  public void deleteAllSites(UserObject user, String criteria) throws JSONException {
	  ArrayList<SiteObject> sites = getAllSites(user);
	    
		for(int i= 0; i < sites.size(); i++) {
			if(sites.get(i).name().get().toLowerCase().contains(criteria)) {
				deleteSite(user, sites.get(i));
				TestLog.And("I delete site: " + sites.get(i).name().get());
				System.out.println("company deleted:" + sites.get(i).name().get() + " index: " + i);
			}
		}	
  }
}