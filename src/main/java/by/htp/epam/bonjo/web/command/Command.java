package by.htp.epam.bonjo.web.command;

import javax.servlet.http.HttpServletRequest;

public abstract class Command {

	public abstract CommandName execute(HttpServletRequest request);
	
	@Override
	public String toString() {
		return getClass().getSimpleName().replace("Command", "");
	}

}
