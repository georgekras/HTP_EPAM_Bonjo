package by.htp.epam.bonjo.web.util.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.htp.epam.bonjo.database.CP;
import by.htp.epam.bonjo.database.ConnectionPool;

public class ConnectionPoolInitListener implements ServletContextListener {

	CP connectionPool = new ConnectionPool();
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ConnectionPool.connectionPoolInitialization();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		((ConnectionPool) connectionPool).connectionPoolDestroy();
	}
	

}
