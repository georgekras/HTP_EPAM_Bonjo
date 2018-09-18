package by.htp.epam.bonjo.web.util;

/**
 * Util class UrlManager
 * 
 * @author George Krasutski
 *
 */
public class UrlManager {

	/**
	 * gets location for redirect
	 * 
	 * @param commandName
	 *            command name for redirect
	 * @return direction for redirect
	 */
	public static String getLocationForRedirect(String commandName) {
		return "bonjo?command=" + commandName;
	}
}