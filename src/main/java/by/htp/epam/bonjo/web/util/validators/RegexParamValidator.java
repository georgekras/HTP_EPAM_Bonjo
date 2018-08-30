package by.htp.epam.bonjo.web.util.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.bonjo.web.constants.RegExPatterns;
import by.htp.epam.bonjo.web.util.exceptions.RegexValidateParamException;

public class RegexParamValidator {

	private static Logger logger = LoggerFactory.getLogger(RegexParamValidator.class);

	public static void userLoginValidation(String login, String password) {
		if (!login.matches(RegExPatterns.USER_LOGIN)) {
			logger.error("Incorrect login recieved on login page.");
			throw new RegexValidateParamException();
		} else if (!password.matches(RegExPatterns.USER_PASSWORD)) {
			logger.error("Incorrect password recieved on login page.");
			throw new RegexValidateParamException();
		}
	}

	public static void userRegistrationValidation(String login, String password, String email, String nickname,
			String phoneNumber) {
		if (!login.matches(RegExPatterns.USER_LOGIN)) {
			logger.error("Incorrect login recieved on sign up page.");
			throw new RegexValidateParamException();
		} else if (!password.matches(RegExPatterns.USER_PASSWORD)) {
			logger.error("Incorrect password recieved on sign up page.");
			throw new RegexValidateParamException();
		} else if (!email.matches(RegExPatterns.USER_EMAIL)) {
			logger.error("Incorrect email recieved on sign up page.");
			throw new RegexValidateParamException();
		} else if (!nickname.matches(RegExPatterns.USER_NICKNAME)) {
			logger.error("Incorrect nickname recieved on sign up page.");
			throw new RegexValidateParamException();
		} else if (!phoneNumber.matches(RegExPatterns.USER_PHONENUMBER)) {
			logger.error("Incorrect phone number recieved on sign up page.");
			throw new RegexValidateParamException();
		}
	}
	
	public static void userCreateAdValidation(String title, String smallDesc, String description, int price, int category_ID) {
		if (!title.matches(RegExPatterns.AD_TITLE)) {
			logger.error("Incorrect title recieved on create ad page.");
			throw new RegexValidateParamException();
		} else if (!smallDesc.matches(RegExPatterns.AD_SMALLDESC)) {
			logger.error("Incorrect small description recieved on create ad page.");
			throw new RegexValidateParamException();
		} else if (!description.matches(RegExPatterns.AD_DESCRIPTION)) {
			logger.error("Incorrect description recieved on create ad page.");
			throw new RegexValidateParamException();
		} else if (price < 0) {
			logger.error("Incorrect price recieved on create ad page.");
			throw new RegexValidateParamException();
		} else if (category_ID < 0) {
			logger.error("Incorrect category recieved on create ad page.");
			throw new RegexValidateParamException();
		}
	}
}
