package by.htp.epam.bonjo.web.util.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.bonjo.web.constants.RegExPatterns;
import by.htp.epam.bonjo.web.util.exceptions.RegexValidateParamException;

/**
 * Class for parameters validation using regex
 * 
 * @author George Krasutski
 *
 */
public class RegexParamValidator {

	private static Logger logger = LoggerFactory.getLogger(RegexParamValidator.class);

	/**
	 * Validates login and password of user for login command
	 * 
	 * @param login
	 *            {@link by.htp.epam.bonjo.domain.User} login
	 * @param password
	 *            {@link by.htp.epam.bonjo.domain.User} password
	 * @throws RegexValidateParamException
	 *             if parameter not matches regex
	 */
	public static void userLoginValidation(String login, String password) {
		if (!login.matches(RegExPatterns.USER_LOGIN)) {
			logger.error("Incorrect login recieved on login page.");
			throw new RegexValidateParamException();
		} else if (!password.matches(RegExPatterns.USER_PASSWORD)) {
			logger.error("Incorrect password recieved on login page.");
			throw new RegexValidateParamException();
		}
	}

	/**
	 * Validates users credentials for sign up command
	 * 
	 * @param login
	 *            {@link by.htp.epam.bonjo.domain.User} login
	 * @param password
	 *            {@link by.htp.epam.bonjo.domain.User} password
	 * @param email
	 *            {@link by.htp.epam.bonjo.domain.User} email
	 * @param nickname
	 *            {@link by.htp.epam.bonjo.domain.User} nickname
	 * @param phoneNumber
	 *            {@link by.htp.epam.bonjo.domain.User} phone number
	 * @throws RegexValidateParamException
	 *             if parameter not matches regex
	 */
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

	/**
	 * Validates ads inputs for create ad command
	 * 
	 * @param title
	 *            {@link by.htp.epam.bonjo.domain.Ad} title
	 * @param smallDesc
	 *            {@link by.htp.epam.bonjo.domain.Ad} small description
	 * @param description
	 *            {@link by.htp.epam.bonjo.domain.Ad} description
	 * @param price
	 *            {@link by.htp.epam.bonjo.domain.Ad} price
	 * @param category_ID
	 *            {@link by.htp.epam.bonjo.domain.Ad} category id
	 * @throws RegexValidateParamException
	 *             if parameter not matches regex
	 */
	public static void userCreateAdValidation(String title, String smallDesc, String description, int price,
			int category_ID) {
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

	/**
	 * Validates users credentials for profile command
	 * 
	 * @param password
	 *            {@link by.htp.epam.bonjo.domain.User} password
	 * @param phoneNumber
	 *            {@link by.htp.epam.bonjo.domain.User} phone number
	 * @throws RegexValidateParamException
	 *             if parameter not matches regex
	 */
	public static void userEditProfileValidation(String password, String phoneNumber) {
		if (!password.matches(RegExPatterns.USER_PASSWORD)) {
			logger.error("Incorrect password recieved on profile page.");
			throw new RegexValidateParamException();
		} else if (!phoneNumber.matches(RegExPatterns.USER_PHONENUMBER)) {
			logger.error("Incorrect phone number recieved on profile page.");
			throw new RegexValidateParamException();
		}
	}

	/**
	 * Validates ads inputs for edit ad command
	 * 
	 * @param title
	 *            {@link by.htp.epam.bonjo.domain.Ad} title
	 * @param smallDesc
	 *            {@link by.htp.epam.bonjo.domain.Ad} small description
	 * @param description
	 *            {@link by.htp.epam.bonjo.domain.Ad} description
	 * @param price
	 *            {@link by.htp.epam.bonjo.domain.Ad} price
	 * @param category_ID
	 *            {@link by.htp.epam.bonjo.domain.Ad} category id
	 * @throws RegexValidateParamException
	 *             if parameter not matches regex
	 */
	public static void userEditAdValidation(String title, String smallDesc, String description, int price,
			int category_ID) {
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

	/**
	 * Validates category name for create category command
	 * 
	 * @param categoryName
	 *            {@link by.htp.epam.bonjo.domain.Category} name
	 * @throws RegexValidateParamException
	 *             if parameter not matches regex
	 */
	public static void adminCategoryValidation(String categoryName) {
		if (!categoryName.matches(RegExPatterns.CATEGORY_NAME)) {
			logger.error("Incorrect category name recieved.");
			throw new RegexValidateParamException();
		}
	}
}
