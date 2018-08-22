package by.htp.epam.bonjo.web.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.epam.bonjo.domain.Ad;
import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.AdService;
import by.htp.epam.bonjo.service.CategoryService;
import by.htp.epam.bonjo.service.impl.AdServiceImpl;
import by.htp.epam.bonjo.service.impl.CategoryServiceImpl;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.command.CommandName;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;

public class EditAdCommand extends Command {

	private AdService adService = new AdServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();

	@Override
	public CommandName execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER);
		User user;
		if (obj != null) {
			user = (User) obj;
		} else {
			return CommandName.LOGIN;
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
				return CommandName.EDITAD;
			} else if (request.getParameter(ParamNameConstantDeclaration.BUTTON_PARAM_DELETE) != null) {
				request.setAttribute("msg_alert", "ad deleted.");
				adService.delete(ad);
				return CommandName.EDITAD;
			}
		}
		return null;
	}

}
