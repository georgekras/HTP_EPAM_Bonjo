package by.htp.epam.bonjo.web.util.validators;

import javax.servlet.http.HttpServletRequest;

public class RequestParamUtil {

	public static String getString(HttpServletRequest request, String field) {
		String value = request.getParameter(field);
		return value;
	}

	public static int getInt(HttpServletRequest request, String field) {
		String value = request.getParameter(field);
		return Integer.parseInt(value);
	}

}
