package by.htp.epam.bonjo.web.util.listeners;

import java.util.Locale;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;

public class LocaleListener implements HttpSessionListener {

	private static Locale defaultLocale = Locale.ENGLISH;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_LOCALE, defaultLocale);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}

}
