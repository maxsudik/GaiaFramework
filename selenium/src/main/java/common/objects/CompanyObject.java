package common.objects;

import org.inferred.freebuilder.FreeBuilder;

import com.google.common.base.Optional;

import core.helpers.Helper;

@FreeBuilder
public abstract class CompanyObject {

	public static final String DEFAULT_COMPANY_NAME = "zzz_ApiCompany";
	public static final String DEFAULT_TAX_NUMBER = "123456";
	
	public static final String COMPANY_NAME = "zzz_CompanyName" + Helper.generateRandomString(5);
	public static final String COMPANY_EMAIL = "maksym.sudik" + Helper.generateRandomString(5) + "@fortify.pro";
	public static final String COMPANY_TAX_NUMBER = "111";
	public static final String COMPANY_TYPE = "Landscape";
	public static final String COMPANY_CURRENCY = "CAD";
	public static final String COMPANY_DESCRIPTION = "Some description";
	
	/**
	 * object
	 */
	public abstract Optional<String> name();
	public abstract Optional<String> email();
	public abstract Optional<String> taxNumber();
	public abstract Optional<String> id();
	public abstract Optional<String> created();
	public abstract Optional<String> type();
	public abstract Optional<String> currency();
	public abstract Optional<String> description();

	  
	public abstract Builder toBuilder();
	public static class Builder extends CompanyObject_Builder{}
	
	public static CompanyObject company() {
		return new CompanyObject.Builder().buildPartial();
	}
	/**
	 * Predefined objects
	 * @return
	 */
	public CompanyObject withDefaultCompany() {
		String rand = Helper.generateRandomString(3);
		return new CompanyObject.Builder()
				.name(DEFAULT_COMPANY_NAME + rand)
				.email("ehsan.matean+" + rand + "@fortify.pro")
				.taxNumber(DEFAULT_TAX_NUMBER)
				.type("landscape")
				.currency("CAD")
			    .buildPartial();
	}
}