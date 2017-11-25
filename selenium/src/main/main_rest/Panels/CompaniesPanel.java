package main.main_rest.Panels;


import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import core.logger.TestLog;
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
					.header("Authorization", user.loginId)
					.contentType(ContentType.JSON)
					.body(company)
				.when().post(apis.COMPANIES_API)
					.then()
				.contentType(ContentType.JSON).statusCode(200).extract().response();
		
		company.id = response.path("id");
		return company;
	}
	
	public void deleteCompany(UserObject user, CompanyObject company) {
		 
				given()
					.header("Authorization", user.loginId)
					.contentType(ContentType.JSON)
					.body(company)
				.when().delete(apis.COMPANIES_API + "/" + company.id)
					.then()
				.contentType(ContentType.JSON).statusCode(200).extract().response();	
	}
	
  public CompanyObject[] getAllCompanies(UserObject user) {
	  CompanyObject[] companies =
	 given()
		.header("Authorization", user.loginId)
		.contentType(ContentType.JSON)
	 .when().get(apis.COMPANIES_API)
		.then()
	 .contentType(ContentType.JSON).statusCode(200).extract().response().as(CompanyObject[].class);	
	
	  return companies;
  }
  
  public void deleteAllCompanies(UserObject user, String criteria) {
	    CompanyObject[] companies = getAllCompanies(user);
		for(int i= 0; i < companies.length; i++) {
			if(companies[i].name.toLowerCase().contains(criteria)) {
				deleteCompany(user, companies[i]);
				TestLog.And("I delete company: " + companies[i].name);
				System.out.println("company deleted:" + companies[i].name + " index: " + i);
			}
		}	
  }
}