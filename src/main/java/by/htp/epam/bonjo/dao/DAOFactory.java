package by.htp.epam.bonjo.dao;

import by.htp.epam.bonjo.dao.impl.AdDaoImpl;
import by.htp.epam.bonjo.dao.impl.CategoryDaoImpl;
import by.htp.epam.bonjo.dao.impl.UserDaoImpl;

public class DAOFactory {

	private static final DAOFactory daoInstance = new DAOFactory();

	private final AdDAO adDao = new AdDaoImpl();
	private final CategoryDAO categoryDao = new CategoryDaoImpl();
	private final UserDAO userDao = new UserDaoImpl();

	public static DAOFactory getDaoInstance() {
		return daoInstance;
	}

	public AdDAO getAdDao() {
		return adDao;
	}

	public CategoryDAO getCategoryDao() {
		return categoryDao;
	}

	public UserDAO getUserDao() {
		return userDao;
	}
}
