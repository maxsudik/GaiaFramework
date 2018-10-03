package main.main_rest.Panels;

import java.util.List;

import common.objects.CompanyObject;
import common.objects.UserObject;
import core.api.Interfaces.restApiInterface;
import core.api.Objects.ApiObject;
import core.configReader.Config;
import core.driver.objects.TestObject;
import core.logger.TestLog;
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
	 */
	public void deleteAllCompanies(String prefix)  {
		// gets all companies
		ApiObject api = TestObject.getApiDef("getCompanies");
		restApiInterface.RestfullApiInterface(api);	
      
		// gets names and ids as list
		List<String> companyNames = Config.getValueList("companyNames");
        List<String> companyIds = Config.getValueList("companyIds");
       
        // deletes all companies with prefix
        for(int i = 0; i< companyNames.size(); i++) {
        	if(companyNames.get(i).contains(prefix)) {
        		TestLog.logPass("deleting company: " + companyNames.get(i));
        		Config.putValue("companyId", companyIds.get(i));
        	    api =  TestObject.getApiDef("deleteCompany");
        	    
        		restApiInterface.RestfullApiInterface(api);	
        	}
        }
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