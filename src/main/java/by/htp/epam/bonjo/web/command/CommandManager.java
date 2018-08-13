package by.htp.epam.bonjo.web.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.epam.bonjo.web.command.impl.MainPageCommand;

public class CommandManager {

	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandManager() {
		commands.put(CommandName.MAIN_PAGE, new MainPageCommand());
	}
	
	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(CommandName.valueOf(commandName.toUpperCase()));
		return command;
	}
}
