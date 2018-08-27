package by.htp.epam.bonjo.web.command;

import by.htp.epam.bonjo.web.constants.CommandNameConstantDeclaration;

public class CommandManager {

	public static CommandName defineCommand(String commandName) {
		if (commandName == null) {
			commandName = CommandNameConstantDeclaration.COMMAND_NAME_VIEW_HOME_PAGE;
		}
		return CommandName.valueOf(commandName.toUpperCase());
	}
}
