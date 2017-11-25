package main.main_rest.objects.site;

import core.helpers.Helper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SiteObject {

	public static final String DEFAULT_SITE_NAME = "zzzApiSite";

	/**
	 * object
	 */
	public @Getter @Setter String name;
	public @Getter @Setter String detectRadius;
	public @Getter @Setter String id;
	public @Getter @Setter String created;
	public @Getter @Setter String companyId;
	public @Getter @Setter String updated;
//	public @Getter @Setter AddressObject address;
	
	/**
	 * Predefined site
	 * @return
	 */
	public SiteObject withDefaultSite() {
		String rand = Helper.generateRandomString(3);
		
		CoordinatesObject coordinates = CoordinatesObject.builder()
				.lat("49.206875")
				.lng("-123.044092")
				.build();
		
		AddressObject address = AddressObject.builder()
				.street("3065 east kent avenue")
				.city("vancouver")
				.country("Canada")
				.postalCode("v5s4p3")
				.state("BC")
				.coordinates(coordinates)
				.build();
				
		SiteObject site = SiteObject.builder()
				.name(DEFAULT_SITE_NAME + rand)
				.detectRadius("137")
				//.address(address)
        			.build();
		
		return site;
	}
}