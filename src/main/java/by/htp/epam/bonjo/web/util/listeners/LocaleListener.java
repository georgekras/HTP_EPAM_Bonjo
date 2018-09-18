package by.htp.epam.bonjo.web.util.listeners;

import java.util.Locale;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;

/**
 * Listener class for setting default locale in session
 * 
 * @author George Krasutski
 */
public class LocaleListener implements HttpSessionListener {

	/**
	 * Default locale instance
	 */
	private static Locale defaultLocale = Locale.ENGLISH;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_LOCALE, defaultLocale);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}
}