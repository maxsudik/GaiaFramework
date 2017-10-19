package test.java.ios.sanityTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import core.helpers.UtilityHelper;
import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.main_ios.Panels.MainPanel;
import main.main_ios.categories.login;
import main.main_ios.categories.user;
import main.main_ios.constants.ProductInfo;
import main.main_ios.constants.UserInfo_Ios;
import main.main_ios.objects.ProductObject;
import main.main_ios.objects.UserObject_Ios;
import main.main_ios.pages.GaiaIos;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class VerifyProductPanelTest extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
		setupWebDriver(GaiaIos.GetDriver());
	}

	@Category({ login.class, user.class })
	@Test
	public void verifyAddProduct() {
		UserObject_Ios user = new UserObject_Ios()
				.withUsername(UserInfo_Ios.MANAGER_USERNAME)
				.withPassword(UserInfo_Ios.MANAGER_PASSWORD);
		
		TestLog.When("I login with manager user");
		app.gaia.login.login(user);
		
		TestLog.Then("I navigate to installs panel");
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.INSTALLS);
		
		TestLog.Then("I add a product");
		String productName = ProductInfo.PRODUCT_NAME_DEFAULT + UtilityHelper.generateRandomString(3);
		ProductObject product = new ProductObject()
				.withProductName(productName)
				.withPricePerUnit(ProductInfo.PRICE_PER_UNIT_DEFAULT)
				.withCurrency(ProductInfo.CURRENCY_DEFAULT)
				.withUnit(ProductInfo.UNIT_DEFAULT)
				.withSupplier(ProductInfo.SUPPLIER_DEFAULT)
				.withAdditionalNotes(ProductInfo.ADDITIONAL_NOTES);
		app.gaia.product.addProduct(product);
		
		TestLog.Then("I verify the product has been added");
	}
}