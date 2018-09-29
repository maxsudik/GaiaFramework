package test.java.ios.smokeTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.helpers.Helper;
import core.logger.TestLog;
import main.java.main.main_ios.Panels.MainPanel;
import main.java.main.main_ios.objects.EquipmentObjectIOS;
import test.java.TestBase;

public class ManagerCreatesEquipment extends TestBase{
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		setupWebDriver(app.gaia.getDriver());
	}
	
	@Test
	public void verifyCreatingEquipment() {
	
		TestLog.When("I login with created user");
		app.gaia.login.loginManager();
		app.gaia.main.selectPanel(MainPanel.gaiaPanels.EQUIPMENT);
		
		String equipmentname = EquipmentObjectIOS.DEFAULT_ITEM_NAME + Helper.generateRandomString(3);
		EquipmentObjectIOS equipment = new EquipmentObjectIOS()
				.withItemName(equipmentname)
				.withItemCode(EquipmentObjectIOS.DEFAULT__ITEM_CODE)
				.withSerialNumber(EquipmentObjectIOS.DEFAULT_SERIAL_NUMBER);
		
		TestLog.Then("I add an equipment");
		app.gaia.equipment.addEquipment(equipment);	
	}

}
