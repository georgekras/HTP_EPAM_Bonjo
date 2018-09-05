//package by.htp.epam.bonjo;
//
//import static org.mockito.Mockito.times;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PowerMockIgnore;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//import org.powermock.reflect.Whitebox;
//
//import by.htp.epam.bonjo.dao.CategoryDAO;
//import by.htp.epam.bonjo.dao.impl.CategoryDaoImpl;
//import by.htp.epam.bonjo.database.ConnectionPool;
//import by.htp.epam.bonjo.domain.Category;
//import by.htp.epam.bonjo.domain.Category.Builder;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({ Category.class, CategoryDaoImpl.class })
//@PowerMockIgnore("javax.management.*")
//public class TestCategoryDaoImpl {
//
//	private CategoryDaoImpl categoryDaoImpl;
//	private Category category;
//	private Connection connection;
//	private ConnectionPool connectionPool;
//	private PreparedStatement preparedStatement;
//	private ResultSet resultSet;
//	private Statement statement;
//	private Builder categoryBuilder;
	
//	@Before
//	public void init() throws SQLException {
//		category = Mockito.mock(Category.class);
//		connectionPool = Mockito.mock(ConnectionPool.class);
//		connection = Mockito.mock(Connection.class);
//		preparedStatement = Mockito.mock(PreparedStatement.class);
//		statement = Mockito.mock(Statement.class);
//		resultSet = Mockito.mock(ResultSet.class);
//		categoryBuilder = Mockito.mock(Builder.class);
//		PowerMockito.mockStatic(Category.class);
//
//		Mockito.when(connectionPool.getConnection()).thenReturn(connection);
//		Mockito.doNothing().when(connectionPool);
//		connectionPool.putConnection(connection);
//		Mockito.when(connection.prepareStatement(Mockito.anyString())).thenReturn(preparedStatement);
//		Mockito.when(connection.createStatement()).thenReturn(statement);
//		Mockito.doNothing().when(preparedStatement).setString(Mockito.anyInt(), Mockito.anyString());
//		Mockito.doNothing().when(preparedStatement).setInt(Mockito.anyInt(), Mockito.anyInt());
//		Mockito.when(preparedStatement.executeQuery()).thenReturn(resultSet);
//		Mockito.when(statement.executeQuery(Mockito.anyString())).thenReturn(resultSet);
//		Mockito.when(resultSet.next()).thenReturn(true, true, false);
//		Mockito.when(resultSet.getInt(Mockito.anyString())).thenReturn(1, 2);
//		Mockito.when(resultSet.getString(Mockito.anyString())).thenReturn("Smartphone", "Laptop");
//		Mockito.doNothing().when(resultSet).close();
//		Mockito.when(category.getId()).thenReturn(1);
//		Mockito.when(category.getName()).thenReturn("Smartphone");
//		PowerMockito.when(Category.newBuilder()).thenReturn(categoryBuilder);
//		Mockito.when(categoryBuilder.setId(Mockito.anyInt())).thenReturn(categoryBuilder);
//		Mockito.when(categoryBuilder.setName(Mockito.anyString())).thenReturn(categoryBuilder);
//		Mockito.when(categoryBuilder.build()).thenReturn(category);
//	}
	
//	@Test
//	public void testCreate() throws SQLException {
//		Category category = Category.newBuilder().setId(10).setName("Category").build();
//
//        ConnectionPool connectionPool = Mockito.mock(ConnectionPool.class);
//        Connection connection = Mockito.mock(Connection.class);
//        ResultSet resultSet = Mockito.mock(ResultSet.class);
//        PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);
//        String query = "SELECT * FROM `krasutski`.`category` WHERE Name=?;";
//
//        Mockito.when(connectionPool.getConnection()).thenReturn(connection);
//        Mockito.when(connection.prepareStatement(query)).thenReturn(preparedStatement);
//        Mockito.doNothing().when(preparedStatement).setString(1, category.getName());
//        Mockito.when(preparedStatement.executeQuery()).thenReturn(resultSet);
//        Mockito.when(resultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
//        Mockito.when(resultSet.getString(2)).thenReturn(category.getName());
//        Mockito.doNothing().when(connectionPool).putConnection(connection);
//
//        CategoryDAO categoryDAO = new CategoryDaoImpl(connectionPool);
//        categoryDAO.read(category.getId());
//
//        Mockito.verify(connectionPool).getConnection();
//        Mockito.verify(connection).prepareStatement(query);
//        Mockito.verify(preparedStatement, times(1)).setString(1, category.getName());
//        Mockito.verify(preparedStatement, times(1)).executeQuery();
//        Mockito.verify(resultSet, times(2)).next();
//        Mockito.verify(resultSet).getString(2);
//
//        Mockito.verify(connectionPool).putConnection(connection);
//	}

//	@Test
//	public void testRead() throws SQLException {
//		categoryDaoImpl.read(category.getId());
//		Mockito.verify(connectionPool, times(1)).getConnection();
//		Mockito.verify(connection, times(1)).prepareStatement(Mockito.anyString());
//		Mockito.verify(preparedStatement, times(1)).setInt(Mockito.anyInt(), Mockito.anyInt());
//		Mockito.verify(preparedStatement, times(1)).executeQuery();
//		Mockito.verify(resultSet, times(1)).next();
//
//		Mockito.verify(resultSet, times(1)).getInt(Mockito.anyString());
//		Mockito.verify(resultSet, times(1)).getString(Mockito.anyString());
//		PowerMockito.verifyStatic(times(1));
//		Category.newBuilder();
//		Mockito.verify(categoryBuilder, times(1)).setId(Mockito.anyInt());
//		Mockito.verify(categoryBuilder, times(1)).setName(Mockito.anyString());
//		Mockito.verify(categoryBuilder, times(1)).build();
//
//		Mockito.verify(connectionPool, times(1)).putConnection(connection);
//		Mockito.verify(resultSet, times(1)).close();
//	}
//
//	@Test
//	public void testReadAll() throws SQLException {
//		categoryDaoImpl.readAll();
//		Mockito.verify(connectionPool, times(1)).getConnection();
//		Mockito.verify(connection, times(1)).createStatement();
//		Mockito.verify(statement, times(1)).executeQuery(Mockito.anyString());
//		Mockito.verify(resultSet, times(3)).next();
//
//		Mockito.verify(resultSet, times(2)).getInt(Mockito.anyString());
//		Mockito.verify(resultSet, times(2)).getString(Mockito.anyString());
//		PowerMockito.verifyStatic(times(2));
//		Category.newBuilder();
//		Mockito.verify(categoryBuilder, times(2)).setId(Mockito.anyInt());
//		Mockito.verify(categoryBuilder, times(2)).setName(Mockito.anyString());
//		Mockito.verify(categoryBuilder, times(2)).build();
//
//		Mockito.verify(connectionPool, times(1)).putConnection(connection);
//		Mockito.verify(resultSet, times(1)).close();
//	}
//
//	@Test
//	public void testUpdate() throws SQLException {
//		categoryDaoImpl.update(category);
//		Mockito.verify(connectionPool, times(1)).getConnection();
//		Mockito.verify(connection, times(1)).prepareStatement(Mockito.anyString());
//		Mockito.verify(preparedStatement, times(1)).setString(Mockito.anyInt(), Mockito.anyString());
//		Mockito.doNothing().when(preparedStatement).setInt(Mockito.anyInt(), Mockito.anyInt());
//		Mockito.verify(preparedStatement, times(1)).executeUpdate();
//		Mockito.verify(connectionPool, times(1)).putConnection(connection);
//	}
//
//	@Test
//	public void testDelete() throws SQLException {
//		categoryDaoImpl.update(category);
//		Mockito.verify(connectionPool, times(1)).getConnection();
//		Mockito.verify(connection, times(1)).prepareStatement(Mockito.anyString());
//		Mockito.verify(preparedStatement, times(1)).setInt(Mockito.anyInt(), Mockito.anyInt());
//		Mockito.verify(preparedStatement, times(1)).executeUpdate();
//		Mockito.verify(connectionPool, times(1)).putConnection(connection);
//	}
//
//	@Test
//	public void testBuildRole() throws Exception {
//		CategoryDaoImpl categoryDaoImplSpy = PowerMockito.spy(categoryDaoImpl);
//		Whitebox.invokeMethod(categoryDaoImplSpy, "buildRole", resultSet);
//		PowerMockito.verifyPrivate(categoryDaoImplSpy).invoke("buildRole", Mockito.any(ResultSet.class));
//		Mockito.verify(resultSet, times(1)).getInt(Mockito.anyString());
//		Mockito.verify(resultSet, times(1)).getString(Mockito.anyString());
//		PowerMockito.verifyStatic(times(1));
//		Category.newBuilder();
//		Mockito.verify(categoryBuilder, times(1)).setId(Mockito.anyInt());
//		Mockito.verify(categoryBuilder, times(1)).setName(Mockito.anyString());
//		Mockito.verify(categoryBuilder, times(1)).build();
//	}


	
//}
