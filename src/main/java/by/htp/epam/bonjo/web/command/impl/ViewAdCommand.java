package by.htp.epam.bonjo.web.command.impl;

import java.io.IOException;

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
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;

/**
 * Class implementing Command interface
 * 
 * @author George Krasutski
 *
 */
public class ViewAdCommand implements Command {

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
		String adId = request.getParameter("adId");
		int chosenAdId = Integer.parseInt(adId);
		Ad chosenAd = adService.read(chosenAdId);
		int userId = chosenAd.getUsers_ID();
		int categoryId = chosenAd.getCategory_ID();
		User userInfo = userService.read(userId);
		Category category = categoryService.read(categoryId);
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_AD, chosenAd);
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_USER_NICKNAME, userInfo.getNickname());
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_USER_PHONENUMBER, userInfo.getPhoneNumber());
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORY, category);
		request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_ADS_VIEW_AD).forward(request, response);
	}
}