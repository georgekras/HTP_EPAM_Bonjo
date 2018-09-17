package by.htp.epam.bonjo;

import static org.junit.Assert.*;

import org.junit.Test;

import by.htp.epam.bonjo.web.util.validators.RegexParamValidator;

public class RegexParamValidatorTest {
	
	@Test
	public void testUserLoginValidation() {
		String login = "jora123";
		String password = "asdasd";
		RegexParamValidator.userLoginValidation(login, password);
		fail("Not yet implemented");
	}

	@Test
	public void testUserRegistrationValidation() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserCreateAdValidation() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserEditProfileValidation() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserEditAdValidation() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdminCategoryValidation() {
		fail("Not yet implemented");
	}

}
