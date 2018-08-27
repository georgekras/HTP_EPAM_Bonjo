package by.htp.epam.bonjo.web.util.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.bonjo.web.constants.RegExPatterns;
import by.htp.epam.bonjo.web.util.exceptions.RegexValidateParamException;

public class RegexParamValidator {

	private static Logger logger = LoggerFactory.getLogger(RegexParamValidator.class);

	public static void userLoginValidation(String login, String password) {
		if (!login.matches(RegExPatterns.USER_LOGIN) || !password.matches(RegExPatterns.USER_PASSWORD)) {
			logger.error("Incorrect inputs");
			throw new RegexValidateParamException();
		}
	}

	public static void userRegistrationValidation(String login, String password, String email, String nickname,
			String phoneNumber) {
		if (!login.matches(RegExPatterns.USER_LOGIN) || !password.matches(RegExPatterns.USER_PASSWORD)
				|| !email.matches(RegExPatterns.USER_EMAIL) || !nickname
						.matches(RegExPatterns.USER_NICKNAME) || !phoneNumber.matches(RegExPatterns.USER_PHONENUMBER)) {
			logger.error("Incorrect inputs");
			throw new RegexValidateParamException();
		}
	}

}
