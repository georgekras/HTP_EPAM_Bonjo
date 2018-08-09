package by.htp.epam.bonjo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.epam.bonjo.dao.AdDAO;
import by.htp.epam.bonjo.database.ConnectionCreator;
import by.htp.epam.bonjo.domain.Ad;

public class AdDaoImpl implements AdDAO {

	private static final String SQL_QUERY_AD_CREATE = "INSERT INTO `krasutski`.`ads` (`Title`, `SmallDesc`, `Description`,"
			+ " `Price`, `users_ID`, `category_ID`) VALUES(?,?,?,?,?,?);";
	private static final String SQL_QUERY_AD_READ = "SELECT * FROM `krasutski`.`ads` WHERE ID=?;";
	private static final String SQL_QUERY_AD_READ_ALL	= "SELECT * FROM `krasutski`.`ads`";
	private final String SQL_QUERY_AD_UPDATE = "UPDATE `krasutski`.`ads` SET `Title`=?, `SmallDesc`=?, `Description`=?,"
			+ " `Price`=?, `users_ID`=?, `category_ID`=? WHERE `ID`=?;";
	private final String SQL_QUERY_AD_DELETE = "DELETE FROM `krasutski`.`ads` WHERE `ID`=?;";
	
	@Override
	public void create(Ad ad) {
		Connection connection = ConnectionCreator.getConnection();
		try(PreparedStatement ps = connection.prepareStatement(SQL_QUERY_AD_CREATE)) {
			ps.setString(1, ad.getTitle());
			ps.setString(2, ad.getSmallDesc());
			ps.setString(3, ad.getDescription());
			ps.setInt(4, ad.getPrice());
			ps.setInt(5, ad.getUsers_ID());
			ps.setInt(6, ad.getCategory_ID());
			ps.executeUpdate();
		} catch (SQLException e) {
			//TODO logger
			e.printStackTrace();
		} finally {
			ConnectionCreator.disconnect(connection);
		}
		
	}

	@Override
	public Ad read(int id) {
		ResultSet rs = null;
		Connection connection = ConnectionCreator.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(SQL_QUERY_AD_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return buildAd(rs);
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
	public List<Ad> readAll() {
		List<Ad> ads = null;
		ResultSet rs = null;
		Connection connection = ConnectionCreator.getConnection();
		try (Statement ps = connection.createStatement()) {
			rs = ps.executeQuery(SQL_QUERY_AD_READ_ALL);
			ads = new ArrayList<>();
			while (rs.next()) {
				ads.add(buildAd(rs));
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
		return ads;
	}

	@Override
	public void update(Ad ad) {
		Connection connection = ConnectionCreator.getConnection();
		try(PreparedStatement ps = connection.prepareStatement(SQL_QUERY_AD_UPDATE)) {
			ps.setString(1, ad.getTitle());
			ps.setString(2, ad.getSmallDesc());
			ps.setString(3, ad.getDescription());
			ps.setInt(4, ad.getPrice());
			ps.setInt(5, ad.getUsers_ID());
			ps.setInt(6, ad.getCategory_ID());
			ps.setInt(7, ad.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			//TODO logger
			e.printStackTrace();
		} finally {
			ConnectionCreator.disconnect(connection);
		}
		
	}

	@Override
	public void delete(Ad ad) {
		Connection connection = ConnectionCreator.getConnection();
		try(PreparedStatement ps = connection.prepareStatement(SQL_QUERY_AD_DELETE)) {
			ps.setInt(1, ad.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			//TODO logger
			e.printStackTrace();
		} finally {
			ConnectionCreator.disconnect(connection);
		}
		
	}

	@Override
	public List<Ad> readUserAds(int user_ID) {
		// TODO Auto-generated method stub
		return null;
	}
	
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
