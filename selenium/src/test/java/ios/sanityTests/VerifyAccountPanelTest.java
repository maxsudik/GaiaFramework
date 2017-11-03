package test.java.ios.sanityTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import core.helpers.Helper;
import core.helpers.UtilityHelper;
import core.logger.TestLog;
import core.runner.ParallelRunner;
import main.main_ios.Panels.AccountsPanel;
import main.main_ios.Panels.MainPanel;
import main.main_ios.categories.login;
import main.main_ios.categories.user;
import main.main_ios.constants.AccountsInfo;
import main.main_ios.objects.AccountObject;
import main.main_ios.pages.GaiaIos;
import test.java.TestBase;

@RunWith(ParallelRunner.class)
public class VerifyAccountPanelTest extends TestBase {

	@Before
	public void beforeMethod() throws Exception {
		setupWebDriver(GaiaIos.GetDriver());
	}

	@Category({ login.class, user.class })
	@Test
	public void verifyCreateAccount() {
		
		TestLog.When("I login with manager user");
		app.gaia.login.loginManager();
		
		TestLog.Then("I navigate to accounts panel");
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.ACCOUNTS);
	
	
		TestLog.Then("I add an accounts");
		String username = "zzz_auto" + UtilityHelper.generateRandomString(3);
		String firstName = "zzz_first" + UtilityHelper.generateRandomString(3);
		String email = "fortify" + UtilityHelper.generateRandomString(3) + "@test.com";
		AccountObject account = new AccountObject()
				.withUsername(username)
				.withEmail(email)
				.withPassword("123")
				.withFirstName(firstName)
				.withLastName("auto")
				.withRoles(AccountsInfo.SUPERVISOR);
		app.gaia.accounts.addAccount(account);

		TestLog.Then("I search for account");
		app.gaia.accounts.searchAccount(account);
		
		TestLog.Then("I verify the account has been added");
		Helper.verifyElementIsDisplayed(AccountsPanel.byAccountUser(account.fullName));
	}
}