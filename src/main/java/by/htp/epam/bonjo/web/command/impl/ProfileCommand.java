package by.htp.epam.bonjo.web.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.UserService;
import by.htp.epam.bonjo.service.impl.UserServiceImpl;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.constants.CommandNameConstantDeclaration;
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.UrlManager;
import by.htp.epam.bonjo.web.util.exceptions.RegexValidateParamException;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;
import by.htp.epam.bonjo.web.util.validators.RegexParamValidator;
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;

public class ProfileCommand implements Command {

	private UserService userService = new UserServiceImpl();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object o = session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER);
		User user;
		if (o != null) {
			user = (User) o;
		} else {
			response.sendRedirect(
					UrlManager.getLocationForRedirect(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_LOGIN_PAGE));
			return;
		}
		if (HttpRequestParamValidator.isPost(request)) {
			try {
			String password = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_USER_PASSWORD);
			String phoneNumber = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_USER_PHONENUMBER);
			RegexParamValidator.userEditProfileValidation(password, phoneNumber);
			user.setPassword(password);
			user.setPhoneNumber(phoneNumber);
			userService.update(user);
			request.setAttribute("msg_success", "Your profile was updated.");
			} catch(RegexValidateParamException e) {
				request.setAttribute("msg_alert", "Check inputs.");
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_USER_PROFILE).forward(request, response);
			}
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_USER_PROFILE).forward(request, response);
		}
	}

}
