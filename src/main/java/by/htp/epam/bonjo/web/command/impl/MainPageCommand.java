package by.htp.epam.bonjo.web.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.bonjo.domain.Ad;
import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.service.AdService;
import by.htp.epam.bonjo.service.CategoryService;
import by.htp.epam.bonjo.service.impl.AdServiceImpl;
import by.htp.epam.bonjo.service.impl.CategoryServiceImpl;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.command.CommandName;

public class MainPageCommand extends Command {

	private AdService adService = new AdServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	public CommandName execute(HttpServletRequest request) {
		List<Ad> ads = adService.getAllAds();
		List<Category> categories = categoryService.getAllCategories();
		request.setAttribute("ads", ads);
		request.setAttribute("categories", categories);
		return CommandName.HOME;
	}

}
