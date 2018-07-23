package main.main_rest.objects;


public class UserObject {

	public static final String ADMIN_USER = "admin";
	public static final String ADMIN_PASSWORD = "# .Gaia$";
	
	/**
	 * object
	 */
	public String username;
	public String password;
	public String loginId;
	
	/**
	 * Predefined objects
	 * @return
	 */
	public UserObject withAdminLogin() {
		return withUsername(ADMIN_USER)
				.withPassword(ADMIN_PASSWORD);
	}

	// define variable getters
	
	public UserObject withUsername(String username) {
		this.username = username;
		return this;
	}
	
	public UserObject withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public UserObject withLoginId(String loginId) {
		this.loginId = loginId;
		return this;
	}
}