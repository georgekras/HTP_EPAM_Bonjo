package by.htp.epam.bonjo.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface providing execute method
 * 
 * @author George Krasutski
 *
 */
public interface Command {

	/**
	 * gets http request and forms http response
	 * 
	 * @param request
	 *            request from client to server
	 * @param response
	 *            response from server to client
	 * @throws ServletException
	 *             if ServletException occurs
	 * @throws IOException
	 *             if IOException occurs
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
