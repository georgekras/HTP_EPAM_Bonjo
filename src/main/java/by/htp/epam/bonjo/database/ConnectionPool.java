package by.htp.epam.bonjo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionPool {

	private static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
	private static BlockingQueue<Connection> connectionQueue = new ArrayBlockingQueue<>(
			ConnectionPoolConfiguration.POOL_SIZE, true);

	private ConnectionPool() {

	}

	public static void connectionPoolInitialization() {
		try {
			Class.forName(ConnectionPoolConfiguration.DRIVER);
			for (int i = 0; i < ConnectionPoolConfiguration.POOL_SIZE; i++) {
				connectionQueue.add(DriverManager.getConnection(ConnectionPoolConfiguration.URL,
						ConnectionPoolConfiguration.LOGIN, ConnectionPoolConfiguration.PASSWORD));
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
