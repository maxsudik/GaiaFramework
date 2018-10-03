package main.main_rest.Panels;

import java.util.List;

import common.objects.CompanyObject;
import core.api.Interfaces.restApiInterface;
import core.api.Objects.ApiObject;
import core.configReader.Config;
import core.driver.objects.TestObject;
import core.logger.TestLog;
import main.main_rest.GaiaRest;
import main.main_rest.objects.site.SiteObject;

public class SitesPanel {

	GaiaRest manager;

	public SitesPanel(GaiaRest manager) {
		this.manager = manager;
	}

	public void createSite(SiteObject site, CompanyObject company) {

		manager.company.findCompany(company.name().get());

		Config.putValue("siteName", site.name().get());

		ApiObject api = TestObject.getApiDef("createSite");
		restApiInterface.RestfullApiInterface(api);
	}

	public void deleteSite(SiteObject site) {

		findSite(site.name().get());

		ApiObject api = TestObject.getApiDef("deleteSite");
		restApiInterface.RestfullApiInterface(api);
	}

	public void findSite(String siteName) {
		Config.putValue("siteName", siteName);
		ApiObject api = TestObject.getApiDef("findSite");
		restApiInterface.RestfullApiInterface(api);
	}

	public void deleteAllSites(String prefix) {
		// gets all sites
		ApiObject api = TestObject.getApiDef("getSites");
		restApiInterface.RestfullApiInterface(api);

		// gets names and ids as list
		List<String> siteNames = Config.getValueList("siteNames");

		// deletes all sites with prefix
		for (int i = 0; i < siteNames.size(); i++) {
			if (siteNames.get(i).contains(prefix)) {
				TestLog.logPass("deleting site: " + siteNames.get(i));
				findSite(siteNames.get(i));
				api = TestObject.getApiDef("deleteSite");
				restApiInterface.RestfullApiInterface(api);
			}
		}
	}
}