package main.main_ios.objects;




import org.inferred.freebuilder.FreeBuilder;

import com.google.common.base.Optional;

@FreeBuilder
public abstract class CompanyObjectIOS {
   
   
  //Company Address 
  public static final String ADDRESS_LINE_1_FIELD = "Office 101";
  public static final String ADDRESS_LINE_2_FIELD = "1st Street";
  public static final String CITY_FIELD = "Vancouver";
  public static final String COUNTRY_DDLMI = "Canada";
  public static final String STATE_PROVINCE_DDLMI = "Alberta";
  public static final String POSTAL_CODE_FIELD = "V0V0V0";
  
  //Company Bank Information
  public static final String INSTITUTION_NUMBER_FIELD = "000";
  public static final String TRANSIT_NUMBER_FIELD = "11000";
  public static final String ACCOUNT_NUMBER_FIELD = "000123456789";
  public static final String ACCOUNT_HOLDER_NAME_FIELD = "HolderName";
  public static final String ACCOUNT_TYPE_DDLMI = "Company";
  
  //Legal Entity
  public static final String LEGAL_FIRST_NAME_FIELD = "FirstName";
  public static final String LEGAL_LAST_NAME_FIELD = "LastName";
  public static final String LEGAL_ADDRESS_LINE_1_FIELD = "Office 222";
  public static final String LEGAL_ADDRESS_LINE_2_FIELD = "2nd St";
  public static final String LEGAL_CITY_FIELD = "Victoria";
  public static final String LEGAL_COUNTRY_DDLMI = "Canada";
  public static final String LEGAL_STATE_DDLMI = "Alberta";
  public static final String LEGAL_POSTAL_CODE_FIELD = "V1V1V1";
  
  

  //Company Address 
  public abstract Optional<String> addressLine1();
  public abstract Optional<String> addressLine2();
  public abstract Optional<String> city();
  public abstract Optional<String> country();
  public abstract Optional<String> state();
  public abstract Optional<String> postalCode();
  
  //Company Bank Information
  public abstract Optional<String> institutionNumber();
  public abstract Optional<String> transitNumber();
  public abstract Optional<String> accountNumber();
  public abstract Optional<String> accountHolderName();
  public abstract Optional<String> accountType();
  
  //Legal Entity
  public abstract Optional<String> legalFirstName();
  public abstract Optional<String> legalLastName();
  public abstract Optional<String> legalAddressLine1();
  public abstract Optional<String> legalAddressLine2();
  public abstract Optional<String> legalCity();
  public abstract Optional<String> legalCountry();
  public abstract Optional<String> legalState();
  public abstract Optional<String> legalPostalCode();
  
  

  public abstract Builder toBuilder();


  public static class Builder extends CompanyObjectIOS_Builder{

  }

      public CompanyObjectIOS withDefaultCompany() {
          return new CompanyObjectIOS.Builder()
        		  
        	//Company Address 
          .addressLine1(ADDRESS_LINE_1_FIELD)
          .addressLine2(ADDRESS_LINE_2_FIELD)
          .city(CITY_FIELD)
          .country(COUNTRY_DDLMI)
          .state(STATE_PROVINCE_DDLMI)
          .postalCode(POSTAL_CODE_FIELD)
          
          	//Company Bank Information
          .institutionNumber(INSTITUTION_NUMBER_FIELD)
          .transitNumber(TRANSIT_NUMBER_FIELD)
          .accountNumber(ACCOUNT_NUMBER_FIELD)
          .accountHolderName(ACCOUNT_HOLDER_NAME_FIELD)
          .accountType(ACCOUNT_TYPE_DDLMI)
          
          	//Legal Entity
          .legalFirstName(LEGAL_FIRST_NAME_FIELD)
          .legalLastName(LEGAL_LAST_NAME_FIELD)
          .legalAddressLine1(LEGAL_ADDRESS_LINE_1_FIELD)
          .addressLine2(LEGAL_ADDRESS_LINE_2_FIELD)
          .legalCity(LEGAL_CITY_FIELD)
          .legalCountry(LEGAL_COUNTRY_DDLMI)
          .legalState(LEGAL_STATE_DDLMI)
          .legalPostalCode(LEGAL_POSTAL_CODE_FIELD)
          
          
          .buildPartial();
      }
  } 