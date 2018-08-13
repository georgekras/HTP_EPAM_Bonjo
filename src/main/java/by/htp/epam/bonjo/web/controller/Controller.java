package by.htp.epam.bonjo.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.command.CommandManager;

public class Controller extends HttpServlet{

	private static final long serialVersionUID = 8792644078442521860L;
	private static final String COMMAND_PARAM_NAME = "command";
	
	private final CommandManager commandManager = new CommandManager();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		String commandName = request.getParameter(COMMAND_PARAM_NAME);
		Command command = commandManager.getCommand(commandName);
		try {
			command.execute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
