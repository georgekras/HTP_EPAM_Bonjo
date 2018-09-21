package by.htp.epam.bonjo.web.command.impl;

import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.ServiceFactory;
import by.htp.epam.bonjo.service.UserService;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.constants.CommandNameConstantDeclaration;
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.UrlManager;
import by.htp.epam.bonjo.web.util.exceptions.RegexValidateParamException;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class implementing Command interface
 * 
 * @author George Krasutski
 *
 */
public class ViewUsersCommand implements Command {

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
		if (!userService.isUserAdmin(request)) {
			response.sendRedirect(
					UrlManager.getLocationForRedirect(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_HOME_PAGE));
			return;
		}
		List<User> users = userService.getAllUsers();
		request.setAttribute("usersSize", users.size());
		String strStart = request.getParameter(ParamNameConstantDeclaration.REQUEST_PARAM_USER_LIST);
		int startUser = 0;
		if (strStart != null) {
			startUser = Integer.parseInt(strStart);
		}
		users = userService.getAllUsersWithPage(startUser, 8);
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_USER_LIST, users);
		if (HttpRequestParamValidator.isPost(request)) {
			try {
				int id = RequestParamUtil.getInt(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_ID);
				HttpRequestParamValidator.validateRequestParamObjectNotNull(id);
				userService.delete(id);
				response.sendRedirect(UrlManager.getLocationForRedirect(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_USERS_PAGE));
			} catch (RegexValidateParamException e) {
				request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_EDIT_USER_ERROR,
						ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_EDIT_USER_ERROR);
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_VIEW_USERS).forward(request,
						response);
			}
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_VIEW_USERS).forward(request, response);
		}
	}
}
