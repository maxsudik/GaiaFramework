package main.main_ios.Panels.OnboardingPanels;

import org.inferred.freebuilder.FreeBuilder;

import com.google.common.base.Optional;

import core.configReader.Config;
import core.configReader.PropertiesType;

@FreeBuilder
public abstract class UserObject {

    public static final String USER_EMAIL_STG_01 = "user01_STG_Email";
    public static final String USER_LOGONID_STG_01 = "user01_STG_LogonId";
    public static final String USER_EMAIL_INT_01 = "user01_INT_Email";
    public static final String USER_EMAIL_PPD_01 = "user01_PPD_Email";
    public static final String USER_EMAIL_INT_NO_COMPOSE_01 = "user01_INT_No_Compose_Email";
    public static final String USER_EMAIL_STG_NO_ADMIN_ACCESS_01 = "user01_STG_No_Admin_Email";

    public static final String USER_PWD = "user_Password";
    public static final String USER_EMAIL_STG_GUI_04 = "user04_STG_GUI_Email";

    /**
     * object
     */
    public abstract Optional<String> email();
    public abstract Optional<String> password();
    public abstract Optional<String> userId();
    public abstract Optional<String> bu();
    
    public abstract Builder toBuilder();

    public static class Builder extends UserObject_Builder {
    }
    
    /**
     * Predefined objects
     *
     * @return
     */
    
    public static UserObject STG01User() {
    	UserObject user = new UserObject.Builder().buildPartial().withSTG01User();
    	user = user.toBuilder().bu("AT_BU").buildPartial();
    	return user;
    }
    
    public static UserObject WebTest01() {
        return new UserObject.Builder()
                .email("WebTest01_stg@abbwfmdev.onmicrosoft.com")
                .password("Test!2345")
                .userId("WEBTEST01")
                .bu("AT_BU")
                .buildPartial();
    }

    public static UserObject JA_TECH() {
        return new UserObject.Builder()
                .email("ja_tech_stg@abbwfmdev.onmicrosoft.com")
                .password("Test!2345")
                .userId("JA_TECH")
                .bu("AT_BU")
                .buildPartial();
    }

    public static UserObject CAJAADU() {
        return new UserObject.Builder()
                .email("cajaadu_stg@abbwfmdev.onmicrosoft.com")
                .password("Test!2345")
                .userId("CAJAADU")
                .bu("AT_BU")
                .buildPartial();
    }
    
    public static UserObject SUPV_STG() {
        return new UserObject.Builder()
                .email("at_supv01@abbwfmdev.onmicrosoft.com")
                .password("ABB!2345")
                .userId("AT_SUPV01")
                .bu("DA_BU")
                .buildPartial();
    }
    
    public UserObject withSTG01User() {
        UserObject login = new UserObject.Builder().email(new Config().getStringProperty(USER_EMAIL_STG_01, PropertiesType.WEB))
                .password(new Config().getStringProperty(USER_PWD, PropertiesType.WEB))
                .userId(new Config().getStringProperty(USER_LOGONID_STG_01, PropertiesType.WEB))
                .buildPartial();
        return login;
    }

    public UserObject withINT01User() {
        UserObject login = new UserObject.Builder().email(new Config().getStringProperty(USER_EMAIL_INT_01, PropertiesType.WEB))
                .password(new Config().getStringProperty(USER_PWD, PropertiesType.WEB))
                .buildPartial();
        return login;
    }

    public UserObject withPPd01User() {
        UserObject login = new UserObject.Builder().email(new Config().getStringProperty(USER_EMAIL_PPD_01, PropertiesType.WEB))
                .password(new Config().getStringProperty(USER_PWD, PropertiesType.WEB))
                .buildPartial();
        return login;
    }

    public UserObject withNoComposeAccessUser() {
        UserObject login = new UserObject.Builder().email(new Config().getStringProperty(USER_EMAIL_STG_GUI_04, PropertiesType.WEB))
                .password(new Config().getStringProperty(USER_PWD, PropertiesType.WEB))
                .bu("EW_BU")
                .userId("EW_TECH").buildPartial();
        return login;
    }

    public UserObject withNoComposeAccessUser01() {
        UserObject login = new UserObject.Builder().email(new Config().getStringProperty(USER_EMAIL_INT_NO_COMPOSE_01, PropertiesType.WEB))
                .password(new Config().getStringProperty(USER_PWD, PropertiesType.WEB))
                .bu("EW_BU")
                .userId("EW_TECH").buildPartial();
        return login;
    }

    public UserObject withNoAdminAccessUser01() {
        UserObject login = new UserObject.Builder().email(new Config().getStringProperty(USER_EMAIL_STG_NO_ADMIN_ACCESS_01, PropertiesType.WEB))
                .password(new Config().getStringProperty(USER_PWD, PropertiesType.WEB))
                .bu("EW_BU")
                .userId("EW_TECH").buildPartial();
        return login;
    }

    public UserObject withInvalidUser() {
        UserObject login = new UserObject.Builder().email(new Config().getStringProperty(USER_EMAIL_STG_01, PropertiesType.WEB))
                .password("invalid")
                .userId("EW_TECH").buildPartial();
        return login;
    }

    public static UserObject createUserObject(String bu, String userId, Optional<String> email, Optional<String> password) {
        if (!email.isPresent()) {
            email = Optional.of(new Config().getStringProperty(USER_EMAIL_STG_01, PropertiesType.WEB));
        }
        if (!password.isPresent()) {
            password = Optional.of(new Config().getStringProperty(USER_PWD, PropertiesType.WEB));
        }
        return new UserObject.Builder().email(email).password(password).bu(bu).userId(userId).buildPartial();

    }
}
