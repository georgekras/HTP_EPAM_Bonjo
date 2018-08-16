package by.htp.epam.bonjo.web.command.impl;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.bonjo.dao.DAOFactory;
import by.htp.epam.bonjo.domain.Ad;
import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.web.command.Command;

public class MainPageCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Ad> ads = DAOFactory.getDaoInstance().getAdDao().readAll();
		List<Category> categories = DAOFactory.getDaoInstance().getCategoryDao().readAll();
		request.setAttribute("ads", ads);
		request.setAttribute("categories", categories);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
		dispatcher.forward(request, response);

	}

}
