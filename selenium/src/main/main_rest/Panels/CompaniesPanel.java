package main.main_rest.Panels;


import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;

import org.json.JSONArray;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import core.logger.TestLog;
import groovyjarjarantlr.collections.List;
import main.main_rest.GaiaRest;
import main.main_rest.objects.CompanyObject;
import main.main_rest.objects.UserObject;

public class CompaniesPanel {

	// category
	public interface search {}
	
	GaiaRest manager; 	
	public CompaniesPanel(GaiaRest manager) {
		this.manager = manager;
	}
	
	public static class apis {
	
		public static String COMPANIES_API = "/companies";
		
	}
	
	public CompanyObject createCompany(UserObject user, CompanyObject company) {
			Response response = 
				given()
					.header("Authorization", user.loginId().get())
					.contentType(ContentType.JSON)
					.body(company)
				.when().post(apis.COMPANIES_API)
					.then()
				.contentType(ContentType.JSON).statusCode(200).extract().response();
		
		String id = response.path("id");
		company = CompanyObject.Builder.from(company).id(id).buildPartial();
		return company;
	}
	
	public void deleteCompany(UserObject user, CompanyObject company) {
		 
				given()
					.header("Authorization", user.loginId().get())
					.contentType(ContentType.JSON)
					.body(company)
				.when().delete(apis.COMPANIES_API + "/" + company.id().get())
					.then()
				.contentType(ContentType.JSON).statusCode(200).extract().response();	
	}
	
  public ArrayList<CompanyObject> getAllCompanies(UserObject user) {
	  Response response = 
	 given()
		.header("Authorization", user.loginId().get())
		.contentType(ContentType.JSON)
	 .when().get(apis.COMPANIES_API)
		.then()
	 .contentType(ContentType.JSON).statusCode(200).extract().response();
	  
	  JSONArray companies = new  JSONArray(response.body().asString());
	  return getCompaniesFromJson(companies);
  }
  
  public CompanyObject getCompanyFromJson(JSONArray companies) {
	  return getCompaniesFromJson(companies).get(0);
  }

  public ArrayList<CompanyObject> getCompaniesFromJson(JSONArray companies) {
	  ArrayList<CompanyObject> companyList = new ArrayList<CompanyObject>();
	  for(int i= 0; i < companies.length(); i++) {
		  CompanyObject company = new CompanyObject.Builder()
			.name(companies.getJSONObject(i).getString("name"))
			.email(companies.getJSONObject(i).getString("email"))
			.taxNumber(companies.getJSONObject(i).getString("taxNumber"))
			.id(companies.getJSONObject(i).getString("id"))
		    .buildPartial();
		  companyList.add(company);
	  }
	  return companyList;
  }
  
  public void deleteAllCompanies(UserObject user, String criteria) {
	   ArrayList<CompanyObject> companies = getAllCompanies(user);
		for(int i= 0; i < companies.size(); i++) {
			if(companies.get(i).name().get().toLowerCase().contains(criteria)) {
				deleteCompany(user, companies.get(i));
				TestLog.And("I delete company: " + companies.get(i).name().get());
				System.out.println("company deleted:" + companies.get(i).name().get() + " index: " + i);
			}
		}	
  }
}