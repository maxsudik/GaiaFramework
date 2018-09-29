package main.java.main.main_ios.Panels;

import core.helpers.Element;
import core.helpers.Helper;
import core.webElement.EnhancedBy;
import main.java.main.main_ios.GaiaIos;
import main.java.main.main_ios.objects.EquipmentObjectIOS;

public class EquipmentPanel {
	
	GaiaIos manager;

	public EquipmentPanel( GaiaIos manager) {
		this.manager = manager;

	}

	
	public static class elements {
	
	public static EnhancedBy ADD_PRODUCT_BUTTON = Element.byAccessibility("Add Equipment", "add equipment");
	
	//Pop-up New Equipment Window
	public static EnhancedBy CANCEL_BUTTON = Element.byAccessibility("Cancel", "cancel");
	public static EnhancedBy ITEM_NAME_FIELD = Element.byClass("XCUIElementTypeTextField", "item field");
	public static EnhancedBy ITEM_CODE_FIELD = Element.byClass("XCUIElementTypeTextField", "item code");
	public static EnhancedBy SERIALL_NUMBER_FIELD = Element.byClass("XCUIElementTypeTextField", "serial number");
	public static EnhancedBy ASSIGNMENT_DDL = Element.byClass("XCUIElementTypeButton", "assignment");
	public static EnhancedBy LOCATION_DDL = Element.byClass("XCUIElementTypeButton", "location");
	public static EnhancedBy CATEGORY_DDL = Element.byClass("XCUIElementTypeButton", "category");
	public static EnhancedBy SAVE_BUTTON = Element.byAccessibility("Save", "save");
	
	//Pop-up Window
	public static EnhancedBy CLOSE_BUTTON = Element.byAccessibility("Close", "close");
	
	}

	public void addEquipment (EquipmentObjectIOS equipment) {
		
		Helper.clickAndExpect(elements.ADD_PRODUCT_BUTTON, elements.SAVE_BUTTON);
		setFileds(equipment);
		Helper.clickAndExpect(elements.SAVE_BUTTON, elements.CLOSE_BUTTON);
		Helper.clickAndExpect(elements.CLOSE_BUTTON, elements.ADD_PRODUCT_BUTTON);
	}
	
	public void setFileds (EquipmentObjectIOS equipment) {
		
		Helper.setField(equipment.itemname, elements.ITEM_NAME_FIELD, 0);
		Helper.setField(equipment.itemcode, elements.ITEM_CODE_FIELD, 1);
		Helper.setField(equipment.serialnumber, elements.SERIALL_NUMBER_FIELD, 2);
	}
}