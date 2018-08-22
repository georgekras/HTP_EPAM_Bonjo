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

public class CreateCategoryCommand extends Command {

	private CategoryService categoryService = new CategoryServiceImpl();

	@Override
	public CommandName execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER);
		int role_id = (int) session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER_ROLE_ID);
		User user;
		if (obj != null && role_id == 1) {
			user = (User) obj;
		} else {
			return CommandName.LOGIN;
		}
		if (HttpRequestParamValidator.isPost(request)) {
			String categoryName = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORY_NAME);
			Category category = new Category(0, categoryName);
			categoryService.create(category);
			request.setAttribute("msg", "Category added.");
		}
		return CommandName.CREATECATEGORY;
	}
}
