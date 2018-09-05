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

import by.htp.epam.bonjo.dao.CategoryDAO;
import by.htp.epam.bonjo.database.ConnectionPool;
import by.htp.epam.bonjo.domain.Category;

/**
 * Works with a {@link by.htp.epam.bonjo.domain.Category} entity class and has
 * access to the 'category' database table.
 *
 */
public class CategoryDaoImpl implements CategoryDAO {

	private static final Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);

	private static final String SQL_QUERY_CATEGORY_CREATE = "INSERT INTO `krasutski`.`category` (`Name`) VALUES(?);";
	private static final String SQL_QUERY_CATEGORY_READ = "SELECT * FROM `krasutski`.`category` WHERE ID=?;";
	private static final String SQL_QUERY_CATEGORY_READ_ALL = "SELECT * FROM `krasutski`.`category`";
	private static final String SQL_QUERY_CATEGORY_UPDATE = "UPDATE `krasutski`.`category` SET `Name`=? WHERE `ID`=?;";
	private static final String SQL_QUERY_CATEGORY_DELETE = "DELETE FROM `krasutski`.`category` WHERE `ID`=?;";

	/**
	 * Creates a new category entry in the database.
	 *
	 * @param category
	 *            the {@link by.htp.epam.bonjo.domain.Category} entity.
	 */
	@Override
	public void create(Category category) {
		Connection connection = ConnectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_CATEGORY_CREATE)) {
			ps.setString(1, category.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("CategoryDao can't create category", e);
		} finally {
			ConnectionPool.putConnection(connection);
		}
	}

	@Override
	public Category read(int id) {
		ResultSet rs = null;
		Category category = null;
		Connection connection = ConnectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_CATEGORY_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				category = new Category();
				category.setId(rs.getInt("ID"));
				category.setName(rs.getString("Name"));
				return category;
			}
		} catch (SQLException e) {
			logger.error("CategoryDao can't find category by id", e);
		} finally {
			ConnectionPool.putConnection(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in categoryDao read method", e);
			}
		}
		return null;
	}

	/**
	 * Retrieves a list of categories from the database.
	 *
	 * @return {@code List<Category>} - the list of categories.
	 */
	@Override
	public List<Category> readAll() {
		List<Category> categories = null;
		ResultSet rs = null;
		Connection connection = ConnectionPool.getConnection();
		try (Statement ps = connection.createStatement()) {
			rs = ps.executeQuery(SQL_QUERY_CATEGORY_READ_ALL);
			categories = new ArrayList<>();
			Category category;
			while (rs.next()) {
				category = new Category();
				category.setId(rs.getInt("ID"));
				category.setName(rs.getString("Name"));
				categories.add(category);
			}
		} catch (SQLException e) {
			logger.error("CategoryDao can't get categories list", e);
		} finally {
			ConnectionPool.putConnection(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in CategoryDao readAll method", e);
			}
		}
		return categories;
	}

	/**
	 * Updates category entry in the database.
	 *
	 * @param category
	 *            the {@link by.htp.epam.bonjo.domain.Category} entity.
	 */
	@Override
	public void update(Category category) {
		Connection connection = ConnectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_CATEGORY_UPDATE)) {
			ps.setString(1, category.getName());
			ps.setInt(2, category.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("CategoryDao can't update category", e);
		} finally {
			ConnectionPool.putConnection(connection);
		}
	}

	/**
	 * Deletes category entry in the database.
	 *
	 * @param category
	 *            the {@link by.htp.epam.bonjo.domain.Category} entity.
	 */
	@Override
	public void delete(int id) {
		Connection connection = ConnectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_CATEGORY_DELETE)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("CategoryDao can't delete category", e);
		} finally {
			ConnectionPool.putConnection(connection);
		}
	}
}
