package main.main_ios.objects;




import org.inferred.freebuilder.FreeBuilder;

import com.google.common.base.Optional;

@FreeBuilder
public abstract class CompanyObjectIOS {
   
   
   
  public static final String ADDRESS_LINE_1_FIELD = "1";
  public static final String ADDRESS_LINE_2_FIELD = "2";
  public static final String CITY_FIELD = "3";
  public static final String POSTAL_CODE_FIELD = "4";

  public abstract Optional<String> ADDRESS_LINE_1_FIELD();
  public abstract Optional<String> ADDRESS_LINE_2_FIELD();
  public abstract Optional<String> CITY_FIELD();
  public abstract Optional<String> POSTAL_CODE_FIELD();

  public abstract Builder toBuilder();


  public static class Builder extends CompanyObjectIOS_Builder{

  }

      public static CompanyObjectIOS fillTheFields() {
          return new CompanyObjectIOS.Builder()
          .ADDRESS_LINE_1_FIELD("a")
          .ADDRESS_LINE_2_FIELD("b")
          .CITY_FIELD("c")
          .POSTAL_CODE_FIELD("d")
          .buildPartial();
      }
  } 