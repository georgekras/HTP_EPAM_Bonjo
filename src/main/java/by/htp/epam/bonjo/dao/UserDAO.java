package by.htp.epam.bonjo.dao;

import java.util.List;

import by.htp.epam.bonjo.domain.User;

/**
 * Interface provides specific methods for access to data in users table
 * 
 * @author George Krasutski
 */
public interface UserDAO {

	/**
	 * Creates a new user entry in the database
	 *
	 * @param user
	 *            the {@link by.htp.epam.bonjo.domain.User} entity
	 */
	void create(User user);

	/**
	 * Find a user by id in the database
	 *
	 * @param id
	 *            the id of a user
	 * @return {@link by.htp.epam.bonjo.domain.User} user
	 */
	User read(int id);

	/**
	 * Find a user by login and password in the database
	 *
	 * @param login
	 *            the login of a user
	 * @param password
	 *            the password of a user
	 * @return {@link by.htp.epam.bonjo.domain.User} user
	 */
	User loginRead(String login, String password);

	/**
	 * Retrieves a list of users from the database
	 *
	 * @return {@code List<User>} - the list of users
	 */
	List<User> readAll();

	/**
	 * Retrieves a list of users from the database in given scope
	 *
	 * @param start
	 *            start position for getting
	 * @param end
	 *            number of getting users
	 * 
	 * @return {@code List<User>} - the list of users
	 */
	List<User> readAllWithPage(int start, int end);

	/**
	 * Updates user entry in the database
	 *
	 * @param user
	 *            the {@link by.htp.epam.bonjo.domain.User} entity
	 */
	void update(User user);

	/**
	 * Deletes user entry and his ads in the database
	 *
	 * @param id
	 *            the id of user
	 */
	void delete(int id);

	/**
	 * Find a user by login in the database
	 *
	 * @param login
	 *            the login of a user
	 * @return {@link by.htp.epam.bonjo.domain.User} user
	 */
	User readByLogin(String login);

	/**
	 * Find a user by email in the database
	 *
	 * @param email
	 *            the email of a user
	 * @return {@link by.htp.epam.bonjo.domain.User} user
	 */
	User readByEmail(String email);
}