package by.htp.epam.bonjo.web.util.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.htp.epam.bonjo.database.impl.ConnectionPool;

/**
 * Listener class for initialize and destroy connection pool
 * 
 * @author George Krasutski
 */
public class ConnectionPoolInitListener implements ServletContextListener {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ConnectionPool.connectionPoolInitialization();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ConnectionPool.destroyConnectionPool();
	}
}