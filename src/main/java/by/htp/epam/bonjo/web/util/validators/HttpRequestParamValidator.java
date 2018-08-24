package by.htp.epam.bonjo.web.util.validators;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.bonjo.web.util.exceptions.ValidateNullParamException;

public class HttpRequestParamValidator {

	private static Logger logger = LoggerFactory.getLogger(HttpRequestParamValidator.class);

	public static void validateRequestParamNotNull(String... str) {
		for (String s : str) {
			if (s == null) {
				logger.error("Empty param recieved");
				throw new ValidateNullParamException("Empty param recieved");
			}
		}
	}

	public static void validateRequestParamObjectNotNull(Object... objects) {
		for (Object o : objects) {
			if (o == null) {
				logger.error("Empty param recieved");
				throw new ValidateNullParamException("Empty parametr recieved");
			}
		}
	}

	public static boolean isPost(HttpServletRequest request) {
		return request.getMethod().toUpperCase().equals("POST");
	}
}
