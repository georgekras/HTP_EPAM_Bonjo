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
import by.htp.epam.bonjo.database.ConnectionCreator;
import by.htp.epam.bonjo.domain.Category;

public class CategoryDaoImpl implements CategoryDAO {

	private static final Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);

	private static final String SQL_QUERY_CATEGORY_CREATE = "INSERT INTO `krasutski`.`category` (`Name`) VALUES(?);";
	private static final String SQL_QUERY_CATEGORY_READ_ALL = "SELECT * FROM `krasutski`.`category`";
	private static final String SQL_QUERY_CATEGORY_UPDATE = "UPDATE `krasutski`.`category` SET `Name`=? WHERE `ID`=?;";
	private static final String SQL_QUERY_CATEGORY_DELETE = "DELETE FROM `krasutski`.`category` WHERE `ID`=?;";

	@Override
	public void create(Category category) {
		Connection connection = ConnectionCreator.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_CATEGORY_CREATE)) {
			ps.setString(1, category.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("CategoryDao can't create category", e);
		} finally {
			ConnectionCreator.disconnect(connection);
		}
	}

	@Override
	public List<Category> readAll() {
		List<Category> categories = null;
		ResultSet rs = null;
		Connection connection = ConnectionCreator.getConnection();
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
			ConnectionCreator.disconnect(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in CategoryDao readAll method", e);
			}
		}
		return categories;
	}

	@Override
	public void update(Category category) {
		Connection connection = ConnectionCreator.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_CATEGORY_UPDATE)) {
			ps.setString(1, category.getName());
			ps.setInt(2, category.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("CategoryDao can't update category", e);
		} finally {
			ConnectionCreator.disconnect(connection);
		}
	}

	@Override
	public void delete(Category category) {
		Connection connection = ConnectionCreator.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_CATEGORY_DELETE)) {
			ps.setInt(1, category.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("CategoryDao can't delete category", e);
		} finally {
			ConnectionCreator.disconnect(connection);
		}
	}

}
