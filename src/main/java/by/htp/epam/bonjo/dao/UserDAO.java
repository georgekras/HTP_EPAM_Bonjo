package by.htp.epam.bonjo.dao;

import java.util.List;

import by.htp.epam.bonjo.domain.User;

public interface UserDAO {

	void create(User user);

	User read(int id);
	
	User loginRead(String login, String password);

	List<User> readAll();

	void update(User user);

	void delete(User user);
	
}
