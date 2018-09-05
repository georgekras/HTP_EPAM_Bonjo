package by.htp.epam.bonjo.web.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.bonjo.domain.Ad;
import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.AdService;
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

public class EditAdCommand implements Command {

	private AdService adService = ServiceFactory.getServiceInstance().getAdService();
	private CategoryService categoryService = ServiceFactory.getServiceInstance().getCategoryService();
	private UserService userService = ServiceFactory.getServiceInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = userService.isUserInSession(request);
		if (user == null) {
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
			try {
				String title = RequestParamUtil.getString(request, ParamNameConstantDeclaration.REQUEST_PARAM_AD_TITLE);
				String smallDesc = RequestParamUtil.getString(request,
						ParamNameConstantDeclaration.REQUEST_PARAM_AD_SMALLDESC);
				String description = RequestParamUtil.getString(request,
						ParamNameConstantDeclaration.REQUEST_PARAM_AD_DESCRIPTION);
				int price = RequestParamUtil.getInt(request, ParamNameConstantDeclaration.REQUEST_PARAM_AD_PRICE);
				int category_Id = RequestParamUtil.getInt(request,
						ParamNameConstantDeclaration.REQUEST_PARAM_AD_CATEGORY_ID);
				Ad ad = Ad.adBuilder().setId(chosenAdId).setTitle(title).setSmallDesc(smallDesc).setDescription(description)
						.setPrice(price).setUsersId(user.getId()).setCategoryId(category_Id).build();
				RegexParamValidator.userEditAdValidation(title, smallDesc, description, price, category_Id);
				if (request.getParameter(ParamNameConstantDeclaration.BUTTON_PARAM_UPDATE) != null) {
					request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE, "ad updated.");
					adService.update(ad);
				} else if (request.getParameter(ParamNameConstantDeclaration.BUTTON_PARAM_DELETE) != null) {
					request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_ALERT, "ad deleted.");
					adService.delete(chosenAdId);
					UrlManager.getLocationForRedirect(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_USER_ADS_PAGE);
				}
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADS_EDIT_AD).forward(request, response);
			} catch (RegexValidateParamException e) {
				request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE_ALERT, "Check inputs.");
			}
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADS_EDIT_AD).forward(request, response);
		}
	}

}
