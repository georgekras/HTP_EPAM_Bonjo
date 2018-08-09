package by.htp.epam.bonjo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import by.htp.epam.bonjo.dao.UserDAO;
import by.htp.epam.bonjo.database.ConnectionCreator;
import by.htp.epam.bonjo.domain.User;

public class UserDaoImpl implements UserDAO{

	private static final String SQL_QUERY_USER_CREATE = "INSERT INTO `krasutski`.`users` (`Login`, `Password`, `Email`,"
			+ " `Nickname`, `PhoneNumber`, `roles_ID`) VALUES(?,?,?,?,?,?);";
	private static final String SQL_QUERY_USER_READ = "SELECT * FROM `krasutski`.`users` WHERE ID=?;";
	private static final String SQL_QUERY_USER_READ_ALL	= "SELECT * FROM `krasutski`.`users`";
	private final String SQL_QUERY_USER_UPDATE = "UPDATE `krasutski`.`users` SET `Login`=?, `Password`=?, `Email`=?,"
			+ " `NickName`=?, `PhoneNumber`=?, `roles_ID`=? WHERE `ID`=?;";
	private final String SQL_QUERY_USER_DELETE = "DELETE FROM `krasutski`.`users` WHERE `ID`=?;";
	
	@Override
	public void create(User user) {
		Connection connection = ConnectionCreator.getConnection();
		try(PreparedStatement ps = connection.prepareStatement(SQL_QUERY_USER_CREATE)) {
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getNickname());
			ps.setString(5, user.getPhoneNumber());
			ps.setInt(6, user.getRoles_ID());
			ps.executeUpdate();
		} catch (SQLException e) {
			//TODO logger
			e.printStackTrace();
		} finally {
			ConnectionCreator.disconnect(connection);
		}
		
	}

	@Override
	public User read(int id) {
		ResultSet rs = null;
		Connection connection = ConnectionCreator.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_USER_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return buildUser(rs);
		} catch (SQLException e) {
			//TODO logger
			e.printStackTrace();
		} finally {
			ConnectionCreator.disconnect(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<User> readAll() {
		List<User> users = null;
		ResultSet rs = null;
		Connection connection = ConnectionCreator.getConnection();
		try (Statement ps = connection.createStatement()) {
			rs = ps.executeQuery(SQL_QUERY_USER_READ_ALL);
			users = new ArrayList<>();
			while (rs.next()) {
				users.add(buildUser(rs));
			}
		} catch (SQLException e) {
			//TODO logger
			e.printStackTrace();
		} finally {
			ConnectionCreator.disconnect(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	@Override
	public void update(User user) {
		Connection connection = ConnectionCreator.getConnection();
		try(PreparedStatement ps = connection.prepareStatement(SQL_QUERY_USER_UPDATE)) {
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getNickname());
			ps.setString(5, user.getPhoneNumber());
			ps.setInt(6, user.getRoles_ID());
			ps.setInt(7, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			//TODO logger
			e.printStackTrace();
		} finally {
			ConnectionCreator.disconnect(connection);
		}
		
	}

	@Override
	public void delete(User user) {
		Connection connection = ConnectionCreator.getConnection();
		try(PreparedStatement ps = connection.prepareStatement(SQL_QUERY_USER_DELETE)) {
			ps.setInt(1, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			//TODO logger
			e.printStackTrace();
		} finally {
			ConnectionCreator.disconnect(connection);
		}
		
	}
	
	private User buildUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("ID"));
		user.setLogin(rs.getString("Login"));
		user.setPassword(rs.getString("Password"));
		user.setEmail(rs.getString("Email"));
		user.setNickname(rs.getString("NickName"));
		user.setPhoneNumber(rs.getString("PhoneNumber"));
		user.setRoles_ID(rs.getInt("roles_ID"));
		return user;
	}

}
