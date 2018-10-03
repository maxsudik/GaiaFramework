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

	public void deleteAllSites(String prefix) {
		// gets all sites
		ApiObject api = TestObject.getTestInfo().apiMap.get("getSites");
		restApiInterface.RestfullApiInterface(api);

		// gets names and ids as list
		List<String> siteNames = Config.getValueList("siteNames");
		List<String> siteIds = Config.getValueList("siteIds");

		// deletes all sites with prefix
		for (int i = 0; i < siteNames.size(); i++) {
			if (siteNames.get(i).contains(prefix)) {
				TestLog.logPass("deleting site: " + siteNames.get(i));
				Config.putValue("siteId", siteIds.get(i));
				api = TestObject.getTestInfo().apiMap.get("deleteSite");
				restApiInterface.RestfullApiInterface(api);
			}
		}
	}
}