package by.htp.epam.bonjo.web.util.validators;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.bonjo.web.util.exceptions.ValidateNullParamException;

public class HttpRequestParamValidator {

	private static Logger logger = LoggerFactory.getLogger(HttpRequestParamValidator.class);

	public static void validateRequestParamNotNull(String... str) {
		for (String s : str) {
			if (s == null) {
				logger.error("Empty parameter recieved");
				throw new ValidateNullParamException("Empty parameter recieved");
			}
		}
	}

	public static void validateRequestParamObjectNotNull(Object... objects) {
		for (Object o : objects) {
			if (o == null) {
				logger.error("Empty parameter recieved");
				throw new ValidateNullParamException("Empty parameter recieved");
			}
		}
	}

	public static void validateRequestParamLocaleNotNull(String locale) {
		if (locale == null || !Pattern.matches("[a-zA-Z]{2}_[a-zA-Z]{2}", locale)) {
			logger.error("Empty parameter recieved");
			throw new ValidateNullParamException("Empty parameter recieved");

		}
	}

	public static boolean isPost(HttpServletRequest request) {
		return request.getMethod().toUpperCase().equals("POST");
	}
}
