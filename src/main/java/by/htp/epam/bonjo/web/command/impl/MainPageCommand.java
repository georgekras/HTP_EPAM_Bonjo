package by.htp.epam.bonjo.web.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.bonjo.dao.DAOFactory;
import by.htp.epam.bonjo.domain.Ad;
import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.command.CommandName;

public class MainPageCommand extends Command {

	@Override
	public CommandName execute(HttpServletRequest request) {
		List<Ad> ads = DAOFactory.getDaoInstance().getAdDao().readAll();
		List<Category> categories = DAOFactory.getDaoInstance().getCategoryDao().readAll();
		request.setAttribute("ads", ads);
		request.setAttribute("categories", categories);
		return CommandName.HOME;
	}

}
