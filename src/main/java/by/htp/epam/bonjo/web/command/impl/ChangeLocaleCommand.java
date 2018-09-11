package by.htp.epam.bonjo.web.command.impl;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.ResourceManager;
import by.htp.epam.bonjo.web.util.exceptions.ValidateNullParamException;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;

public class ChangeLocaleCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String locale = request.getParameter(ParamNameConstantDeclaration.REQUEST_PARAM_LOCALE);
		try {
			HttpRequestParamValidator.validateRequestParamLocaleNotNull(locale);
			String[] localArr = locale.split("_");
			ResourceManager.LOCALIZATION.changeResource(new Locale(localArr[0], localArr[1]));
			request.getSession().setAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_LOCALE, locale);
			response.sendRedirect(request.getHeader("Referer"));
		} catch (ValidateNullParamException e) {

		}
	}

}
