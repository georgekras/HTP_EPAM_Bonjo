package by.htp.epam.bonjo.web.command.impl;

import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.service.CategoryService;
import by.htp.epam.bonjo.service.UserService;
import by.htp.epam.bonjo.service.impl.CategoryServiceImpl;
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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCategoryCommand implements Command {

	private CategoryService categoryService = new CategoryServiceImpl();
	private UserService userService = new UserServiceImpl();

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
				request.setAttribute("msg", "Category added.");
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_CREATE_CATEGORY).forward(request,
						response);
			} catch (RegexValidateParamException e) {
				request.setAttribute("msg", "Check inputs.");
			}
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_CREATE_CATEGORY).forward(request,
					response);
		}
	}
}
