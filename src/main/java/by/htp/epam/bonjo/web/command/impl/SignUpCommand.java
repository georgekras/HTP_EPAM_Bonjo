package by.htp.epam.bonjo.web.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.ServiceFactory;
import by.htp.epam.bonjo.service.UserService;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.constants.CommandNameConstantDeclaration;
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;
import by.htp.epam.bonjo.web.util.UrlManager;
import by.htp.epam.bonjo.web.util.exceptions.RegexValidateParamException;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;
import by.htp.epam.bonjo.web.util.validators.RegexParamValidator;

public class SignUpCommand implements Command {

	private UserService userService = ServiceFactory.getServiceInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (HttpRequestParamValidator.isPost(request)) {
			String login = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_LOGIN);
			String email = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_EMAIL);
			String password = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_USER_PASSWORD);
			String nickname = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_USER_NICKNAME);
			String phoneNumber = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_USER_PHONENUMBER);
			try {
				RegexParamValidator.userRegistrationValidation(login, password, email, nickname, phoneNumber);
				User user = User.userBuilder().setId(0).setLogin(login).setEmail(email).setPassword(password)
						.setNickname(nickname).setPhoneNumber(phoneNumber).setRolesId(2).build();
				userService.create(user);
				response.sendRedirect(
						UrlManager.getLocationForRedirect(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_LOGIN_PAGE));
			} catch (RegexValidateParamException e) {
				request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_SIGNUP_ERROR,
						ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_SIGNUP_ERROR);
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_USER_SIGNUP).forward(request, response);
			}
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_USER_SIGNUP).forward(request, response);
		}
	}

}
