package by.htp.epam.bonjo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.bonjo.domain.User;


public interface UserService {
	
	void create(User user);
	
	User read(int id);
	
	User loginRead(String login, String password);
	
	void update(User user);
	
	void delete(int userId);
	
	List<User> getAllUsers();
	
	List<User> getAllUsersWithPage(int start, int end);
	
	boolean isUserAdmin(HttpServletRequest request);
	
	User isUserInSession(HttpServletRequest request);

}
