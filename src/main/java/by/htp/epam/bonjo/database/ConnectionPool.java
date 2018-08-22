package by.htp.epam.bonjo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionPool {

	private static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);

	private final static ResourceBundle rb = ResourceBundle.getBundle("db_config");

	private final static int POOL_SIZE = 40;
	private final static String DRIVER = rb.getString("db.driver");
	private final static String URL = rb.getString("db.url");
	private final static String LOGIN = rb.getString("db.login");
	private final static String PASSWORD = rb.getString("db.pass");
	
	private static BlockingQueue<Connection> connectionQueue = new ArrayBlockingQueue<>(POOL_SIZE, true);

	private ConnectionPool() {

	}

	public static void connectionPoolInitialization() {
		try {
			Class.forName(DRIVER);
			for (int i = 0; i < POOL_SIZE; i++) {
				connectionQueue.add(DriverManager.getConnection(URL, LOGIN, PASSWORD));
			}
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(e.getMessage() + " in initialization method of ConnectionPool class.", e);
			System.exit(0);
		}
	}

	public static void connectionPoolDestroy() {
		connectionQueue.removeAll(connectionQueue);
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = connectionQueue.take();
		} catch (InterruptedException e) {
			logger.error(e.getMessage() + " in getConnection method of ConnectionPool class", e);
		}
		return connection;
	}

	public static void putConnection(Connection connection) {
		try {
			connectionQueue.put(connection);
		} catch (InterruptedException e) {
			logger.error(e.getMessage() + " in putConnection method of ConnectionPool class", e);
		}
	}
}
