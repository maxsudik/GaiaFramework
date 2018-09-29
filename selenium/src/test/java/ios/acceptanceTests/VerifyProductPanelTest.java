package test.java.ios.acceptanceTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.java.main.main_ios.Panels.MainPanel;
import main.java.main.main_ios.objects.ProductObject;
import test.java.TestBase;

public class VerifyProductPanelTest extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}

	@Test
	public void verifyAddProduct() {
		
		TestLog.When("I login with manager user");
		app.gaia.login.loginManager();
		
		TestLog.Then("I navigate to installs panel");
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.INSTALLS);
		
		TestLog.Then("I add a product");
		String productName = ProductObject.PRODUCT_NAME_DEFAULT + Helper.generateRandomString(3);
		ProductObject product = new ProductObject()
				.withProductName(productName)
				.withPricePerUnit(ProductObject.PRICE_PER_UNIT_DEFAULT)
				.withCurrency(ProductObject.CURRENCY_DEFAULT)
				.withUnit(ProductObject.UNIT_DEFAULT)
				.withAdditionalNotes(ProductObject.ADDITIONAL_NOTES);
		app.gaia.product.addProduct(product);
		
		TestLog.Then("I verify the product has been added");
	}
}