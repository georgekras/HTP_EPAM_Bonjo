package by.htp.epam.bonjo.web.command.impl;

import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.CategoryService;
import by.htp.epam.bonjo.service.impl.CategoryServiceImpl;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.command.CommandName;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

public class EditCategoryCommand extends Command {

	private CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	public CommandName execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER);
		Object role_id = session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER_ROLE_ID);
		User user;
		if (obj != null && role_id != null && (int) role_id == 1) {
			user = (User) obj;
		} else {
			return CommandName.LOGIN;
		}
		List<Category> categories = categoryService.getAllCategories();
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORIES_LIST, categories);
		if (HttpRequestParamValidator.isPost(request)) {
			int id = RequestParamUtil.getInt(request, ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORY_ID);
			String name = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORY_NAME);
			Category category = new Category(id, name);
			if (request.getParameter("Update") != null) {
				request.setAttribute("msg", "category updated.");
				categoryService.update(category);
				return CommandName.EDITCATEGORY;
			} else if (request.getParameter("Delete") != null) {
				request.setAttribute("msg", "category deleted.");
				categoryService.delete(id);
				return CommandName.EDITCATEGORY;
			}
		}
		return CommandName.EDITCATEGORY;
	}
}
