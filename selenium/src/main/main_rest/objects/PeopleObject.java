package main.main_rest.objects;



import org.inferred.freebuilder.FreeBuilder;

import com.google.common.base.Optional;

import core.helpers.Helper;

@FreeBuilder
public abstract class PeopleObject {

	   public abstract Optional<String> firstName();
	   public abstract Optional<String> lastName();
	   public abstract Optional<String> notes();
	   public abstract Optional<String> roleName();
	   public abstract Optional<String> username();
	   public abstract Optional<String> email();
	   public abstract Optional<String> companyId();
	   public abstract Optional<String> id();
	   public abstract Optional<Boolean> emailVerified();
	   public abstract Optional<String> created();
	   public abstract Optional<String> password();
	   public abstract Optional<String> error();
	   
		public abstract Builder toBuilder();
		public static class Builder extends PeopleObject_Builder{}
		
		public static PeopleObject people() {
			return new PeopleObject.Builder().buildPartial();
		}
		/**
		 * Predefined objects
		 * @return
		 */
		public PeopleObject withDefaultPerson() {
			String rand = Helper.generateRandomString(3);
			return new PeopleObject.Builder()
					.firstName("zzz_apifirst" + rand)
					.lastName("zzz_apilast" + rand)
					.notes("auto notes")
					.roleName("manager")
					.username("zzz_first" + rand + ".zzz_last" + rand)
					.email("ehsan.matean+" + rand + "@fortify.pro")
					.emailVerified(true)
					.password("ZZZe123@@" + rand)
					.buildPartial();
		}
}
