package by.htp.epam.bonjo.web.command.impl;

import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.service.CategoryService;
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

public class CreateCategoryCommand implements Command {

	private CategoryService categoryService = ServiceFactory.getServiceInstance().getCategoryService();
	private UserService userService = ServiceFactory.getServiceInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!userService.isUserAdmin(request)) {
			response.sendRedirect(
					UrlManager.getLocationForRedirect(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_HOME_PAGE));
			return;
		}
		if (HttpRequestParamValidator.isPost(request)) {
			try {
				String categoryName = RequestParamUtil.getString(request,
						ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORY_NAME);
				RegexParamValidator.adminCategoryValidation(categoryName);
				Category category = new Category(0, categoryName);
				categoryService.create(category);
				request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_CREATE_CATEGORY_SUCCESS,
						ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_CREATE_CATEGORY_SUCCESS);
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_CREATE_CATEGORY).forward(request,
						response);
			} catch (RegexValidateParamException e) {
				request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_CREATE_CATEGORY_ERROR,
						ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_CREATE_CATEGORY_ERROR);
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_CREATE_CATEGORY).forward(request,
						response);
			}
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_CREATE_CATEGORY).forward(request,
					response);
		}
	}
}
