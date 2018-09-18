package by.htp.epam.bonjo.web.util.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Custom not null parameter exception class
 * 
 * @author George Krasutski
 *
 */
public class ValidateNullParamException extends RuntimeException {

	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = 2527844506355763337L;

	private static Logger logger = LoggerFactory.getLogger(ValidateNullParamException.class);

	/**
	 * constructor without parameters
	 */
	public ValidateNullParamException() {
	}

	/**
	 * constructor with message and cause
	 * 
	 * @param message
	 *            the detail message.
	 * @param cause
	 *            the cause
	 */
	public ValidateNullParamException(String message, Throwable cause) {
		logger.error(message + " " + cause);
	}

	/**
	 * constructor with message
	 * 
	 * @param message
	 *            the detail message.
	 */
	public ValidateNullParamException(String message) {
		logger.error(message);
	}

	/**
	 * constructor with cause
	 * 
	 * @param cause
	 *            the cause
	 */
	public ValidateNullParamException(Throwable cause) {
		logger.error("{}", cause);
	}
}