package main.customerPanel.objects;

import org.fluttercode.datafactory.impl.DataFactory;

import core.helpers.Helper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyObject {
	
	public static final String DEFAULT_TAX_NUMBER = "33";
	public static final String ADDRESS = "3033 main street";
	public static final String CITY = "Vancouver";
	public static final String COUNTRY = "Canada";
	public static final String STATE = "British Columbia";
	public static final String ZIP_CODE = "v5s4p3";
	public static final String LICENSE_LIMIT = "313";
	
	// company info
	public @Getter @Setter String companyName;
	public @Getter @Setter String companyEmail;
	public @Getter @Setter String companyWebsite;
	public @Getter @Setter String companyTaxNumber;
	public @Getter @Setter String companyType;
	
	// company address
	public @Getter @Setter String companyAddress1;
	public @Getter @Setter String companyAddress2;
	public @Getter @Setter String companyCity;
	public @Getter @Setter String companyCountry;
	public @Getter @Setter String companyState;
	public @Getter @Setter String companyZipCode;

	
    // credit card info
	public @Getter @Setter String cardLicenseLimit;
	public @Getter @Setter String cardNumber;
	public @Getter @Setter String cardName;
	public @Getter @Setter String cardExpirationMonth;
	public @Getter @Setter String cardExpirationYear;
	public @Getter @Setter String cardExpirationCvv;
	public @Getter @Setter String cardAddress1;
	public @Getter @Setter String cardAddress2;
	public @Getter @Setter String cardCity;
	public @Getter @Setter String cardCountry;
	public @Getter @Setter String cardState;
	public @Getter @Setter String cardPostal;
	
    // bank account info
	public @Getter @Setter String bankInstitutionNumber;
	public @Getter @Setter String bankTransitNumber;
	public @Getter @Setter String bankNumber;
	public @Getter @Setter String bankHolder;
	public @Getter @Setter String bankType;
	
    // legal entity info
	public @Getter @Setter String legalFirstName;
	public @Getter @Setter String legalLastName;
	public @Getter @Setter String legalBirthYear;
	public @Getter @Setter String legalBirthMonth;
	public @Getter @Setter String legalBirthDay;
	public @Getter @Setter String legalAddress1;
	public @Getter @Setter String legalAddress2;
	public @Getter @Setter String legalCity;
	public @Getter @Setter String legalCountry;
	public @Getter @Setter String legalState;
	public @Getter @Setter String legalZipCode;
	public @Getter @Setter String legalIdPath;
	
	final DataFactory data = new DataFactory();
	/**
	 * Predefined objects
	 * @return
	 */
	
	public CompanyObject withCreateDefaultCompany() {
		String rand = Helper.generateRandomString(3);
		String randInt = Helper.generateRandomInteger(5);
		return CompanyObject.builder()
				.companyName("zzz_auto" + rand)
				.companyEmail("ehsan.matean+" + rand + "@fortify.pro")
				.companyTaxNumber(randInt)
				.companyType("Landscape")
				.build();
	}
	
	public CompanyObject withEditDefaultCompany() {
		String rand = Helper.generateRandomString(5);
		String randInt = Helper.generateRandomInteger(5);
		return CompanyObject.builder()
				.companyName("zzz_auto" + rand)
				//.companyEmail("ehsan.matean+" + rand + "@fortify.pro")
				.companyWebsite("https://gaialandscape.com/")
				.companyTaxNumber(randInt)
				.companyAddress1(data.getAddress())
				.companyAddress2(data.getAddress())
				.companyCity(data.getCity())
				.companyCountry("Canada")
				.companyState("British Columbia")
				.companyZipCode("v5s4p3")
				.cardLicenseLimit("313")
				.cardNumber("5555 5555 5555 4444")
				.cardName(data.getName())
				.cardExpirationMonth("01")
				.cardExpirationYear("28")
				.cardExpirationCvv("112")
				.cardAddress1(data.getAddress())
				.cardAddress2(data.getAddress())
				.cardCity(data.getCity())
				.cardCountry("Canada")
				.cardState("British Columbia")
				.cardPostal("v4s3p2")
				.bankInstitutionNumber("000")
				.bankTransitNumber("11000")
				.bankNumber("000123456789")
				.bankHolder(data.getName())
				.bankType("Company")
				.legalFirstName(data.getFirstName())
				.legalLastName(data.getLastName())
				.legalBirthYear("1980")
				.legalBirthMonth("01")
				.legalBirthDay("22")
				.legalAddress1(data.getAddress())
				.legalAddress2(data.getAddress())
				.legalCity(data.getCity())
				.legalCountry("Canada")
				.legalState("British Columbia")
				.legalZipCode("V5s4p3")
				.legalIdPath("/test-data/crashlytics.png")
				.build();
	}
}