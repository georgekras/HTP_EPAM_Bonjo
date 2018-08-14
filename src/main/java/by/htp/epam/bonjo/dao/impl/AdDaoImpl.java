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

import by.htp.epam.bonjo.dao.AdDAO;
import by.htp.epam.bonjo.database.ConnectionPool;
import by.htp.epam.bonjo.domain.Ad;

/**
 * Works with a {@link by.htp.epam.bonjo.domain.Ad} entity class and has access
 * to the 'ads' database table.
 *
 */
public class AdDaoImpl implements AdDAO {

	private static final Logger logger = LoggerFactory.getLogger(AdDaoImpl.class);

	private static final String SQL_QUERY_AD_CREATE = "INSERT INTO `krasutski`.`ads` (`Title`, `SmallDesc`, `Description`,"
			+ " `Price`, `users_ID`, `category_ID`) VALUES(?,?,?,?,?,?);";
	private static final String SQL_QUERY_AD_READ = "SELECT * FROM `krasutski`.`ads` WHERE ID=?;";
	private static final String SQL_QUERY_AD_READ_ALL = "SELECT * FROM `krasutski`.`ads`";
	private static final String SQL_QUERY_AD_UPDATE = "UPDATE `krasutski`.`ads` SET `Title`=?, `SmallDesc`=?, `Description`=?,"
			+ " `Price`=?, `users_ID`=?, `category_ID`=? WHERE `ID`=?;";
	private static final String SQL_QUERY_AD_DELETE = "DELETE FROM `krasutski`.`ads` WHERE `ID`=?;";
	private static final String SQL_QUERY_AD_READ_BY_USER_ID = "SELECT * FROM `krasutski`.`ads` WHERE users_id=?;";

	/**
	 * Creates a new ad entry in the database.
	 *
	 * @param ad
	 *            the {@link by.htp.epam.bonjo.domain.Ad} entity.
	 */
	@Override
	public void create(Ad ad) {
		Connection connection = ConnectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_AD_CREATE)) {
			ps.setString(1, ad.getTitle());
			ps.setString(2, ad.getSmallDesc());
			ps.setString(3, ad.getDescription());
			ps.setInt(4, ad.getPrice());
			ps.setInt(5, ad.getUsers_ID());
			ps.setInt(6, ad.getCategory_ID());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("AdDAO can't create ad", e);
		} finally {
			ConnectionPool.putConnection(connection);
		}

	}

	/**
	 * Find a ad by id in the database.
	 *
	 * @param id
	 *            the id of a ad.
	 */
	@Override
	public Ad read(int id) {
		ResultSet rs = null;
		Connection connection = ConnectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_AD_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return buildAd(rs);
		} catch (SQLException e) {
			logger.error("AdDAO can't find ad by id", e);
			e.printStackTrace();
		} finally {
			ConnectionPool.putConnection(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in AdDao read method", e);
			}
		}
		return null;
	}

	/**
	 * Retrieves a list of ads from the database.
	 *
	 * @return {@code List<Ad>} - the list of ads.
	 */
	@Override
	public List<Ad> readAll() {
		List<Ad> ads = null;
		ResultSet rs = null;
		Connection connection = ConnectionPool.getConnection();
		try (Statement ps = connection.createStatement()) {
			rs = ps.executeQuery(SQL_QUERY_AD_READ_ALL);
			ads = new ArrayList<>();
			while (rs.next()) {
				ads.add(buildAd(rs));
			}
		} catch (SQLException e) {
			logger.error("AdDAO can't get list of ads", e);
		} finally {
			ConnectionPool.putConnection(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in AdDao readAll method", e);
			}
		}
		return ads;
	}

	/**
	 * Updates ad entry in the database.
	 *
	 * @param ad
	 *            the {@link by.htp.epam.bonjo.domain.Ad} entity.
	 */
	@Override
	public void update(Ad ad) {
		Connection connection = ConnectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_AD_UPDATE)) {
			ps.setString(1, ad.getTitle());
			ps.setString(2, ad.getSmallDesc());
			ps.setString(3, ad.getDescription());
			ps.setInt(4, ad.getPrice());
			ps.setInt(5, ad.getUsers_ID());
			ps.setInt(6, ad.getCategory_ID());
			ps.setInt(7, ad.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("AdDAO can't update ad", e);
		} finally {
			ConnectionPool.putConnection(connection);
		}

	}

	/**
	 * Deletes ad entry in the database.
	 *
	 * @param ad
	 *            the {@link by.htp.epam.bonjo.domain.Ad} entity.
	 */
	@Override
	public void delete(Ad ad) {
		Connection connection = ConnectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_AD_DELETE)) {
			ps.setInt(1, ad.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("AdDAO can't delete ad", e);
		} finally {
			ConnectionPool.putConnection(connection);
		}

	}

	/**
	 * Retrieves a list of ads by user id from the database.
	 *
	 * @param user_ID
	 *            is the user id
	 * @return {@code List<Ad>} - the list of ads by user id.
	 */
	@Override
	public List<Ad> readUserAds(int user_ID) {
		List<Ad> ads = null;
		ResultSet rs = null;
		Connection connection = ConnectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_AD_READ_BY_USER_ID)) {
			ps.setInt(1, user_ID);
			rs = ps.executeQuery();
			ads = new ArrayList<>();
			while (rs.next()) {
				ads.add(buildAd(rs));
			}
		} catch (SQLException e) {
			logger.error("AdDAO can't get list of ads by user id", e);
		} finally {
			ConnectionPool.putConnection(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Fail to close result set in AdDao readUserAds method", e);
			}
		}
		return ads;
	}

	/**
	 * Build ad.
	 *
	 * @param rs
	 *            is result set.
	 * @return ad the {@link by.academy.it.entity.Ad} entity.
	 */
	private Ad buildAd(ResultSet rs) throws SQLException {
		Ad ad = new Ad();
		ad.setId(rs.getInt("ID"));
		ad.setTitle(rs.getString("Title"));
		ad.setSmallDesc(rs.getString("SmallDesc"));
		ad.setDescription(rs.getString("Description"));
		ad.setPrice(rs.getInt("Price"));
		ad.setUsers_ID(rs.getInt("users_ID"));
		ad.setCategory_ID(rs.getInt("category_ID"));
		return ad;
	}

}
