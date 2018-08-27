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
import by.htp.epam.bonjo.web.util.UrlManager;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;

public class EditAdCommand implements Command {

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
		String adId = request.getParameter("adId");
		int chosenAdId = Integer.parseInt(adId);
		Ad chosenUserAd = adService.read(chosenAdId);
		List<Category> categories = categoryService.getAllCategories();
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_USER_AD, chosenUserAd);
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORIES_LIST, categories);
		if (HttpRequestParamValidator.isPost(request)) {
			String title = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_AD_TITLE);
			String smallDesc = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_AD_SMALLDESC);
			String description = RequestParamUtil.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_AD_DESCRIPTION);
			int price = RequestParamUtil.getInt(request, ParamNameConstantDeclaration.REQUEST_PARAM_AD_PRICE);
			int category_Id = RequestParamUtil.getInt(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_AD_CATEGORY_ID);
			Ad ad = new Ad(chosenAdId, title, smallDesc, description, price, user.getId(), category_Id);
			if (request.getParameter(ParamNameConstantDeclaration.BUTTON_PARAM_UPDATE) != null) {
				request.setAttribute("msg", "ad updated.");
				adService.update(ad);
			} else if (request.getParameter(ParamNameConstantDeclaration.BUTTON_PARAM_DELETE) != null) {
				request.setAttribute("msg_alert", "ad deleted.");
				adService.delete(chosenAdId);
			}
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADS_EDIT_AD).forward(request, response);
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADS_EDIT_AD).forward(request, response);
		}
	}

}
