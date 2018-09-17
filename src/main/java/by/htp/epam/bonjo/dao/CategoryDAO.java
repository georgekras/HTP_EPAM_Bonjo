package by.htp.epam.bonjo.dao;

import java.util.List;

import by.htp.epam.bonjo.domain.Category;

/**
 * Interface provides specific methods for access to data in category table.
 * 
 * @author George Krasutski
 */
public interface CategoryDAO {

	/**
	 * Creates a new category entry in the database.
	 *
	 * @param category
	 *            the {@link by.htp.epam.bonjo.domain.Category} entity.
	 */
	void create(Category category);

	/**
	 * Find a category by id in the database
	 *
	 * @param id
	 *            the id of a category
	 */
	Category read(int id);

	/**
	 * Retrieves a list of categories from the database.
	 *
	 * @return {@code List<Category>} - the list of categories.
	 */
	List<Category> readAll();

	/**
	 * Updates category entry in the database.
	 *
	 * @param category
	 *            the {@link by.htp.epam.bonjo.domain.Category} entity.
	 */
	void update(Category category);

	/**
	 * Deletes category entry in the database.
	 *
	 * @param category
	 *            the {@link by.htp.epam.bonjo.domain.Category} entity.
	 */
	void delete(int id);

}
