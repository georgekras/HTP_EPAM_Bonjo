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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class EditCategoryCommand implements Command {

	private CategoryService categoryService = ServiceFactory.getServiceInstance().getCategoryService();
	private UserService userService = ServiceFactory.getServiceInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!userService.isUserAdmin(request)) {
			response.sendRedirect(
					UrlManager.getLocationForRedirect(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_HOME_PAGE));
			return;
		}
		List<Category> categories = categoryService.getAllCategories();
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORIES_LIST, categories);
		if (HttpRequestParamValidator.isPost(request)) {
			try {
				int id = RequestParamUtil.getInt(request, ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORY_ID);
				String name = RequestParamUtil.getString(request,
						ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORY_NAME);
				HttpRequestParamValidator.validateRequestParamObjectNotNull(id);
				RegexParamValidator.adminCategoryValidation(name);
				Category category = new Category(id, name);
				if (request.getParameter(ParamNameConstantDeclaration.BUTTON_PARAM_UPDATE) != null) {
					request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE, "category updated.");
					categoryService.update(category);
				} else if (request.getParameter(ParamNameConstantDeclaration.BUTTON_PARAM_DELETE) != null) {
					request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE, "category deleted.");
					categoryService.delete(id);
				}
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_EDIT_CATEGORY).forward(request,
						response);
			} catch (RegexValidateParamException e) {
				request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE, "can't update category.");
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_EDIT_CATEGORY).forward(request,
						response);
			}
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADMIN_EDIT_CATEGORY).forward(request,
					response);
		}
	}
}
