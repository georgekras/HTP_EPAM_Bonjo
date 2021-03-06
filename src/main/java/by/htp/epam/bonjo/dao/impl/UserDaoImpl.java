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
import by.htp.epam.bonjo.database.BaseConnectionPool;
import by.htp.epam.bonjo.database.impl.ConnectionPool;
import by.htp.epam.bonjo.domain.User;

/**
 * Works with a {@link by.htp.epam.bonjo.domain.User} entity class and has
 * access to the 'users' database table.
 *
 */
public class UserDaoImpl implements UserDAO {

	private final BaseConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	private static final String SQL_QUERY_USER_CREATE = "INSERT INTO `krasutski`.`users` (`Login`, `Password`, `Email`,"
			+ " `Nickname`, `PhoneNumber`, `roles_ID`) VALUES(?,?,?,?,?,?);";
	private static final String SQL_QUERY_USER_READ = "SELECT * FROM `krasutski`.`users` WHERE ID=?;";
	private static final String SQL_QUERY_USER_READ_BY_LOGIN_AND_PASSWORD = "SELECT * FROM `krasutski`.`users` WHERE `login`=? AND `password`=?;";
	private static final String SQL_QUERY_USER_READ_BY_LOGIN = "SELECT * FROM `krasutski`.`users` WHERE `login`=?;";
	private static final String SQL_QUERY_USER_READ_BY_EMAIL = "SELECT * FROM `krasutski`.`users` WHERE `email`=?;";
	private static final String SQL_QUERY_USER_READ_ALL = "SELECT * FROM `krasutski`.`users`";
	private static final String SQL_QUERY_USER_READ_ALL_WITH_PAGE = "SELECT * FROM `krasutski`.`users` LIMIT ?,?";
	private static final String SQL_QUERY_USER_UPDATE = "UPDATE `krasutski`.`users` SET `Login`=?, `Password`=?, `Email`=?,"
			+ " `NickName`=?, `PhoneNumber`=?, `roles_ID`=? WHERE `ID`=?;";
	private static final String SQL_QUERY_USER_DELETE = "DELETE FROM `krasutski`.`users` WHERE `ID`=?;";
	private static final String SQL_QUERY_USER_AND_ADS_DELETE = "DELETE `krasutski`.`users`, `krasutski`.`ads` "
			+ "FROM `krasutski`.`users` INNER JOIN `krasutski`.`ads` "
			+ "ON `krasutski`.`ads`.`users_id` = `krasutski`.`users`.`ID`" + "WHERE `krasutski`.`users`.`ID`=?;";
	private static final String SQL_QUERY_AD_READ_BY_USER_ID = "SELECT * FROM `krasutski`.`ads` WHERE users_id=?;";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create(User user) {
		Connection connection = connectionPool.getConnection();
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
			connectionPool.putConnection(connection);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User read(int id) {
		ResultSet rs = null;
		Connection connection = connectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_USER_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return buildUser(rs);
		} catch (SQLException e) {
			logger.error("UserDao can't find user by id", e);
		} finally {
			connectionPool.putConnection(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in userDao read method", e);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User loginRead(String login, String password) {
		ResultSet rs = null;
		Connection con = connectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_USER_READ_BY_LOGIN_AND_PASSWORD)) {
			ps.setString(1, login);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next())
				return buildUser(rs);
		} catch (SQLException e) {
			logger.error("SQLException in read method of UserDaoImpl class", e);
		} finally {
			connectionPool.putConnection(con);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in userDao loginRead method", e);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> readAll() {
		List<User> users = null;
		ResultSet rs = null;
		Connection connection = connectionPool.getConnection();
		try (Statement ps = connection.createStatement()) {
			rs = ps.executeQuery(SQL_QUERY_USER_READ_ALL);
			users = new ArrayList<>();
			while (rs.next()) {
				users.add(buildUser(rs));
			}
		} catch (SQLException e) {
			logger.error("UserDao can't get users list", e);
		} finally {
			connectionPool.putConnection(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in UserDao readAll method", e);
			}
		}
		return users;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> readAllWithPage(int start, int end) {
		List<User> users = null;
		ResultSet rs = null;
		Connection connection = connectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_USER_READ_ALL_WITH_PAGE)) {
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			users = new ArrayList<>();
			while (rs.next()) {
				users.add(buildUser(rs));
			}
		} catch (SQLException e) {
			logger.error("UserDao can't get users list", e);
		} finally {
			connectionPool.putConnection(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in UserDao readAll method", e);
			}
		}
		return users;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(User user) {
		Connection connection = connectionPool.getConnection();
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
			connectionPool.putConnection(connection);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(int id) {
		ResultSet resultSet = null;
		PreparedStatement userAds = null;
		PreparedStatement deleteUser = null;
		PreparedStatement deleteUserAndAds = null;
		Connection connection = connectionPool.getConnection();
		try {
			connection.setAutoCommit(false);
			userAds = connection.prepareStatement(SQL_QUERY_AD_READ_BY_USER_ID);
			deleteUser = connection.prepareStatement(SQL_QUERY_USER_DELETE);
			deleteUserAndAds = connection.prepareStatement(SQL_QUERY_USER_AND_ADS_DELETE);
			userAds.setInt(1, id);
			resultSet = userAds.executeQuery();
			if (!resultSet.next()) {
				deleteUser.setInt(1, id);
				deleteUser.executeUpdate();
			} else {
				deleteUserAndAds.setInt(1, id);
				deleteUserAndAds.executeUpdate();
			}
			connection.commit();
		} catch (SQLException e) {
			logger.error("UserDao can't delete user", e);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in UserDao delete method", e);
			}
			connectionPool.putConnection(connection);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User readByLogin(String login) {
		ResultSet rs = null;
		Connection connection = connectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_USER_READ_BY_LOGIN)) {
			ps.setString(1, login);
			rs = ps.executeQuery();
			if (rs.next())
				return buildUser(rs);
		} catch (SQLException e) {
			logger.error("SQLException in readByLogin method of UserDaoImpl class", e);
		} finally {
			connectionPool.putConnection(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in userDao readByLogin method", e);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User readByEmail(String email) {
		ResultSet rs = null;
		Connection connection = connectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_USER_READ_BY_EMAIL)) {
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next())
				return buildUser(rs);
		} catch (SQLException e) {
			logger.error("SQLException in readByEmail method of UserDaoImpl class", e);
		} finally {
			connectionPool.putConnection(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in userDao loginRead method", e);
			}
		}
		return null;
	}

	/**
	 * Build user.
	 *
	 * @param rs
	 *            is result set.
	 * @return user the {@link by.academy.it.entity.User} entity.
	 */
	private User buildUser(ResultSet rs) throws SQLException {
		User user = User.userBuilder().setId(rs.getInt("ID")).setLogin(rs.getString("Login"))
				.setEmail(rs.getString("Email")).setPassword(rs.getString("Password"))
				.setNickname(rs.getString("NickName")).setPhoneNumber(rs.getString("PhoneNumber"))
				.setRolesId(rs.getInt("roles_ID")).build();
		return user;
	}
}