package test.java;

import core.driver.AbstractDriverTestNG;
import main.AppManager;

public class TestBase extends AbstractDriverTestNG {
	protected AppManager app = new AppManager();
}
