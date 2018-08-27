package by.htp.epam.bonjo.web.util;

public class UrlManager {

	public static String getLocationForRedirect(String actionName) {
		return "bonjo?command=" + actionName;
	}

}
