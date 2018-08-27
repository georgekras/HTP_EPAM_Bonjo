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
import by.htp.epam.bonjo.service.UserService;
import by.htp.epam.bonjo.service.impl.AdServiceImpl;
import by.htp.epam.bonjo.service.impl.CategoryServiceImpl;
import by.htp.epam.bonjo.service.impl.UserServiceImpl;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;

public class ViewAdCommand implements Command{
	
	private UserService userService = new UserServiceImpl();
	private AdService adService = new AdServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();

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