package by.htp.epam.bonjo.web.command.impl;

import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.UserService;
import by.htp.epam.bonjo.service.impl.UserServiceImpl;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.command.CommandName;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class EditUsersCommand extends Command {
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	public CommandName execute(HttpServletRequest request) {
		List<User> users = userService.getAllUsers();
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_USER_LIST, users);
		if (HttpRequestParamValidator.isPost(request)) {
			int id = RequestParamUtil.getInt(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_ID);
			String login = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_LOGIN);
			String email = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_EMAIL);
			String password = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_PASSWORD);
			String nickname = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_NICKNAME);
			String phoneNumber = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_PHONENUMBER);
			int role_id = RequestParamUtil.getInt(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_ROLES_ID);
			User user = new User(id, login, email, password, nickname, phoneNumber, role_id);
			if (request.getParameter(ParamNameConstantDeclaration.BUTTON_PARAM_UPDATE) != null) {
				request.setAttribute("msg", "user updated.");
				userService.update(user);
				return CommandName.EDITUSERS;
			} else if (request.getParameter(ParamNameConstantDeclaration.BUTTON_PARAM_DELETE) != null) {
				request.setAttribute("msg_alert", "user deleted.");
				userService.delete(user);
				return CommandName.EDITUSERS;
			}
		}
		return CommandName.EDITUSERS;
	}
//    @Override
//    Action execute(HttpServletRequest req) throws Exception {
//
//        if (FormUtil.isPost(req)) {
//            int id = FormUtil.getInt(req, "ID");
//            String login = FormUtil.getString(req, "Login", Patterns.LOGIN);
//            String email = FormUtil.getString(req, "Email", Patterns.EMAIL);
//            String password = FormUtil.getString(req, "Password", Patterns.PASSWORD);
//            String nickname = FormUtil.getString(req, "Nickname", Patterns.NICKNAME);
//            String phonenumber = FormUtil.getString(req, "PhoneNumber", Patterns.PHONENUMBER);
//            int roles_ID = FormUtil.getInt(req, "roles_ID");
//            User user = new User(id, login, email, password, nickname, phonenumber, roles_ID);
//            if (req.getParameter("Update") != null) {
//                DAO.getDAO().userDAO.update(user);
//            } else if (req.getParameter("Delete") != null) {
//                DAO.getDAO().userDAO.delete(user);
//            }
//        }
//        List<User> users = DAO.getDAO().userDAO.getAll("");
//        List<Role> roles = DAO.getDAO().roleDAO.getAll("");
//        req.setAttribute("users", users);
//        req.setAttribute("roles", roles);
//        return null;
}
