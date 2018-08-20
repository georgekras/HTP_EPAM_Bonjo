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
		int role_id = (int) session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER_ROLE_ID);
		User user;
		if (obj != null && role_id == 1) {
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
			if (request.getAttribute("Update") != null) {
				categoryService.update(category);
				request.setAttribute("msg", "category updated.");
				return CommandName.EDITCATEGORY;
			} else if (request.getParameter("Delete") != null) {
				categoryService.delete(category);
				request.setAttribute("msg", "category deleted.");
				return CommandName.EDITCATEGORY;
			}
		}
		return null;
	}

//    @Override
//    Action execute(HttpServletRequest req) throws Exception {
//        if (FormUtil.isPost(req)) {
//            Category category = new Category(FormUtil.getInt(req, "ID"),
//                    FormUtil.getString(req, "Name", ".+"));
//            if (req.getParameter("Update") != null) {
//                DAO.getDAO().categoryDAO.update(category);
//            } else if (req.getParameter("Delete") != null) {
//                DAO.getDAO().categoryDAO.delete(category);
//            }
//        }
//        List<Category> categories = DAO.getDAO().categoryDAO.getAll("");
//        req.setAttribute("categories", categories);
//        return null;
//    }
}
