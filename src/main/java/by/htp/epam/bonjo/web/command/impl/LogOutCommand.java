package by.htp.epam.bonjo.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.command.CommandName;

public class LogOutCommand extends Command{

	@Override
	public CommandName execute(HttpServletRequest request) {
		request.getSession().invalidate();
		return CommandName.HOME;
	}

}
