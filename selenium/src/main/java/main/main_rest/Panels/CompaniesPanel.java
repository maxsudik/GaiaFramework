package main.main_rest.Panels;

import org.json.JSONException;

import common.objects.CompanyObject;
import common.objects.UserObject;
import core.api.Interfaces.restApiInterface;
import core.api.Objects.ApiObject;
import core.configReader.Config;
import core.driver.objects.TestObject;
import core.helpers.Helper;
import main.main_rest.GaiaRest;

public class CompaniesPanel {


	GaiaRest manager;

	public CompaniesPanel(GaiaRest manager) {
		this.manager = manager;
	}

	
	public void createCompany(CompanyObject company) {
		
		Config.putValue("companyName", company.name().get());
		Config.putValue("companyEmail", company.email().get());
		Config.putValue("taxNumber", company.taxNumber().get());
		Config.putValue("companyType", company.type().get());
		Config.putValue("companyCurrency", company.currency().get());
		Config.putValue("companyDescription", company.description().get());

		ApiObject companyAPI = TestObject.getApiDef("createCompany");
		restApiInterface.RestfullApiInterface(companyAPI);	
	}

	
	public void deleteCompany(CompanyObject company) {

		ApiObject api = TestObject.getApiDef("deleteCompany");
		restApiInterface.RestfullApiInterface(api);	
		
	}
	
	/** deletes all companies with prefix
	 * 
	 * @param prefix
	 * @throws JSONException 
	 */
	public void deleteAllCompanies(String prefix) throws JSONException  {
		Helper.runApiContaining("name", "zzz_","getCompanies",  "id","companyId","deleteCompany");
	}


	public CompanyObject loginAndCreateCompany() {
		UserObject user = UserObject.user().withAdminLogin();
		manager.login.login(user);
		
		// create company through api 
		CompanyObject company = CompanyObject.company().withDefaultCompany();
		manager.company.createCompany(company);
		return company;
	}
}