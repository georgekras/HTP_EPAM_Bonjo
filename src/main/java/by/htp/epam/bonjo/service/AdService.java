package by.htp.epam.bonjo.service;

import java.util.List;

import by.htp.epam.bonjo.domain.Ad;

/**
 * Interface provides specific methods for working with Ad entity
 * 
 * {@link by.htp.epam.bonjo.domain.Ad}
 * 
 * @author George Krasutski
 */
public interface AdService {

	/**
	 * Creates a new ad
	 *
	 * @param ad
	 *            the {@link by.htp.epam.bonjo.domain.Ad} entity
	 */
	void create(Ad ad);

	/**
	 * Find a ad by id
	 *
	 * @param id
	 *            the id of a ad
	 */
	Ad read(int id);

	/**
	 * Updates ad
	 *
	 * @param ad
	 *            the {@link by.htp.epam.bonjo.domain.Ad} entity
	 */
	void update(Ad ad);

	/**
	 * Deletes ad
	 *
	 * @param ad
	 *            the {@link by.htp.epam.bonjo.domain.Ad} entity
	 */
	void delete(int adId);

	/**
	 * Retrieves a list of ads
	 *
	 * @return {@code List<Ad>} - the list of ads
	 */
	List<Ad> getAllAds();

	/**
	 * Retrieves a list of ads in given scope
	 * 
	 * @param start
	 *            start position for getting
	 * @param end
	 *            number of getting ads
	 * 
	 * @return {@code List<Ad>} - the list of ads
	 */
	List<Ad> getAllAdsWithPage(int start, int end);

	/**
	 * Retrieves a list of ads by user id
	 *
	 * @param user_ID
	 *            is the user id
	 * @return {@code List<Ad>} - the list of ads by user id
	 */
	List<Ad> getUserAds(int user_ID);

	/**
	 * Retrieves a list of ads by user id in given scope
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
	List<Ad> getUserAdsWithPage(int user_ID, int start, int end);

}