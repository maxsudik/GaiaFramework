package main.java.main.main_ios.objects;

public class EquipmentObjectIOS {
	
	public String itemname;
	public String itemcode;
	public String serialnumber;
	public String assignment;
	public String location;
	public String categoty;

	//Default values for fields
	public static final String DEFAULT_ITEM_NAME = "Hammer";
	public static final String DEFAULT__ITEM_CODE = "123456789";
	public static final String DEFAULT_SERIAL_NUMBER = "987654321";
	
	public EquipmentObjectIOS withItemName(String itemname) {
		this.itemname = itemname;
		return this;
	}

	public EquipmentObjectIOS withItemCode(String itemcode) {
		this.itemcode = itemcode;
		return this;
	}

	public EquipmentObjectIOS withSerialNumber(String serialnumber) {
		this.serialnumber = serialnumber;
		return this;
	}

}
