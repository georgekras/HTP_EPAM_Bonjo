package by.htp.epam.bonjo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.bonjo.dao.UserDAO;
import by.htp.epam.bonjo.database.ConnectionCreator;
import by.htp.epam.bonjo.domain.User;

/**
 * Works with a {@link by.htp.epam.bonjo.domain.User} entity class and has access to the 'users' database table.
 *
 */
public class UserDaoImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	private static final String SQL_QUERY_USER_CREATE = "INSERT INTO `krasutski`.`users` (`Login`, `Password`, `Email`,"
			+ " `Nickname`, `PhoneNumber`, `roles_ID`) VALUES(?,?,?,?,?,?);";
	private static final String SQL_QUERY_USER_READ = "SELECT * FROM `krasutski`.`users` WHERE ID=?;";
	private static final String SQL_QUERY_USER_READ_ALL = "SELECT * FROM `krasutski`.`users`";
	private static final String SQL_QUERY_USER_UPDATE = "UPDATE `krasutski`.`users` SET `Login`=?, `Password`=?, `Email`=?,"
			+ " `NickName`=?, `PhoneNumber`=?, `roles_ID`=? WHERE `ID`=?;";
	private static final String SQL_QUERY_USER_DELETE = "DELETE FROM `krasutski`.`users` WHERE `ID`=?;";

    /**
     * Creates a new user entry in the database.
     *
     * @param user the {@link by.htp.epam.bonjo.domain.User} entity.
     */
	@Override
	public void create(User user) {
		Connection connection = ConnectionCreator.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_USER_CREATE)) {
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getNickname());
			ps.setString(5, user.getPhoneNumber());
			ps.setInt(6, user.getRoles_ID());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("UserDao can't create user", e);
		} finally {
			ConnectionCreator.disconnect(connection);
		}

	}

    /**
     * Find a user by id in the database.
     *
     * @param id the id of a user.
     */
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
			logger.error("UserDao can't find user by id", e);
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

    /**
     * Retrieves a list of users from the database.
     *
     * @return {@code List<User>} - the list of users.
     */
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
			logger.error("UserDao can't get users list", e);
		} finally {
			ConnectionCreator.disconnect(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in UserDao readAll method", e);
			}
		}
		return users;
	}

    /**
     * Updates user entry in the database.
     *
     * @param user the {@link by.htp.epam.bonjo.domain.User} entity.
     */
	@Override
	public void update(User user) {
		Connection connection = ConnectionCreator.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_USER_UPDATE)) {
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getNickname());
			ps.setString(5, user.getPhoneNumber());
			ps.setInt(6, user.getRoles_ID());
			ps.setInt(7, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("UserDao can't update user", e);
		} finally {
			ConnectionCreator.disconnect(connection);
		}

	}

    /**
     * Deletes user entry in the database.
     *
     * @param user the {@link by.htp.epam.bonjo.domain.User} entity.
     */
	@Override
	public void delete(User user) {
		Connection connection = ConnectionCreator.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_USER_DELETE)) {
			ps.setInt(1, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("UserDao can't delete user", e);
		} finally {
			ConnectionCreator.disconnect(connection);
		}

	}

    /**
     * Build user.
     *
     * @param rs is result set.
     * @return user the {@link by.academy.it.entity.User} entity.
     */
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