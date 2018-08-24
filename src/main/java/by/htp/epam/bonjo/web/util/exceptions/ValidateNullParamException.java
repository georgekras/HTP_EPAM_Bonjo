package by.htp.epam.bonjo.web.util.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateNullParamException extends RuntimeException {

	private static final long serialVersionUID = 2527844506355763337L;
	
	private static Logger logger = LoggerFactory.getLogger(ValidateNullParamException.class);
	
	public ValidateNullParamException() {
	}

	public ValidateNullParamException(String message, Throwable cause) {
		logger.error(message + " " + cause);
	}

	public ValidateNullParamException(String message) {
		logger.error(message);
	}

	public ValidateNullParamException(Throwable cause) {
		logger.error("{}", cause);
	}

}
