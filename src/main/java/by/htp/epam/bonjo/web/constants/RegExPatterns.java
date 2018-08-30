package by.htp.epam.bonjo.web.constants;

public class RegExPatterns {

	public static final String USER_LOGIN = "[a-zA-Z0-9]{5,20}";
	public static final String USER_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,6}$";
	public static final String USER_PASSWORD = "[a-zA-Z0-9]{5,20}";
	public static final String USER_NICKNAME = "[a-zA-Z0-9]{5,20}";
	public static final String USER_PHONENUMBER = "[\\+]+[0-9]{12}";

	public static final String AD_TITLE = "[a-zA-Z0-9]{5,45}";
	public static final String AD_SMALLDESC = "[a-zA-Z0-9]{0,100}";
	public static final String AD_DESCRIPTION = "[a-zA-Z0-9]{0,200}";
	public static final String AD_PRICE = "[0-9]{1,10}";

}
