package by.htp.epam.bonjo.web.util.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Custom regex exception class
 * 
 * @author George Krasutski
 *
 */
public class RegexValidateParamException extends RuntimeException {

	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = 5342155323603037133L;

	private static Logger logger = LoggerFactory.getLogger(RegexValidateParamException.class);

	/**
	 * constructor without parameters
	 */
	public RegexValidateParamException() {
	}

	/**
	 * constructor with message and cause
	 * 
	 * @param message
	 *            the detail message.
	 * @param cause
	 *            the cause
	 */
	public RegexValidateParamException(String message, Throwable cause) {
		logger.error(message + " " + cause);
	}

	/**
	 * constructor with message
	 * 
	 * @param message
	 *            the detail message.
	 */
	public RegexValidateParamException(String message) {
		logger.error(message);
	}

	/**
	 * constructor with cause
	 * 
	 * @param cause
	 *            the cause
	 */
	public RegexValidateParamException(Throwable cause) {
		logger.error("{}", cause);
	}
}