package main.main_rest.Panels;

import org.json.JSONException;

import common.objects.CompanyObject;
import core.api.Interfaces.restApiInterface;
import core.api.Objects.ApiObject;
import core.driver.objects.TestObject;
import core.helpers.Helper;
import main.main_rest.GaiaRest;
import main.main_rest.objects.site.SiteObject;

public class SitesPanel {

	GaiaRest manager;

	public SitesPanel(GaiaRest manager) {
		this.manager = manager;
	}

	public void createSite(SiteObject site, CompanyObject company) {

		TestObject.getTestInfo().config.put("siteName", site.name().get());

		ApiObject api = TestObject.getTestInfo().apiMap.get("createSite");
		restApiInterface.RestfullApiInterface(api);
	}

	public void deleteSite(SiteObject site) {

		findSite(site);

		ApiObject api = TestObject.getTestInfo().apiMap.get("deleteSite");
		restApiInterface.RestfullApiInterface(api);
	}

	public void findSite(SiteObject site) {
		TestObject.getTestInfo().config.put("siteName", site.name().get());
		ApiObject api = TestObject.getTestInfo().apiMap.get("findSite");
		restApiInterface.RestfullApiInterface(api);
	}

	public void deleteAllSites(String prefix) throws JSONException {
		
		Helper.runApiContaining("name", "zzz_","getSites", "id","siteId","deleteSite");
	}
}