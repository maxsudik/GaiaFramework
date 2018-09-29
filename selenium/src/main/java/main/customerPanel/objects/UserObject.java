package main.java.main.customerPanel.objects;


public class UserObject {

	public String email;
	public String password;

	
	public static final String USER_ADMIN = "admin";
	public static final String PASSWORD_ADMIN = "# .Gaia$";
	
	public static final String USER_AUTO_MANAGER = "zzzautomanager1";
	public static final String PASSWORD_AUTO_MANAGER = "zzzautomanager1";
	
	public static final String USER_AUTO_SUPERVISOR = "zzzauto1";
	public static final String PASSWORD_AUTO_SUPERVISOR = "zzzauto1";
	
	public static final String USER_PRODUCTION_MANAGER = "qamanager1";
	public static final String PASSWORD_PRODUCTION_MANAGER = "QaTest$123!";
	
	public static final String USER_PRODUCTION_SUPERVISOR = "qasupervisor1";
	public static final String PASSWORD_PRODUCTION_SUPERVISOR = "QaTest$123!";
	
	public UserObject withEmail(String email) {
		this.email = email;
		return this;
	}

	public UserObject withPassword(String password) {
		this.password = password;
		return this;
	}
}