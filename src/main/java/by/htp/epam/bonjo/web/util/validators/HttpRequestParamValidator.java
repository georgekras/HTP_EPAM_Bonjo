package by.htp.epam.bonjo.web.util.validators;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.bonjo.web.util.exceptions.ValidateNullParamException;

/**
 * Class for parameters validation
 * 
 * @author George Krasutski
 *
 */
public class HttpRequestParamValidator {

	private static Logger logger = LoggerFactory.getLogger(HttpRequestParamValidator.class);

	/**
	 * Validates strings. Check is if parameter null or not
	 * 
	 * @param str
	 *            parameters
	 * @throws ValidateParamException
	 *             if parameter null
	 */
	public static void validateRequestParamNotNull(String... str) {
		for (String s : str) {
			if (s == null) {
				logger.error("Empty parameter recieved");
				throw new ValidateNullParamException("Empty parameter recieved");
			}
		}
	}

	/**
	 * Validates objects. Check is if parameter null or not
	 * 
	 * @param objects
	 *            parameters
	 * @throws ValidateParamException
	 *             if parameter null
	 */
	public static void validateRequestParamObjectNotNull(Object... objects) {
		for (Object o : objects) {
			if (o == null) {
				logger.error("Empty parameter recieved");
				throw new ValidateNullParamException("Empty parameter recieved");
			}
		}
	}

	/**
	 * Validates locale
	 * 
	 * @param locale
	 *            locale
	 * @throws ValidateParamException
	 *             if locale not valid
	 */
	public static void validateRequestParamLocaleNotNull(String locale) {
		if (locale == null || !Pattern.matches("[a-zA-Z]{2}_[a-zA-Z]{2}", locale)) {
			logger.error("Empty parameter recieved");
			throw new ValidateNullParamException("Empty parameter recieved");

		}
	}

	/**
	 * check method post or not
	 * 
	 * @param request
	 *            HttpServletRequest object
	 * @return {@code true} if method post, {@code false} otherwise
	 */
	public static boolean isPost(HttpServletRequest request) {
		return request.getMethod().toUpperCase().equals("POST");
	}
}
