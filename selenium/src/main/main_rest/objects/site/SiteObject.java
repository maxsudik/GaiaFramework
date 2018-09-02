package main.main_rest.objects.site;

import org.inferred.freebuilder.FreeBuilder;

import com.google.common.base.Optional;

import core.helpers.Helper;
import main.main_rest.objects.CompanyObject;
import main.main_rest.objects.site.AddressObject.Builder;


@FreeBuilder
public abstract class SiteObject {

	public static final String DEFAULT_SITE_NAME = "zzz_ApiSite";

	/**
	 * object
	 */
	public abstract Optional<String> name();
	public abstract Optional<String> detectRadius();
	public abstract Optional<String> id();
	public abstract Optional<String> created();
	public abstract Optional<String> companyId();
	public abstract Optional<String> updated();
	//public abstract Optional<AddressObject> address();
	
	public abstract Builder toBuilder();
	public static class Builder extends SiteObject_Builder{}

	public static SiteObject site() {
		return new SiteObject.Builder().buildPartial();
	}
	
	/**
	 * Predefined site
	 * @return
	 */
	public SiteObject withDefaultSite() {
		String rand = Helper.generateRandomString(3);
		
		CoordinatesObject coordinates = new CoordinatesObject.Builder()
				.lat("49.206875")
				.lng("-123.044092")
				.build();
		
		AddressObject address = new AddressObject.Builder()
				.street("3065 east kent avenue")
				.city("vancouver")
				.country("Canada")
				.postalCode("v5s4p3")
				.state("BC")
				.coordinates(coordinates)
				.build();
				
		SiteObject site = new SiteObject.Builder()
				.name(DEFAULT_SITE_NAME + rand)
				.detectRadius("137")
				//.address(address)
        			.buildPartial();
		
		return site;
	}
}