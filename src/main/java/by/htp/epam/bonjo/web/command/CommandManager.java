package by.htp.epam.bonjo.web.command;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.bonjo.web.constants.CommandNameConstantDeclaration;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;

public class CommandManager {

	public static CommandName defineAction(HttpServletRequest request) {
		String commandName = request.getParameter(ParamNameConstantDeclaration.REQUEST_PARAM_COMMAND);
		if (commandName == null) {
			commandName = CommandNameConstantDeclaration.COMMAND_NAME_VIEW_HOME_PAGE;
		}
		return CommandName.valueOf(commandName.toUpperCase());
	}
}
