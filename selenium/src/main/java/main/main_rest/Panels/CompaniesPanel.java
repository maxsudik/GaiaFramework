package main.java.main.main_rest.Panels;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import core.logger.TestLog;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import main.java.common.objects.CompanyObject;
import main.java.common.objects.UserObject;
import main.java.main.main_rest.GaiaRest;

public class CompaniesPanel {

	// category
	public interface search {
	}

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
					.header("Authorization",user.loginId().get())
					.contentType(ContentType.JSON)
					.body(company)
				.when().post(apis.COMPANIES_API)
				.then().contentType(ContentType.JSON).statusCode(200).extract().response();

		String id = response.path("id");
		company = CompanyObject.Builder.from(company).id(id).buildPartial();
		return company;
	}

	public void deleteCompany(UserObject user, CompanyObject company) {

		given().header("Authorization", user.loginId().get()).contentType(ContentType.JSON).body(company).when()
				.delete(apis.COMPANIES_API + "/" + company.id().get()).then().contentType(ContentType.JSON)
				.statusCode(200).extract().response();
	}

	public ArrayList<CompanyObject> getAllCompanies(UserObject user) throws JSONException {
		Response response = 
				given()
					.header("Authorization", user.loginId().get())
					.contentType(ContentType.JSON).when()
				.get(apis.COMPANIES_API)
				.then().contentType(ContentType.JSON).statusCode(200).extract().response();

		JSONArray companies;
		ArrayList<CompanyObject> companyArray = new ArrayList<CompanyObject>();
			companies = new JSONArray(response.body().asString());
			companyArray = getCompaniesFromJson(companies);
		return companyArray;

	}

	public CompanyObject getCompanyFromJson(JSONArray companies) throws JSONException {
		return getCompaniesFromJson(companies).get(0);
	}

	public ArrayList<CompanyObject> getCompaniesFromJson(JSONArray companies) throws JSONException {
		ArrayList<CompanyObject> companyList = new ArrayList<CompanyObject>();
		CompanyObject company;

			for (int i = 0; i < companies.length(); i++) {

				company = new CompanyObject.Builder().name(companies.getJSONObject(i).getString("name"))
						.email(companies.getJSONObject(i).getString("email"))
						.taxNumber(companies.getJSONObject(i).getString("taxNumber"))
						.id(companies.getJSONObject(i).getString("id")).buildPartial();
				companyList.add(company);
			}

		return companyList;
	}

	public void deleteAllCompanies(UserObject user, String criteria) throws JSONException {
		ArrayList<CompanyObject> companies = getAllCompanies(user);
		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).name().get().toLowerCase().contains(criteria)) {
				deleteCompany(user, companies.get(i));
				TestLog.And("I delete company: " + companies.get(i).name().get());
				System.out.println("company deleted:" + companies.get(i).name().get() + " index: " + i);
			}
		}
	}
	
	public CompanyObject loginAndCreateCompany() {
		UserObject user = UserObject.user().withAdminLogin();
		user = manager.login.login(user);
		
		// create company through api 
		CompanyObject company = CompanyObject.company().withDefaultCompany();
		company = manager.company.createCompany(user, company);
		return company;
	}
}