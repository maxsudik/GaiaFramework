package main.java.main.main_rest.objects;

import org.inferred.freebuilder.FreeBuilder;

import com.google.common.base.Optional;


@FreeBuilder
public abstract class  UserObject {

	public static final String ADMIN_USER = "admin";
	public static final String ADMIN_PASSWORD = "# .Gaia$";
	
	/**
	 * object
	 */
   public abstract Optional<String> username();
   public abstract Optional<String> password();
   public abstract Optional<String> loginId();
	
	public abstract Builder toBuilder();
	public static class Builder extends UserObject_Builder{}
	
	public static UserObject user() {
		return new UserObject.Builder().buildPartial();
	}
	/**
	 * Predefined objects
	 * @return
	 */
	public UserObject withAdminLogin() {
		return new UserObject.Builder()
				.username(ADMIN_USER)
				.password(ADMIN_PASSWORD)
				.buildPartial();
	}


}