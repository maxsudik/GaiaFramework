package main.main_rest.objects;

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

	public static final String DEFAULT_COMPANY_NAME = "zzz_ApiCompany";
	public static final String DEFAULT_TAX_NUMBER = "123456";
	
	/**
	 * object
	 */
	public @Getter @Setter String name;
	public @Getter @Setter String email;
	public @Getter @Setter String taxNumber;
	public @Getter @Setter String id;
	public @Getter @Setter String created;

	/**
	 * Predefined objects
	 * @return
	 */
	public CompanyObject withDefaultCompany() {
		String rand = Helper.generateRandomString(3);
		return CompanyObject.builder()
				.name(DEFAULT_COMPANY_NAME + rand)
				.email("ehsan.matean+" + rand + "@fortify.pro")
				.taxNumber(DEFAULT_TAX_NUMBER)
				.build();
	}
}