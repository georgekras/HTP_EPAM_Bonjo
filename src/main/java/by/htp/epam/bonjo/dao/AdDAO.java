package by.htp.epam.bonjo.dao;

import java.util.List;

import by.htp.epam.bonjo.domain.Ad;

/**
 * Interface provides specific methods for access to data in ads table
 * 
 * @author George Krasutski
 */
public interface AdDAO {

	/**
	 * Creates a new ad entry in the database
	 *
	 * @param ad
	 *            the {@link by.htp.epam.bonjo.domain.Ad} entity
	 */
	void create(Ad ad);

	/**
	 * Find a ad by id in the database
	 *
	 * @param id
	 *            the id of a ad
	 */
	Ad read(int id);

	/**
	 * Retrieves a list of ads from the database
	 *
	 * @return {@code List<Ad>} - the list of ads
	 */
	List<Ad> readAll();

	/**
	 * Retrieves a list of ads from the database in given scope
	 * 
	 * @param start
	 *            start position for getting
	 * @param end
	 *            number of getting ads
	 * 
	 * @return {@code List<Ad>} - the list of ads
	 */
	List<Ad> readAllWithPage(int start, int end);

	/**
	 * Updates ad entry in the database
	 *
	 * @param ad
	 *            the {@link by.htp.epam.bonjo.domain.Ad} entity
	 */
	void update(Ad ad);

	/**
	 * Deletes ad entry in the database
	 *
	 * @param ad
	 *            the {@link by.htp.epam.bonjo.domain.Ad} entity
	 */
	void delete(int id);

	/**
	 * Retrieves a list of ads by user id from the database
	 *
	 * @param user_ID
	 *            is the user id
	 * @return {@code List<Ad>} - the list of ads by user id
	 */
	List<Ad> readUserAds(int user_ID);

	/**
	 * Retrieves a list of ads by user id from the database in given scope
	 *
	 * @param user_ID
	 *            is the user id
	 * @param start
	 *            start position for getting
	 * @param end
	 *            number of getting ads
	 * 
	 * @return {@code List<Ad>} - the list of ads by user id
	 */
	List<Ad> readUserAdsWithPage(int user_ID, int start, int end);

}
