package by.htp.epam.bonjo.database;

import java.sql.Connection;

/**
 * Interface provides connections to the database
 */
public interface BaseConnectionPool {

	/**
	 * Returns connection from connection pool to user
	 * 
	 * @return Connection
	 */
	public Connection getConnection();

	/**
	 * Put the connection to the pool
	 * 
	 * @param connection
	 *            connection to database
	 */
	public void putConnection(Connection connection);

}
