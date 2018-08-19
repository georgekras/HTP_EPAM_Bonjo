package by.htp.epam.bonjo.web.command;

import by.htp.epam.bonjo.web.command.impl.MainPageCommand;
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;

public enum CommandName {

	HOME {
		{
			this.command = new MainPageCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_USER_MAIN;
		}
	};

	public Command command;
	public String jspPage;

}
