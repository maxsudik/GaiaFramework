package common.objects;

import org.inferred.freebuilder.FreeBuilder;

import com.google.common.base.Optional;


@FreeBuilder
public abstract class UserObject {

	public static final String ADMIN_USER = "admin";
	public static final String ADMIN_PASSWORD = "# .Gaia$";
	
	public static final String USER_AUTO_MANAGER = "zzzautomanager1";
	public static final String PASSWORD_AUTO_MANAGER = "zzzautomanager1";
	
	public static final String USER_AUTO_SUPERVISOR = "zzzauto1";
	public static final String PASSWORD_AUTO_SUPERVISOR = "zzzauto1";
	
	public static final String USER_PRODUCTION_MANAGER = "qamanager1";
	public static final String PASSWORD_PRODUCTION_MANAGER = "QaTest$123!";
	
	public static final String USER_PRODUCTION_SUPERVISOR = "qasupervisor1";
	public static final String PASSWORD_PRODUCTION_SUPERVISOR = "QaTest$123!";
	/**
	 * object
	 */
   public abstract Optional<String> username();
   public abstract Optional<String> password();
   public abstract Optional<String> email();
   public abstract Optional<String> firstName();
   public abstract Optional<String> lastName();
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
	
	public UserObject withManagerUser() {
		return new UserObject.Builder()
				.username(USER_AUTO_MANAGER)
				.password(PASSWORD_AUTO_MANAGER)
				.buildPartial();
	}
	
	public UserObject withSupervisorUser() {
		return new UserObject.Builder()
				.username(USER_AUTO_SUPERVISOR)
				.password(PASSWORD_AUTO_SUPERVISOR)
				.buildPartial();
	}
	
	public UserObject withProductionManagerUser() {
		return new UserObject.Builder()
				.username(USER_PRODUCTION_MANAGER)
				.password(PASSWORD_PRODUCTION_MANAGER)
				.buildPartial();
	}
	
	public UserObject withProductionSupervisorUser() {
		return new UserObject.Builder()
				.username(USER_PRODUCTION_SUPERVISOR)
				.password(PASSWORD_PRODUCTION_SUPERVISOR)
				.buildPartial();
	}
}