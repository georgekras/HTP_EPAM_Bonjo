package by.htp.epam.bonjo.web.command;

import by.htp.epam.bonjo.web.command.impl.CreateAdCommand;
import by.htp.epam.bonjo.web.command.impl.CreateCategoryCommand;
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
	SIGNUP {
		{
			this.command = new SignUpCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_USER_SIGNUP;
		}
	},
	PROFILE {
		{
			this.command = new ProfileCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_USER_PROFILE;
		}
	},
	USERADS {
		{
			this.command = new UserAdsCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_ADS_USER_ADS;
		}
	},
	VIEWAD {
		{
			this.command = new ViewAdCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_ADS_VIEW_AD;
		}
	},
	CREATEAD {
		{
			this.command = new CreateAdCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_ADS_CREATE_AD;
		}
	},
	EDITUSERS {
		{
			this.command = new EditUsersCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_ADMIN_EDIT_USERS;
		}
	},
	CREATECATEGORY {
		{
			this.command = new CreateCategoryCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_ADMIN_CREATE_CATEGORY;
		}
	},
	EDITCATEGORY {
		{
			this.command = new EditCategoryCommand();
			this.jspPage = PagePathConstantDeclaration.PAGE_ADMIN_EDIT_CATEGORY;
		}
	};

	public Command command;
	public String jspPage;

}
