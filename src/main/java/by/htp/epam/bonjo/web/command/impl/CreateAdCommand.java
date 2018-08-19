package by.htp.epam.bonjo.web.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.epam.bonjo.dao.DAOFactory;
import by.htp.epam.bonjo.domain.Ad;
import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.command.CommandName;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;
import by.htp.epam.bonjo.web.util.validators.HttpRequestParamValidator;

public class CreateAdCommand extends Command {

	@Override
	public CommandName execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER);
		User user;
		user = (User) obj;
		List<Category> categories = DAOFactory.getDaoInstance().getCategoryDao().readAll();
		request.setAttribute(ParamNameConstantDeclaration.REQUEST_PARAM_CATEGORIES_LIST, categories);
		if (HttpRequestParamValidator.isPost(request)) {
			String title = HttpRequestParamValidator.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_AD_TITLE);
			String smallDesc = HttpRequestParamValidator.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_AD_SMALLDESC);
			String description = HttpRequestParamValidator.getString(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_AD_DESCRIPTION);
			int price = HttpRequestParamValidator.getInt(request, ParamNameConstantDeclaration.REQUEST_PARAM_AD_PRICE);
			int category_Id = HttpRequestParamValidator.getInt(request,
					ParamNameConstantDeclaration.REQUEST_PARAM_AD_CATEGORY_ID);
			Ad ad = new Ad(0, title, smallDesc, description, price, user.getId(), category_Id);
			DAOFactory.getDaoInstance().getAdDao().create(ad);
		}
		return CommandName.CREATEAD;
	}
}