package by.htp.epam.bonjo.web.command.impl;

import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.UserService;
import by.htp.epam.bonjo.service.impl.UserServiceImpl;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.constants.CommandNameConstantDeclaration;
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.UrlManager;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditUsersCommand implements Command {

	private UserService userService = new UserServiceImpl();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER);
		Object role_id = session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER_ROLE_ID);
		User userobj;
		if (obj != null && role_id != null && (int) role_id == 1) {
			userobj = (User) obj;
		} else {
			response.sendRedirect(
					UrlManager.getLocationForRedirect(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_LOGIN_PAGE));
			return;
		}
		List<User> users = userService.getAllUsers();
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_USER_LIST, users);
		if (HttpRequestParamValidator.isPost(request)) {
			int id = RequestParamUtil.getInt(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_ID);
			String login = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_LOGIN);
			String email = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_EMAIL);
			String password = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_USER_PASSWORD);
			String nickname = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_USER_NICKNAME);
			String phoneNumber = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_USER_PHONENUMBER);
			int roleId = RequestParamUtil.getInt(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_ROLES_ID);
			User user = new User(id, login, email, password, nickname, phoneNumber, roleId);
			if (request.getParameter(ParamNameConstantDeclaration.BUTTON_PARAM_UPDATE) != null) {
				request.setAttribute("msg", "user updated.");
				userService.update(user);
			} else if (request.getParameter(ParamNameConstantDeclaration.BUTTON_PARAM_DELETE) != null) {
				request.setAttribute("msg_alert", "user deleted.");
				userService.delete(id);
			}
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_EDIT_USERS).forward(request, response);
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_EDIT_USERS).forward(request, response);
		}
	}
}
