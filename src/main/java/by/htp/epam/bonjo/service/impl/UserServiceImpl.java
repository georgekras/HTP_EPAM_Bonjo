package by.htp.epam.bonjo.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.epam.bonjo.dao.DAOFactory;
import by.htp.epam.bonjo.dao.UserDAO;
import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.UserService;
import by.htp.epam.bonjo.web.constants.ParamNameConstantDeclaration;

public class UserServiceImpl implements UserService {

	/**
	 * UserDao instance
	 */
	private UserDAO userDao = DAOFactory.getDaoInstance().getUserDao();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create(User user) {
		userDao.create(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User read(int id) {
		return userDao.read(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAllUsers() {
		return userDao.readAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAllUsersWithPage(int start, int end) {
		return userDao.readAllWithPage(start, end);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User loginRead(String login, String password) {
		return userDao.loginRead(login, password);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUserAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER);
		return user != null && user.getRoles_ID() == 1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User isUserInSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(ParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER);
		return user;
	}

}
