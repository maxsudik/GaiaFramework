package test.java.ios.acceptanceTests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.java.main.main_ios.Panels.MainPanel;
import main.java.main.main_ios.objects.EstimateObject;
import main.java.main.main_ios.objects.EstimateObject.paymentType;
import main.java.main.main_ios.objects.ProductObject;
import test.java.TestBase;

public class VerifyEstimatePanelTest extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}

	@Test
	@Ignore //TODO test needs to be updated from products selection
	public void verifyAddEstimation() {
		
		TestLog.When("I login with manager user");
		app.gaia.login.loginManager();
		
		TestLog.Then("I navigate to installs panel");
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.INSTALLS);
		
		TestLog.Then("I add an estimate");
		ProductObject product = new ProductObject()
				.withProductIndex(0);
		
		String estimateTitle = "zzz_estimate" + Helper.generateRandomString(3);
		EstimateObject estimate = new EstimateObject()
				.withTitle(estimateTitle)
				.withCustomerSite(0)
				.withEmail("ehsan.matean+3@fortify.pro")
				.withAddDescription("description")
				.withCustomerName(0)
				.withProduct(product)
				.withPaymentType(paymentType.CASH)
				.withTotal("1.00");
		       
		app.gaia.estimate.addEstimate(estimate);
		
		TestLog.Then("I verify the estimate has been added");
	}
}