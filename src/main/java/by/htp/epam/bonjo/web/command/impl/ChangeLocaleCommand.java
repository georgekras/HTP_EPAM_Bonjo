package by.htp.epam.bonjo.web.command.impl;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.exceptions.ValidateNullParamException;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;

/**
 * Class implementing Command interface
 * 
 * @author George Krasutski
 *
 */
public class ChangeLocaleCommand implements Command {

	private static final String LOCALE_MESSAGES = "localization.msg";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String locale = request.getParameter(ParamNameConstantDeclaration.REQUEST_PARAM_LOCALE);
		try {
			HttpRequestParamValidator.validateRequestParamLocaleNotNull(locale);
			String[] localArr = locale.split("_");
			ResourceBundle.getBundle(LOCALE_MESSAGES, new Locale(localArr[0], localArr[1]));
			request.getSession().setAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_LOCALE, locale);
			response.sendRedirect(request.getHeader("Referer"));
		} catch (ValidateNullParamException e) {

		}
	}

}
