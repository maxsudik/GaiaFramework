package main.main_ios.objects;


public class ProductObject {

	public productType productType;
	public String productName;
	public String pricePerUnit;
	public int currency = -1;
	public String unit;
	public String supplier;
	public String additionalNotes;
	
	// used in estimate panel product selection
	public String quantity;
	public int productIndexInList = -1;
	
   // account panel user role button index
	public static final String PRODUCT_NAME_DEFAULT = "zzzhammer";
	public static final String PRICE_PER_UNIT_DEFAULT = "24";
	public static final int CURRENCY_DEFAULT = 0;
	public static final String UNIT_DEFAULT = "3";
	public static final String SUPPLIER_DEFAULT = "Gaia";
	public static final String ADDITIONAL_NOTES = "automation product";
	
	
	public enum productType {
		PLANT, 
		MATERIAL, 
		LABOR,
		DELIVERY,
		DISPOSAL,
		OTHER
	}
	
	public ProductObject withProductType(productType productType) {
		this.productType = productType;
		return this;
	}

	public ProductObject withProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public ProductObject withPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
		return this;
	}
	
	public ProductObject withCurrency(int currency) {
		this.currency = currency;
		return this;
	}
	
	public ProductObject withUnit(String unit) {
		this.unit = unit;
		return this;
	}
	
	public ProductObject withSupplier(String supplier) {
		this.supplier = supplier;
		return this;
	}
	
	public ProductObject withAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
		return this;
	}
	
	public ProductObject withQuantity(String quantity) {
		this.quantity = quantity;
		return this;
	}
	
	public ProductObject withProductIndex(int productIndexInList) {
		this.productIndexInList = productIndexInList;
		return this;
	}
}