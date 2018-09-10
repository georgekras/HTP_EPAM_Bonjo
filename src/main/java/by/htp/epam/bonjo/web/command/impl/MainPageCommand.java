package by.htp.epam.bonjo.web.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.bonjo.domain.Ad;
import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.service.AdService;
import by.htp.epam.bonjo.service.CategoryService;
import by.htp.epam.bonjo.service.ServiceFactory;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;

public class MainPageCommand implements Command {

	private AdService adService = ServiceFactory.getServiceInstance().getAdService();
	private CategoryService categoryService = ServiceFactory.getServiceInstance().getCategoryService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ad> ads = adService.getAllAds();
		request.setAttribute("adsSize", ads.size());
		String strStart = request.getParameter(ParamNameConstantDeclaration.REQUEST_PARAM_ADS_LIST);
		int startAd = 0;
		if (strStart != null) {
			startAd = Integer.parseInt(strStart);
		}
		ads = adService.getAllAdsWithPage(startAd, startAd + 9);
		List<Category> categories = categoryService.getAllCategories();
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_ADS_LIST, ads);
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORIES_LIST, categories);
		request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_USER_HOME).forward(request, response);
	}

}
