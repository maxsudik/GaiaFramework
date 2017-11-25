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
public class PeopleObject {

	   public @Getter @Setter String firstName;
	   public @Getter @Setter String lastName;
	   public @Getter @Setter String notes;
	   public @Getter @Setter String roleName;
	   public @Getter @Setter String username;
	   public @Getter @Setter String email;
	   public @Getter @Setter String companyId;
	   public @Getter @Setter String id;
	   public @Getter @Setter Boolean emailVerified;
	   public @Getter @Setter String created;
	   public @Getter @Setter String password;
	   public @Getter @Setter ErrorObject error;
	   

		/**
		 * Predefined objects
		 * @return
		 */
		public PeopleObject withDefaultPerson() {
			String rand = Helper.generateRandomString(3);
			return PeopleObject.builder()
					.firstName("zzz_apifirst" + rand)
					.lastName("zzz_apilast" + rand)
					.notes("auto notes")
					.roleName("manager")
					.username("zzz_first" + rand + ".zzz_last" + rand)
					.email("ehsan.matean+" + rand + "@fortify.pro")
					.emailVerified(true)
					.password("ZZZe123@@" + rand)
					.build();
		}
}
