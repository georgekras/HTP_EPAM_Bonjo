package by.htp.epam.bonjo.database;

import java.util.ResourceBundle;

public class ConnectionPoolConfiguration {

	
	final static int POOL_SIZE = 40;
	
	private final static ResourceBundle rb = ResourceBundle.getBundle("db_config");

	final static String DRIVER = rb.getString("db.driver");
	final static String URL = rb.getString("db.url");
	final static String LOGIN = rb.getString("db.login");
	final static String PASSWORD = rb.getString("db.pass");
}
