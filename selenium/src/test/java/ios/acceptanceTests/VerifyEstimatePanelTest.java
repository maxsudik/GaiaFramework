package test.java.ios.acceptanceTests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import core.helpers.UtilityHelper;
import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.main_ios.Panels.MainPanel;
import main.main_ios.categories.login;
import main.main_ios.categories.user;
import main.main_ios.objects.EstimateObject;
import main.main_ios.objects.EstimateObject.paymentType;
import main.main_ios.objects.ProductObject;
import main.main_ios.pages.GaiaIos;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class VerifyEstimatePanelTest extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
		setupWebDriver(GaiaIos.GetDriver());
	}

	@Category({ login.class, user.class })
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
		
		String estimateTitle = "zzz_estimate" + UtilityHelper.generateRandomString(3);
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