package by.htp.epam.bonjo.web.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.UserService;
import by.htp.epam.bonjo.service.impl.UserServiceImpl;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;

public class SignUpCommand implements Command{

	private UserService userService = new UserServiceImpl();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(HttpRequestParamValidator.isPost(request)) {
            String login =
                    RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_LOGIN);
            String email =
            		RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_EMAIL);
            String password =
            		RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_PASSWORD);
            String nickName =
            		RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_NICKNAME);
            String phoneNumber =
            		RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_USER_PHONENUMBER);
            User user = new User(0,login, email, password, nickName, phoneNumber, 2);
            userService.create(user);
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_USER_SIGNUP).forward(request, response);
		}
	}

}
