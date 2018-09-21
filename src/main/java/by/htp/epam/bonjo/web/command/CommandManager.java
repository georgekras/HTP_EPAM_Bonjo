package by.htp.epam.bonjo.web.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.epam.bonjo.web.command.impl.ChangeLocaleCommand;
import by.htp.epam.bonjo.web.command.impl.CreateAdCommand;
import by.htp.epam.bonjo.web.command.impl.CreateCategoryCommand;
import by.htp.epam.bonjo.web.command.impl.EditAdCommand;
import by.htp.epam.bonjo.web.command.impl.EditCategoryCommand;
import by.htp.epam.bonjo.web.command.impl.EditUsersCommand;
import by.htp.epam.bonjo.web.command.impl.ErrorCommand;
import by.htp.epam.bonjo.web.command.impl.LogInCommand;
import by.htp.epam.bonjo.web.command.impl.LogOutCommand;
import by.htp.epam.bonjo.web.command.impl.MainPageCommand;
import by.htp.epam.bonjo.web.command.impl.ProfileCommand;
import by.htp.epam.bonjo.web.command.impl.SignUpCommand;
import by.htp.epam.bonjo.web.command.impl.UserAdsCommand;
import by.htp.epam.bonjo.web.command.impl.ViewAdCommand;
import by.htp.epam.bonjo.web.command.impl.ViewUsersCommand;
import by.htp.epam.bonjo.web.constants.CommandNameConstantDeclaration;

/**
 * Class contains instances of command classes
 * 
 * @author George Krasutski
 *
 */
public class CommandManager {

	/**
	 * Map for containing instances
	 */
	private static Map<String, Command> commands;

	static {
		commands = new HashMap<>();
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_AD_PAGE, new ViewAdCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_CREATE_AD_PAGE, new CreateAdCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_CREATE_CATEGORY_PAGE, new CreateCategoryCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_EDIT_AD_PAGE, new EditAdCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_EDIT_CATEGORY_PAGE, new EditCategoryCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_EDIT_USER_PAGE, new EditUsersCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_HOME_PAGE, new MainPageCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_LOGIN_PAGE, new LogInCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_LOGOUT_PAGE, new LogOutCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_PROFILE_PAGE, new ProfileCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_SIGNUP_PAGE, new SignUpCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_USER_ADS_PAGE, new UserAdsCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_CHANGE_LOCALE, new ChangeLocaleCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_ERROR_PAGE, new ErrorCommand());
		commands.put(CommandNameConstantDeclaration.COMMAND_NAME_VIEW_USERS_PAGE, new ViewUsersCommand());
	}

	/**
	 * defines command
	 * 
	 * @param commanName
	 *            name of command
	 * @return certain command entity
	 */
	public static Command defineCommand(String commandName) {
		if (commandName == null) {
			commandName = CommandNameConstantDeclaration.COMMAND_NAME_VIEW_HOME_PAGE;
		}
		return commands.get(commandName);
	}
}
