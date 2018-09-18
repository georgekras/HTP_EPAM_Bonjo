package by.htp.epam.bonjo.web.constants;

/**
 * Class contains regex constants
 * 
 * @author George Krasutski
 *
 */
public class RegExPatterns {

	public static final String USER_LOGIN = "^[a-zA-Z0-9]{5,20}$";
	public static final String USER_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,6}$";
	public static final String USER_PASSWORD = "^[a-zA-Z0-9]{5,20}$";
	public static final String USER_NICKNAME = "^[а-яА-Яa-zA-Z0-9_]{5,20}$";
	public static final String USER_PHONENUMBER = "^[+]+[0-9]{12}$";

	public static final String AD_TITLE = "^[а-яА-Яa-zA-Z0-9%\\-_\\s]{5,45}$";
	public static final String AD_SMALLDESC = "[а-яА-Яa-zA-Z0-9,.\\-_%()\\s]{4,100}";
	public static final String AD_DESCRIPTION = "[а-яА-Яa-zA-Z0-9,.\\-_%()\\s]{4,200}";
	public static final String AD_PRICE = "[0-9]{1,10}";
	
	public static final String CATEGORY_NAME = "^[а-яА-Яa-zA-Z0-9\\-\\s_]{3,40}$";
}