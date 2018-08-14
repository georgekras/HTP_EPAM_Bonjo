package by.htp.epam.bonjo.database;

import static by.htp.epam.bonjo.database.ConnectionPoolConfiguration.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionPool {

	private static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
	private static BlockingQueue<Connection> connectionPool = new ArrayBlockingQueue<>(POOL_SIZE, true);

	private ConnectionPool() {
		
	}
	
	static {
		try {
			Class.forName(DRIVER);
			for (int i = 0; i < POOL_SIZE; i++) {
				connectionPool.add(DriverManager.getConnection(URL, LOGIN, PASSWORD));
			}
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(e.getMessage() + " in static block of ConnectionPool class.", e);
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = connectionPool.take();
		} catch (InterruptedException e) {
			logger.error(e.getMessage()+" in getConnection method of ConnectionPool class", e);
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void putConnection(Connection connection) {
		try {
			connectionPool.put(connection);
		} catch (InterruptedException e) {
			logger.error(e.getMessage()+" in putConnection method of ConnectionPool class", e);
			e.printStackTrace();
		}
	}
}
