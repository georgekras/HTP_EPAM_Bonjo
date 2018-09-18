package by.htp.epam.bonjo.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.command.CommandManager;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;

/**
 * Controller class
 * 
 * @author George Krasutski
 *
 */
public class Controller extends HttpServlet {

	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = 8792644078442521860L;
	private static Logger logger = LoggerFactory.getLogger(Controller.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * defines command and execute an appropriate logic
	 * 
	 * @param request
	 *            request from client to server
	 * @param response
	 *            response from server to client
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			String commandName = request.getParameter(ParamNameConstantDeclaration.REQUEST_PARAM_COMMAND);
			Command command = CommandManager.defineCommand(commandName);
			command.execute(request, response);
		} catch (NullPointerException | ServletException | IOException e) {
			logger.error(e.getMessage() + " in Controller class", e);
		}
	}
}
