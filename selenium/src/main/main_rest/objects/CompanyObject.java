package main.main_rest.objects;

import org.inferred.freebuilder.FreeBuilder;

import com.google.common.base.Optional;

import core.helpers.Helper;

@FreeBuilder
public abstract class CompanyObject {

	public static final String DEFAULT_COMPANY_NAME = "zzz_ApiCompany";
	public static final String DEFAULT_TAX_NUMBER = "123456";
	
	/**
	 * object
	 */
	public abstract Optional<String> name();
	public abstract Optional<String> email();
	public abstract Optional<String> taxNumber();
	public abstract Optional<String> id();
	public abstract Optional<String> created();
	  
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
			    .buildPartial();
	}
}