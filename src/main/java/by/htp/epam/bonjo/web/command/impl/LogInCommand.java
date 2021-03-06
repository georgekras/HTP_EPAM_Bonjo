package by.htp.epam.bonjo.web.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.ServiceFactory;
import by.htp.epam.bonjo.service.UserService;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.constants.CommandNameConstantDeclaration;
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.UrlManager;
import by.htp.epam.bonjo.web.util.exceptions.RegexValidateParamException;
import by.htp.epam.bonjo.web.util.exceptions.ValidateNullParamException;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;
import by.htp.epam.bonjo.web.util.validators.RegexParamValidator;

/**
 * Class implementing Command interface
 * 
 * @author George Krasutski
 *
 */
public class LogInCommand implements Command {

	/**
	 * UserService instance
	 * 
	 * {@link by.htp.epam.bonjo.service.UserService}
	 */
	private UserService userService = ServiceFactory.getServiceInstance().getUserService();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = userService.isUserInSession(request);
		if (user != null) {
			response.sendRedirect(
					UrlManager.getLocationForRedirect(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_HOME_PAGE));
			return;
		}
		HttpSession session = request.getSession();
		if (HttpRequestParamValidator.isPost(request)) {
			String login = request.getParameter(ParamNameConstantDeclaration.REQUEST_PARAM_USER_LOGIN);
			String password = request.getParameter(ParamNameConstantDeclaration.REQUEST_PARAM_USER_PASSWORD);
			try {
				RegexParamValidator.userLoginValidation(login, password);
				user = userService.loginRead(login, password);
				HttpRequestParamValidator.validateRequestParamObjectNotNull(user);
				session.setAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER, user);
				session.setAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER_ROLE_ID,
						user.getRoles_ID());
				response.sendRedirect(UrlManager
						.getLocationForRedirect(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_PROFILE_PAGE));
			} catch (RegexValidateParamException | ValidateNullParamException e) {
				request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_LOGIN_ERROR,
						ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_LOGIN_ERROR);
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_USER_LOGIN).forward(request, response);
			}
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_USER_LOGIN).forward(request, response);
		}
	}
}