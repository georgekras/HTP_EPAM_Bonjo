package by.htp.epam.bonjo.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.epam.bonjo.dao.DAOFactory;
import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.command.CommandName;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;

public class LogInCommand extends Command {

	@Override
	public CommandName execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER) != null) {
			session.setAttribute(ParamNameConstantDeclaration.SESSION_PARAM_ERROR_MESSAGE, "You are already logged in");
			return CommandName.ERROR;
		}
		if (HttpRequestParamValidator.isPost(request)) {
			String login = request.getParameter(ParamNameConstantDeclaration.REQUEST_PARAM_USER_LOGIN);
			String password = request.getParameter(ParamNameConstantDeclaration.REQUEST_PARAM_USER_PASSWORD);
			if (!HttpRequestParamValidator.validateRequestParamNotNull(login, password)) {
				session.setAttribute(ParamNameConstantDeclaration.SESSION_PARAM_ERROR_MESSAGE, "Something went wrong. Try again.");
				return CommandName.ERROR;
			}
			User user = DAOFactory.getDaoInstance().getUserDao().loginRead(login, password);
			if (user != null) {
				session.setAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER, user);
				session.setMaxInactiveInterval(500);
				return CommandName.HOME;
			} else {
				session.setAttribute("msg", "Incorrect username or password");
				return CommandName.ERROR;
			}
		} else
			return CommandName.LOGIN;
	}
	
}
