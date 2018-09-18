package by.htp.epam.bonjo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.bonjo.domain.User;

/**
 * Interface provides specific methods for working with User entity
 * 
 * {@link by.htp.epam.bonjo.domain.User}
 * 
 * @author George Krasutski
 */
public interface UserService {

	/**
	 * Creates a new user
	 *
	 * @param user
	 *            the {@link by.htp.epam.bonjo.domain.User} entity
	 */
	void create(User user);

	/**
	 * Find a user by id
	 *
	 * @param id
	 *            the id of a user
	 * @return {@link by.htp.epam.bonjo.domain.User}
	 */
	User read(int id);

	/**
	 * Find a user by login and password
	 *
	 * @param login
	 *            the login of a user
	 * @param password
	 *            the password of a user
	 * @return {@link by.htp.epam.bonjo.domain.User} user
	 */
	User loginRead(String login, String password);

	/**
	 * Updates user
	 *
	 * @param user
	 *            the {@link by.htp.epam.bonjo.domain.User} entity
	 */
	void update(User user);

	/**
	 * Deletes user entry and his ads
	 *
	 * @param userId
	 *            the id of user
	 */
	void delete(int userId);

	/**
	 * Retrieves a list of users
	 *
	 * @return {@code List<User>} - the list of users
	 */
	List<User> getAllUsers();

	/**
	 * Retrieves a list of users in given scope
	 *
	 * @param start
	 *            start position for getting
	 * @param end
	 *            number of getting users
	 * 
	 * @return {@code List<User>} - the list of users
	 */
	List<User> getAllUsersWithPage(int start, int end);

	/**
	 * checks if user role admin
	 * 
	 * @param request
	 *            HttpServletRequest object
	 * @return {@code true} if user is admin, {@code false} otherwise
	 */
	boolean isUserAdmin(HttpServletRequest request);

	/**
	 * checks if user in session
	 * 
	 * @param request
	 *            HttpServletRequest object
	 * @return {@link by.htp.epam.bonjo.domain.User} user
	 */
	User isUserInSession(HttpServletRequest request);
	
	
}