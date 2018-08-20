package by.htp.epam.bonjo.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.UserService;
import by.htp.epam.bonjo.service.impl.UserServiceImpl;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.command.CommandName;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;

public class ProfileCommand extends Command {

	private UserService userService = new UserServiceImpl();
	
	@Override
	public CommandName execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object o = session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER);
        User user;
        if (o != null) {
            user = (User) o;
        } else
            return CommandName.LOGIN;
        if (HttpRequestParamValidator.isPost(request)) {
            String password = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_PASSWORD);
            String phoneNumber = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_PHONENUMBER);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            userService.update(user);
            request.setAttribute("msg_success", "Your profile was updated.");
        }
        return CommandName.PROFILE;
	}

}
