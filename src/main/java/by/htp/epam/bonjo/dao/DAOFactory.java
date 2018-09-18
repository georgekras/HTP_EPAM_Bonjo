package by.htp.epam.bonjo.dao;

import by.htp.epam.bonjo.dao.impl.AdDaoImpl;
import by.htp.epam.bonjo.dao.impl.CategoryDaoImpl;
import by.htp.epam.bonjo.dao.impl.UserDaoImpl;

/**
 * Factory provides DAO instances
 * 
 * @author George Krasutski
 */
public class DAOFactory {

	/**
	 * Singleton instance
	 */
	private static final DAOFactory daoInstance = new DAOFactory();

	/**
	 * AdDaoImpl instance
	 */
	private final AdDAO adDao = new AdDaoImpl();
	/**
	 * CategoryDaoImpl instance
	 */
	private final CategoryDAO categoryDao = new CategoryDaoImpl();
	/**
	 * UserDaoImpl instance
	 */
	private final UserDAO userDao = new UserDaoImpl();

	/**
	 * static method for getting instance of dao factory
	 * 
	 * @return {@link #daoInstance}
	 */
	public static DAOFactory getDaoInstance() {
		return daoInstance;
	}

	/**
	 * @return {@link #adDao}
	 */
	public AdDAO getAdDao() {
		return adDao;
	}

	/**
	 * @return {@link #categoryDao}
	 */
	public CategoryDAO getCategoryDao() {
		return categoryDao;
	}

	/**
	 * @return {@link #userDao}
	 */
	public UserDAO getUserDao() {
		return userDao;
	}
}