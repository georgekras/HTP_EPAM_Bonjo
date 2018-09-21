package by.htp.epam.bonjo.database.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.bonjo.database.BaseConnectionPool;

/**
 * Class provides connections to the database
 * 
 * @author George Krasutski
 *
 */

public class ConnectionPool implements BaseConnectionPool {

	private static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);

	/**
	 * Resource bundle gets database config
	 */
	private static final ResourceBundle rb = ResourceBundle.getBundle("db_config");

	/**
	 * Singleton instance
	 */
	private static ConnectionPool instance;

	/**
	 * Connection pool size
	 */
	private static final int POOL_SIZE = 10;
	/**
	 * Database driver
	 */
	private static final String DRIVER = rb.getString("db.driver");
	/**
	 * Database URL
	 */
	private static final String URL = rb.getString("db.url");
	/**
	 * Database login
	 */
	private static final String LOGIN = rb.getString("db.login");
	/**
	 * Database password
	 */
	private static final String PASSWORD = rb.getString("db.pass");

	/**
	 * queue for containing free connections
	 */
	private static BlockingQueue<Connection> connectionQueue = new ArrayBlockingQueue<>(POOL_SIZE);
	/**
	 * queue for containing occupied connections
	 */
	private static BlockingQueue<Connection> givenAwayConectionQueue = new ArrayBlockingQueue<>(POOL_SIZE);

	/**
	 * Constructor without parameters
	 */
	public ConnectionPool() {

	}

	/**
	 * static method for getting instance of connection pool
	 * 
	 * @return BaseConnectionPool
	 */
	public static BaseConnectionPool getInstance() {
		if (instance == null) {
			synchronized (ConnectionPool.class) {
				if (instance == null) {
					instance = new ConnectionPool();
				}
			}
		}
		return instance;
	}

	public static void connectionPoolInitialization() {
		try {
			Class.forName(DRIVER);
			for (int i = 0; i < POOL_SIZE; i++) {
				connectionQueue.add(DriverManager.getConnection(URL, LOGIN, PASSWORD));
			}
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(e.getMessage() + " in initialization method of ConnectionPool class.", e);
			System.exit(1);
		}
	}

	/**
	 * destroy connection pool in InitializeConnectionPoolListener class during
	 * context destroying
	 */
	public static void destroyConnectionPool() {
		closeConnectionQueue(connectionQueue);
		closeConnectionQueue(givenAwayConectionQueue);
	}

	/**
	 * purge queue with connections
	 * 
	 * @param queue
	 *            queue for purging
	 */
	private static void closeConnectionQueue(BlockingQueue<Connection> queue) {
		Connection connection = null;
		while ((connection = queue.poll()) != null) {
			try {
				connection.close();
				logger.info("connection was successfully closed");
			} catch (SQLException e) {
				logger.error("connection can't be closed ");
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = connectionQueue.take();
			givenAwayConectionQueue.add(connection);
		} catch (InterruptedException e) {
			logger.error("InterruptedException in getConnection method in ConnectionPool class", e);
		}
		return connection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void putConnection(Connection connection) {
		try {
			if (connection.isClosed()) {
				logger.error("Already closed connection can't be closed ");
			}
			if (connection.isReadOnly()) {
				connection.setReadOnly(false);
			}
			if (!givenAwayConectionQueue.remove(connection)) {
				logger.error("Connection can't be deleted from givenAwayConectionQueue");
			}
			if (!connectionQueue.offer(connection)) {
				logger.error("Connection can't be added to connectionQueue");
			}
		} catch (SQLException e) {
			logger.error("{} in putConnection() in ConnectionPool class", e);
		}
	}
}