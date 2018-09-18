package by.htp.epam.bonjo.web.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;

/**
 * Class implementing Command interface
 * 
 * @author George Krasutski
 *
 */
public class ErrorCommand implements Command {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher(PagePathConstantDeclaration.PAGE_USER_ERROR).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}