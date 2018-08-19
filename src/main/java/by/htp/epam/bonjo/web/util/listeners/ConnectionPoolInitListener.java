package by.htp.epam.bonjo.web.util.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.htp.epam.bonjo.database.ConnectionPool;

public class ConnectionPoolInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ConnectionPool.connectionPoolInitialization();
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	

}
