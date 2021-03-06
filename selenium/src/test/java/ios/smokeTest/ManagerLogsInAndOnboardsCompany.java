package ios.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import core.logger.TestLog;
import main.main_ios.objects.CompanyObjectIOS;
import main.main_ios.objects.UserObject_Ios;

public class ManagerLogsInAndOnboardsCompany extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}
	
	@Test
	public void verifyManagerLogsInAndOnboardsCompany( ) {
	
	UserObject_Ios user = new UserObject_Ios().withUsername(UserObject_Ios.MANAGER_USERNAME).withPassword(UserObject_Ios.MANAGER_PASSWORD);
	CompanyObjectIOS company = new CompanyObjectIOS.Builder().buildPartial().withDefaultCompany();
	 
	 TestLog.When("I login with created user");
	 app.gaia.login.loginManagerOnboarding(user);
	 
	 TestLog.Then("I scan credit card");
	 app.gaia.creditCardInfo.scanID();

	 TestLog.Then("I enter company details");
	 app.gaia.companyAddress.enterCompanyAddress(company);
	 
	 TestLog.Then("I enter bank inforamtion");
	 app.gaia.companyBankInformation.enterCompanyBankInformation(company);
	 
	 TestLog.Then("I enter legal entity information");
	 app.gaia.legalEntity.enterLegalEntity(company);
	 
	 TestLog.Then("I scan credit card");
	 app.gaia.scanCreditCard.scanCreditCard(company);
	 
	 TestLog.Then("I enter credit card information");
	 app.gaia.creditCardInformation.enterCreditcardInformation(company);
	 
	}
}
