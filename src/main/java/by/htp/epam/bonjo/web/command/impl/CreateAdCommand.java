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
import by.htp.epam.bonjo.web.util.validators.RequestParamUtil;
import by.htp.epam.bonjo.web.util.UrlManager;
import by.htp.epam.bonjo.web.util.exceptions.RegexValidateParamException;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;
import by.htp.epam.bonjo.web.util.validators.RegexParamValidator;

/**
 * Class implementing Command interface
 * 
 * @author George Krasutski
 *
 */
public class CreateAdCommand implements Command {

	/**
	 * AdService instance
	 * 
	 * {@link by.htp.epam.bonjo.service.AdService}
	 */
	private AdService adService = ServiceFactory.getServiceInstance().getAdService();
	/**
	 * CategoryService instance
	 * 
	 * {@link by.htp.epam.bonjo.service.CategoryService}
	 */
	private CategoryService categoryService = ServiceFactory.getServiceInstance().getCategoryService();
	/**
	 * UserService instance
	 * 
	 * {@link by.htp.epam.bonjo.service.UserService}
	 */
	private UserService userService = ServiceFactory.getServiceInstance().getUserService();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = userService.isUserInSession(request);
		if (user == null) {
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
				int category_Id = RequestParamUtil.getInt(request,
						ParamNameConstantDeclaration.REQUEST_PARAM_AD_CATEGORY_ID);
				RegexParamValidator.userCreateAdValidation(title, smallDesc, description, price, category_Id);
				Ad ad = Ad.adBuilder().setId(0).setTitle(title).setSmallDesc(smallDesc).setDescription(description)
						.setPrice(price).setUsersId(user.getId()).setCategoryId(category_Id).build();
				adService.create(ad);
				response.sendRedirect(UrlManager
						.getLocationForRedirect(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_USER_ADS_PAGE));
			} catch (RegexValidateParamException e) {
				request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_MESSAGE, "Incorrect inputs");
				request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADS_CREATE_AD).forward(request, response);
			}
		} else {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADS_CREATE_AD).forward(request, response);
		}
	}
}