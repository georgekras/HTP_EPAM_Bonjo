package by.htp.epam.bonjo.service.impl;

import java.util.List;

import by.htp.epam.bonjo.dao.UserDAO;
import by.htp.epam.bonjo.dao.impl.UserDaoImpl;
import by.htp.epam.bonjo.domain.User;
import by.htp.epam.bonjo.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDao = new UserDaoImpl();

	@Override
	public void create(User user) {
		userDao.create(user);

	}

	@Override
	public User read(int id) {
		return userDao.read(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.readAll();
	}

	@Override
	public User loginRead(String login, String password) {
		return userDao.loginRead(login, password);
	}

}
