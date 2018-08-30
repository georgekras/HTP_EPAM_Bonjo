package by.htp.epam.bonjo.web.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.epam.bonjo.domain.Ad;
import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.AdService;
import by.htp.epam.bonjo.service.CategoryService;
import by.htp.epam.bonjo.service.impl.AdServiceImpl;
import by.htp.epam.bonjo.service.impl.CategoryServiceImpl;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.constants.CommandNameConstantDeclaration;
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;
import by.htp.epam.bonjo.web.util.UrlManager;
import by.htp.epam.bonjo.web.util.exceptions.RegexValidateParamException;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;
import by.htp.epam.bonjo.web.util.validators.RegexParamValidator;

public class CreateAdCommand implements Command {

	private AdService adService = new AdServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER);
		User user;
		if (obj != null) {
			user = (User) obj;
		} else {
			response.sendRedirect(
					UrlManager.getLocationForRedirect(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_LOGIN_PAGE));
			return;
		}
		List<Category> categories = categoryService.getAllCategories();
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORIES_LIST, categories);
		if (HttpRequestParamValidator.isPost(request)) {
			try {
			String title = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_AD_TITLE);
			String smallDesc = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_AD_SMALLDESC);
			String description = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_AD_DESCRIPTION);
			int price = RequestParamUtil.getInt(request, ParamNameConstantDeclaration.REQUEST_PARAM_AD_PRICE);
			int category_Id = RequestParamUtil.getInt(request, ParamNameConstantDeclaration.REQUEST_PARAM_AD_CATEGORY_ID);
			RegexParamValidator.userCreateAdValidation(title, smallDesc, description, price, category_Id);
			Ad ad = new Ad(0, title, smallDesc, description, price, user.getId(), category_Id);
			adService.create(ad);
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADS_CREATE_AD).forward(request, response);
			} catch(RegexValidateParamException e) {
				request.setAttribute("msg", "Incorrect inputs");
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADS_CREATE_AD).forward(request, response);
			}
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADS_CREATE_AD).forward(request, response);
		}
	}
}