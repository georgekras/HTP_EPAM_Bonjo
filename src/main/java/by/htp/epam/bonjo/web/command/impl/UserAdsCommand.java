package by.htp.epam.bonjo.web.command.impl;

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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Class implementing Command interface
 * 
 * @author George Krasutski
 *
 */
public class UserAdsCommand implements Command {

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
		List<Ad> userAds = adService.getUserAds(user.getId());
		List<Category> categories = categoryService.getAllCategories();
		request.setAttribute("adsSize", userAds.size());
		String strStart = request.getParameter(ParamNameConstantDeclaration.REQUEST_PARAM_ADS_LIST);
		int startAd = 0;
		if (strStart != null) {
			startAd = Integer.parseInt(strStart);
		}
		userAds = adService.getUserAdsWithPage(user.getId(), startAd, 9);
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_ADS_LIST, userAds);
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORIES_LIST, categories);
		request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADS_USER_ADS).forward(request, response);
	}
}