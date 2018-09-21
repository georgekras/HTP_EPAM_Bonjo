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
import by.htp.epam.bonjo.web.util.validators.RegexParamValidator;
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class implementing Command interface
 * 
 * @author George Krasutski
 *
 */
public class EditUsersCommand implements Command {

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
		String userId = request.getParameter("userId");
		int chosenUserId = Integer.parseInt(userId);
		User chosenUser = userService.read(chosenUserId);
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_USER, chosenUser);
		if (HttpRequestParamValidator.isPost(request)) {
			try {
				String login = RequestParamUtil.getString(request,
						ParamNameConstantDeclaration.REQUEST_PARAM_USER_LOGIN);
				String email = RequestParamUtil.getString(request,
						ParamNameConstantDeclaration.REQUEST_PARAM_USER_EMAIL);
				String password = RequestParamUtil.getString(request,
						ParamNameConstantDeclaration.REQUEST_PARAM_USER_PASSWORD);
				String nickname = RequestParamUtil.getString(request,
						ParamNameConstantDeclaration.REQUEST_PARAM_USER_NICKNAME);
				String phoneNumber = RequestParamUtil.getString(request,
						ParamNameConstantDeclaration.REQUEST_PARAM_USER_PHONENUMBER);
				RegexParamValidator.userRegistrationValidation(login, password, email, nickname, phoneNumber);
				User user = User.userBuilder().setId(chosenUserId).setLogin(login).setEmail(email).setPassword(password)
						.setNickname(nickname).setPhoneNumber(phoneNumber).setRolesId(2).build();
				request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_USER, user);
				request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_EDIT_USER_UPDATE,
						ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_EDIT_USER_UPDATE);
				userService.update(user);
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_EDIT_USER).forward(request,
						response);
			} catch (RegexValidateParamException e) {
				request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_EDIT_USER_ERROR,
						ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_EDIT_USER_ERROR);
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_EDIT_USER).forward(request,
						response);
			}
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_EDIT_USER).forward(request, response);
		}
	}
}
