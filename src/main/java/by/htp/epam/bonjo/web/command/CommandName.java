package by.htp.epam.bonjo.web.command;

import by.htp.epam.bonjo.web.command.impl.CreateAdCommand;
import by.htp.epam.bonjo.web.command.impl.ErrorCommand;
import by.htp.epam.bonjo.web.command.impl.LogInCommand;
import by.htp.epam.bonjo.web.command.impl.LogOutCommand;
import by.htp.epam.bonjo.web.command.impl.MainPageCommand;
import by.htp.epam.bonjo.web.constants.PagePathConstantDeclaration;

public enum CommandName {

	HOME {
		{
			this.command = new MainPageCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_USER_HOME;
		}
	},
	ERROR {
		{
			this.command = new ErrorCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_USER_ERROR;
		}
	},
	LOGIN {
		{
			this.command = new LogInCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_USER_LOGIN;
		}
	},
	LOGOUT {
		{
			this.command = new LogOutCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_USER_LOGOUT;
		}
	},
	CREATEAD {
		{
			this.command = new CreateAdCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_ADS_CREATE_AD;
		}
	};

	public Command command;
	public String jspPage;

}
