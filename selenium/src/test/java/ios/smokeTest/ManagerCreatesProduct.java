package test.java.ios.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.logger.TestLog;
import main.java.main.main_ios.Panels.MainPanel;
import main.java.main.main_ios.objects.InstallsObject;
import test.java.TestBase;

public class ManagerCreatesProduct extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}
	
	@Test
	public void verifyCreatingProduct() {
		
		TestLog.When("I login with created user");
		app.gaia.login.loginManager();
		
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.INSTALLS);
		
		InstallsObject installs = new InstallsObject()
				.withProductName(InstallsObject.PRODUCT_NAME)
				.withProdcutRetailPrice(InstallsObject.RETAIL_PRICE)
				.withProductTag(InstallsObject.TAG)
				.withProductAdditionalNotes(InstallsObject.ADDITIONAL_NOTES);
		
		TestLog.Then("I create a product");
		app.gaia.installs.addProduct(installs);
		
	}

}
