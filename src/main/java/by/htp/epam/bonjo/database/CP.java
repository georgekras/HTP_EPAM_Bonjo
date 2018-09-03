package by.htp.epam.bonjo.database;

import java.sql.Connection;

public interface CP {

	public Connection getConnection();

	public void putConnection(Connection connection);
	
}
