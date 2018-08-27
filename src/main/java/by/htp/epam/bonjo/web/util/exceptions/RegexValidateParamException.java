package by.htp.epam.bonjo.web.util.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegexValidateParamException extends RuntimeException {

	private static final long serialVersionUID = 5342155323603037133L;
	
	private static Logger logger = LoggerFactory.getLogger(RegexValidateParamException.class);
	
	public RegexValidateParamException() {
	}

	public RegexValidateParamException(String message, Throwable cause) {
		logger.error(message + " " + cause);
	}

	public RegexValidateParamException(String message) {
		logger.error(message);
	}

	public RegexValidateParamException(Throwable cause) {
		logger.error("{}", cause);
	}

}
