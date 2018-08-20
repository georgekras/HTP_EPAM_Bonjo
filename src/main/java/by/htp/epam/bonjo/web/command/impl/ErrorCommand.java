package by.htp.epam.bonjo.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.bonjo.web.command.Command;
import by.htp.epam.bonjo.web.command.CommandName;

public class ErrorCommand extends Command{

	@Override
	public CommandName execute(HttpServletRequest request) {
		return CommandName.ERROR;
	}

}
